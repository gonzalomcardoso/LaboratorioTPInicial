package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadDTO;

public interface LocalidadDAO 
{
	
	public boolean insert(LocalidadDTO localidad);

	public boolean delete(LocalidadDTO localidad_a_eliminar);
	
	public List<LocalidadDTO> readAll();
	
	public List<LocalidadDTO> search(LocalidadDTO localidad_a_buscar );

	public boolean update(LocalidadDTO localidad_a_editar);
}