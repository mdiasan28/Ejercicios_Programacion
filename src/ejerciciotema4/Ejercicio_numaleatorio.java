package ejerciciotema4;

import javax.swing.JOptionPane;

public class Ejercicio_numaleatorio {

	public static void main(String[] args) {
		int num = obtenerNumeroAzar();
		int numpedido= 0;
		
		for (;num!=numpedido;) {
			numpedido=Integer.parseInt(JOptionPane.showInputDialog("introduce un número"));
			
			if (numpedido>num) {
				JOptionPane.showMessageDialog(null, "Tu numero es mayor que el generado al azar");
			}
			if (numpedido<num) {
				JOptionPane.showMessageDialog(null, "Tu numero es menor que el generado al azar");
			}
			if (numpedido==num) {
				JOptionPane.showMessageDialog(null, "Ehnorabuena has acertado");
			}
			
		} 		
}
			
			
			
			
			
	
	

	private static int obtenerNumeroAzar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
