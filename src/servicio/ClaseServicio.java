package servicio;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.Calendar;

import entidades.Evaluacion;
import entidades.Turno;
import entidades.Usuario;
import metodos.ClaveDuplicadaException;
import metodos.ExcepcionesPersonalizadas.ConexionException;
import metodos.NotFoundException;
import metodos.UsuarioDAO;
import metodos.UsuarioDAOH2Impl;
import swing.PanelInicioDeSesion;

public class ClaseServicio {
	
	// La clase servicio recibe los valores de los paneles, los pasa a la respectiva clase y los deriva al DAO

	//Falta agregar el NullPointerException
public void SConsultaPassword(String usuarioIngresado, String passwordIngresado) throws NotFoundException {
	
	UsuarioDAOH2Impl u = new UsuarioDAOH2Impl();
	u.passwordUsuario(usuarioIngresado, passwordIngresado);
		UsuarioDAO dao = new UsuarioDAOH2Impl();
		String unUsuario = usuarioIngresado;
		String unPassword = passwordIngresado;
			Usuario usuarioBase = dao.passwordUsuario(unUsuario, unPassword);
			PanelInicioDeSesion pa = new PanelInicioDeSesion();
			if (usuarioBase.esAdmin == true) {
				pa.mostrarIngresoAdmin(usuarioBase);
			} else if (usuarioBase.esAdmin == false) {
				pa.mostrarIngreso(usuarioBase);
			}
	
}

public List<String> obtenerSedesDisponibles() {
	UsuarioDAO dao = new UsuarioDAOH2Impl();
    return dao.obtenerSedesDisponibles();
}

public List<String> obtenerVehiculosUsuario(Usuario usuario) {
	UsuarioDAO dao = new UsuarioDAOH2Impl();
    return dao.obtenerVehiculosUsuario(usuario);
}

public void SAltasTurnoFinal(Usuario usuarioSolicitante, String fechaIngresada, int horaIngresada, int minutosIngresados, String sedeSeleccionada, String vehiculoSeleccionado) {
	Turno unTurno = new Turno();
	unTurno.setUsuario(usuarioSolicitante);
	unTurno.setFechayhora(fechaIngresada + " " + horaIngresada + ":" + minutosIngresados + ":00");
	unTurno.setVehiculo(vehiculoSeleccionado);
	unTurno.setSede(sedeSeleccionada);
	UsuarioDAO dao = new UsuarioDAOH2Impl();
	unTurno.setIDTurno(dao.obtenerNuevoId()+1);
	
	UsuarioDAOH2Impl u = new UsuarioDAOH2Impl();
	try {
		u.cargarTurno(unTurno);
	} catch (ClaveDuplicadaException e) { 
		e.printStackTrace();
	}
}

public void SAltasEval(String vehiculoObtenido, List<Integer> puntajes) {
	Evaluacion unaEval = new Evaluacion();
	LocalDate fechaActual = LocalDate.now();
	java.sql.Date fechaActualParse = java.sql.Date.valueOf(fechaActual);
	unaEval.setVehiculo(vehiculoObtenido);
	unaEval.setPuntajes(puntajes);
	unaEval.setFecha(fechaActualParse);
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(fechaActualParse);
	calendar.add(Calendar.YEAR, 1);
	java.sql.Date fechaVencimiento = new java.sql.Date(calendar.getTimeInMillis());
	unaEval.setFechaVencimiento(fechaVencimiento);
	unaEval.setInspector(Sesion.obtenerUsuarioActual());
	boolean todosAprobados = puntajes.stream().allMatch(puntaje -> puntaje > 5);
	if (todosAprobados) {
	    unaEval.setEstado("Aprobado");
	} else {
	    unaEval.setEstado("Rechazado");
	}
	UsuarioDAOH2Impl u = new UsuarioDAOH2Impl();
	try {
		u.cargarEvaluacion(unaEval);
	} catch (ClaveDuplicadaException e) { 
		e.printStackTrace();
	}
}

    public String obtenerUltimoVehiculo() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAOH2Impl();
        	String ultimoTurno = usuarioDAO.obtenerUltimoTurno();
            if (ultimoTurno != null) {
                return ultimoTurno;
            } else {
                return "N/A";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener el vehículo";
        }
    }


}