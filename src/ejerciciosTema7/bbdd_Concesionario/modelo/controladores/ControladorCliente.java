package ejerciciosTema7.bbdd_Concesionario.modelo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejerciciosTema7.bbdd_Concesionario.modelo.Cliente;
import ejerciciosTema7.bbdd_Concesionario.modelo.Concesionario;

public class ControladorCliente extends ControladorBBDD {

	
	
	public static List<Cliente> getAll () throws ErrorBBDDException {
		List<Cliente> Clientes = new ArrayList<Cliente> ();
				
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from cliente");

			while (rs.next()) {
				Cliente client = new Cliente();
				client.setId(rs.getInt("id"));
				client.setNombre(rs.getString("nombre"));
				client.setApellidos(rs.getString("apellidos"));
				client.setLocalidad(rs.getString("localidad"));
				client.setDniNie(rs.getString("dniNie"));
				client.setFechaNac(rs.getDate("fechaNac"));
				client.setActivo(rs.getBoolean("activo"));
				Clientes.add(client);
			}
			
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return Clientes;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Cliente cliente) throws ErrorBBDDException {
		if (get(cliente.getId()) != null) { // Solo modificar
			almacenarModificado(cliente);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(cliente);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Cliente get (int id) throws ErrorBBDDException {
		Connection conn = null;
		Cliente client = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from cliente where id = " + id);

			if (rs.next()) {
				client = new Cliente();
				client.setId(id);
				client.setNombre(rs.getString("nombre"));
				client.setApellidos(rs.getString("apellidos"));
				client.setLocalidad(rs.getString("localidad"));
				client.setDniNie(rs.getString("dniNie"));
				client.setFechaNac(rs.getDate("fechaNac"));
				client.setActivo(rs.getBoolean("activo"));
			}
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return client;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Cliente cliente) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"INSERT INTO cliente (id, nombre, apellidos, dniNie, fechaNac) VALUES  (?, ?, ?, ?, ?)");
			int registrosInsertados;
			
			ps.setInt(1, nextIdEnTabla(conn, "Cliente")); 
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getLocalidad());
			ps.setString(5, cliente.getDniNie());
			ps.setDate(6, cliente.getFechaNac());

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
	private static void almacenarModificado (Cliente cliente) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"update cliente set nombre = ?, apellidos = ?, localidad=?, dniNie=?, fechaNac=? where id = ?");
			int registrosInsertados;
			
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getLocalidad());
			ps.setString(4, cliente.getDniNie());
			ps.setDate(5, cliente.getFechaNac());

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
	public static void eliminar (Cliente client) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"delete from cliente where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, client.getId()); 

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
