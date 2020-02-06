package ejerciciotema4.parte2.ej02_bloque2;

public class Antiguedades {
	
	private int añoFabricacion;
	private String origen;
	private int precioVenta;
	/**
	 * @param añoFabricacion
	 * @param origen
	 * @param precioVenta
	 */
	public Antiguedades(int añoFabricacion, String origen, int precioVenta) {
		super();
		this.añoFabricacion = añoFabricacion;
		this.origen = origen;
		this.precioVenta = precioVenta;
	}
	
	@Override
	public String toString() {
		return "Antiguedades [añoFabricacion=" + añoFabricacion + ", origen=" + origen + ", precioVenta=" + precioVenta
				+ "]";
	}

	/**
	 * @return the añoFabricacion
	 */
	public int getAñoFabricacion() {
		return añoFabricacion;
	}
	/**
	 * @param añoFabricacion the añoFabricacion to set
	 */
	public void setAñoFabricacion(int añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}
	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * @return the precioVenta
	 */
	public int getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	

}
