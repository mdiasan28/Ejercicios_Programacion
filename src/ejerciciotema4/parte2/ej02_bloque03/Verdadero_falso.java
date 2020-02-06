package ejerciciotema4.parte2.ej02_bloque03;

import javax.swing.JOptionPane;

public class Verdadero_falso extends Question {

	public Verdadero_falso(String enunciado, int respuestacorrecta) {
		super(enunciado, respuestacorrecta);
	}
	public void mostrarPantalla() {
		String enunciadoAMostrar= this.Enunciado + "\n1.- Verdadero\n2.-Falso";
		String respuesta= JOptionPane.showInputDialog(enunciadoAMostrar);
		int respuestaInt= Integer.parseInt(respuesta);
		if(esCorrecta(respuestaInt)) {
			System.out.println("Acertaste");
		}
		else System.out.println("Has fracasaso");
	}
	 
}
