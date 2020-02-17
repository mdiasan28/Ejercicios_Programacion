package ejerciciosTema6.eventos;

public class PalabraMagicaIntroducidaEvent {
	private String palabraIntroducida;
	
	public PalabraMagicaIntroducidaEvent (String palabraIntroducida ) {
		this.palabraIntroducida = palabraIntroducida;
	}

	public String getPalabraIntroducida() {
		return palabraIntroducida;
	}
	
	
}
