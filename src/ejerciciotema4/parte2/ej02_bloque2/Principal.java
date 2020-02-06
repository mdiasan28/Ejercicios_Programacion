package ejerciciotema4.parte2.ej02_bloque2;

public class Principal {

	public static void main(String[] args) {
		Libros libro01 = new Libros(1875,"Aleman", 8, "Hola", "Dirk");
		System.out.println(libro01);

		Cuadro cuadro01 = new Cuadro(1964, "Frances", 500, "Romanico");
		System.out.println(cuadro01);
		
		Reloj reloj01 = new Reloj(2001, "Suizo", 300, "Diamantes");
		System.out.println(reloj01);
		
		Monedas moneda01 = new Monedas(2001, "italiano", 3, "Griego");
		System.out.println(moneda01);
		
	}

}
