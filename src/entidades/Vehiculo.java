package entidades;

public class Vehiculo {


	private String matricula;
	private String modelo;
	private int año;
	private int dnipropietario;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	
	public int getDnipropietario() {
		return dnipropietario;
	}
	public void setDnipropietario(int dnipropietario) {
		this.dnipropietario = dnipropietario;
	}
	public Vehiculo(String matricula, String modelo, int año) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.año = año;
	}
	
	public Vehiculo(String matricula, String modelo, int año, int dnipropietario) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.año = año;
		this.dnipropietario = dnipropietario;
	}
	public Vehiculo() {

	}
	
	
	
}
