package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import recursos.Propiedades;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);
	String Ip; 
	String Puerto;
	String Usuario;
	String Contrasena;
	
	private Conexion()
	{
		try
		{
			Ip = Propiedades.leer("ip");
			Puerto = Propiedades.leer("puerto");
			Usuario = Propiedades.leer("usuario");
			Contrasena = Propiedades.leer("contrasena");
			
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection("jdbc:mysql://"+Ip+":"+Puerto+"/agenda", Usuario, Contrasena);
			//this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","root");
			
			log.info("Conexión exitosa");
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}
