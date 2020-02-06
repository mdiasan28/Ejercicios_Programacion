package tareas;

import Programacion.Utils_arrays;

public class Ejercicio_nacho_media_nº_matriz {

	public static void main(String[] args) {
		int matriz[][] = new int [10][10];
		
		Utils_arrays.ImprimirMatriz(matriz);
		
		int matrizaux[][] = new int [3][3];
		Utils_arrays.inicializarMatrizConValoresAlAzar(matrizaux, 0, 100);
		Utils_arrays.ImprimirMatriz(matrizaux);
	}

}
