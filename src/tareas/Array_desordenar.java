package tareas;

public class Array_desordenar {

	public static void main(String[] args) {
		int array[] = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)Math.round(Math.random()*100);
			System.out.print(array[i]+ " ");
		}
		for (int i = 0; i < array.length * 2 ; i++) {
			int i1, i2;
			i1 = Programacion.Utils_arrays.ObtenerNumAlteatorio(array.length-1, 0);
			i2 = Programacion.Utils_arrays.ObtenerNumAlteatorio(array.length-1, 0);
			int aux= array[i1];
			array[i1] = array[i2];
			array[i2] = aux;
		}
		Programacion.Utils_arrays.MostrarArray(array);
}
	}

		
