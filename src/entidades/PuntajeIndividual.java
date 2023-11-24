package entidades;

public class PuntajeIndividual {

	public int ID;
	public String descripcion;
	public int puntaje;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public PuntajeIndividual(int iD, String descripcion, int puntaje) {
		super();
		ID = iD;
		this.descripcion = descripcion;
		this.puntaje = puntaje;
	}
	
	
}
