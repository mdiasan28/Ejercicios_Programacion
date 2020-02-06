package ejerciciotema3;

import javax.swing.JOptionPane;

public class ejerciciobloque03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int acumulador = 0;
		
		int numapedir= Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de  numeros"));
		
		for (int i=0; i<numapedir; i++) {
			int num= Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
		if (num == 0) {
			break;
		}
		else acumulador += num;
		}
		System.out.println(acumulador);
	}
}
