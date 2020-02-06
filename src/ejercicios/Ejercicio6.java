package ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		String str = JOptionPane.showInputDialog("Introduce un número");
		int num1= Integer.parseInt(str);
		
		if (num1 % 2 == 0)
			System.out.println("El número es par");
	
		else {
		System.out.println("El número es impar");
		
		
		}
	}
}
