package ejerciciotema4.parte2;

public class Principal {

	public static void main(String[] args) {
		//Primer plato
		Plato macarrones =new Plato("Macarrones con tomate", 5f);
		Plato tortilla =new Plato("Tortilla", 3f);
		Plato solomillo =new Plato("Solomillo", 10f);
		Plato pizza =new Plato("Pizza", 7.5f);
		Plato flamenquin =new Plato("Flamenquin", 9f);
		Plato sanJacobo =new Plato("San Jacobo", 11f);
		Plato habicholones =new Plato("habicholones", 4f);
		//Segundo plato
		Plato solomilloroquefort =new Plato("Solomillo Roquefort", 7f);
		Plato bacalao =new Plato("Bacalao", 10f);
		Plato lenguado =new Plato("Lenguado", 12f);
		Plato pulpo =new Plato("Pulpo Gallega", 15f);
		Plato ensalada =new Plato("Ensalada", 5f);
		Plato calamares =new Plato("Calamares", 8f);
		//Postre
		Plato tartaAbuela =new Plato("Tarta de la abuela", 4f);
		Plato natillas =new Plato("Natillascon galleta", 4f);
		Plato tartaQueso =new Plato("Tarta de queso", 4.5f);
		Plato tarta3Chocolates =new Plato("Tarta 3 chocolates", 6f);
		Plato fruta =new Plato("Fruta del tiempo", 3f);
		
		// Construimos menus
		Menu menus[] = new Menu[3];
		menus [0] = new Menu(lenguado, pulpo, fruta);
		menus [1]= new Menu(flamenquin, ensalada, natillas);
		menus [2]= new Menu(lenguado, pulpo, fruta);
		
		//Imprimo menus
		for (int i = 0; i < menus.length; i++) {
			System.out.println(menus[i].toString());
			System.out.println("Precio: " + menus[i].getPrecio());
		}
	

	}

}
