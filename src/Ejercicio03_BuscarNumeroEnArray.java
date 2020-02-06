
import Programacion.Utils_arrays;



public class Ejercicio03_BuscarNumeroEnArray {

	public static void main(String[] args) {
		int sumaPares = 0, sumaImpares = 0;
		// Declaración de array
		int array[] = Utils_arrays.CrearArrayNumAleatorio(5, 0, 100);
		
		// Mostramos el array 
		Utils_arrays.MostrarArray(array);
		
		for (int i = 0; i < array.length; i++) {
			  //SIRVE PARA RECOGER UN NÚMERO DENTRO DE UN ARRAY CON LOS VALORES ESPECIFICADOS
			if ((array[i] % 2) == 1) { // impar
				sumaImpares += array[i];
			}
			else { // par 
				sumaPares += array[i];
			}
		}
		
		// IMprimo el resultado
		System.out.println("\nSuma impares: " + sumaImpares + 
				" - suma pares: " + sumaPares);
	}
	
	
	
	
	
	/**
	 * 
	 * @return
	 */
	private static int obtenerNumeroAleatorio () {
		return (int) Math.round(Math.random() * 100);
	}

	/**
	 * 
	 * @return
	 */
	private static int obtenerNumeroAleatorio (int limiteInferior, int limiteSuperior) {
		return (int) Math.round(Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
	}

}
