package ejerciciosTema7.bbdd_Concesionario.modelo;

import java.sql.Date;

public class Cliente {

	int id;
	String nombre;
	String apellidos;
	String localidad;
	String dniNie;
	Date fechaNac;
	boolean activo;
	

	public Cliente() {
	}
	
	public Cliente(int id, String nombre, String apellidos, String localidad, String dniNie, Date fechaNac,
			boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.localidad = localidad;
		this.dniNie = dniNie;
		this.fechaNac = fechaNac;
		this.activo = activo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the dniNie
	 */
	public String getDniNie() {
		return dniNie;
	}

	/**
	 * @param dniNie the dniNie to set
	 */
	public void setDniNie(String dniNie) {
		this.dniNie = dniNie;
	}

	/**
	 * @return the fechaNac
	 */
	public Date getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param date the fechaNac to set
	 */
	public void setFechaNac(Date date) {
		this.fechaNac = date;
	}

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", localidad=" + localidad
				+ ", dniNie=" + dniNie + ", fechaNac=" + fechaNac + ", activo=" + activo + "]";
	}

	



}
