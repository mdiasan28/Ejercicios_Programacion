package ejerciciosTema7;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio1 {

	private static void pruebaConsultaPorFicheroDePropiedades () {

		String driver = JDBCPropiedades.getProperty("JDBC_DRIVER_CLASS");
		String user = JDBCPropiedades.getProperty("JDBC_USER");
		String password = JDBCPropiedades.getProperty("JDBC_PASSWORD");
		String host = JDBCPropiedades.getProperty("JDBC_HOST");
		String schema = JDBCPropiedades.getProperty("JDBC_SCHEMA_NAME");


		try {
			// A través de la siguiente línea comprobamos si tenemos acceso al driver MySQL, si no fuera así
			// no podemos trabajar con esa BBDD.
			Class.forName(driver);

			// Necesitamos obtener un acceso a la BBDD, eso se materializa en un objeto de tipo Connection, al cual
			// le tenemos que pasar los parámetros de conexión.
			Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema, user, password);

			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) conexion.createStatement(); 

			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta

			Scanner sc = new Scanner(System.in);

			System.out.println("Introduzca un número:\n 1: Mostrar tabla de Frabricantes"
					+ "\n 2: Añadir Fabricantes"
					+ "\n 3: Modificar fabricantes"
					+ "\n 4: Eliminar fabricantes"
					+ "\n 0: Salir");

			int opt= Integer.parseInt(sc.nextLine());

			switch (opt) {

			case 0:{
				return;
			}

			case 1:{
				ResultSet rs = s.executeQuery ("select * from fabricante");

				// Navegación del objeto ResultSet
				System.out.println("id" + "   CIF" + "     Marca");
				System.out.println("--------------------");
				while (rs.next()) { 
					System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getString(3));
				}
				System.out.println("------------------");
				System.out.println("Pulsa 0 para volver");
				opt= Integer.parseInt(sc.nextLine());
				switch (opt) {
				case 0:{
					generarMenu(conexion);
					}
				}
				// Cierre de los elementos
				rs.close();
			}
			case 2:{

			}
			}
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
		}
	}


	public static void createConexion() {
		String driver = JDBCPropiedades.getProperty("JDBC_DRIVER_CLASS");
		String user = JDBCPropiedades.getProperty("JDBC_USER");
		String password = JDBCPropiedades.getProperty("JDBC_PASSWORD");
		String host = JDBCPropiedades.getProperty("JDBC_HOST");
		String schema = JDBCPropiedades.getProperty("JDBC_SCHEMA_NAME");
		
		try {
		Class.forName(driver);
		
		Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema, user, password);
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
		}
	}
	
	public static void generarMenu(Connection conexion) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca un número:\n 1: Mostrar tabla de Frabricantes"
				+ "\n 2: Añadir Fabricantes"
				+ "\n 3: Modificar fabricantes"
				+ "\n 4: Eliminar fabricantes"
				+ "\n 0: Salir");
		
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//		pruebaConsultaBasica();
		pruebaConsultaPorFicheroDePropiedades();
	}

}
