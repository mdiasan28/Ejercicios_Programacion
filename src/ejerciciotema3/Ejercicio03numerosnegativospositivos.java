package ejerciciotema3;

import javax.swing.JOptionPane;

public class Ejercicio03numerosnegativospositivos {
	public static void main(String[] args) {

		int acumuladornegativo = 0;
		int acumuladorpositivo = 0;
		
		int numapedir= Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de  numeros"));
		
		for (int i=0; i<numapedir; i++) {
			int num= Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
		if (num < 0) {
			acumuladornegativo++;
				}
		else  acumuladorpositivo++;
		}
		System.out.println( "Has introducidos " + acumuladorpositivo);
		System.out.println("Has introducido " + acumuladornegativo);
	}
}

		
		
		

