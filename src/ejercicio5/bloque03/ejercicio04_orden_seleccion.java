package ejercicio5.bloque03;

import Programacion.Utils_arrays;

public class ejercicio04_orden_seleccion {

	public static void main(String[] args) {
		int array[] =  Utils_arrays.CrearArrayNumAleatorio(10, 0, 100);
		Utils_arrays.MostrarArray(array);
		int j;
		int intercambio = 0;
		
		for (int i = 0; i < array.length - 1; i++) {
			int peque�o= i;
			
			for ( j = i; j < array.length; j++) {
				if (array[j] < array[peque�o]){
					peque�o =j;

				}
			}
			intercambio= array[i];
			array[i]=array[peque�o];
			array[peque�o]= intercambio;
		}
		Utils_arrays.MostrarArray(array);
	}
}
