package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import presentacion.controlador.Controlador;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class VentanaConfiguracion extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIp;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JButton btnAgregarDatos;
	private Controlador controlador;
	
	public VentanaConfiguracion() 
	{
		
		super();
		//this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder (6, 6, 6, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIp = new JLabel("Ip");
		lblIp.setBounds(10, 11, 113, 14);
		panel.add(lblIp);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(10, 33, 113, 14);
		panel.add(lblPuerto);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 55, 113, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setBounds(10, 77, 113, 14);
		panel.add(lblContrasena);
		
		txtIp = new JTextField();
		txtPuerto = new JTextField();
		txtUsuario = new JTextField();
		txtContrasena = new JTextField();
		
		txtIp.setBounds(113, 8, 164, 20);
		panel.add(txtIp);
		txtIp.setColumns(10);
		
		txtPuerto.setBounds(113, 30, 164, 20);
		panel.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		txtUsuario.setBounds(113, 52, 164, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena.setBounds(113, 74, 164, 20);
		panel.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		btnAgregarDatos = new JButton("Ingresar");
		//btnAgregarDatos.addActionListener(this.controlador);
		btnAgregarDatos.setBounds(93, 102, 89, 23);
		panel.add(btnAgregarDatos);
			
		this.setVisible(true);
	}
	
	public String getIp() {
		return txtIp.getText();
	}
	
	public String getPuerto() {
		return txtPuerto.getText();
	}
	public String getUsuario() {
		return txtUsuario.getText();
	}
	public String getContrasena() {
		return txtContrasena.getText();
	}

	public JButton getBtnAgregarDatos() {
		return btnAgregarDatos;
	}

}
