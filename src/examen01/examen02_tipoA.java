package examen01;

import javax.swing.JOptionPane;

import Programacion.Utils_arrays;

public class examen02_tipoA {

	public static void main(String[] args) {
		int limiteInf, limiteSup;
		int numeros[] = new int[150];
		
		// Petici�n de l�mites al usuario
		limiteInf = Integer.parseInt(JOptionPane.showInputDialog("Introduzca l�mite inferior"));
		limiteSup = Integer.parseInt(JOptionPane.showInputDialog("Introduzca l�mite superior"));

		// Inicializamos el contenido del array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) Math.round(Math.random() * (limiteSup - limiteInf) + limiteInf);
		}
		
		// Imprimir en la consola el array creado
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		
		// Imprimo un salto de l�nea
		System.out.println();
		
		for (int i = numeros.length - 1; i > -1; i--) {
			System.out.print(numeros[i] + " ");

		}
	}

}
