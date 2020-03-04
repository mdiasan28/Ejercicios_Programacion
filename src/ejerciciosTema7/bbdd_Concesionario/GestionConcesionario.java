package ejerciciosTema7.bbdd_Concesionario;

import java.util.List;

import ejerciciosTema7.bbdd_Concesionario.modelo.Concesionario;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorConcesionario;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ErrorBBDDException;


public class GestionConcesionario {

	/**
	 * 
	 */
	public static void menuGestion() {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE CONCESIONARIOS");
				
				System.out.println("\n\t1.- Listado de Concesionarios.");
				System.out.println("\t2.- Alta de Concesionario.");
				System.out.println("\t3.- Modificación de Concesionario.");
				System.out.println("\t4.- Baja de Concesionario.");
				System.out.println("\t0.- Salir");
				System.out.println("\n\tElija una opción: ");
				
				opcionElegida = Utils.getIntConsola(0, 4);
				
				switch (opcionElegida) {
				case 0:
					break;
				case 1:
					listado(true);
					break;
				case 2: 
					alta();
					break;
				case 3: 
					modificacion();
					break;
				case 4: 
					baja();
					break;
				}
			} catch (ErrorBBDDException e) {
				System.out.println("\n\t\t\tError de acceso a datos: " + e.getMessage() + "\n");
				e.printStackTrace();
			}
		} while (opcionElegida != 0);
	}

	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void listado(boolean pausafinal) throws ErrorBBDDException {
		List<Concesionario> Concesionarios = ControladorConcesionario.getAll();
		System.out.println("\n\tListado de fabricantes: \n");
		for (Concesionario conc : Concesionarios) {
			System.out.println("\t" + conc.toString());
		}
		if (pausafinal) {
			System.out.println("\n\tPulse 'Intro' tecla para continuar");
			Utils.pausa();
		}
	}
	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void alta () throws ErrorBBDDException {
		System.out.println("\n\tAlta de fabricante\n");
		
		Concesionario conc = new Concesionario();
		System.out.print("\nIntroduzca 'CIF' del Concesionario: ");
		conc.setCif(Utils.getStringConsola());
		System.out.print("\nIntroduzca 'Nombre' del Concesionario: ");
		conc.setNombre(Utils.getStringConsola());
		
		ControladorConcesionario.almacenar(conc);  

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}



	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void modificacion () throws ErrorBBDDException {
		System.out.println("\n\tModificación de Concesionario\n");
		
		Concesionario conc = seleccionPorUsuario();
		
		if (conc != null) {		
			System.out.print("\nIntroduzca 'CIF' del Concesionario ('Intro' para no modificar): ");
			String str = Utils.getStringConsola();
			if (!str.equals("")) 
				conc.setCif(str);
			System.out.print("\nIntroduzca 'Nombre' del Concesionario  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				conc.setNombre(str);
		
			ControladorConcesionario.almacenar(conc);  

			System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
			Utils.pausa();
		}
	}

	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void baja () throws ErrorBBDDException {
		System.out.println("\n\tModificación de Concesionario\n");
		
		Concesionario conc = seleccionPorUsuario();
		
		if (conc != null) {		
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) { 		 
				ControladorConcesionario.eliminar(conc);  
				System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
				Utils.pausa();
			}
		}
	}

	
	
	/**
	 * 
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Concesionario seleccionPorUsuario () throws ErrorBBDDException {
		Concesionario conc = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del Concesionario ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			}
			else {
				if (id != 0) {
					conc = ControladorConcesionario.get(id);
					if (conc == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (conc == null && id != 0);
		return conc;
	}
}
