/**
 * 
 */
package ejerciciotema4.parte2.Examen2018;

public class Baraja {

	public Baraja() {
		super();
		generarPalo();
	}




	Baraja barajaCartas[]= new Baraja[52];
	 
	 
	 
	 
	 public void generarPalo() {
		 for (int i = 0; i < barajaCartas.length/4; i++) {
	 
		 for (int j = 0; j < barajaCartas.length/4; j++) {
			System.out.println("El" + barajaCartas[j] + "de diamantes");
		}
		 
		 for (int j = 0; j < barajaCartas.length/4; j++) {
				System.out.println("El" + barajaCartas[j] + "de picas");
			}
	 
		 for (int j = 0; j < barajaCartas.length/4; j++) {
			System.out.println("El" + barajaCartas[j] + "de treboles");
		}
	 
		 for (int j = 0; j < barajaCartas.length/4; j++) {
			System.out.println("El" + barajaCartas[j] + "de corazones");
		 	}
		 }return;
	 } 
}


