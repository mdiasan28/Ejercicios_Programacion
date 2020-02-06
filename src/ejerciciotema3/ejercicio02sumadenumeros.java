package ejerciciotema3;

import javax.swing.JOptionPane;

public class ejercicio02sumadenumeros {

	public static void main(String[] args) {
		
		int acumulador = 0;
		
		int numapedir= Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de  numeros"));
		
		for (int i=0; i<numapedir; i++) {
			int num= Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
		if (num > 10) {
			acumulador += num;
		
	
			}
		}
		System.out.println(acumulador);
	}
}

