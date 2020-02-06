package examen01;

import Programacion.Utils_arrays;

public class ejercicio04_tipoB {

	public static void main(String[] args) {
		int uno=1;
		int array[]= Utils_arrays.CrearArrayNumAleatorio(100, 0, 0);
		Programacion.Utils_arrays.MostrarArray(array);
		for (int i = 0; i < 10; i++) {
			int i1= examen_oficial.Utils.obtenerNumeroAzarentreLimites(0, array.length-1);
			array[i1]=uno;
		}
		Programacion.Utils_arrays.MostrarArray(array);
	}

}
