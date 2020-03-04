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
import ejerciciosTema7.bbdd_Concesionario.modelo.Venta;

public class ControladorVenta extends ControladorBBDD {

	
	
	public static List<Venta> getAll () throws ErrorBBDDException {
		List<Venta> Ventas = new ArrayList<Venta> ();
				
		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from venta");

			while (rs.next()) {
				Venta v = new Venta();
				v.setId(rs.getInt("id"));
				v.setIdcliente(rs.getInt("idcliente"));
				v.setIdconcesionario(rs.getInt("idconcesionario"));
				v.setIdcoche(rs.getInt("idcoche"));
				v.setFecha(rs.getDate("fecha"));
				v.setPrecioventa(rs.getFloat("precioventa"));
				Ventas.add(v);
			}
			
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return Ventas;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	public static void almacenar (Venta venta) throws ErrorBBDDException {
		if (get(venta.getId()) != null) { // Solo modificar
			almacenarModificado(venta);
		}
		else { // Crear nuevo objeto en la BBDD
			almacenarNuevo(venta);
		}
	}
	

	
	/**
	 * 
	 * @param fabricante
	 * @return
	 * @throws ErrorBBDDException
	 */
	public static Venta get (int id) throws ErrorBBDDException {
		Connection conn = null;
		Venta v = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from venta where id = " + id);

			if (rs.next()) {
				v = new Venta();
				v.setId(id);
				v.setIdcliente(rs.getInt("idfcliente"));
				v.setIdconcesionario(rs.getInt("idconcesionario"));
				v.setIdcoche(rs.getInt("idcoche"));
				v.setFecha(rs.getDate("fecha"));
				v.setPrecioventa(rs.getFloat("precioventa"));
			}
			s.close();
			
		} catch (SQLException | ImposibleConectarException e) {			
			throw new ErrorBBDDException(e);
		} 
		return v;
	}
	
	
	
	
	/**
	 * 
	 * @param actors
	 * @throws ErrorBBDDException
	 */
	private static void almacenarNuevo (Venta venta) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"INSERT INTO venta (id, idcliente, idconcesionario, idcoche,  fecha, precioventa) VALUES  (?, ?, ?, ?, ?, ?)");
			int registrosInsertados;
			
			ps.setInt(1, nextIdEnTabla(conn, "Venta"));
			ps.setInt(2, venta.getIdcliente());
			ps.setInt(3, venta.getIdconcesionario());
			ps.setInt(4, venta.getIdcoche());
			ps.setDate(5, venta.getFecha());
			ps.setFloat(6, venta.getPrecioventa());

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
	private static void almacenarModificado (Venta venta) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"update venta set idcliente = ?, idconcesionario = ?, idcoche= ?, fecha= ?, precioventa= ? where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, venta.getIdcliente());
			ps.setInt(2, venta.getIdconcesionario());
			ps.setInt(3, venta.getIdcoche());
			ps.setDate(4, venta.getFecha());
			ps.setFloat(5, venta.getPrecioventa());

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
	public static void eliminar (Venta venta) throws ErrorBBDDException {

		Connection conn = null;

		try {
			conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = (PreparedStatement) conn.
					prepareStatement(
					"delete from venta where id = ?");
			int registrosInsertados;
			
			ps.setInt(1, venta.getId()); 

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
