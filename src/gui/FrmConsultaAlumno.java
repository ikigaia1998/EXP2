package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;



import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import model.AlumnoModel;

import java.awt.event.KeyListener;



import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class FrmConsultaAlumno extends JInternalFrame implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblPas;
	private JLabel lblFechaDeRegistro;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtDesde;
	private JComboBox <String>cboPais;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTable tblConsulta;
	private JLabel lblDesde;
	private JLabel lblHasta;
	private JTextField txtHasta;
	private JLabel lblNewLabel_1;

	public FrmConsultaAlumno() {
		getContentPane().setBackground(new Color(23,175,174));
		setFrameIcon(new ImageIcon(FrmConsultaAlumno.class.getResource("/imgs/documento.png")));
		getContentPane().setForeground(Color.RED);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Alumno");
		setBounds(100, 100, 1133, 610);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(23,175,174));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Consulta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 59, 1090, 184);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 59, 70, 13);
		panel.add(lblNewLabel);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 111, 70, 13);
		panel.add(lblApellidos);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDni.setBounds(388, 59, 45, 13);
		panel.add(lblDni);
		
		lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPas.setBounds(388, 111, 45, 13);
		panel.add(lblPas);
		
		lblFechaDeRegistro = new JLabel("Fecha de Registro:");
		lblFechaDeRegistro.setFont(new Font("Arial", Font.PLAIN, 13));
		lblFechaDeRegistro.setBounds(648, 85, 121, 13);
		panel.add(lblFechaDeRegistro);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(86, 54, 274, 19);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(86, 105, 270, 19);
		panel.add(txtApellidos);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setColumns(10);
		txtDNI.setBounds(443, 54, 136, 19);
		panel.add(txtDNI);
		
		txtDesde = new JTextField();
		txtDesde.setColumns(10);
		txtDesde.setBounds(929, 60, 136, 19);
		panel.add(txtDesde);
		
		cboPais = new JComboBox<String>();
		cboPais.addItem("");
		cboPais.addItem("Perú");
		cboPais.addItem("Chile");
		cboPais.addItem("Ecuador");
		cboPais.addItem("Colombia");
		cboPais.addItem("Venezuela");
		cboPais.setBounds(443, 104, 136, 21);
		panel.add(cboPais);
		

		
		btnConsultar = new JButton(" Consultar");
		btnConsultar.setBackground(new Color(152, 79, 151));
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultar.setBounds(423, 152, 165, 21);
		panel.add(btnConsultar);
		
		lblDesde = new JLabel("Desde:");
		lblDesde.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDesde.setBounds(848, 62, 45, 13);
		panel.add(lblDesde);
		
		lblHasta = new JLabel("Hasta:");
		lblHasta.setFont(new Font("Arial", Font.PLAIN, 12));
		lblHasta.setBounds(848, 107, 45, 13);
		panel.add(lblHasta);
		
		txtHasta = new JTextField();
		txtHasta.setColumns(10);
		txtHasta.setBounds(929, 105, 136, 19);
		panel.add(txtHasta);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(48,155,210));
		scrollPane.setBounds(20, 254, 1084, 307);
		getContentPane().add(scrollPane);
		
		tblConsulta = new JTable();
		tblConsulta.setBackground(new Color(191,252,250));
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombres", "Apellidos", "DNI", "Pa\u00EDs", "Correo", "Fecha de Nacimiento", "Fecha de Registro"
			}
		));
		tblConsulta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblConsulta);
		
		tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(15);
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(50);
		tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(20);
		tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(30);
		tblConsulta.getColumnModel().getColumn(5).setPreferredWidth(50);
		tblConsulta.getColumnModel().getColumn(6).setPreferredWidth(40);
		tblConsulta.getColumnModel().getColumn(7).setPreferredWidth(40);
		
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		tblConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		tblConsulta.getTableHeader().setReorderingAllowed(false);
		
		tblConsulta.setDefaultEditor(Object.class, null);
		
		tblConsulta.setSelectionBackground(new Color(0,207,203));
		
		lblNewLabel_1 = new JLabel("Consulta Alumno");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(372, 11, 364, 37);
		getContentPane().add(lblNewLabel_1);
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDNI) {
			keyTypedTxtDNI(e);
		}
	}
	protected void keyTypedTxtDNI(KeyEvent e) {
		if (Character.isLetter(e.getKeyChar())) {
			
			 getToolkit().beep();
			 e.consume();
		      JOptionPane.showMessageDialog(null, "Debe ingresar sólo números","Error",JOptionPane.ERROR_MESSAGE); 
			 
		}
		
		String dni = txtDNI.getText() + e.getKeyChar();
		
		if (dni.length() > 8) {
			e.consume();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		String nombre = txtNombres.getText();
		String apellido = txtApellidos.getText();
		String dni = txtDNI.getText();
		String pais = cboPais.getSelectedItem().toString();
		String desde = txtDesde.getText();
		String hasta = txtHasta.getText();
		
		AlumnoModel am = new AlumnoModel();
		List<Alumno> alumno = am.consultaNombreApellidoDniPaisFechareg(nombre, apellido, dni, pais, desde, hasta);
		
		DefaultTableModel dtm = (DefaultTableModel) tblConsulta.getModel();
		dtm.setRowCount(0);
		Object[] fila = null;
		for (Alumno x : alumno) {
			fila = new Object [] 
			{x.getIdAlumno(),
			x.getNombre(),
			x.getApellido(),
			x.getDni(),
			x.getPais(),
			x.getCorreo(),
			x.getFechanac(),
			x.getFechareg(),};
			dtm.addRow(fila);
			}
	}
	
	void limpiar() {
		txtNombres.setText(null);
		txtApellidos.setText(null);
		txtDNI.setText(null);
		txtDesde.setText(null);
		txtHasta.setText(null);
		cboPais.setSelectedIndex(-1);
		txtNombres.requestFocus();
	}
	
}
