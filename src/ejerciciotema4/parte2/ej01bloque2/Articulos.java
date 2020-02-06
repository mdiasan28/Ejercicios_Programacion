package ejerciciotema4.parte2.ej01bloque2;

import javax.swing.JOptionPane;

public class Articulos {
	private static String codigo;
	private static String nombre;
	private static String precio;
	private static String caducidad;
	
	/**
	 * 
	 */
	public Articulos() {
		super();
		Articulos.codigo = JOptionPane.showInputDialog("Introduce el codigo");
		Articulos.nombre = JOptionPane.showInputDialog("Introduce el nombre del articulo");;
		Articulos.precio = JOptionPane.showInputDialog("Introduce el precio");
		Articulos.caducidad = JOptionPane.showInputDialog("Introduce la caducidad del objeto si la tiene");
	}
	public static void imprimeEnConsola () {
		System.out.println("Persona: " + "Codigo:" + codigo +" Nombre del articulo:" + nombre +" Precio: " + precio + " Caducidad" + caducidad);
		}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
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
	/**
	 * @return the precio
	 */
	public String getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
}
