package ejerciciotema5;

import javax.swing.JOptionPane;

public class ejercicio03bloque01 {

	public static void main(String[] args) {
	int numeros[] = new int[150];

	
		 int usuario= (int)Integer.parseInt(JOptionPane.showInputDialog("Introduce el número que quieras encontrar"));
		for ( int i = 0; i < numeros.length; i++) {
			numeros[i] = (int)Math.round(Math.random()*100);
			 System.out.print(numeros[i] + " ");
		
		 if (usuario == numeros[i] ) {
			 System.out.print("Has encontrado el numero, en está en la posición,"  );
			}

		 }
	}
}


