package ejerciciotema4.parte2.ej02_bloque2;

public class Cuadro extends Antiguedades {
	private String estilo;
	/**
	 * @param añoFabricacion
	 * @param origen
	 * @param precioVenta
	 * @param estilo
	 */
	public Cuadro(int añoFabricacion, String origen, int precioVenta, String estilo) {
		super(añoFabricacion, origen, precioVenta);
		this.estilo = estilo;
	}

	/**
	 * @return the estilo
	 */
	public String getEstilo() {
		return estilo;
	}

	/**
	 * @param estilo the estilo to set
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return "Cuadro [estilo=" + estilo + ", getAñoFabricacion()=" + getAñoFabricacion() + ", getOrigen()="
				+ getOrigen() + ", getPrecioVenta()=" + getPrecioVenta() + "]";
	}
	

}
