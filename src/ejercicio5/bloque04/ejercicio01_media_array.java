package ejercicio5.bloque04;

import Programacion.Utils;
import Programacion.Utils_arrays;

public class ejercicio01_media_array {

	public static void main(String[] args) {
		
		int longitud = Utils.obtenerNumUsuario("Introduce la longitud del array");  //INTODUCIMOS LA LONGITUD DEL ARRAY DESEADA
		int array[] =  Utils_arrays.CrearArrayNumAleatorio(longitud, 0, 100);
		Utils_arrays.MostrarArray(array);
		int valormedio=0;
		
		for (int i = 0; i < array.length; i++) {
			if (array.length % 2 ==0) {   //CUANDO LA LONGITUD DEL ARRAY SEA PAR
				break;
			}
		}
		if (array.length % 2 ==1) {     //CUANDO LA POSICION DEL ARRAY SEA IMPAR RECOGEREMOS EN UNA VARIABLE LA POSICION MEDIA 
			valormedio = array[array.length/2];  // CON ARRAY[] SE RECOGEN EL VALOR QUE QUERAMOS DENTRO DEL ARRAY
			}
		System.out.println("");
		System.out.println(valormedio + " Es el valor medio");
	}

}
