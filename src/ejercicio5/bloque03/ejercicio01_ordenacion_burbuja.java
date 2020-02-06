package ejercicio5.bloque03;

import Programacion.Utils_arrays;

public class ejercicio01_ordenacion_burbuja {

	public static void main(String[] args) {

		int array[] =  Utils_arrays.CrearArrayNumAleatorio(10, 0, 100);
		Utils_arrays.MostrarArray(array);
		boolean esmayor= false;
		
		do {
			esmayor =false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i+1]) { //BUSCA EL NUMERO SIGUIENTE ALDE LA POSICION DE LA I 
					int aux= array[i];
					array[i]= array[i+1];  //CON LA VARIABLE AUXILIAR INTERCAMBIAMOS LOS VALORES
					array[i+1]= aux;
					esmayor=true;
				}
			}
		}while (esmayor);
		
		Utils_arrays.MostrarArray(array);
	}
}

