package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import presentacion.controlador.Controlador;

public class VentanaContacto extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnAgregarContacto;
	private Controlador controlador;
	
	public VentanaContacto(Controlador controlador) 
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
		
		JLabel lblNombre = new JLabel("Tipo de Contacto");
		lblNombre.setBounds(10, 11, 113, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
			
			
		btnAgregarContacto = new JButton("Agregar");
		btnAgregarContacto.addActionListener(this.controlador);
		btnAgregarContacto.setBounds(208, 92, 89, 23);
		panel.add(btnAgregarContacto);
			
		this.setVisible(true);
		
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public JButton getBtnAgregarContacto() {
		return btnAgregarContacto;
	}


	
}
	
