package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.LocalidadDTO;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private List<LocalidadDTO> localidades_en_tabla;
		private PersonaDTO persona_a_editar;
		private VentanaPersona ventanaPersona; 
		private VentanaLocalidad ventanaLocalidad; 
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnEditar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
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
						this.personas_en_tabla.get(i).getCalle(),
						this.personas_en_tabla.get(i).getAltura(),
						this.personas_en_tabla.get(i).getPiso(),
						this.personas_en_tabla.get(i).getLocalidad().getNombre(),
						this.personas_en_tabla.get(i).getMail(),
						this.personas_en_tabla.get(i).getContacto(),
						
						};
				this.vista.getModelPersonas().addRow(fila);
			}			
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
				
				this.persona_a_editar.setLocalidad(this.personas_en_tabla.get(fila_seleccionada).getLocalidad());
				
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
			
			
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{
				LocalidadDTO buscadaLocalidad = new LocalidadDTO(0,(String)ventanaPersona.getTxtLocalidad().getSelectedItem(),null);
				buscadaLocalidad = agenda.buscarLocalidad(buscadaLocalidad);
				PersonaDTO nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText(), ventanaPersona.getTxtCalle().getText(), ventanaPersona.getTxtAltura().getText(), ventanaPersona.getTxtPiso().getText(), buscadaLocalidad , ventanaPersona.getTxtMail().getText(), Integer.parseInt(ventanaPersona.getTxtContacto().getText()));
				this.agenda.agregarPersona(nuevaPersona);
				this.llenarTabla();
				this.ventanaPersona.dispose();
			}

			else if(e.getSource() == this.ventanaPersona.getBtnEditarPersona())
			{
				
				this.persona_a_editar.setNombre(this.ventanaPersona.getTxtNombre().getText());
				this.persona_a_editar.setTelefono(this.ventanaPersona.getTxtTelefono().getText());
				this.agenda.editarPersona(this.persona_a_editar);
				this.llenarTabla();
				this.ventanaPersona.dispose();
			}
			
			else if(e.getSource() == this.ventanaLocalidad.getBtnAgregarLocalidad())
			{

				LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, ventanaLocalidad.getTxtNombre().getText(),ventanaLocalidad.getTxtCodPostal().getText());
				this.agenda.agregarLocalidad(nuevaLocalidad);
				this.localidadesElegibles();
				this.llenarTabla();
				this.ventanaLocalidad.dispose();
			}
			
		}

}
