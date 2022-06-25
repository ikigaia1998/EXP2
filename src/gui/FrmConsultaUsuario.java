package gui;
//import
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import entidad.Usuario;
import model.UsuarioModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmConsultaUsuario extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtApellido;
	private JTextField txtInicio;
	private JTextField txtFin;
	private JButton btnFiltrar;
	private JTable table;

	public FrmConsultaUsuario() {
		setFrameIcon(new ImageIcon(FrmConsultaUsuario.class.getResource("/imgs/documento.png")));
		getContentPane().setBackground(new Color(23,175,174));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Usuario");
		setBounds(100, 100, 955, 550);
		getContentPane().setLayout(null);
		
		JLabel lblConsultaDeUsuario = new JLabel("Consulta de Usuario");
		lblConsultaDeUsuario.setForeground(Color.BLACK);
		lblConsultaDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeUsuario.setFont(new Font("Arial", Font.BOLD, 30));
		lblConsultaDeUsuario.setBounds(46, 10, 886, 48);
		getContentPane().add(lblConsultaDeUsuario);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(46, 100, 69, 14);
		getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(143, 96, 149, 20);
		getContentPane().add(txtNombre);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(46, 166, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(143, 164, 149, 20);
		getContentPane().add(txtDNI);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(46, 135, 69, 14);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(143, 133, 149, 20);
		getContentPane().add(txtApellido);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio");
		lblFechaDeInicio.setBounds(317, 100, 104, 20);
		getContentPane().add(lblFechaDeInicio);
		
		txtInicio = new JTextField();
		txtInicio.setColumns(10);
		txtInicio.setBounds(414, 100, 149, 20);
		getContentPane().add(txtInicio);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de Fin");
		lblFechaDeFin.setBounds(317, 136, 85, 14);
		getContentPane().add(lblFechaDeFin);
		
		txtFin = new JTextField();
		txtFin.setColumns(10);
		txtFin.setBounds(412, 133, 149, 20);
		getContentPane().add(txtFin);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(new Color(152, 79, 151));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(756, 143, 149, 37);
		getContentPane().add(btnFiltrar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 195, 912, 314);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setSelectionBackground(new Color( 53,194,169));
		table.setBackground(new Color(191,252,250));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Código", "Nombre", "Apellido", "DNI", "Login", "Password", "Correo","Fecha de Nacimiento", "Dirección", "País"
			}
		));
		scrollPane_1.setViewportView(table);
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String dni = txtDNI.getText();
		String desde = txtInicio.getText();
		String hasta = txtFin.getText();
		
		UsuarioModel model = new UsuarioModel();
		List<Usuario>  listaUsuario = model.consultaPorNombreDNIFecha(nombre, apellido, dni, desde, hasta);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null;
		
		for (Usuario x : listaUsuario) {
			fila = new Object[]{x.getIdUsuario(), x.getNombre(), x.getApellido(), x.getDni(),x.getLogin(),x.getPassword(),x.getCorreo()
					, x.getFechaNacimiento(), x.getDireccion(), x.getPais() };
			
			dtm.addRow(fila);
			
		}
		
	}
}
