package ejerciciotema4.parte2;

import javax.swing.JOptionPane;

public class Persona {	
	 String nombre;
	 String apellidos;
	 String direccion;
	 String DNI;
	 String telefono;
	/**
	 * 
	 */

	public Persona () {
		 nombre = JOptionPane.showInputDialog("Introduce el nombre");
		 apellidos =  JOptionPane.showInputDialog("Introduce el apellido");
		 direccion =  JOptionPane.showInputDialog("Introduce tu direccion");
		 DNI =  JOptionPane.showInputDialog("Introduce el DNI");
		 telefono =  JOptionPane.showInputDialog("Introduce el teléfono");
		}
	

	public void imprimeEnConsola () {
		System.out.println("Persona:" + " nombre:" + nombre +" apellidos:" + apellidos +" DNI:" + DNI +" direccion:" + direccion + " telefono:" + telefono);
		}
	}

