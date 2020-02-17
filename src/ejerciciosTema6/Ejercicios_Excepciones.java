package ejerciciosTema6;

import javax.swing.JOptionPane;


public class Ejercicios_Excepciones {

	public static void main(String[] args) {
		try {
			pideNumeroPar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void pideNumeroPar() throws Exception {
		String str = JOptionPane.showInputDialog("Introduce un numero");
		int num1= Integer.parseInt(str);
		
		if (num1 %2==0) {
			System.out.println("Has introducido tu número par correctamente");
		}
		else throw new Exception("El caracter introducido no es un número par");
	}

}
