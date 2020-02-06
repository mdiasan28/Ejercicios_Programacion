package ejercicio5.bloque03;

import Programacion.Utils_arrays;

public class ejercicio02_inserccion_directa {

	public static void main(String[] args) {

		int array[] =  Utils_arrays.CrearArrayNumAleatorio(10, 0, 100);
		int j;
		Utils_arrays.MostrarArray(array);
		
		for (int i = 0; i < array.length; i++) {
			int acumulador= array[i];
			
			for ( j=i; j > 0 && array[j - 1] > acumulador; j--) {
				array[j]= array [j-1];
				
				}
			 array[j]= acumulador;
		}
		Utils_arrays.MostrarArray(array);
	}

}
