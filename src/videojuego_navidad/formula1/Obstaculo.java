package videojuego_navidad.formula1;

public class Obstaculo {

	protected int posicion;
	protected int modificacion;
	/**
	 * @param posicion
	 * @param impulso
	 */
	public Obstaculo(int posicion, int modificacion) {
		super();
		this.posicion = posicion;
		this.modificacion = modificacion;
	}
	/**
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	/**
	 * @return the impulso
	 */
	/**
	 * @return the espacio
	 */
	/**
	 * @return the modificacion
	 */
	public int getModificacion() {
		return modificacion;
	}
	/**
	 * @param modificacion the modificacion to set
	 */
	public void setModificacion(int modificacion) {
		this.modificacion = modificacion;
	}
	
}
