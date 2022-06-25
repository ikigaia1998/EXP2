package inicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidad.Usuario;
import model.UsuarioModel;
import util.DatosGlobales;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FrmLogin extends JDialog implements ActionListener {

	public JLabel lblLogin, lblClave;
	public JTextField txtLogin;
	public JPasswordField txtClave;
	public JButton btnEnviar, btnLimpiar;
	private UsuarioModel model = new UsuarioModel();

	public FrmPrincipal frm;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	//
	public FrmLogin(FrmPrincipal frm) {
		getContentPane().setBackground(new Color(102, 153, 255));
		this.frm = frm;

		getContentPane().setLayout(null);
		this.setSize(758, 499);
		this.setLocationRelativeTo(null);
		this.setTitle("Sistema de gestión de biblioteca");

		lblLogin = new JLabel("Username:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBounds(78, 211, 100, 25);
		getContentPane().add(lblLogin);

		txtLogin = new JTextField("luis");
		txtLogin.setBackground(new Color(255, 255, 255));
		txtLogin.setBounds(193, 211, 144, 25);
		txtLogin.addActionListener(this);
		getContentPane().add(txtLogin);

		lblClave = new JLabel("Password:");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClave.setForeground(new Color(255, 255, 255));
		lblClave.setBounds(78, 243, 100, 25);
		getContentPane().add(lblClave);

		txtClave = new JPasswordField("luis");
		txtClave.setBackground(new Color(255, 255, 255));
		txtClave.addActionListener(this);
		txtClave.setBounds(193, 243, 144, 25);
		getContentPane().add(txtClave);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(102, 204, 153));
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(60, 305, 300, 25);
		getContentPane().add(btnEnviar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(102, 204, 153));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(160, 334, 100, 25);
		getContentPane().add(btnLimpiar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/imgs/login.jpg")));
		lblNewLabel.setBounds(432, 0, 320, 480);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Biblioteca 2022");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setBounds(96, 138, 226, 37);
		getContentPane().add(lblNewLabel_1);

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar || e.getSource() == txtLogin || e.getSource() == txtClave) {

			String login = txtLogin.getText().trim();
			String clave = new String(txtClave.getPassword());

			Usuario bean = model.valida(login, clave);

			if (bean != null) {
				DatosGlobales.ID_USUARIO = bean.getIdUsuario();
				frm.setVisible(true);
				this.setVisible(false);
				frm.muestraOpciones();
			} else {
				JOptionPane.showMessageDialog(this, "Usuario no valido");
			}

		}
		if (e.getSource() == btnLimpiar) {
			txtLogin.setText("");
			txtClave.setText("");
			txtLogin.requestFocus();
		}

	}

	public void windowDeactivated(WindowEvent e) {
	}
}
