package ejerciciotema4.parte2.ej02_bloque2;

public class Reloj extends Antiguedades {
	private String material;
	/**
	 * @param aņoFabricacion
	 * @param origen
	 * @param precioVenta
	 * @param material
	 */
	public Reloj(int aņoFabricacion, String origen, int precioVenta, String material) {
		super(aņoFabricacion, origen, precioVenta);
		this.material = material;
	}
	@Override
	public String toString() {
		return "Reloj [material=" + material + ", getAņoFabricacion()=" + getAņoFabricacion() + ", getOrigen()="
				+ getOrigen() + ", getPrecioVenta()=" + getPrecioVenta();
	}
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	

}
