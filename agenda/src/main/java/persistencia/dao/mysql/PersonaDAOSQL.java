package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.ContactoDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, calle, altura, piso, Localidad, mail, TipoContacto, FNacimiento) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String update = "UPDATE personas SET nombre = ?, telefono = ?, calle = ?, altura = ?, piso = ?, Localidad = ?, mail = ?, TipoContacto = ?, FNacimiento = ? WHERE idPersona = ?";
	private static final String search = "SELECT * FROM personas WHERE nombre = ? or localidad = ? or TipoContacto = ? order by idPersona asc";
	
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getCalle());
			statement.setString(5, persona.getAltura());
			statement.setString(6, persona.getPiso());
			statement.setString(7, persona.getNombreLocalidad());
			statement.setString(8, persona.getMail());
			statement.setString(9, persona.getNombreContacto());
			statement.setDate(10, persona.getfNacimiento());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
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
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"),  resultSet.getString("Calle"),  resultSet.getString("Altura"),  resultSet.getString("Piso"), new LocalidadDTO(0,resultSet.getString("Localidad"),""),  resultSet.getString("Mail"), new ContactoDTO(0,resultSet.getString("TipoContacto")), resultSet.getDate("FNacimiento")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}

	
	public boolean update(PersonaDTO persona_a_editar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, persona_a_editar.getNombre());
			statement.setString(2, persona_a_editar.getTelefono());
			statement.setString(3, persona_a_editar.getCalle());
			statement.setString(4, persona_a_editar.getAltura());
			statement.setString(5, persona_a_editar.getPiso());
			statement.setString(6, persona_a_editar.getNombreLocalidad());
			statement.setString(7, persona_a_editar.getMail());
			statement.setString(8, persona_a_editar.getNombreContacto());
			statement.setDate(9, persona_a_editar.getfNacimiento());
			statement.setInt(10, persona_a_editar.getIdPersona());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<PersonaDTO> search(PersonaDTO persona_a_buscar) {
		{
			PreparedStatement statement;
			ResultSet resultSet; //Guarda el resultado de la query
			ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
			Conexion conexion = Conexion.getConexion();
			try 
			{	
				statement = conexion.getSQLConexion().prepareStatement(search);
				if(persona_a_buscar.getNombre()!=null)
					statement.setString(1, persona_a_buscar.getNombre());
				else 
					statement.setString(1, persona_a_buscar.getNombre());
				if(persona_a_buscar.getLocalidad()!=null)
					statement.setString(2, persona_a_buscar.getLocalidad().getNombre());
				else
					statement.setString(2, null);
				if(persona_a_buscar.getContact()!=null)
					statement.setString(3, persona_a_buscar.getContact().getTipo());
				else
					statement.setString(3, null);
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"),  resultSet.getString("Calle"),  resultSet.getString("Altura"),  resultSet.getString("Piso"), new LocalidadDTO(0,resultSet.getString("Localidad"),""),  resultSet.getString("Mail"), new ContactoDTO(0,resultSet.getString("TipoContacto")), resultSet.getDate("FNacimiento")));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return personas;
		}
	}
}
