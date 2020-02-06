package ejerciciotema4.parte2.ej03_bloque2;

public class Hojas extends Arbol {
	
	/**
	 * @param nombre
	 */
	public Hojas(String nombre) {
		super();
		this.nombre = nombre;
	}

	private String nombre;
	

	@Override
	public String toString() {
		return "Hojas [nombre=" + nombre + "]";
	}

	/**
	 * 
	 */
	

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
	
}
