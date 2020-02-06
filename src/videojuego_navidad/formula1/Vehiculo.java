package videojuego_navidad.formula1;

import java.awt.Color;
import java.awt.Graphics;

import Programacion.Utils;

public abstract class Vehiculo{

	
	//Variables de la clase Vehiculo
	private String nombre;
	private int posicion;
	
	/**
	 * @param nombre
	 * @param i
	 * @param jugadores
	 */
	public Vehiculo(String nombre, int posicion) {
		super();
		this.nombre = nombre;
		this.posicion = 0;
	}

	public abstract void paint(Graphics g);
	
	public void avanza() {
		this.posicion =  Utils.obtenerNumeroAzarentreLimites(1, 6);
		
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
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	/**
	 * @return the jugadores
	 */
	

}
