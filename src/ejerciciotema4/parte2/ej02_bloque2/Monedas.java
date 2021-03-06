package ejerciciotema4.parte2.ej02_bloque2;

public class Monedas extends Antiguedades {
	private String pais;
	/**
	 * @param aņoFabricacion
	 * @param origen
	 * @param precioVenta
	 * @param pais
	 */
	public Monedas(int aņoFabricacion, String origen, int precioVenta, String pais) {
		super(aņoFabricacion, origen, precioVenta);
		this.pais = pais;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Monedas [pais=" + pais + ", getAņoFabricacion()=" + getAņoFabricacion() + ", getOrigen()=" + getOrigen()
				+ ", getPrecioVenta()=" + getPrecioVenta() + "]";
	}
	
}
