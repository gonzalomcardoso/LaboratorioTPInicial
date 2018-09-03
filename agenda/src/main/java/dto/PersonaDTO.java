package dto;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String fNacimiento;
	private String calle;
	private String altura;
	private String piso;
	private LocalidadDTO localidad;
	private String mail;
	private ContactoDTO contact;
	
	public PersonaDTO(int idPersona, String nombre, String telefono,
			String calle, String altura, String piso, LocalidadDTO localidad,
			String mail, ContactoDTO contact, String fNacimiento) {
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

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
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

	
	
	
}
