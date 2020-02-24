package ejerciciosTema7;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio1_2 {

	private static void pruebaConsultaPorFicheroDePropiedades () throws SQLException {

		Connection conexion=createConexion();
		generarMenu(conexion);
	}


	public static Connection createConexion() {
		try {
			Connection conexion = ConnectionManagerV2.getConexion();
			return conexion;
		} catch (SQLException | ImposibleConectarException e) {
			System.out.println("IMPOSIBLE CONECTAR A LA BASE DE DATOS");
		}
		return null;
	}

	public static void generarMenu(Connection conexion) throws SQLException {

		Statement s = (Statement) conexion.createStatement();

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
			mostrarTablaFabricantes(conexion);

			opt= Integer.parseInt(sc.nextLine());

			switch (opt) {
			case 0:{
				generarMenu(conexion);
			}
			}
		}
		case 2:{
			mostrarTablaFabricantes(conexion);

			opt= Integer.parseInt(sc.nextLine());

			switch (opt) {
			case 0:{
				generarMenu(conexion);
			}
			}
		}
		case 3:{
			vaciarFabricante(conexion);

			opt= Integer.parseInt(sc.nextLine());

			switch (opt) {
			case 0:{
				generarMenu(conexion);
			}
			}
		}
		}
	}

	public static void mostrarTablaFabricantes(Connection conexion) throws SQLException {
		Statement s = (Statement) conexion.createStatement();

		ResultSet rs = s.executeQuery ("select * from fabricante");

		System.out.println("id" + "   CIF" + "     Marca");
		System.out.println("--------------------");
		while (rs.next()) { 
			System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getString(3));
		}
		System.out.println("------------------");
		System.out.println("Pulsa 0 para volver");

		rs.close();

	}
	
	private static void crearFabricante (Connection conn) throws SQLException {
		Statement s = (Statement) conn.createStatement();
		
		System.out.println("Introduce el id del fabricante que quieres borrar");

		Scanner sc = new Scanner(System.in);
		int introducido= Integer.parseInt(sc.nextLine());

		 s.executeUpdate
			 ("delete from tutorialjavacoches." + "fabricante " + "where id = " + introducido);
		

		s.close();
	}

	private static void vaciarFabricante (Connection conn) throws SQLException {
		Statement s = (Statement) conn.createStatement();
		
		System.out.println("Introduce el id del fabricante que quieres borrar");

		Scanner sc = new Scanner(System.in);
		int introducido= Integer.parseInt(sc.nextLine());

		 s.executeUpdate
			 ("delete from tutorialjavacoches." + "fabricante " + "where id = " + introducido);
		

		s.close();
	}

	public static void main(String[] args) throws SQLException {
		pruebaConsultaPorFicheroDePropiedades();
	}

}

