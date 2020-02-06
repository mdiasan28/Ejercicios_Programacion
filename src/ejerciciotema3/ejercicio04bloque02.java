package ejerciciotema3;

import javax.swing.JOptionPane;

public class ejercicio04bloque02 {

	public static void main(String[] args) {
		// se puede realizar las ventanas por una ejecucion en terminal de Scanner
		int factor = Integer.parseInt(JOptionPane.showInputDialog("Introduzca número"));
		int limite = Integer.parseInt(JOptionPane.showInputDialog("Introduzca su límite"));
		
		for (int i = 1; i <100; i++) {
			int multiplo = i*factor;
			if (multiplo<limite) {
			System.out.println(i + " x " + factor + " = " + multiplo );
			}
			
		}
	}
}
