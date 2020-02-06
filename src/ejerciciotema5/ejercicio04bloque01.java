package ejerciciotema5;

public class ejercicio04bloque01 {

	public static void main(String[] args) {
		int numeros[] = new int[150];
		int suma=0;
		
		for ( int i = 0; i < numeros.length; i++) {
			numeros[i] = (int)Math.round(Math.random()*100);
			 System.out.print(numeros[i] + " ");
			 if ((i %2) == 0) {
				 suma += numeros[i];
			 }
		}
		System.out.println("\nLa suma de los indices pares es " +  suma);
	}
}
