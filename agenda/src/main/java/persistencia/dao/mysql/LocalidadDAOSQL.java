package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;
import dto.LocalidadDTO;

public class LocalidadDAOSQL implements LocalidadDAO {
	
	private static final String insert = "INSERT INTO localidades (idLocalidad, Nombre, CodigoPostal) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM localidades WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidades";
	private static final String update = "UPDATE localidades SET nombre = ?, codPostal = ? WHERE idLocalidad = ?";
	private static final String search = "SELECT * FROM localidades WHERE nombre = ? order by idLocalidad asc";
	
	public boolean insert(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, localidad.getIdLocalidad());
			statement.setString(2, localidad.getNombre());
			statement.setString(3, localidad.getCodPostal());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(LocalidadDTO localidad_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(localidad_a_eliminar.getIdLocalidad()));
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
	
	public List<LocalidadDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				localidades.add(new LocalidadDTO(resultSet.getInt("idLocalidad"), resultSet.getString("Nombre"), resultSet.getString("CodigoPostal")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidades;
	}

	public boolean update(LocalidadDTO localidad_a_editar) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, localidad_a_editar.getNombre());
			statement.setString(2, localidad_a_editar.getCodPostal());
			statement.setInt(3, localidad_a_editar.getIdLocalidad());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

	
	public List<LocalidadDTO> search(LocalidadDTO localidad_a_buscar) {
		{
			PreparedStatement statement;
			ResultSet resultSet; //Guarda el resultado de la query
			ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
			Conexion conexion = Conexion.getConexion();
			try 
			{	
				statement = conexion.getSQLConexion().prepareStatement(search);
				statement.setString(1, localidad_a_buscar.getNombre());
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					localidades.add(new LocalidadDTO(resultSet.getInt("idLocalidad"), resultSet.getString("Nombre"), resultSet.getString("CodigoPostal")));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return localidades;
		}
	}

}
