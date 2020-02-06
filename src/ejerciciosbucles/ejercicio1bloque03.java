package ejerciciosbucles;

import javax.swing.JOptionPane;

public class ejercicio1bloque03 {

	public static void main(String[] args) {
		
		int suma=0;
		int numero =-2;
		while (numero!=0) {
		numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número \n 0 para cerrar"));
		suma+=numero;
		}
		System.out.println("La suma es  " + suma);
	}
	

}
