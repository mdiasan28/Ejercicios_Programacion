package ejerciciosTema7.bbdd_Concesionario.modelo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejerciciosTema7.bbdd_Concesionario.modelo.Cliente;
import ejerciciosTema7.bbdd_Concesionario.modelo.Coche;
import ejerciciosTema7.bbdd_Concesionario.modelo.Concesionario;

public class ControladorCoche extends ControladorBBDD {

	
	
	public static List<Coche> getAll () throws ErrorBBDDException {
		List<Coche> Coches = new ArrayList<Coche> ();
				
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from coche");

			while (rs.next()) {
				Coche c = new Coche();
				c.setId(rs.getInt("id"));
				c.setIdfabricante(rs.getInt("idfabricante"));
				c.setBastidor(rs.getString("bastidor"));
				c.setModelo(rs.getString("modelo"));
				c.setColor(rs.getString("color"));
				Coches.add(c);
			}
			
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return Coches;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Coche coche) throws ErrorBBDDException {
		if (get(coche.getId()) != null) { // Solo modificar
			almacenarModificado(coche);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(coche);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Coche get (int id) throws ErrorBBDDException {
		Connection conn = null;
		Coche c = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from coche where id = " + id);

			if (rs.next()) {
				c = new Coche();
				c.setId(id);
				c.setIdfabricante(rs.getInt("idfabricante"));
				c.setBastidor(rs.getString("bastidor"));
				c.setModelo(rs.getString("modelo"));
				c.setColor(rs.getString("color"));
			}
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return c;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Coche coche) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"INSERT INTO coche (id, idfabricante, bastidor, modelo,  color) VALUES  (?, ?, ?, ?, ?)");
			int registrosInsertados;
			
			ps.setInt(1, nextIdEnTabla(conn, "Coche")); 
			ps.setInt(2, coche.getIdfabricante());
			ps.setString(3, coche.getBastidor());
			ps.setString(4, coche.getModelo());
			ps.setString(5, coche.getColor());

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la inserción del nuevo registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarModificado (Coche coche) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"update coche set idfabricante = ?, bastidor = ?, modelo = ?, color= ? where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, coche.getIdfabricante());
			ps.setString(2, coche.getBastidor());
			ps.setString(3, coche.getModelo());
			ps.setString(4, coche.getColor());

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la modificación del registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void eliminar (Coche coche) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"delete from coche where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, coche.getId()); 

			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new ErrorBBDDException ("No ha sido posible la eliminación del registro");
			}
			ps.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		}

	}
	
	
}
