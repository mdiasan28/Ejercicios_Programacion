import javax.swing.JOptionPane;

public class Utils {

	public static void main(String[] args) {

	}

	public static int obtenerNumUsuario (String mensaje) {
		int num= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return num;
	}
	public static int obtenerNumUsuarioEntreLimites (String mensaje, int minimo, int maximo) {
		int num;
		
		do {
			 num= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			 	if (num < minimo || num > maximo) {
			 JOptionPane.showInputDialog(" El n�mero debe de estar entre " + minimo + " y " + maximo);
			 }
		} while( num < minimo || num > maximo);
		
		return num;
	}
}
