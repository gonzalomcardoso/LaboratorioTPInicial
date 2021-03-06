/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.ContactoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;

public class DAOSQLFactory implements DAOAbstractFactory 
{
	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	public PersonaDAO createPersonaDAO() 
	{
				return new PersonaDAOSQL();
	}
	
	public LocalidadDAO createLocalidadDAO() 
	{
				return new LocalidadDAOSQL();
	}

	public ContactoDAO createContactoDAO() {
				return new ContactoDAOSQL();
	}

}
