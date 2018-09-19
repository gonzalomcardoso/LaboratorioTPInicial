package modelo;

import java.sql.Date;
import java.util.List;

import dto.ContactoDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.ContactoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	
	private LocalidadDAO localidad;
	
	private ContactoDAO contacto;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
		this.contacto = metodo_persistencia.createContactoDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
	public List<PersonaDTO> buscarPersona(int idPersona, String nombre, String telefono,
			String calle, String altura, String piso, LocalidadDTO localidad,
			String mail, ContactoDTO contact, Date fNacimiento) {
		PersonaDTO buscadoPersona = new PersonaDTO(idPersona,nombre,telefono,calle,altura,piso,localidad,mail,contact,fNacimiento);
		return this.persona.search(buscadoPersona);
	}

	public void editarPersona(PersonaDTO editadaPersona) {
		
		this.persona.update(editadaPersona);
		
	}
	
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.localidad.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar) 
	{
		this.localidad.delete(localidad_a_eliminar);
	}
	
	public List<LocalidadDTO> obtenerLocalidades()
	{
		return this.localidad.readAll();		
	}

	public LocalidadDTO buscarLocalidad(String nombreLocalidad) {
		LocalidadDTO buscadalocalidad = new LocalidadDTO(0,nombreLocalidad,null);
		
		return this.localidad.search(buscadalocalidad).get(0);
		
	}

	public List<ContactoDTO> obtenerContactos() {
		return this.contacto.readAll();
	}

	public ContactoDTO buscarContacto(String nombreContacto) {
		ContactoDTO buscadoContacto = new ContactoDTO(0, nombreContacto);
		return this.contacto.search(buscadoContacto).get(0);
	}

	public void agregarContacto(ContactoDTO nuevoContacto) {
		this.contacto.insert(nuevoContacto);
		
	}
	
	public void borrarContacto(ContactoDTO contacto_a_eliminar) 
	{
		this.contacto.delete(contacto_a_eliminar);
	}
	
	

	public boolean isLocalidadUsed(LocalidadDTO localidad_usada) {
		
		if(!this.buscarPersona(0, null, null, null, null, null, localidad_usada, null, null, null).isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isContactUsed(ContactoDTO contacto_usado) {
		if(!this.buscarPersona(0, null, null, null, null, null, null, null, contacto_usado, null).isEmpty()) {
			return true;
		}
		return false;
	}
	

	
	
}
