package dto;

public class LocalidadDTO {
	
	private int idLocalidad;
	private String nombre_localidad;
	private String codigo_postal;
	public LocalidadDTO(int idLocalidad, String nombre_localidad,
			String codigo_postal) {
		super();
		this.idLocalidad = idLocalidad;
		this.nombre_localidad = nombre_localidad;
		this.codigo_postal = codigo_postal;
	}
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public String getNombre() {
		return nombre_localidad;
	}
	public void setNombre(String nombre_localidad) {
		this.nombre_localidad = nombre_localidad;
	}
	public String getCodPostal() {
		return codigo_postal;
	}
	public void setCodPostal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	
	

}
