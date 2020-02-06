package ejerciciotema5.bloque02;

public class ejercicio02bloque02 {

	public static void main(String[] args) {
		int array1[] = new int[5];
		int array2[] = new int[5];
		int array3[] = new int[5];
		for ( int i = 0; i < array1.length; i++) {
			array1[i] = (int)Math.round(Math.random()*100);
			System.out.print(array1[i] + " array1\n ");
			}
		for ( int i = 0; i < array1.length; i++) {
			array2[i] = (int)Math.round(Math.random()*100);
			System.out.print(array2[i] + " array2 ");
		}
		for ( int i = 0; i < array1.length; i++) {
			if (i % 2 == 0)
			array3[i] = array1[i];
			if (i % 2 == 1)
				array3[i] = array2[i];
		System.out.println("\n" + array3[i] + " array3 ");
		}
	}
}
			 


