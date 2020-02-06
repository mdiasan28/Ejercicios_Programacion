package ejerciciotema4.parte2.ej03_bloque2;

public class Principal {

	public static void main(String[] args) {
		Hojas hoja01 = new Hojas("Peremne");
		Frutos fruto01 = new Frutos("menta");
		Hojas hoja02 = new Hojas("Caduca");
		Frutos fruto2 = new Frutos("Fresa");
		Ramas ramasegunda =new Ramas(hoja02, fruto2, hoja01);
		Ramas ramaprimera = new Ramas(hoja01, fruto01, ramasegunda);
			System.out.println(ramaprimera);
	}

}
