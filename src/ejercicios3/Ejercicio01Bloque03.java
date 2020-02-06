package ejercicios3;

import javax.swing.JOptionPane;

public class Ejercicio01Bloque03 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog(" 1.-Raiz\n"
				+ "  2.-Potencia\n"
				+ "  3.-Resto de una division\n\n "
				+"Introduce un numero \n");
		int opt= Integer.parseInt(str);
		
		
		
		switch (opt) {
		
		default: System.out.println("Operacion no permitida");
		break;
		
		case 1: String str1 = JOptionPane.showInputDialog("introduce tu numero");
		int num1= Integer.parseInt(str1);
		
		str1 = JOptionPane.showInputDialog("introduce tu exponente de la raiz");
		int raiz= Integer.parseInt(str1);
		
		float solucion= (float) Math.pow(num1, (float)1/raiz);
		
		System.out.println(solucion);
		
		break;
		
		case 2: String str2 = JOptionPane.showInputDialog("introduce tu numero");
		int num2= Integer.parseInt(str2);
		
		str2 = JOptionPane.showInputDialog("introduce tu exponente");
		float exponente= Integer.parseInt(str2);
		
		float solucion1= (float) Math.pow(num2,exponente);
		
		System.out.println(solucion1);
		
		break;
		
		case 3:  String str3 = JOptionPane.showInputDialog("introduce tu divisor");
		int num3= Integer.parseInt(str3);
		
		str3 = JOptionPane.showInputDialog("introduce tu dividendo");
		float dividendo= Integer.parseInt(str3);
		
		float solucion2 = num3 % dividendo; //esta opcion nos permite averiguar el resto de una división//
		
		System.out.println(solucion2);
		
		
		
		
		
		
		
		
		}
	}

}
