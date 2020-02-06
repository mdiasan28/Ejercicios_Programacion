package ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio02 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca un número");
		int num1 = Integer.parseInt(str);
		 str = JOptionPane.showInputDialog("Introduzca un número");
		 int num2 = Integer.parseInt(str);
		 str = JOptionPane.showInputDialog("Introduzca un número");
		 int num3 = Integer.parseInt(str);
		 
		 int mayor;
		 
		 // Comparación por si los tres son iguales

		 if(num1 == num2 && num2 == num3) {
			  System.out.println("Los tres números son iguales");
	}
		 else {
			  System.out.println(num2);
	}
  }
}
