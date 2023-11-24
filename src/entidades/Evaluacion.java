package entidades;

import java.sql.Date;
import java.util.List;

public class Evaluacion {
	
	public int ID;
	public Date fecha;
	//public List<PuntajeIndividual> puntajes;
	public List<Integer> puntajes;
	public String estado;
	public Date fechaVencimiento;
	public Usuario inspector;
	public String vehiculo;
	//public Certificado certificado;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date date) {
		this.fecha = date;
	}
	public List<Integer> getPuntajes() {
		return puntajes;
	}
	public void setPuntajes(List<Integer> puntajes) {
		this.puntajes = puntajes;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public Usuario getInspector() {
		return inspector;
	}
	public void setInspector(Usuario inspector) {
		this.inspector = inspector;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	/*public Certificado getCertificado() {
		return certificado;
	}
	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}*/
	/*public Evaluacion(int iD, Date fecha, List<Integer> puntajes, String notas, String estado,
			Date fechaVencimiento, Certificado certificado) {
		super();
		ID = iD;
		this.fecha = fecha;
		this.puntajes = puntajes;
		this.notas = notas;
		this.estado = estado;
		this.fechaVencimiento = fechaVencimiento;
		//this.certificado = certificado;
	}*/
	
	
	public Evaluacion() {
		// TODO Auto-generated constructor stub
	}
	public Evaluacion(int iD, Date fecha, List<Integer> puntajes, String notas, String estado, Date fechaVencimiento,
			Usuario inspector, String vehiculo) {
		super();
		ID = iD;
		this.fecha = fecha;
		this.puntajes = puntajes;
		this.estado = estado;
		this.fechaVencimiento = fechaVencimiento;
		this.inspector = inspector;
		this.vehiculo = vehiculo;
	}
	
	

}
