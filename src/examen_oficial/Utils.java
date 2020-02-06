package examen_oficial;
import javax.swing.JOptionPane;

public class Utils {

	public static void main(String[] args) {

	}
	
public static int NumAlAzar () {
		
		return (int) Math.round(Math.random()*100);
	}

	public static int obtenerNumUsuario (String mensaje) {
		int num= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return num;
		
	}
	
	public static int obtenerNumeroAzarentreLimites (int min, int max) {
		 return (int) Math.round(Math.random() * (max - min)) + min;
	}
	
	
	
	
	public static int obtenerNumUsuarioEntreLimites (String mensaje, int minimo, int maximo) {
		int num;
		
		do {
			 num= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			 	if (num < minimo || num > maximo) {
			 JOptionPane.showInputDialog(" El número debe de estar entre " + minimo + " y " + maximo);
			 }
		} while( num < minimo || num > maximo);
		
		return num;
	}
}
