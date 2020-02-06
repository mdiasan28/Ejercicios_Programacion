package ejerciciotema3;

import javax.swing.JOptionPane;

public class Ejercicio1bloque01 {

	public static void main(String[] args) {
		
		int acumulador = 0;
		
		for (int i=0; i<5; i++) {
			int num= Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
		if (num > 10) {
			acumulador += num;
		
	
				}
			}
		System.out.println(acumulador);
		}
	}
