package ejerciciotema4.parte2.ej02_bloque2;

public class Antiguedades {
	
	private int a�oFabricacion;
	private String origen;
	private int precioVenta;
	/**
	 * @param a�oFabricacion
	 * @param origen
	 * @param precioVenta
	 */
	public Antiguedades(int a�oFabricacion, String origen, int precioVenta) {
		super();
		this.a�oFabricacion = a�oFabricacion;
		this.origen = origen;
		this.precioVenta = precioVenta;
	}
	
	@Override
	public String toString() {
		return "Antiguedades [a�oFabricacion=" + a�oFabricacion + ", origen=" + origen + ", precioVenta=" + precioVenta
				+ "]";
	}

	/**
	 * @return the a�oFabricacion
	 */
	public int getA�oFabricacion() {
		return a�oFabricacion;
	}
	/**
	 * @param a�oFabricacion the a�oFabricacion to set
	 */
	public void setA�oFabricacion(int a�oFabricacion) {
		this.a�oFabricacion = a�oFabricacion;
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
