package ejerciciotema5.bloque02;

import Programacion.Utils;

public class ejercicio03bloque02 {
	public static void main(String[] args) {
		int numeros[] = new int[150];
		
		int multiplicaci�n =0;
		
		for ( int i = 0; i < numeros.length; i++) {
			numeros[i] = (int)Math.round(Math.random()*100);
			 System.out.print(numeros[i] + " "); 
		}
		int m�ltiplo = Utils.obtenerNumUsuario("Introduce un n�mero");
		for ( int i = 0; i < numeros.length; i++) {
			multiplicaci�n = numeros[i] * m�ltiplo;
			 System.out.println("\n" + numeros[i]+ " x " +  m�ltiplo + " = " + multiplicaci�n);
		}
	}

}
