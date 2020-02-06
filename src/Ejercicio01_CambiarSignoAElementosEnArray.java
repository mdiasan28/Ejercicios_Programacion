

import Programacion.Utils_arrays;

public class Ejercicio01_CambiarSignoAElementosEnArray {

	public static void main(String[] args) {
		int array[] = Utils_arrays.CrearArrayNumAleatorio(150, -100, 100);
		
		Utils_arrays.MostrarArray(array);

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				array[i] *= -1;
			}
		}
		
		Utils_arrays.MostrarArray(array);
	}

}
