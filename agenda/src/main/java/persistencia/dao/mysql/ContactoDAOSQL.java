package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ContactoDAO;
import dto.ContactoDTO;

public class ContactoDAOSQL implements ContactoDAO {
	
	private static final String insert = "INSERT INTO contactos (idContacto, tipo) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM contactos WHERE idContacto = ?";
	private static final String readall = "SELECT * FROM contactos";
	private static final String update = "UPDATE contactos SET tipo = ? WHERE idcontacto = ?";
	private static final String search = "SELECT * FROM contactos WHERE tipo = ? order by idContacto asc";
	
	public boolean insert(ContactoDTO contacto)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, contacto.getIdContacto());
			statement.setString(2, contacto.getTipo());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(ContactoDTO contacto_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(contacto_a_eliminar.getIdContacto()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<ContactoDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<ContactoDTO> contactos = new ArrayList<ContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				contactos.add(new ContactoDTO(resultSet.getInt("idContacto"), resultSet.getString("Tipo")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return contactos;
	}

	public boolean update(ContactoDTO contacto_a_editar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, contacto_a_editar.getTipo());
			statement.setInt(2, contacto_a_editar.getIdContacto());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

	
	public List<ContactoDTO> search(ContactoDTO contacto_a_buscar) {
		{
			PreparedStatement statement;
			ResultSet resultSet; //Guarda el resultado de la query
			ArrayList<ContactoDTO> contactos = new ArrayList<ContactoDTO>();
			Conexion conexion = Conexion.getConexion();
			try 
			{	
				statement = conexion.getSQLConexion().prepareStatement(search);
				statement.setString(1, contacto_a_buscar.getTipo());
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					contactos.add(new ContactoDTO(resultSet.getInt("idContacto"), resultSet.getString("Tipo")));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return contactos;
		}
	}

}
