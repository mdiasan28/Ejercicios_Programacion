package tareas;

import Programacion.Utils_arrays;

public class No_repetir_array {

	public static void main(String[] args) {
		int array[] = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			int candidato;
			boolean existeCandidatoEnArray;  // Bandera que indique que el candidato es o no es utilizable
			// comienzo un bucle que tiene como objetivo determinar un numero número al azar no 
			// repetido en el array
			do {
				candidato = Utils_arrays.ObtenerNumAlteatorio(0, 9);
				// Compruebo ahora si el "candidato" existe en las posiciones del array previas a i
				existeCandidatoEnArray = false;
				for (int j = 0; j < i; j++) {
					if (array[j] == candidato) {
						existeCandidatoEnArray = true;
					}
				}
			} while (existeCandidatoEnArray);
			// Cuando llego aquí sé que el candidato no se repite en el array, es utilizable
			array[i] = candidato;
		}
		
		// Muestro el array
		Utils_arrays.MostrarArray(array);
			

		}
	}

