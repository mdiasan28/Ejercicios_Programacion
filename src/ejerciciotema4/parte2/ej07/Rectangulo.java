package ejerciciotema4.parte2.ej07;

public class Rectangulo {
	private int ancho;
	private int alto;
	int rectangulo[][] = new int [ancho][alto];
/**
 * 
 * @param ancho
 * @param alto
 */
	public Rectangulo(int ancho, int alto) {
		super();
		this.ancho=ancho;
		this.alto=alto;
		
	}


	public void imprimirEnConsola () {
		for (int i = 0; i < getAncho(); i++) {
			for (int j = 0; j < getAlto(); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}


	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}


	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}


	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}


	/**
	 * @return the rectangulo
	 */
	public int[][] getRectangulo() {
		return rectangulo;
	}


	/**
	 * @param rectangulo the rectangulo to set
	 */
	public void setRectangulo(int[][] rectangulo) {
		this.rectangulo = rectangulo;
	}
	
}
