package videojuego_navidad.formula1_no_funciona;

import java.awt.Graphics;

import Programacion.Utils;

public class Mancha_de_aceite extends Obstaculo {
	

	public Mancha_de_aceite(int posicion, int modificacion) {
		super(posicion, modificacion);
		this.modificacion = Utils.obtenerNumeroAzarentreLimites(-5, -25);
		this.posicion = Utils.obtenerNumeroAzarentreLimites(30, 99);
	}
	
	public void paint(Graphics g) {
		
	}

}
