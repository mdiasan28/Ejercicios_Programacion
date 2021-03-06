package ejerciciotema4.parte2.ej02_bloque2;

public class Libros extends Antiguedades {
	private String titulo;
	private String autor;
	/**
	 * @param aņoFabricacion
	 * @param origen
	 * @param precioVenta
	 * @param titulo
	 * @param autor
	 */
	public Libros(int aņoFabricacion, String origen, int precioVenta, String titulo, String autor) {
		super(aņoFabricacion, origen, precioVenta);
		this.titulo = titulo;
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Libros [titulo=" + titulo + ", autor=" + autor + ", getAņoFabricacion()=" + getAņoFabricacion()
				+ ", getOrigen()=" + getOrigen() + ", getPrecioVenta()=" + getPrecioVenta() + "]";
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	

}
