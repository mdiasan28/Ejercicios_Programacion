package examen01;

import examen_oficial.Utils_arrays;

public class ejercicio04_tipoA {

	public static void main(String[] args) {
int array[] = Utils_arrays.CrearArrayNumAleatorio(5, 0, 100);		
		
		Utils_arrays.MostrarArray(array);
		boolean serepite=false;
		// Empezamos a desordenar
		// En un bucle que se ejecuta el doble de veces que posiciones tiene el array, nosotros
		// hacemos el intercambio de los valores de dos posiciones.
		for (int i = 0; i < array.length * 2; i++) {
			int i1, i2;
			i1 = examen_oficial.Utils.obtenerNumeroAzarentreLimites(0, array.length-1);
			i2 = examen_oficial.Utils.obtenerNumeroAzarentreLimites(0, array.length-1);
			// Realizo el intercambio de valores a cuyas posiciones apuntan i1 e i2
			int aux = array[i1];
			array[i1] = array[i2];
			array[i2] = aux;
		}

		// Finalmente imprimo el array
		Programacion.Utils_arrays.MostrarArray(array);
	}
}
