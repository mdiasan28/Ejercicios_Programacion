package ventanas;


import javax.swing.JButton;

/**
 * Clase que hereda de JButton para poder tener información de la fila y la columna donde se encuentra un botón en una matriz.
 * También incluye un atributo y métodos para manejar un valor entero como label
 * @author portatil
 *
 */
public class BotonInt extends JButton{
	int valorInt;
	int fil;
	int col;
	
	/**
	 * @return the fil
	 */
	public int getFil() {
		return fil;
	}

	/**
	 * @param fil the fil to set
	 */
	public void setFil(int fil) {
		this.fil = fil;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	public BotonInt() {
		super();
		this.valorInt = -1;
	}

	/**
	 * Constructor nuevo
	 * @param valorInt valor entero para la etiqueta del botón
	 * @param fil fila de la matriz donde se encuentra el botón
	 * @param col columna de la matriz donde se encuentra el botón
	 */
	public BotonInt(int valorInt, int fil, int col) {
		setText(Integer.toString(valorInt));
		this.valorInt = valorInt;
		this.fil = fil;
		this.col = col;
	}
	
	/**
	 * @return the valorInt
	 */
	public int getValorInt() {
		return valorInt;
	}

	/**
	 * Metodo que asigna un número al botón y lo muestra como label
	 * @param valorInt the valorInt to set
	 */
	public void setValorInt(int valorInt) {
		this.valorInt = valorInt;
		setText(Integer.toString(valorInt));
	}

}
