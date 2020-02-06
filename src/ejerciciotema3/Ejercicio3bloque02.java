package ejerciciotema3;

import javax.swing.JOptionPane;

public class Ejercicio3bloque02 {

	public static void main(String[] args) {
		
int factor = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número"));

		
		for (int i = 1; i <100; i++) {
			int multiplo = i*factor;
			if (multiplo<100) {
			System.out.println(i + " x " + factor + " = " + multiplo );
			}
			
		}
	}
}
