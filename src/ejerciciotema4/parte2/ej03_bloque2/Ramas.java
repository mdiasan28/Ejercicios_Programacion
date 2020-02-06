package ejerciciotema4.parte2.ej03_bloque2;

public class Ramas extends Arbol {
	/**
	 * @param el1
	 * @param el2
	 * @param el3
	 */
	public Ramas(Arbol el1, Arbol el2, Arbol el3) {
		super();
		this.el1 = el1;
		this.el2 = el2;
		this.el3 = el3;
	}
	Arbol el1;
	Arbol el2;
	Arbol el3;
	@Override
	public String toString() {
		return "Ramas [el1=" + el1 + ", el2=" + el2 + ", el3=" + el3 + "]";
	}
	
}
