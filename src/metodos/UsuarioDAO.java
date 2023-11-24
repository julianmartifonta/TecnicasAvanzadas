package metodos;

import java.sql.SQLException;
import java.util.List;

import entidades.Evaluacion;
import entidades.Turno;
/*import entidades.Vehiculo;
import entidades.Sede;
import entidades.Turno;*/
import entidades.Usuario;
import entidades.Vehiculo;
import metodos.ExcepcionesPersonalizadas.ConexionException;

public interface UsuarioDAO {
	
	Usuario passwordUsuario(String apellido, String password);
	
	List<String> obtenerSedesDisponibles();
	
    List<String> obtenerVehiculosUsuario(Usuario usuario);
    
    public void cargarTurno(Turno unTurno) throws ClaveDuplicadaException;
    
    public String obtenerUltimoTurno() throws SQLException;
    
    public Vehiculo obtenerVehiculoPorMatricula(String matricula) throws SQLException;
    
    public void cargarEvaluacion(Evaluacion unaEval) throws ClaveDuplicadaException;
    
    public int obtenerNuevoId();
    
}
