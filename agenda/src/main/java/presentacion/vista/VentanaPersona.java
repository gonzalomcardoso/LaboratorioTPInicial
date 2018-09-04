package presentacion.vista;


import java.sql.Date;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import dto.ContactoDTO;
import dto.LocalidadDTO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
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
	private JDatePickerImpl txtFNac;
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
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		txtFNac = new JDatePickerImpl(datePanel);
		
		
		
		
		if (controlador.personaEditable()!=null){
			txtNombre = new JTextField(controlador.personaEditable().getNombre());
			txtTelefono = new JTextField(controlador.personaEditable().getTelefono());
			txtCalle = new JTextField(controlador.personaEditable().getCalle());
			txtAltura = new JTextField(controlador.personaEditable().getAltura());
			txtPiso = new JTextField(controlador.personaEditable().getPiso());
			txtLocalidad.setSelectedItem(controlador.personaEditable().getNombreLocalidad());
			txtMail = new JTextField(controlador.personaEditable().getMail());
			txtContacto.setSelectedItem(controlador.personaEditable().getNombreContacto());
			model.setValue(controlador.personaEditable().getfNacimiento());
			
			
			btnEditarPersona = new JButton("Editar Persona");
			btnEditarPersona.addActionListener(this.controlador);
			btnEditarPersona.setBounds(208, 445, 89, 23);
			panel.add(btnEditarPersona);
			
			this.setVisible(true);
			
		}else{
			
			
			btnAgregarPersona = new JButton("Agregar Persona");
			btnAgregarPersona.addActionListener(this.controlador);
			btnAgregarPersona.setBounds(208, 445, 164, 20);
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
		
		
		txtFNac.setBounds(133, 339, 250, 30);
		panel.add(txtFNac);
	}
	
	

	public String getTxtNombre() 
	{
		return txtNombre.getText();
	}

	public String getTxtTelefono() 
	{
		return txtTelefono.getText();
	}

	public String getTxtCalle() {
		return txtCalle.getText();
	}

	public String getTxtAltura() {
		return txtAltura.getText();
	}

	public String getTxtPiso() {
		return txtPiso.getText();
	}

	public String getTxtLocalidad() {
		return (String)txtLocalidad.getSelectedItem();
	}

	public String getTxtMail() {
		return txtMail.getText();
	}

	public String getTxtContacto() {
		return (String)txtContacto.getSelectedItem();
	}
	
	public  Date getTxtFNac() {
		java.util.Date uDate = (java.util.Date) txtFNac.getModel().getValue();
		java.sql.Date sDate =  new java.sql.Date(uDate.getTime());
		return sDate;
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

