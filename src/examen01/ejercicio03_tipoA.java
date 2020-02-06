package examen01;

import Programacion.Utils_arrays;

public class ejercicio03_tipoA {

	public static void main(String[] args) {
		int array[] = new int [20];
		
		 for ( int i = 0; i < array.length; i++) {
				int num = Utils_arrays.ObtenerNumAlteatorio (0, 20);
			if (num <10) {
				array[i]=num;
			}
		 }
		 Utils_arrays.MostrarArray(array);
	}
}


