package ejerciciosTema7.bbdd_Concesionario.modelo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejerciciosTema7.bbdd_Concesionario.modelo.Concesionario;

public class ControladorConcesionario extends ControladorBBDD {

	
	
	public static List<Concesionario> getAll () throws ErrorBBDDException {
		List<Concesionario> Concesionarios = new ArrayList<Concesionario> ();
				
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from concesionario");

			while (rs.next()) {
				Concesionario conc = new Concesionario();
				conc.setId(rs.getInt("id"));
				conc.setCif(rs.getString("cif"));
				conc.setNombre(rs.getString("nombre"));
				conc.setLocalidad(rs.getString("localidad"));
				Concesionarios.add(conc);
			}
			
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return Concesionarios;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Concesionario Concesionario) throws ErrorBBDDException {
		if (get(Concesionario.getId()) != null) { // Solo modificar
			almacenarModificado(Concesionario);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(Concesionario);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Concesionario get (int id) throws ErrorBBDDException {
		Connection conn = null;
		Concesionario conc = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from Concesionario where id = " + id);

			if (rs.next()) {
				conc = new Concesionario();
				conc.setId(id);
				conc.setCif(rs.getString("cif"));
				conc.setNombre(rs.getString("nombre"));
				conc.setLocalidad(rs.getString("localidad"));
			}
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return conc;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Concesionario concesionario) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"INSERT INTO concesionario (id, cif, nombre, localidad) VALUES  (?, ?, ?, ?)");
			int registrosInsertados;
			
			ps.setInt(1, nextIdEnTabla(conn, "concesionario")); 
			ps.setString(2, concesionario.getCif());
			ps.setString(3, concesionario.getNombre());
			ps.setString(4, concesionario.getLocalidad());

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
	private static void almacenarModificado (Concesionario concesionario) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"update concesionario set cif = ?, nombre = ?, localidad=? where id = ?");
			int registrosInsertados;
			
			ps.setString(1, concesionario.getCif());
			ps.setString(2, concesionario.getNombre());
			ps.setString(3, concesionario.getLocalidad());
			ps.setInt(4, concesionario.getId()); 

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
	public static void eliminar (Concesionario conc) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"delete from concesionario where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, conc.getId()); 

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
