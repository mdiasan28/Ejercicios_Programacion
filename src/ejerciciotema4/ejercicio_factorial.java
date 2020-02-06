package ejerciciotema4;

import javax.swing.JOptionPane;

public class ejercicio_factorial {

	public static void main(String[] args) {
		int numero= Integer.parseInt(JOptionPane.showInputDialog("Introduce tu número factorial"));
		
		for (int i=numero-1; i>1; i--) {
			int factorial= numero * i;
			System.out.println(numero + " x " + i + " = " + factorial);
		}

	}

}
