package ejercicios3;

import javax.swing.JOptionPane;

public class Ejercicio04 {

	public static void main(String[] args) {
		//88.72 pago 100.00 50.00 25.00  5.00  1.00  //
					//division y resto//
	
		String str = JOptionPane.showInputDialog("Introduce el precio de la compra");
		int precio = Integer.parseInt(str);
		
		 str = JOptionPane.showInputDialog("Introduce el dinero a pagar");
		int dinero = Integer.parseInt(str);
		
		int vuelta = precio-dinero;
		System.out.println("Devuelvo " + (vuelta/100)+ " billetes de 100");
		vuelta = vuelta%100;
		
		System.out.println("Devuelvo " + (vuelta/50)+ " billetes de 50");
		vuelta = vuelta%50;
		
		System.out.println("Devuelvo " + (vuelta/25)+ " billetes de 25");
		vuelta = vuelta%25;
		
		System.out.println("Devuelvo " + (vuelta/5)+ " billetes de 5");
		vuelta = vuelta%5;
		
		System.out.println("Devuelvo " + (vuelta/1)+ " monedas de 1");
		vuelta = vuelta%1;
		
	}
}





