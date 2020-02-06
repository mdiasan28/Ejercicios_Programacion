package ejerciciotema4.parte2.examen2018_recuperacion;

public class Malvado extends Personaje {
	
	/**
	 * @param puntos_vida
	 * @param nombre
	 * @param vivo
	 */
	public Malvado(int puntos_vida, String nombre, boolean vivo) {
		super(puntos_vida, nombre, vivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Malvado [getPuntos_vida()=" + getPuntos_vida() + ", getNombre()=" + getNombre() + ", isVivo()="
				+ isVivo() + "]";
	}
	
}
