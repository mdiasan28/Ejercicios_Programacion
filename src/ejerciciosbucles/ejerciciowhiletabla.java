package ejerciciosbucles;

import javax.swing.JOptionPane;

public class ejerciciowhiletabla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i= 1;
		int numero= 1;
		int multiplicacion= 1;
		int multiplicador=0;
		while (numero!=0)
		 {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número \n 0 para cerrar"));
			if (multiplicador<10) {
				multiplicador +=i;
				multiplicacion= multiplicador * numero;
				System.out.println(multiplicador + " x " + numero + " = " + multiplicacion);
			}
		}
	}

}
