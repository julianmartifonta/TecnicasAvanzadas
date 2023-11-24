package metodos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Evaluacion;
import entidades.Turno;
import entidades.Usuario;
import entidades.Vehiculo;
import metodos.ExcepcionesPersonalizadas.ConexionException;
import servicio.ClaseServicio;

public class UsuarioDAOH2Impl implements UsuarioDAO {



public Usuario passwordUsuario(String usuario, String password) {
    String sql = "SELECT * FROM usuario WHERE nombreusuario = '" + usuario + "' and password = '" + password + "'";
    Connection c = DBManager.connect();
    try {
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(sql);

        
        if (rs.next()) {
            int dni = rs.getInt("dni");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            double celular = rs.getDouble("celular");
            boolean esAdmin = rs.getBoolean("esAdmin");
            Usuario u = new Usuario(dni, usuario, nombre, apellido, celular, password, esAdmin);
            return u;
        }

    } catch (SQLException e) {
        try {
            c.rollback();
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    } finally {
        try {
            c.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    return null;
}

public void cargarTurno(Turno unTurno) throws ClaveDuplicadaException {
    String matricula = unTurno.getVehiculo();
    int dni = unTurno.Usuario.getDNI();
    String fechayhora = unTurno.getFechayhora();
    String sede = unTurno.getSede();
    int id = unTurno.getIDTurno();

    Connection c = DBManager.connect();
    try {
        Statement s = c.createStatement();

        String sql = "INSERT INTO turno (id, estado, vehiculo_matricula, usuario_dni, fechayhora, sede) VALUES ('" + id + "', 'En curso', '" + matricula + "', '" + dni + "','" + fechayhora + "', '" + sede + "')";
        s.executeUpdate(sql);
        c.commit();
    } catch (SQLException e) {
        try {
            if (e.getErrorCode() == 23505) {
                throw new ClaveDuplicadaException();
            }
            e.printStackTrace();
            c.rollback();
        } catch (SQLException e1) {
            e.printStackTrace();
        } catch (ClaveDuplicadaException e1) {
            e1.printStackTrace();
        }
    } finally {
        try {
            c.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}

public int obtenerNuevoId() {
    int nuevoId = 0;
    Connection c = DBManager.connect();

    try {
        Statement s = c.createStatement();
        String sql = "SELECT COALESCE(MAX(id), 0) + 1 FROM turno";
        ResultSet rs = s.executeQuery(sql);

        if (rs.next()) {
            nuevoId = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return nuevoId;
}

private int obtenerNuevoIdEval() {
    int nuevoId = 0;
    Connection c = DBManager.connect();

    try {
        Statement s = c.createStatement();
        String sql = "SELECT COALESCE(MAX(id), 0) + 1 FROM evaluacion";
        ResultSet rs = s.executeQuery(sql);

        if (rs.next()) {
            nuevoId = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return nuevoId;
}

public String obtenerUltimoTurno() throws SQLException {
    String sql = "SELECT * FROM Turno WHERE Fechayhora < CURRENT_DATE ORDER BY Fechayhora DESC LIMIT 1";
    try (Connection connection = DBManager.connect();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        if (resultSet.next()) {
            String vehiculo = resultSet.getString("Vehiculo_Matricula");
            return vehiculo;
        } else {
            return null;
        }
    }
}

public Vehiculo obtenerVehiculoPorMatricula(String matricula) throws SQLException {
    String sql = "SELECT * FROM Vehiculo WHERE Matricula = ?";
    try (Connection connection = DBManager.connect();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, matricula);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Vehiculo(
                        resultSet.getString("Matricula"),
                        resultSet.getString("Modelo"),
                        resultSet.getInt("Anio"),
                        resultSet.getInt("Dnipropietario")
                );
            } else {
                return null;
            }
        }
    }
}

public List<String> obtenerSedesDisponibles() {
    List<String> sedes = new ArrayList<>();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = DBManager.connect();
        String sql = "SELECT nombre FROM sede";
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            sedes.add(resultSet.getString("nombre"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return sedes;
}

@Override
public List<String> obtenerVehiculosUsuario(Usuario usuario) {
    List<String> vehiculos = new ArrayList<>();
    int dni = usuario.getDNI();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = DBManager.connect();
        String sql = "SELECT matricula FROM vehiculo WHERE DNIPROPIETARIO = " + dni;
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            vehiculos.add(resultSet.getString("matricula"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return vehiculos;
}

public void cargarEvaluacion(Evaluacion unaEval) throws ClaveDuplicadaException {
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        connection = DBManager.connect();

        String sql = "INSERT INTO evaluacion (matriculavehiculo, fecha, puntajes, dniinspector, estado, fechaVencimiento, id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        statement = connection.prepareStatement(sql);

        statement.setString(1, unaEval.getVehiculo());
        statement.setDate(2, new java.sql.Date(unaEval.getFecha().getTime()));
        statement.setString(3, convertirPuntajesAString(unaEval.getPuntajes()));
        statement.setInt(4, unaEval.getInspector().getDNI());
        statement.setString(5, unaEval.getEstado());
        statement.setDate(6, new java.sql.Date(unaEval.getFechaVencimiento().getTime()));
        statement.setInt(7, obtenerUltimaEvaluacion()+1);
        
        statement.executeUpdate();
        connection.commit();
    } catch (SQLException e) {
        try {
            if (e.getErrorCode() == 23505) {
                throw new ClaveDuplicadaException();
            }
            e.printStackTrace();
            connection.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    } finally {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public int obtenerUltimaEvaluacion() throws SQLException {
    String sql = "SELECT COALESCE(MAX(ID), 1) AS MaximoID FROM Evaluacion";
    try (Connection connection = DBManager.connect();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        if (resultSet.next()) {
            int maximo = resultSet.getInt("MaximoID");
            return maximo;
        } else {
            return 1;
        }
    }
}

private String convertirPuntajesAString(List<Integer> puntajes) {
    return String.join(",", puntajes.stream().map(Object::toString).toArray(String[]::new));
}

}

	
