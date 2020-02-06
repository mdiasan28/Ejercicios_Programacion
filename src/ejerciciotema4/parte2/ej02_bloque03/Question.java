package ejerciciotema4.parte2.ej02_bloque03;

public abstract class Question {
	protected String Enunciado;
	protected int respuestacorrecta;
	protected int respuestausuario;
	/**
	 * @param enunciado
	 * @param respuestacorrecta
	 */
	public Question(String enunciado, int respuestacorrecta) {
		super();
		this.Enunciado = enunciado;
		this.respuestacorrecta = respuestacorrecta;
	}


	public boolean esCorrecta(int respuestaUsuario) {
		return this.respuestacorrecta == respuestaUsuario;
	}
	public abstract void mostrarPantalla();
	
}