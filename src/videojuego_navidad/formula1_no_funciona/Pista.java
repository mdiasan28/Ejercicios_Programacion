package videojuego_navidad.formula1_no_funciona;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import examen_oficial.Utils;

public class Pista {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	/**
	 * 
	 */
	public  Pista() {
		JFrame ventana = new JFrame("Formula 1");
		ventana.setBounds(0,0,WIDTH,HEIGHT);
		ventana.setVisible(true);
	}
	
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(null,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	List<Vehiculo> jugadores = new ArrayList<Vehiculo>();
	int longitud = 100;

	public void crearPista() {
		for (int i = 0; i < jugadores.size(); i++) {
			int num = Utils.obtenerNumeroAzarentreLimites(0, 1);
			if (num == 0) {
				Rampa rampa = new Rampa(num, num, num);
			}
			else {
			Mancha_de_aceite mancha = new Mancha_de_aceite(num, num);
			}
		}
	}
//	public static void main(String[] args) {
//		 Pantalla inv = new  Pantalla();
//	}
}
