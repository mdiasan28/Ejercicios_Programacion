package ejerciciotema5;

public class ejercicio02bloque01 {

	public static void main(String[] args) {
		int numeros[] = new int[150];
		
		for ( int i = 0; i < numeros.length; i++) {
			numeros[i] = (int)Math.round(Math.random()*100);
			 System.out.print(numeros[i] + " ");
		}
		
		 System.out.println("\nAhora del revés chicoos");
		 for( int i=numeros.length-1; i>=0; i--) {
			 System.out.print(numeros[i] + " ");
			 
		 }

	}

}
