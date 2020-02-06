package videojuego_navidad.formula1;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Moto extends Vehiculo {

	/**
	 * @param nombre
	 * @param posicion
	 * @param color
	 * @param pista
	 * @param jugadores
	 */
	public Moto(String nombre, int posicion) {
		super(nombre, posicion);
	}

	public void paint(Graphics g) {
	}
	

}
