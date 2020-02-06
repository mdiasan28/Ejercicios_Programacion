package videojuego_navidad.formula1;

import java.awt.Graphics;

import Programacion.Utils;

public class Rampa extends Obstaculo {
	
	public Rampa(int posicion, int impulso, int modificacion) {
		super(posicion, modificacion);
		this.modificacion = Utils.obtenerNumeroAzarentreLimites(5, 25);
		this.posicion = Utils.obtenerNumeroAzarentreLimites(1, 85);
	}

	public void paint(Graphics g) {
	}

}
