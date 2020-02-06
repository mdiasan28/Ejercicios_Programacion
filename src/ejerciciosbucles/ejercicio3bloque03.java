package ejerciciosbucles;

import javax.swing.JOptionPane;

public class ejercicio3bloque03 {

	public static void main(String[] args) {
		
		int i = 1;
		int numero=1;
		int acumuladormayor=0;
		int acumuladormenor=0;
		int cero=0;
		while (numero!=0) {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Introduceun número \n 0 para cerrar"));	
		
		if (i==0) {
			numero = acumuladormenor;
			numero = acumuladormayor;
		 }
		 else {
			 if (numero==0) cero=numero;
			 if (numero>acumuladormayor) acumuladormayor=numero;
			 if (numero<acumuladormenor) acumuladormenor=numero;

		 }
	}
		System.out.println("El mayor es  " + acumuladormayor);
		System.out.println("El menor es  " + acumuladormenor);
}
}

