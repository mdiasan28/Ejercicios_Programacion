package ejerciciotema3;

import javax.swing.JOptionPane;

public class Ejercicio02bloque03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int acumulador = 0;  //Variable para acumular los números
		int num =-1 , i;
		
		for ( i=0; num!=0; i++) {  //Bucle 
			 num= Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
			 acumulador = (acumulador + num);
		
	
			
		}
		System.out.println("La media es " + acumulador/(i-1));
	}
}

