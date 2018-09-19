package dto;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import modelo.TimeUtils;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private Date fNacimiento;
	private String calle;
	private String altura;
	private String piso;
	private LocalidadDTO localidad;
	private String mail;
	private ContactoDTO contact;
	
	public PersonaDTO(int idPersona, String nombre, String telefono,
			String calle, String altura, String piso, LocalidadDTO localidad,
			String mail, ContactoDTO contact, Date fNacimiento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.localidad = localidad;
		this.mail = mail;
		this.contact = contact;
		this.fNacimiento = fNacimiento;
	}

	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public LocalidadDTO getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}
	
	public void setNombreLocalidad(String nombreLocalidad) {
		localidad.setNombre(nombreLocalidad);
	}
	
	public String getNombreLocalidad() {
		return localidad.getNombre();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public ContactoDTO getContact() {
		return contact;
	}

	public void setContact(ContactoDTO contact) {
		this.contact = contact;
	}

	public String getNombreContacto() {
		return this.contact.getTipo();
	}
	
	public Integer getFDiaNacimiento() {
//		TimeUtils dateEdit = new TimeUtils();
		return TimeUtils.getDay(fNacimiento);		
	}
	
	public Integer getFMesNacimiento() {
//		TimeUtils dateEdit = new TimeUtils();
		return TimeUtils.getMonth(fNacimiento);		
	}
	
	public String MonthMap(Integer mes) {
		Map<Integer, String> meses = new HashMap<Integer,String> ();
		meses.put(1, "Enero");
		meses.put(2, "Febrero");
		meses.put(3, "Marzo");
		meses.put(4, "Abril");
		meses.put(5, "Mayo");
		meses.put(6, "Junio");
		meses.put(7, "Julio");
		meses.put(8, "Agosto");
		meses.put(9, "Septiembre");
		meses.put(10, "Octubre");
		meses.put(11, "Noviembre");
		meses.put(12, "Diciembre");
		return meses.get(mes);
	}
	public String getMes() {
		return this.MonthMap(this.getFMesNacimiento());
	}
	

	
	
	
}
