package gui;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entidad.Alumno;
import model.AlumnoModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.event.KeyListener;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmReporteAlumno extends JInternalFrame implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblPas;
	private JLabel lblFechaDeRegistro;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtDesde;
	private JComboBox<String> cboPais;
	private JButton btnConsultar;
	private JLabel lblDesde;
	private JLabel lblHasta;
	private JTextField txtHasta;
	private JPanel pnlReporte;

	public FrmReporteAlumno() {
		getContentPane().setForeground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Reporte", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(72, 61, 139)));
		panel.setBounds(10, 10, 1090, 184);
		getContentPane().add(panel);
		
		lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 59, 70, 13);
		panel.add(lblNewLabel);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 111, 70, 13);
		panel.add(lblApellidos);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setBounds(388, 59, 45, 13);
		panel.add(lblDni);
		
		lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPas.setBounds(388, 111, 45, 13);
		panel.add(lblPas);
		
		lblFechaDeRegistro = new JLabel("Fecha de Registro:");
		lblFechaDeRegistro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeRegistro.setBounds(648, 85, 121, 13);
		panel.add(lblFechaDeRegistro);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(86, 54, 274, 19);
		panel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(86, 105, 270, 19);
		panel.add(txtApellido);
		
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
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsultar.setBounds(423, 152, 165, 21);
		panel.add(btnConsultar);
		
		lblDesde = new JLabel("Desde:");
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesde.setBounds(848, 62, 45, 13);
		panel.add(lblDesde);
		
		lblHasta = new JLabel("Hasta:");
		lblHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHasta.setBounds(848, 107, 45, 13);
		panel.add(lblHasta);
		
		txtHasta = new JTextField();
		txtHasta.setColumns(10);
		txtHasta.setBounds(929, 105, 136, 19);
		panel.add(txtHasta);
		
		pnlReporte = new JPanel();
		pnlReporte.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlReporte.setBounds(10, 204, 1088, 307);
		getContentPane().add(pnlReporte);
		pnlReporte.setLayout(new BoxLayout(pnlReporte, BoxLayout.X_AXIS));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de alumno");
		setBounds(100, 100, 1120, 550);

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
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String dni = txtDNI.getText();
		String pais = cboPais.getSelectedItem().toString();
		String desde = txtDesde.getText();
		String hasta = txtHasta.getText();
		
		AlumnoModel am = new AlumnoModel();
		List<Alumno> reporte = am.consultaNombreApellidoDniPaisFechareg(nombre, apellido, dni, pais, desde, hasta);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reporte);
		String jasper = "ReporteAlumno.jasper";
		
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		
		JRViewer viewer = new JRViewer(print);
		
		
		pnlReporte.removeAll();
		pnlReporte.add(viewer);
		pnlReporte.repaint();
		pnlReporte.revalidate();
	}
}
