package ejercicio5.bloque04;

import Programacion.Utils_arrays;

public class ejercicio02_notas {

	public static void main(String[] args) {
		int array[] =  Utils_arrays.CrearArrayNumAleatorio(20, 0, 10);
		Utils_arrays.MostrarArray(array);
		float aprobados=0;
		float suspensos=0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]>=5)
			aprobados = aprobados + 1;   //ACUMULAMOS LOS NUMEROS QUESEAN MAYORES O IGUALES DE CINCO
			
			if (array[i]<5)
				suspensos = suspensos + 1;   //CALCULAMOS LOS NUMEROS MENORES DE CINCO
				
			
		}
		aprobados = (float) (aprobados/array.length * 100);   //CALCULAMOS LOS PORCENTAJES
		suspensos = (float) (suspensos/array.length * 100);
		System.out.println("");
		System.out.println(aprobados +"%" + " Porcentaje de personas aprobadas");
		System.out.println(suspensos +"%" + " Porcentaje de personas suspensas");

	}

}
