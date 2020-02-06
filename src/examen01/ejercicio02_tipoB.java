package examen01;

import examen_oficial.Utils;

public class ejercicio02_tipoB {

	public static void main(String[] args) {
		boolean primo = false;
		int numero = 4;
		int contador = 0;
		for(int i = numero; i > 0; i--){
		    if(numero % i == 0 ){
		        contador++;
		    }
		}
		if(contador == 2){
		    primo = true;
		}
		if (primo) {
			System.out.println("El número es primo");
		}
		else System.out.println("El número no es primo");
		
	}
}
