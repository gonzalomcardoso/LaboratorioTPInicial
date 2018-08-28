package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import presentacion.controlador.Controlador;

public class VentanaLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCodPostal;
	private JButton btnAgregarLocalidad;
	private Controlador controlador;
	
	public VentanaLocalidad(Controlador controlador) 
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Localidad");
		lblNombre.setBounds(10, 11, 113, 14);
		panel.add(lblNombre);
		
		JLabel lblCodPostal = new JLabel("Codigo Postal");
		lblCodPostal.setBounds(10, 52, 113, 14);
		panel.add(lblCodPostal);
		
		txtNombre = new JTextField();
		txtCodPostal = new JTextField();
			
			
		btnAgregarLocalidad = new JButton("Agregar");
		btnAgregarLocalidad.addActionListener(this.controlador);
		btnAgregarLocalidad.setBounds(208, 92, 89, 23);
		panel.add(btnAgregarLocalidad);
			
		this.setVisible(true);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtCodPostal() {
		return txtCodPostal;
	}

	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}


	
}
	
