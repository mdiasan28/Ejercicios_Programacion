package ejerciciosTema6.eventos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	private static List<PalabraMagicaIntroducidaListener> palabraMagicaIntroducidaListeners = new ArrayList<PalabraMagicaIntroducidaListener>();
	
	
	public static void main(String[] args) {
		Perro goofy = new Perro("Goofy");
		Perro pluto = new Perro("Pluto");

		
		while (true) {
						
			Scanner sc = new Scanner(System.in);

			System.out.println("Introduzca una frase:");
			
			String frase = sc.nextLine();
			
			String palabras[] = frase.split(" ");
			for (String palabra : palabras) {
				int contador=0;
				for(int i = 0; i < palabra.length(); i++) {
					char chr= palabra.charAt(i);
						if (Character.isDigit(chr)){
							contador++;
						}
						if (contador==3) {
							firePalabraMagicaIntroducidaListeners(new PalabraMagicaIntroducidaEvent(palabra));
						}
				}
			}
		}
		
	}

	/**
	 * 
	 * @param listener
	 */
	public static void addPalabraMagicaIntroducidaListener (PalabraMagicaIntroducidaListener listener) {
		palabraMagicaIntroducidaListeners.add(listener);
	}

	/**
	 * 
	 * @param listener
	 */
	public static void removePalabraMagicaIntroducidaListener (PalabraMagicaIntroducidaListener listener) {
		palabraMagicaIntroducidaListeners.remove(listener);
	}

	/**
	 * 
	 */
	public static void firePalabraMagicaIntroducidaListeners(PalabraMagicaIntroducidaEvent event) {
		for (PalabraMagicaIntroducidaListener listener : palabraMagicaIntroducidaListeners) {
			listener.palabraMagicaIntroducida(event);
		}
	}
}
