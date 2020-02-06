package ejercicio5.bloque03;

import Programacion.Utils_arrays;

public class ejercicio03_ordenacion_shell {

	public static void main(String[] args) {
		int array[] =  Utils_arrays.CrearArrayNumAleatorio(10, 0, 100);
		Utils_arrays.MostrarArray(array);
		int j;
		boolean esmayor= false;
		int divisor =array.length;
		
		do {
			esmayor =false;
			
			divisor =divisor/2;
			for (int i = divisor; i < array.length; i++) {
			int acumulador= array[i];
			for ( j = i; j >= (divisor) && array[j-(divisor)]>acumulador;  j-=divisor) {
				array[j]= array[j-divisor];
				esmayor=true;

			
			}
			array[j]=acumulador;
		}
		}while (esmayor==true);
		
		Utils_arrays.MostrarArray(array);

	}

}
