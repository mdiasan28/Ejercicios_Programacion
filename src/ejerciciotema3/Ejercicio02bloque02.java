package ejerciciotema3;

import javax.swing.JOptionPane;

public class Ejercicio02bloque02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int acumuladormayor = 0;  //Variable para acumular los números
		int acumuladormenor= 0;
		
		int numapedir= Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de  numeros"));
		
		for (int i=0; i<numapedir; i++) {  //Bucle 
			int num= Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));

		
		if (i== 0) {
			acumuladormayor= num;
			acumuladormenor= num;
			}
		else
			if (num>acumuladormayor) {
			 acumuladormayor = num;
			}
			if (num<acumuladormenor) {
				 acumuladormenor = num;
			}
			 
		
	
			
		}
		System.out.println("El mayor es " + acumuladormayor);
		System.out.println("El menor es " + acumuladormenor);
	}
}