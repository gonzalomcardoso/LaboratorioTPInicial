package presentacion.vista;


import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import dto.ContactoDTO;
import dto.LocalidadDTO;
import presentacion.controlador.Controlador;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JComboBox txtLocalidad;
	private JTextField txtMail;
	private JComboBox txtContacto;
	private JCalendar txtFNac;
	private JButton btnAgregarPersona;
	private JButton btnEditarPersona;
	private JButton btnAgregarLocalidad;
	private JButton btnAgregarContact;
	private Controlador controlador;
	

	
	public VentanaPersona(Controlador controlador) 
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 22, 582, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 93, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 134, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 175, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 216, 113, 14);
		panel.add(lblLocalidad);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 257, 113, 14);
		panel.add(lblMail);
		
		JLabel lblContacto = new JLabel("Tipo de Contacto");
		lblContacto.setBounds(10, 298, 113, 14);
		panel.add(lblContacto);
		
		JLabel lblFNacimiento = new JLabel("Fecha de Nacimiento");
		lblFNacimiento.setBounds(10, 339, 113, 14);
		panel.add(lblFNacimiento);
		
		txtNombre = new JTextField();
		txtTelefono = new JTextField();
		txtCalle = new JTextField();
		txtAltura = new JTextField();
		txtPiso = new JTextField();
		txtLocalidad = new JComboBox();
		for (Iterator<LocalidadDTO> i = controlador.localidadesElegibles().iterator(); i.hasNext();) { 
		    txtLocalidad.addItem(i.next().getNombre());
		}
		txtMail = new JTextField();
		txtContacto = new JComboBox();
		for (Iterator<ContactoDTO> i = controlador.contactosElegibles().iterator(); i.hasNext();) { 
			txtContacto.addItem(i.next().getTipo());
		}
		txtFNac = new JCalendar();
		
		
		
		if (controlador.personaEditable()!=null){
			txtNombre = new JTextField(controlador.personaEditable().getNombre());
			txtTelefono = new JTextField(controlador.personaEditable().getTelefono());
			txtCalle = new JTextField(controlador.personaEditable().getCalle());
			txtAltura = new JTextField(controlador.personaEditable().getAltura());
			txtPiso = new JTextField(controlador.personaEditable().getPiso());
			txtLocalidad.setSelectedItem(controlador.personaEditable().getNombreLocalidad());
			txtMail = new JTextField(controlador.personaEditable().getMail());
			txtContacto.setSelectedItem(controlador.personaEditable().getNombreContacto());
			txtFNac.setDate(controlador.personaEditable().getfNacimiento());
			
			
			btnEditarPersona = new JButton("Editar Persona");
			btnEditarPersona.addActionListener(this.controlador);
			btnEditarPersona.setBounds(208, 440, 89, 23);
			panel.add(btnEditarPersona);
			
			this.setVisible(true);
			
		}else{
			
			
			btnAgregarPersona = new JButton("Agregar Persona");
			btnAgregarPersona.addActionListener(this.controlador);
			btnAgregarPersona.setBounds(208, 440, 164, 20);
			panel.add(btnAgregarPersona);
			
			
			
			
			
			this.setVisible(true);
		}
		
		
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCalle.setBounds(133, 93, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		txtAltura.setBounds(133, 134, 164, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPiso.setBounds(133, 175, 164, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		txtLocalidad.setBounds(133, 216, 164, 20);
		panel.add(txtLocalidad);
		
		btnAgregarLocalidad = new JButton("Agregar Localidad");
		btnAgregarLocalidad.addActionListener(this.controlador);
		btnAgregarLocalidad.setBounds(369, 216, 164, 20);
		panel.add(btnAgregarLocalidad);
		
		txtMail.setBounds(133, 257, 164, 20);
		panel.add(txtMail);
		txtMail.setColumns(10);
		
		txtContacto.setBounds(133, 298, 164, 20);
		panel.add(txtContacto);
		
		btnAgregarContact = new JButton("Agregar Contact");
		btnAgregarContact.addActionListener(this.controlador);
		btnAgregarContact.setBounds(369, 298, 164, 20);
		panel.add(btnAgregarContact);

		JDayChooser dayChooser = new JDayChooser();
		dayChooser.setBounds(133, 359, 300, 20);
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(133, 339, 164, 20);
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(369, 339, 164, 20);
		
		
		txtFNac.setBounds(133, 339, 300, 100);
		panel.add(txtFNac);
		//txtFNac.setColumns(10);
	}
	
	

	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public JTextField getTxtPiso() {
		return txtPiso;
	}

	public JComboBox getTxtLocalidad() {
		return txtLocalidad;
	}

	public JTextField getTxtMail() {
		return txtMail;
	}

	public JComboBox getTxtContacto() {
		return txtContacto;
	}
	
	public JCalendar getTxtFNac() {
		return txtFNac;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
	
	public JButton getBtnEditarPersona() 
	{
		return btnEditarPersona;
	}
	
	public JButton getBtnAgregarLocalidad() 
	{
		return btnAgregarLocalidad;
	}
	
	public JButton getBtnAgregarContact() 
	{
		return btnAgregarContact;
	}

	
	
}

