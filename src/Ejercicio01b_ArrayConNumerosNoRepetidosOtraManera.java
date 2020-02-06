

import Programacion.Utils_arrays;

public class Ejercicio01b_ArrayConNumerosNoRepetidosOtraManera {

	public static void main(String[] args) {
		// Declaración del array
		int array[] = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			// Declaro aux fuera del do porque lo necesito en la claúsula while
			int candidato; // Número generado al azar que se propone para ocupar la posiciónd array[i]
			boolean existeCandidatoEnArray;  // Bandera que indique que el candidato es o no es utilizable
			candidato = Utils_arrays.ObtenerNumAlteatorio(0, 9);
			// Compruebo ahora si el "candidato" existe en las posiciones del array previas a i
			existeCandidatoEnArray = false;
			for (int j = 0; j < i; j++) {
				if (array[j] == candidato) {
					existeCandidatoEnArray = true;
				}
			}
			
			if (existeCandidatoEnArray) {
				i = i - 1;
			}
			else {
				// Cuando llego aquí sé que el candidato no se repite en el array, es utilizable
				array[i] = candidato;
			}			
		}
		
		// Muestro el array
		Utils_arrays.MostrarArray(array);
	}

}
