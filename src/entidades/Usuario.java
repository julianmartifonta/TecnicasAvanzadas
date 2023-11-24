package entidades;

import java.util.List;

public class Usuario {

	public int DNI;
	public String nombreUsuario;
	public String nombre;
	public String apellido;
	public double celular;
	public String contraseña;
	public boolean esAdmin;
	public List<String> vehiculos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public double getCelular() {
		return celular;
	}
	public void setCelular(double celular) {
		this.celular = celular;
	}
	
	
	
	public boolean isEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	public List<String> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<String> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public Usuario(int DNI, String nombreUsuario, String nombre, String apellido, double celular, String contraseña, boolean esAdmin) {
		this.DNI = DNI;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.contraseña = contraseña;
		this.esAdmin = esAdmin;
		
	}
	public Usuario(int dNI, String nombreUsuario, String nombre, String apellido, double celular, String contraseña,
			boolean esAdmin, List<String> vehiculos) {
		super();
		DNI = dNI;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.contraseña = contraseña;
		this.esAdmin = esAdmin;
		this.vehiculos = vehiculos;
	}
	
	
	
}
