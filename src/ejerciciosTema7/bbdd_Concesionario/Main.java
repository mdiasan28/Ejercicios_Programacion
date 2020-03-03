package ejerciciosTema7.bbdd_Concesionario;

public class Main {

	public static void main(String[] args) {
		menuPrincipal();
	}


	/**
	 * 
	 */
	private static void menuPrincipal() {

		int opcionElegida;
		do {
			System.out.println("\n\t\t\tGESTIÓN DE VENTAS DE COCHES");

			System.out.println("\n\t1.- Gestión de Concesionario.");
			System.out.println("\t2.- Gestión de Fabricante.");
			System.out.println("\t3.- Gestión de Cliente.");
			System.out.println("\t4.- Gestión de Coche.");
			System.out.println("\t5.- Gestión de Venta.");
			System.out.println("\t0.- Salir");
			System.out.println("\n\tElija una opción: ");

			opcionElegida = Utils.getIntConsola(0, 5);

			switch (opcionElegida) {
			case 0:
				System.out.println("\n!Qué tenga un feliz día!");
				break;
			case 1:
				GestionConcesionario.menuGestion();

			case 2:
				GestionFabricante.menuGestion();
				
			case 3:
				GestionCliente.menuGestion();
				
			case 4:
				GestionCoche.menuGestion();
				
			case 5:
				GestionVenta.menuGestion();
			}
		} while (opcionElegida != 0);
	}

}
