package ejerciciotema5.bloque02;

import Programacion.Utils;

public class ejercicio03bloque02 {
	public static void main(String[] args) {
		int numeros[] = new int[150];
		
		int multiplicación =0;
		
		for ( int i = 0; i < numeros.length; i++) {
			numeros[i] = (int)Math.round(Math.random()*100);
			 System.out.print(numeros[i] + " "); 
		}
		int múltiplo = Utils.obtenerNumUsuario("Introduce un número");
		for ( int i = 0; i < numeros.length; i++) {
			multiplicación = numeros[i] * múltiplo;
			 System.out.println("\n" + numeros[i]+ " x " +  múltiplo + " = " + multiplicación);
		}
	}

}
