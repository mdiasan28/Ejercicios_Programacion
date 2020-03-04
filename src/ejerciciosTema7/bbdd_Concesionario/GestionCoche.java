package ejerciciosTema7.bbdd_Concesionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import ejerciciosTema7.bbdd_Concesionario.modelo.Cliente;
import ejerciciosTema7.bbdd_Concesionario.modelo.Coche;
import ejerciciosTema7.bbdd_Concesionario.modelo.Concesionario;
import ejerciciosTema7.bbdd_Concesionario.modelo.Fabricante;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorCliente;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorCoche;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorConcesionario;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ErrorBBDDException;


public class GestionCoche {

	/**
	 * @throws ParseException 
	 * 
	 */
	public static void menuGestion() throws ParseException {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE COCHES");
				
				System.out.println("\n\t1.- Listado de coches.");
				System.out.println("\t2.- Alta de coche.");
				System.out.println("\t3.- Modificación de coche.");
				System.out.println("\t4.- Baja de coche.");
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
		List<Coche> Coches = ControladorCoche.getAll();
		System.out.println("\n\tListado de fabricantes: \n");
		for (Coche c : Coches) {
			System.out.println("\t" + c.toString());
		}
		if (pausafinal) {
			System.out.println("\n\tPulse 'Intro' tecla para continuar");
			Utils.pausa();
		}
	}
	
	
	/**
	 * 
	 * @throws ErrorBBDDException
	 * @throws ParseException 
	 */
	private static void alta () throws ErrorBBDDException, ParseException {
		System.out.println("\n\tAlta de Cliente\n");
		
		Coche c = new Coche();
		Fabricante fab= GestionFabricante.seleccionPorUsuario();
		c.setIdfabricante(fab.getId());
		
		System.out.print("\nIntroduzca 'bastidor' del coche: ");
		c.setBastidor(Utils.getStringConsola());
		
		System.out.print("\nIntroduzca 'modelo' del coche: ");
		c.setModelo(Utils.getStringConsola());
		
		System.out.print("\nIntroduzca 'color' del coche: ");
		c.setColor(Utils.getStringConsola());
		
		ControladorCoche.almacenar(c);  

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}



	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void modificacion () throws ErrorBBDDException {
		System.out.println("\n\tModificación de Cliente\n");
		
		Coche c = seleccionPorUsuario();
		
		if (c != null) {		
			System.out.print("\nIntroduzca 'Color' del Clientes ('Intro' para no modificar): ");
			String str = Utils.getStringConsola();
			if (!str.equals("")) 
				c.setColor(str);
			System.out.print("\nIntroduzca 'Modelo' del Concesionario  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				c.setModelo(str);
			System.out.print("\nIntroduzca 'Bastidor' del Concesionario  ('Intro' para no modificar): ");
			str = Utils.getStringConsola();
			if (!str.equals("")) 
				c.setBastidor(str);
		
			ControladorCoche.almacenar(c);  

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
		
		Coche c = seleccionPorUsuario();
		
		if (c != null) {		
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) { 		 
				ControladorCoche.eliminar(c);  
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
	public static Coche seleccionPorUsuario () throws ErrorBBDDException {
		Coche c = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del Coche ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			}
			else {
				if (id != 0) {
					c = ControladorCoche.get(id);
					if (c == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (c == null && id != 0);
		return c;
	}
}
