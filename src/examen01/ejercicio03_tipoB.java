package examen01;

import Programacion.Utils_arrays;

public class ejercicio03_tipoB {

	public static void main(String[] args) {
		int array[]= new int[20];
			;
			int numero=1;
			int anterior=0;
		for (int i = 0; i < array.length; i++) {
			array[i]= numero;
			anterior= numero;
			anterior = array[i];
		}
		Utils_arrays.MostrarArray(array);
		

	}

}
