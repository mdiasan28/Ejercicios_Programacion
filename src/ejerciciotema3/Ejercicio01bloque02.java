package ejerciciotema3;

import javax.swing.JOptionPane;

public class Ejercicio01bloque02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int acumulador = 0;  //Variable para acumular los números
		
		int numapedir= Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de  numeros"));
		
		for (int i=0; i<numapedir; i++) {  //Bucle 
			int num= Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
			 acumulador = (acumulador + num);
		
	
			
		}
		System.out.println("La media es " + acumulador/numapedir);
	}
}

