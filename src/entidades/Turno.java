package entidades;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Turno {

	public int IDTurno;
	public String fechayhora;
	public String estado;
	public String vehiculo;
	public Vehiculo VehiculoV;
	public Usuario Usuario;
	public String usuarioS;
	public String sede;
	
	public int getIDTurno() {
		return IDTurno;
	}

	public void setIDTurno(int iDTurno) {
		IDTurno = iDTurno;
	}

	public String getFechayhora() {
		return fechayhora;
	}

	public void setFechayhora(String fecha) {
		this.fechayhora = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
	
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Vehiculo getVehiculoV() {
		return VehiculoV;
	}

	public void setVehiculoV(Vehiculo vehiculoV) {
		this.VehiculoV = vehiculoV;
	}

	public String getUsuarioS() {
		return usuarioS;
	}

	public void setUsuarioS(String usuarioS) {
		usuarioS = usuarioS;
	}

	public Turno(int iDTurno, String fechayhora, String estado, String vehiculo, String sede, entidades.Usuario usuario) {
		super();
		IDTurno = iDTurno;
		this.fechayhora = fechayhora;
		this.estado = estado;
		this.vehiculo = vehiculo;
		Usuario = usuario;
		this.sede = sede;
	}
	
	public Turno(int iDTurno, String fechayhora, String estado, Vehiculo vehiculoV, String sede, String usuarioS) {
		super();
		IDTurno = iDTurno;
		this.fechayhora = fechayhora;
		this.estado = estado;
		vehiculoV = VehiculoV;
		this.usuarioS = usuarioS;
		this.sede = sede;
	}

	public Turno() {
		
	}
	
}
