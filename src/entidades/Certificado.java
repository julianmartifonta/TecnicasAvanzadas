package entidades;

import java.sql.Date;

public class Certificado {

	public int ID;
	public Vehiculo vehiculo;
	public Date fechaEmision;
	public Date fechaVencimiento;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Certificado(int iD, Vehiculo vehiculo, Date fechaEmision, Date fechaVencimiento) {
		super();
		ID = iD;
		this.vehiculo = vehiculo;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
}
