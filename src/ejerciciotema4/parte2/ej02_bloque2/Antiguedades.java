package ejerciciotema4.parte2.ej02_bloque2;

public class Antiguedades {
	
	private int aņoFabricacion;
	private String origen;
	private int precioVenta;
	/**
	 * @param aņoFabricacion
	 * @param origen
	 * @param precioVenta
	 */
	public Antiguedades(int aņoFabricacion, String origen, int precioVenta) {
		super();
		this.aņoFabricacion = aņoFabricacion;
		this.origen = origen;
		this.precioVenta = precioVenta;
	}
	
	@Override
	public String toString() {
		return "Antiguedades [aņoFabricacion=" + aņoFabricacion + ", origen=" + origen + ", precioVenta=" + precioVenta
				+ "]";
	}

	/**
	 * @return the aņoFabricacion
	 */
	public int getAņoFabricacion() {
		return aņoFabricacion;
	}
	/**
	 * @param aņoFabricacion the aņoFabricacion to set
	 */
	public void setAņoFabricacion(int aņoFabricacion) {
		this.aņoFabricacion = aņoFabricacion;
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
