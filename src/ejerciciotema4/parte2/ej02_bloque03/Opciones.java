package ejerciciotema4.parte2.ej02_bloque03;

public class Opciones extends Question {
	
	private String opcioncorrect[];
	
	public Opciones(String enunciado, int respuestacorrecta, String opcioncorrect[]) {
		super(enunciado, respuestacorrecta);
		this.setOpcioncorrect(opcioncorrect);
	}

	public String[] getOpcioncorrect() {
		return opcioncorrect;
	}

	public void setOpcioncorrect(String opcioncorrect[]) {
		this.opcioncorrect = opcioncorrect;
	}
	

}
