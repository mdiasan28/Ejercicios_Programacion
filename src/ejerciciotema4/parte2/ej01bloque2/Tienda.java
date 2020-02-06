package ejerciciotema4.parte2.ej01bloque2;

import javax.swing.JOptionPane;


public class Tienda {

	public static void main(String[] args) {
	
		int numeropersonas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el nº de personas"));;
		for (int i = 0; i < numeropersonas; i++) {
		
		Articulos articulo = new Articulos();
		Articulos.imprimeEnConsola();
		
		
		}
	}
}
