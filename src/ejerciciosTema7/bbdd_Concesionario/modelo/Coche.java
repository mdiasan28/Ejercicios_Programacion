package ejerciciosTema7.bbdd_Concesionario.modelo;

import java.sql.Date;

public class Coche {

	int id;
	int idfabricante;
	String bastidor;
	String modelo;
	String color;
	

	public Coche() {
	}
	
	public Coche(int id, int idfabricante, String bastidor,String modelo,String color) {
		super();
		this.id = id;
		this.idfabricante = idfabricante;
		this.bastidor = bastidor;
		this.modelo = modelo;
		this.color = color;
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
	 * @return the idfabricante
	 */
	public int getIdfabricante() {
		return idfabricante;
	}

	/**
	 * @param idfabricante the idfabricante to set
	 */
	public void setIdfabricante(int idfabricante) {
		this.idfabricante = idfabricante;
	}

	/**
	 * @return the bastidor
	 */
	public String getBastidor() {
		return bastidor;
	}

	/**
	 * @param bastidor the bastidor to set
	 */
	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", idfabricante=" + idfabricante + ", bastidor=" + bastidor + ", modelo=" + modelo
				+ ", color=" + color + "]";
	}

}
