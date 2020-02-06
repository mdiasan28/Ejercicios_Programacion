package videojuego_navidad.formula1_no_funciona;

import java.awt.Color;
import java.awt.Graphics;

import Programacion.Utils;

public abstract class Coche extends Vehiculo {

	/**
	 * @param nombre
	 * @param posicion
	 * @param color
	 * @param pista
	 * @param jugadores
	 */
	public Coche(String nombre, int posicion) {
		super(nombre, posicion);
	}
	public void avanza() {
		setPosicion(this.getPosicion() +  Utils.obtenerNumeroAzarentreLimites(1, 5));
	}
	
	public void paint(Graphics g) {
	}
	
}
