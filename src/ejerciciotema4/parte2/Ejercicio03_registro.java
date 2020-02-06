package ejerciciotema4.parte2;

import javax.swing.JOptionPane;

public class Ejercicio03_registro {

	public static void main(String[] args) {
		int numeropersonas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el nº de personas"));;
		for (int i = 0; i < numeropersonas; i++) {
		
		Persona persona = new Persona();
		
		
		persona.imprimeEnConsola();
		}
	}
}
