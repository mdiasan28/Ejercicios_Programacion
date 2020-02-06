package ejerciciotema4;

import javax.swing.JOptionPane;

public class Ejercicio_caraocruz {

	public static void main(String[] args) {
		int victorias=0;
		int derrotas=0;
	
		for ( ; victorias< 2 && derrotas<2 ;) {
		int numazar= (int)Math.round(Math.random()+1);
		int numpedido = 0;
		
		
			numpedido=Integer.parseInt(JOptionPane.showInputDialog("introduce un número \n 1:cruz 2: cara"));
	
		if (numpedido==numazar) {
			victorias+=1;
			JOptionPane.showMessageDialog(null, "Has ganado");
		}
		else {JOptionPane.showMessageDialog(null, "Has perdido");
		derrotas+=1;
				}
			}
		JOptionPane.showMessageDialog(null, "Ha ganado " + victorias + "veces");
		JOptionPane.showMessageDialog(null, "Ha perdido " + derrotas + "veces");
		}
	}
	


