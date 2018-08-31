package dto;

public class ContactoDTO {
	
	private int idContacto;
	
	private String tipo;

	public ContactoDTO(int idContacto, String tipo) {
		super();
		this.idContacto = idContacto;
		this.tipo = tipo;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
