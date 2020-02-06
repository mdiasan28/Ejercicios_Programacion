package tareas;

import Programacion.Utils_arrays;

public class Ordenar_impares {

	public static void main(String[] args) {
		int array[] = Utils_arrays.CrearArrayNumAleatorio(10, 0, 9);

		// Mostrar array original
		Utils_arrays.MostrarArray(array);
		
		// Creo un array auxiliar que contendrá a los números impares
		int impares[] = new int[array.length];
		
		// Recorro el array original, buscando y almacenando números impares en el array "impares"
		int indiceArrayImpares = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) { // Impar, debe ir al array "impares"
				impares[indiceArrayImpares] = array[i];
				indiceArrayImpares++;
			}
		}
		
		int pares[] = new int[array.length];
		
		int indiceArraypares = indiceArrayImpares ;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0 ) {
				impares[indiceArraypares] = array[i];
				indiceArraypares++;
			}
		}
		
		Utils_arrays.MostrarArray(pares);
		
		
		Utils_arrays.MostrarArray(impares);
 	}

}
