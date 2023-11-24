package entidades;

public class Inspeccion {
	
	public int ID;
	public Usuario inspector;
	public Vehiculo vehiculo;
	public int puntaje;
	public Certificado certificado;
	public Evaluacion evaluacion;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Usuario getInspector() {
		return inspector;
	}
	public void setInspector(Usuario inspector) {
		this.inspector = inspector;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public Certificado getCertificado() {
		return certificado;
	}
	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}
	public Inspeccion(int iD, Usuario inspector, Vehiculo vehiculo, int puntaje, Certificado certificado, Evaluacion evaluacion) {
		super();
		ID = iD;
		this.inspector = inspector;
		this.vehiculo = vehiculo;
		this.puntaje = puntaje;
		this.certificado = certificado;
		this.evaluacion = evaluacion;
	}
	
	
	

}
