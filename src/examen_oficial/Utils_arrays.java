package examen_oficial;

public class Utils_arrays {

	
	
	
	public static int ObtenerNumAlteatorio (int limiteSup, int limiteInf) {
		return (int) Math.round(Math.random()* (limiteSup - limiteInf)) + limiteInf;
	}
	
	
	
	
	
	public static int[] CrearArrayNumAleatorio (int longitud, int limiteInf, int limiteSup) {
		int array[] = new int [longitud];
		
		for (int i = 0; i < array.length; i++) {
			
			array[i]= ObtenerNumAlteatorio (limiteInf, limiteSup);
			
		}
		return array;
	}
	
	
	
	
	
	
	public static void MostrarArray (int [] array) {
		System.out.println("\nContenido del array");
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			}
	}
	
	public static void inicializarMatrizConValoresAlAzar (int matriz[][], int min, int max) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]= Utils_arrays.ObtenerNumAlteatorio(min, max);
				}
			}
	}
	
	public static void ImprimirMatriz (int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
				}
				System.out.println();
		}
	}
	
	public static void esMatrizPositiva (int matriz[][]) {
		boolean positiva = true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
		if (matriz[i][j]<0) { //Si los valores de la matriz son negativos
			positiva=false;
				}	
			}
		}
		if (positiva) {
			System.out.println("La matriz es positiva");
		}
		else {
			System.out.println("La matriz es negativa");
		}
	} 
	
	public static void esMatrizSuperior (int matriz[][]) {
		boolean superior = true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
		if (i>j && matriz[i][j]!=0) { //Compruebo si hay un elemento debajo de la diagonal que sea cero
			superior=false;
				}	
			}
		}
		if (superior) {
			System.out.println("La matriz es superior");
		}
		else {
			System.out.println("La matriz no es superior");
		}
	} 
}

