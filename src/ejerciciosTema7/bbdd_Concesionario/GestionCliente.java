package ejerciciosTema7.bbdd_Concesionario;

import java.util.List;

import ejerciciosTema7.bbdd_Concesionario.modelo.Cliente;
import ejerciciosTema7.bbdd_Concesionario.modelo.Concesionario;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorCliente;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorConcesionario;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ErrorBBDDException;


public class GestionCliente {

	/**
	 * 
	 */
	public static void menuGestion() {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE CLIENTES");
				
				System.out.println("\n\t1.- Listado de Clientes.");
				System.out.println("\t2.- Alta de Cliente.");
				System.out.println("\t3.- Modificación de Cliente.");
				System.out.println("\t4.- Baja de Cliente.");
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
		List<Cliente> Clientes = ControladorCliente.getAll();
		System.out.println("\n\tListado de fabricantes: \n");
		for (Cliente client : Clientes) {
			System.out.println("\t" + client.toString());
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
		System.out.println("\n\tAlta de Cliente\n");
		
		Cliente client = new Cliente();
		System.out.print("\nIntroduzca 'Nombre' del Cliente: ");
		client.setNombre(Utils.getStringConsola());
		
		System.out.print("\nIntroduzca 'Apellido' del Cliente: ");
		client.setApellidos(Utils.getStringConsola());
		
		System.out.print("\nIntroduzca 'Localidad' del Cliente: ");
		client.setLocalidad(Utils.getStringConsola());
		
		System.out.print("\nIntroduzca 'DniNie' del Cliente: ");
		client.setDniNie(Utils.getStringConsola());
		
		System.out.print("\nIntroduzca 'FechaNac' del Cliente: ");
		client.setFechaNac(Utils.getStringConsola());
		
		ControladorCliente.almacenar(client);  

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}



	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void modificacion () throws ErrorBBDDException {
		System.out.println("\n\tModificación de Cliente\n");
		
		Cliente client = seleccionPorUsuario();
		
		if (client != null) {		
			System.out.print("\nIntroduzca 'Localidad' del Clientes ('Intro' para no modificar): ");
			String str = Utils.getStringConsola();
			if (!str.equals("")) 
				client.setLocalidad(str);
			System.out.print("\nIntroduzca 'Nombre' del Concesionario  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				client.setNombre(str);
		
			ControladorCliente.almacenar(client);  

			System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
			Utils.pausa();
		}
	}

	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void baja () throws ErrorBBDDException {
		System.out.println("\n\tModificación de Cliente\n");
		
		Cliente client = seleccionPorUsuario();
		
		if (client != null) {		
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) { 		 
				ControladorCliente.eliminar(client);  
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
	private static Cliente seleccionPorUsuario () throws ErrorBBDDException {
		Cliente client = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del Concesionario ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			}
			else {
				if (id != 0) {
					client = ControladorCliente.get(id);
					if (client == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (client == null && id != 0);
		return client;
	}
}
