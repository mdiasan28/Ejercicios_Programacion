package ejerciciotema4.parte2.examen2018_recuperacion;

public class CampoBatalla {
	private String Nombre;
	private Malvado campoMalvados[]= new Malvado[20];
	private Humano campoHumanos[] = new Humano[20];
	
	public CampoBatalla() {
		for (int i = 0; i < campoHumanos.length; i++) {
			campoMalvados[i]= new Malvado(puntosVida(), "Malvado", true);
			if (i == campoHumanos.length-1) {
				campoMalvados[i]= new Malvado(puntosVida()*2, "MalvadoJefe", true);
			}
		}
		for (int i = 0; i < campoHumanos.length; i++) {
			campoHumanos[i]= new Humano(puntosVida(), "Humano", true);
			if (i == campoHumanos.length-1) {
				campoHumanos[i]= new Humano(puntosVida()*2, "HumanoJefe", true);
			}
		}
		
	}
	
	
	public static int puntosVida () {
		 return (int) Math.round(Math.random() * (100 - 50)) + 50;
		 
	}
	
	public void imprimirMalvados () {
		System.out.println("Campo Batalla");
		for (int i = 0; i < campoMalvados.length; i++) {
			System.out.println(campoMalvados[i]);
		}
	}
	
	public void imprimirHumanos () {
		System.out.println("Campo Batalla");
		for (int i = 0; i < campoHumanos.length; i++) {
			System.out.println(campoHumanos[i]);
		}
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * @param nombre
	 * @param campoMalvados
	 * @param campoHumanos
	 */
	public CampoBatalla(String nombre, Malvado[] campoMalvados, Humano[] campoHumanos) {
		super();
		this.Nombre = nombre;
		this.campoMalvados = campoMalvados;
		this.campoHumanos = campoHumanos;
	}
	
	
	
}


