package ejerciciotema4.parte2.examen2018_recuperacion;

public class Personaje {
	private int puntos_vida;
	private String nombre;
	private boolean vivo = true;
	/**
	 * @param puntos_vida
	 * @param nombre
	 * @param vivo
	 */
	public Personaje(int puntos_vida, String nombre, boolean vivo) {
		super();
		this.puntos_vida = (int) (Math.round(Math.random() * (100 - 50)) + 50);
		this.nombre = nombre;
		this.vivo = vivo;
	}
	/**
	 * @return the puntos_vida
	 */
	public int getPuntos_vida() {
		return puntos_vida;
	}
	/**
	 * @param puntos_vida the puntos_vida to set
	 */
	public void setPuntos_vida(int puntos_vida) {
		this.puntos_vida = puntos_vida;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the vivo
	 */
	public boolean isVivo() {
		return vivo;
	}
	/**
	 * @param vivo the vivo to set
	 */
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	@Override
	public String toString() {
		return "Personaje [puntos_vida=" + puntos_vida + ", nombre=" + nombre + ", vivo=" + vivo + "]";
	}
	
	
	
	
}

	