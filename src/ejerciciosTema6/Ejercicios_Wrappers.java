package ejerciciosTema6;

import javax.swing.JOptionPane;

public class Ejercicios_Wrappers {

	public static void main(String[] args) {
//		ej1();
//		ej2();
		ej3();

	}

	public static void ej1(){

		// Wrapper para el tipo de datos "Byte"
		System.out.println("Valor m�ximo para un Byte: " + Byte.MAX_VALUE);
		System.out.println("Valor m�nimo para un Byte: " + Byte.MIN_VALUE);
		System.out.println("Tama�o en bits complemento a 2 para Byte: " + Byte.SIZE);
		
		// Wrapper para el tipo de datos "int"
		System.out.println("Valor m�ximo para un Integer: " + Integer.MAX_VALUE);
		System.out.println("Valor m�nimo para un Integer: " + Integer.MIN_VALUE);
		System.out.println("Tama�o en bits complemento a 2 para Integer: " + Integer.SIZE);

		// Wrapper para el tipo de datos "long"
		System.out.println("\nValor m�ximo para un Long: " + Long.MAX_VALUE);
		System.out.println("Valor m�nimo para un Long: " + Long.MIN_VALUE);
		System.out.println("Tama�o en bits complemento a 2 para Long: " + Long.SIZE);

		// Wrapper para el tipo de datos "short"
		System.out.println("\nValor m�ximo para un Short: " + Short.MAX_VALUE);
		System.out.println("Valor m�nimo para un Short: " + Short.MIN_VALUE);
		System.out.println("Tama�o en bits complemento a 2 para Short: " + Short.SIZE);

		// Wrapper para el tipo de datos "float"
		System.out.println("\nValor m�ximo para un Float: " + Float.MAX_VALUE);
		System.out.println("Valor m�nimo para un Float: " + Float.MIN_VALUE);
		System.out.println("Tama�o en bits complemento a 2 para Float: " + Float.SIZE);

		// Wrapper para el tipo de datos "double"
		System.out.println("\nValor m�ximo para un Double: " + Double.MAX_VALUE);
		System.out.println("Valor m�nimo para un Double: " + Double.MIN_VALUE);
		System.out.println("Tama�o en bits complemento a 2 para Double: " + Double.SIZE);
	}

	public static void ej2(){
		boolean mayuscula= false;
		boolean minuscula = false;
		boolean alfanumerico = false;
		boolean digito = false;
		
		int indice=0;
		boolean hecho=false;
		do {
			String contrase�a = (String) JOptionPane.showInputDialog("Introduce una contrase�a");
			for ( indice = 0; indice < contrase�a.length(); indice++) {
				char str = contrase�a.charAt(indice);
				if (Character.isLowerCase(str)) {
					minuscula=true;
				}
				if (Character.isUpperCase(str)) {
					mayuscula=true;
				}
				if (Character.isAlphabetic(str)) {
					alfanumerico = true;
				}
				if (Character.isDigit(str)) {
					digito = true;
				}
			}
			if (minuscula==true && mayuscula==true && digito==true && alfanumerico==true) {
				hecho=true;
				System.out.println("Contrase�a introducida correctamente");
			}
			else {
				System.out.println("Contrase�a introducida incorrectamente intentalo de nuevo");
			}
		} while (!hecho);
		
	}
	
	public static void ej3() {
		for (int i = 1; i < 100; i++) {
			System.out.println("El n�mero " + i + " en base 16 " + Integer.toHexString(i));
		}
	}

}


