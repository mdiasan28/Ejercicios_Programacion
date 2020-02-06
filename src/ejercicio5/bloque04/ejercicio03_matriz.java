package ejercicio5.bloque04;

import Programacion.Utils_arrays;

public class ejercicio03_matriz {

	public static void main(String[] args) {
		int matriz[][] = new int [10][10];
		int num=1; // VALOR PARA HACER LA MATRIZ 10 X 10 
		int limite1=1;  // LIMITE INFERIOR DE LA MATRIZ 1,1
		int limite2=3;  // LIMITE SUPERIOR DE LA MATRIZ 3,3
		int acumulador=0;
		boolean estadentro=false;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				acumulador = matriz [i][j];
				matriz[i][j]=num++;
			}
		}
		if  (acumulador<0 && acumulador>3)
			estadentro= false;
		
		if(estadentro)
			Utils_arrays.ImprimirMatriz(matriz);
		else
			
			
		
		
		Utils_arrays.ImprimirMatriz(matriz);
		System.out.println();
		int matriz2[][] = new int [3][3];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
			}
		}
		Utils_arrays.ImprimirMatriz(matriz2);
		
		int matriz3[][] = new int [3][3];
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[i].length; j++) {
			}
		}
		System.out.println();
		Utils_arrays.ImprimirMatriz(matriz3);
		
		
		
		
		
		

	}

}
