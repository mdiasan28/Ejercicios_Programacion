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
import ejerciciosTema7.bbdd_Concesionario.modelo.Venta;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorCliente;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorCoche;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorConcesionario;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ControladorVenta;
import ejerciciosTema7.bbdd_Concesionario.modelo.controladores.ErrorBBDDException;


public class GestionVenta {

	/**
	 * @throws ParseException 
	 * 
	 */
	public static void menuGestion() throws ParseException {

		int opcionElegida = -1;
		do {
			try {
				System.out.println("\n\t\t\tGESTIÓN DE VENTAS");
				
				System.out.println("\n\t1.- Listado de ventas.");
				System.out.println("\t2.- Alta de venta.");
				System.out.println("\t3.- Modificación de ventas.");
				System.out.println("\t4.- Baja de venta.");
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
		List<Venta> Ventas = ControladorVenta.getAll();
		System.out.println("\n\tListado de ventas: \n");
		for (Venta v : Ventas) {
			System.out.println("\t" + v.toString());
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
		System.out.println("\n\tAlta de Venta\n");
		
		Venta v = new Venta();
		Cliente client = GestionCliente.seleccionPorUsuario();
		v.setIdcliente(client.getId());
		
		Concesionario c = GestionConcesionario.seleccionPorUsuario();
		v.setIdconcesionario(c.getId());
		
		Coche car = GestionCoche.seleccionPorUsuario();
		v.setIdcoche(car.getId());
		
		System.out.print("\nIntroduzca 'FechaNac' del Cliente: ");
		String fecha = (String) JOptionPane.showInputDialog("Introduce una fecha con /");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date f = sdf.parse(fecha);
		java.sql.Date fechafinal = new java.sql.Date(f.getTime());
		v.setFecha(fechafinal);
		
		System.out.print("\nIntroduzca 'precio' de la venta: ");
		String precioventafinal = (String) JOptionPane.showInputDialog("Introduce un precio de venta");
		float precioventa = Float.parseFloat(precioventafinal);
		v.setPrecioventa(precioventa);
		
		ControladorVenta.almacenar(v);  

		System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
		Utils.pausa();
	}



	/**
	 * 
	 * @throws ErrorBBDDException
	 */
	private static void modificacion () throws ErrorBBDDException {
		System.out.println("\n\tModificación de Cliente\n");
		
		Venta v = seleccionPorUsuario();
		
		if (v != null) {		
			System.out.print("\nIntroduzca 'Precio' de Venta ('Intro' para no modificar): ");
			String str = Utils.getStringConsola();
			if (!str.equals("")) 
		
			ControladorVenta.almacenar(v);  

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
		
		Venta v = seleccionPorUsuario();
		
		if (v != null) {		
			System.out.print("\n¿Realmente desea eliminar el registro? (S/N): ");
			String str = Utils.getStringConsola();
			if (str.equalsIgnoreCase("S")) { 		 
				ControladorVenta.eliminar(v);  
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
	public static Venta seleccionPorUsuario () throws ErrorBBDDException {
		Venta v = null;
		int id = -2;
		do {
			System.out.println("\n\tIntroduzca ID del Concesionario ('-1' - ver listado, '0' - salir): ");
			id = Utils.getIntConsola(-1);
			if (id == -1) {
				listado(false);
			}
			else {
				if (id != 0) {
					v = ControladorVenta.get(id);
					if (v == null) {
						System.out.println("\tError. Ha especificado un ID inválido.");
					}
				}
			}
		} while (v == null && id != 0);
		return v;
	}
}
