package ejerciciotema5;

public class ejercicio01bloque01 {

	public static void main(String[] args) {
		int numeros[] = new int[150];
		for (int i = 0; i < numeros.length; i++) {
			int limite = 500 - (-500);
			numeros[i] =  (int) Math.round(Math.random() * limite +(-500));
			System.out.print(numeros[i] + " ");
		}
	}

}
