package ejerciciotema4.parte2.examen2018_recuperacion;

public class Humano extends Personaje {

	public Humano(int puntos_vida, String nombre, boolean vivo) {
		super(puntos_vida, nombre, vivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Humano [getPuntos_vida()=" + getPuntos_vida() + ", getNombre()=" + getNombre() + ", isVivo()="
				+ isVivo() + "]";
	}
	
}
