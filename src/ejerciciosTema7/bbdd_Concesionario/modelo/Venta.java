package ejerciciosTema7.bbdd_Concesionario.modelo;

import java.sql.Date;

public class Venta {

	int id;
	int idcliente;
	int idconcesionario;
	int idcoche;
	Date fecha;
	Float precioventa;
	

	public Venta() {
	}

	public Venta(int id, int idcliente, int idconcesionario, int idcoche, Date fecha, Float precioventa) {
		super();
		this.id = id;
		this.idcliente = idcliente;
		this.idconcesionario = idconcesionario;
		this.idcoche = idcoche;
		this.fecha = fecha;
		this.precioventa = precioventa;
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
	 * @return the idcliente
	 */
	public int getIdcliente() {
		return idcliente;
	}

	/**
	 * @param idcliente the idcliente to set
	 */
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	/**
	 * @return the idconcesionario
	 */
	public int getIdconcesionario() {
		return idconcesionario;
	}

	/**
	 * @param idconcesionario the idconcesionario to set
	 */
	public void setIdconcesionario(int idconcesionario) {
		this.idconcesionario = idconcesionario;
	}

	/**
	 * @return the idcoche
	 */
	public int getIdcoche() {
		return idcoche;
	}

	/**
	 * @param idcoche the idcoche to set
	 */
	public void setIdcoche(int idcoche) {
		this.idcoche = idcoche;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the precioventa
	 */
	public Float getPrecioventa() {
		return precioventa;
	}

	/**
	 * @param string the precioventa to set
	 */
	public void setPrecioventa(Float string) {
		this.precioventa = string;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", idcliente=" + idcliente + ", idconcesionario=" + idconcesionario + ", idcoche="
				+ idcoche + ", fecha=" + fecha + ", precioventa=" + precioventa + "]";
	}
	
	
	
}
