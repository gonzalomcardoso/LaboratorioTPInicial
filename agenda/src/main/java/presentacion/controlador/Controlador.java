package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaContacto;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaConfiguracion;
import presentacion.vista.Vista;
import recursos.Propiedades;
import dto.ContactoDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private List<LocalidadDTO> localidades_en_tabla;
		private List<ContactoDTO> contactos_en_tabla;
		private PersonaDTO persona_a_editar;
		private VentanaPersona ventanaPersona; 
		private VentanaLocalidad ventanaLocalidad; 
		private VentanaContacto ventanaContacto;
		private VentanaConfiguracion ventanaConfiguracion;
		private Agenda agenda;
		
		
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnEditar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.vista.getVentanaConfiguracion().getBtnAgregarDatos().addActionListener(this);
			this.agenda = agenda;
			this.personas_en_tabla = null;
			this.persona_a_editar = null;
		}
		
		public void inicializar()
		{
			this.llenarTabla();
			this.vista.show();
			
		}
		
		public PersonaDTO personaEditable()
		{
			
			return this.persona_a_editar;
		}
		
		public List<LocalidadDTO>  localidadesElegibles(){
			localidades_en_tabla = this.agenda.obtenerLocalidades();
			return localidades_en_tabla;
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = {
						this.personas_en_tabla.get(i).getNombre(), 
						this.personas_en_tabla.get(i).getTelefono(),
						this.personas_en_tabla.get(i).getfNacimiento(),
						this.personas_en_tabla.get(i).getCalle(),
						this.personas_en_tabla.get(i).getAltura(),
						this.personas_en_tabla.get(i).getPiso(),
						this.personas_en_tabla.get(i).getNombreLocalidad(),
						this.personas_en_tabla.get(i).getMail(),
						this.personas_en_tabla.get(i).getNombreContacto()
						
						
						
						};
				this.vista.getModelPersonas().addRow(fila);
			}			
		}
		
		public List<ContactoDTO> contactosElegibles() {
			this.contactos_en_tabla = this.agenda.obtenerContactos();
			return this.contactos_en_tabla;
		}
		
		private boolean isValidPersona(VentanaPersona campoPersona) {
			
			if(this.isEmpty(campoPersona.getTxtNombre())) {
				this.ventanaWarning("Nombre de Persona es vacio", this.ventanaPersona);
				
				return false;
			}
				
			if(this.isEmpty(campoPersona.getTxtTelefono())) {
				this.ventanaWarning("Numero de Telefono es vacio", this.ventanaPersona);
				return false;
			}
				
			if( campoPersona.getButtonTxtFNac() == null) {
				this.ventanaWarning("No hay Fecha de Nacimiento ", this.ventanaPersona);
				return false;
			} else if( this.isEmpty(campoPersona.getTxtFNac().toString()) ) {
				
				this.ventanaWarning("Fecha de Nacimiento es vacio", this.ventanaPersona);
				return false;
			}
				
			if(this.isEmpty(campoPersona.getTxtCalle()) || this.isEmpty(campoPersona.getTxtAltura())) {
				
				if((this.isEmpty(campoPersona.getTxtCalle()) && !this.isEmpty(campoPersona.getTxtAltura())) || 
						(!this.isEmpty(campoPersona.getTxtCalle()) && this.isEmpty(campoPersona.getTxtAltura()))){
					
					if(this.isEmpty(campoPersona.getTxtCalle())) {
						this.ventanaWarning("La calle es vacia", this.ventanaPersona);
						return false;
					}
					
					
					if(this.isEmpty(campoPersona.getTxtAltura())) {
						this.ventanaWarning("La altura es vacia", this.ventanaPersona);
						return false;
					}
					
				}
					
			}
					
			if(this.isEmpty(campoPersona.getTxtLocalidad())) {
				this.ventanaWarning("La localidad es vacio", this.ventanaPersona);
				return false;
			}
				
			if(this.isEmpty(campoPersona.getTxtMail())) {
				this.ventanaWarning("El mail es vacio", this.ventanaPersona);
				return false;
			}
				
			if(this.isEmpty(campoPersona.getTxtContacto())) {
				this.ventanaWarning("El contacto es vacio", this.ventanaPersona);
				return false;
			}
				
			
			return true;
			
			
			
		}
		
		private boolean isValidLocalidad(VentanaLocalidad campoLocalidad) {
			if(this.isEmpty(campoLocalidad.getTxtNombre())) {
				this.ventanaWarning("Nombre de Localidad vacio", campoLocalidad);
				return false;
			}
				
			if(this.isEmpty(campoLocalidad.getTxtCodPostal())) {
				this.ventanaWarning("Codigo Postal de Localidad vacio", campoLocalidad);
				return false;
			}
			return true;
		}
		
		private boolean isValidContacto(VentanaContacto campoContacto) {
			if(this.isEmpty(campoContacto.getTxtNombre())) {
				this.ventanaWarning("Tipo de Contacto vacio", campoContacto);
				return false;
			}
				
			return true;
		}
		
		private boolean isEmpty(String campo) {
			
			return "".equals(campo) || esUnaArrayVacia(campo);			

		}
		
		private Boolean esUnaArrayVacia(String campo) {
			
			// recorro la array
			String stringEmpty = " ";
			Boolean isEmpty = true;
			
			String s = campo;
			
			char[] cArray = s.toCharArray();
			
			for (char c : cArray) {
				// condicion si encuentro un valor distinto de " "
				if (!stringEmpty.equals(c)) {
					// es false 
					isEmpty = false;
					break;
				}
			}  
			
			return isEmpty;
		}
		
		private void ventanaWarning(String message, JFrame ventana) {
			
			JOptionPane.showOptionDialog(
		             null, message, 
		             "Aceptar", JOptionPane.WARNING_MESSAGE,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
			
			
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			
			
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				this.ventanaPersona = new VentanaPersona(this);
				
			}
			
			else if(e.getSource() == this.vista.getBtnEditar())
			{
				int fila_seleccionada = this.vista.getTablaPersonas().getSelectedRow();
				
				this.persona_a_editar = this.personas_en_tabla.get(fila_seleccionada);
				
				this.persona_a_editar.setLocalidad(agenda.buscarLocalidad(this.personas_en_tabla.get(fila_seleccionada).getNombreLocalidad()));
				
				this.persona_a_editar.setContact(agenda.buscarContacto(this.personas_en_tabla.get(fila_seleccionada).getNombreContacto()));
				
				this.ventanaPersona = new VentanaPersona(this);
				
			}
			
			else if(e.getSource() == this.vista.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
				}
				
				this.llenarTabla();
				
			}
			
			else if(e.getSource() == this.vista.getBtnReporte())
			{				
				ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
				reporte.mostrar();				
			}
			
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarLocalidad())
			{
				this.ventanaLocalidad = new VentanaLocalidad(this);
			}
			
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarContact())
			{
				this.ventanaContacto = new VentanaContacto(this);
			}
			
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{
				
				LocalidadDTO buscadaLocalidad = agenda.buscarLocalidad(ventanaPersona.getTxtLocalidad());
				ContactoDTO buscadoContacto = agenda.buscarContacto(ventanaPersona.getTxtContacto());
				if(this.isValidPersona(this.ventanaPersona)) {
					PersonaDTO nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre(), ventanaPersona.getTxtTelefono(), ventanaPersona.getTxtCalle(), ventanaPersona.getTxtAltura(), ventanaPersona.getTxtPiso(), buscadaLocalidad , ventanaPersona.getTxtMail(), buscadoContacto, ventanaPersona.getTxtFNac());
					this.agenda.agregarPersona(nuevaPersona);
					this.llenarTabla();
					this.localidadesElegibles();
					this.contactosElegibles();
					this.ventanaPersona.dispose();
					
				}
				
			}

			else if(e.getSource() == this.ventanaPersona.getBtnEditarPersona())
			{
				
				this.persona_a_editar.setNombre(this.ventanaPersona.getTxtNombre());
				this.persona_a_editar.setTelefono(this.ventanaPersona.getTxtTelefono());
				this.persona_a_editar.setCalle(this.ventanaPersona.getTxtCalle());
				this.persona_a_editar.setAltura(this.ventanaPersona.getTxtAltura());
				this.persona_a_editar.setPiso(this.ventanaPersona.getTxtPiso());
				this.persona_a_editar.setLocalidad(agenda.buscarLocalidad(this.ventanaPersona.getTxtLocalidad()));
				this.persona_a_editar.setMail(this.ventanaPersona.getTxtTelefono());
				this.persona_a_editar.setContact(agenda.buscarContacto( this.ventanaPersona.getTxtContacto()));
				this.persona_a_editar.setfNacimiento(this.ventanaPersona.getTxtFNac());
				if(this.isValidPersona(this.ventanaPersona)) {
					this.agenda.editarPersona(this.persona_a_editar);
					this.llenarTabla();
					this.localidadesElegibles();
					this.contactosElegibles();
					this.ventanaPersona.dispose();
				}
				
			}
			
			else if(this.ventanaLocalidad!= null && e.getSource() == this.ventanaLocalidad.getBtnAgregarLocalidad())
			{
				if(this.isValidLocalidad(ventanaLocalidad)) {
					LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, ventanaLocalidad.getTxtNombre(),ventanaLocalidad.getTxtCodPostal());
					this.agenda.agregarLocalidad(nuevaLocalidad);
					this.ventanaPersona.refresh();
					this.ventanaLocalidad.dispose();
				}

				
			}

			
						
			else if(this.ventanaContacto!= null && e.getSource() == this.ventanaContacto.getBtnAgregarContacto())
			{
				if(this.isValidContacto(ventanaContacto)) {
					ContactoDTO nuevoContacto = new ContactoDTO(0,ventanaContacto.getTxtNombre());
					this.agenda.agregarContacto(nuevoContacto);
					this.ventanaPersona.refresh();
					this.ventanaContacto.dispose();
				}

				
			}
			
			else if (this.vista.getVentanaConfiguracion() != null && e.getSource() == this.vista.getVentanaConfiguracion().getBtnAgregarDatos()) {
				
				String nuevaIp = this.vista.getVentanaConfiguracion().getIp();
				String nuevoPuerto = this.vista.getVentanaConfiguracion().getPuerto();
				String nuevoUsuario = this.vista.getVentanaConfiguracion().getUsuario();
				String nuevaContrasena = this.vista.getVentanaConfiguracion().getContrasena();
				
				Map<String, String> datos = new HashMap<String, String>();
				datos.put("ip", nuevaIp);
				datos.put("puerto", nuevoPuerto);
				datos.put("usuario", nuevoUsuario);
				datos.put("contrasena", nuevaContrasena);
				datos.put("primeravez", "No");
				Propiedades.guardar(datos);
				
				
			}
			
			
		}
		
		
		
		
		

}
