package ejerciciotema5.bloque02;

public class ejercicio04bloque02 {

	public static void main(String[] args) {
		int array[] = new int[5];
		
		
		for ( int i = 0; i < array.length; i++) {
			array[i] = (int)Math.round(Math.random()*100);
			System.out.print(array[i]+ " ");
			

		}
		int aux =array[array.length-1];
		
		for ( int i = array.length -1; i>0; i--) {
			
			array[i] = array[i-1];
			 
		
		}
		array[0]=aux;
		
		System.out.println();
		
		for ( int i = 0; i < array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		
	}

}
