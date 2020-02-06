package ejercicios;

import javax.swing.JOptionPane;

public class Ejercicios {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca un número");
		int num1 = Integer.parseInt(str);
		 str = JOptionPane.showInputDialog("Introduzca un número");
		 int num2 = Integer.parseInt(str);
		 if (num1 > num2) {
			 System.out.println(num1 +" es mayor que "+ num2 );
		                 }
		 else {
			 System.out.println(num1 +" es menor que "+ num2);
		 }
	}

}
