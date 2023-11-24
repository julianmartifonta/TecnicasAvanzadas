package entidades;

public class Vehiculo {


	private String matricula;
	private String modelo;
	private int a�o;
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
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	
	public int getDnipropietario() {
		return dnipropietario;
	}
	public void setDnipropietario(int dnipropietario) {
		this.dnipropietario = dnipropietario;
	}
	public Vehiculo(String matricula, String modelo, int a�o) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.a�o = a�o;
	}
	
	public Vehiculo(String matricula, String modelo, int a�o, int dnipropietario) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.a�o = a�o;
		this.dnipropietario = dnipropietario;
	}
	public Vehiculo() {

	}
	
	
	
}
