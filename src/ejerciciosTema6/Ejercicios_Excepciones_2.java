package ejerciciosTema6;

import javax.swing.JOptionPane;

public class Ejercicios_Excepciones_2 {
	public static void generarFrase() throws Exception {

		boolean hecho=false;
		do {
			String frase = (String) JOptionPane.showInputDialog("Introduce una frase");
			// A partir de una persona, vamos a construir un StringBuffer que recorra sus dos piernas
			if (frase.isEmpty() ) {
				throw new Exception("La frase no puede estar vacía");
			}
			if (frase.contains("bombilla") ){
			}
			else {
				throw new Exception("No has introducido la palabra bombilla");
			}
			if (frase.contains("tonto") ) {
				throw new Exception("Has introducido una palabra ofensiva");
			}
			if (frase.contains("tonta") ) {
				throw new Exception("Has introducido una palabra ofensiva");
			}
			if (frase.contains("idiota") ) {
				throw new Exception("Has introducido una palabra ofensiva");
			}

			if (frase.length() <15 ) {
				throw new Exception("La frase debe contener mas de 15 carácteres");
			}

			hecho=true;
			System.out.println(frase);
		} while (!hecho);
	}
	public static void main(String[] args) {
		try {
			generarFrase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
