package ejerciciotema5.bloque02;

public class ejercicio01bloque02 {

	public static void main(String[] args) {
		int numeros[] = new int[5];
		int pares=0;
		
		for (int i = 0; i < numeros.length; i++) {
			int limite = -100 - (100);
			numeros[i] =  (int) Math.round(Math.random() * limite +(100));
			System.out.print(numeros[i] + " ");
			 }
		for ( int i = 0; i < numeros.length; i++) {
			if( numeros[i] % 2 == 0) {
				pares = numeros[i] * -1;
				System.out.println("\nLos pares que han cambiado son " + pares);
				}
			}
	}
}

	