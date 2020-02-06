package examen01;

import Programacion.Utils_arrays;

public class num_aleatorio_sinrepetir {

	public static void main(String[] args) {
		int array[] = new int [20];
		
		 for ( int i = 0; i < array.length; i++) {
				boolean existeCandidatoEnArray;  // Bandera que indique que el candidato es o no es utilizable
				int numero = Programacion.Utils.obtenerNumeroAzarentreLimites(0, 40);
				// Compruebo ahora si el "candidato" existe en las posiciones del array previas a i
				existeCandidatoEnArray = false;
				for (int j = 0; j < i; j++) {
					if (array[j] == numero) {
						existeCandidatoEnArray = true;
					}
				}
				
				if (existeCandidatoEnArray) {
					i = i - 1;
				}
				else {
					// Cuando llego aquí sé que el candidato no se repite en el array, es utilizable
					array[i] = numero;
				}			
			}
			
			// Muestro el array
			Utils_arrays.MostrarArray(array);
		}
}
