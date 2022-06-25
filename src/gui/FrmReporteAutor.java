package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import entidad.Autor;
import model.AutorModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class FrmReporteAutor extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblPais;
	private JComboBox<String> cboPais;
	private JTextField txtNombres;
	private JLabel lblNombre;
	private JLabel lblGrado;
	private JLabel lblApellido;
	private JComboBox<String> cboGrado;
	private JLabel lblFechaDeNacimiento;
	private JTextField txtApellidos;
	private JTextField txtFechaDesde;
	private JLabel lblReporteDeAutor;
	private JButton btnFiltrar;
	private JPanel pnlReporte;
	private JLabel lblFechaNacimientoHasta;
	private JTextField txtFechaHasta;
	private JButton btnLimpiar;

	public FrmReporteAutor() {
		setFrameIcon(new ImageIcon(FrmReporteAutor.class.getResource("/imgs/reporte.png")));
		getContentPane().setBackground(new Color(48,155,210));
		getContentPane().setForeground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de Autor");
		setBounds(100, 100, 1134, 603);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPais.setBounds(20, 134, 61, 20);
		getContentPane().add(lblPais);
		
		cboPais = new JComboBox<String>();
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Per\u00FA", "Chile", "Ecuador", "Colombia", "Argentina"}));
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboPais.setBounds(216, 129, 165, 25);
		getContentPane().add(cboPais);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombres.setColumns(10);
		txtNombres.setBounds(216, 54, 205, 22);
		getContentPane().add(txtNombres);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombre.setBounds(20, 57, 84, 20);
		getContentPane().add(lblNombre);
		
		lblGrado = new JLabel("Grado");
		lblGrado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGrado.setBounds(455, 135, 61, 19);
		getContentPane().add(lblGrado);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 14));
		lblApellido.setBounds(455, 57, 90, 20);
		getContentPane().add(lblApellido);
		
		cboGrado = new JComboBox<String>();
		cboGrado.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "T\u00E9cnico", "Licenciado", "Doctor", "Autor"}));
		cboGrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGrado.setBounds(661, 131, 205, 25);
		getContentPane().add(cboGrado);
		
		lblFechaDeNacimiento = new JLabel("Fecha de  nacimiento desde");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFechaDeNacimiento.setBounds(21, 100, 209, 20);
		getContentPane().add(lblFechaDeNacimiento);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(661, 57, 205, 22);
		getContentPane().add(txtApellidos);
		
		txtFechaDesde = new JTextField();
		txtFechaDesde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaDesde.setColumns(10);
		txtFechaDesde.setBounds(216, 97, 205, 22);
		getContentPane().add(txtFechaDesde);
		
		lblReporteDeAutor = new JLabel("Reporte de Autor");
		lblReporteDeAutor.setFont(new Font("Arial", Font.BOLD, 30));
		lblReporteDeAutor.setBounds(391, 7, 285, 36);
		getContentPane().add(lblReporteDeAutor);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(new Color(164, 49, 112));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnFiltrar.setBounds(902, 58, 159, 38);
		getContentPane().add(btnFiltrar);
		
		pnlReporte = new JPanel();
		pnlReporte.setBackground(new Color(206,246,255));
		pnlReporte.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Reporte", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlReporte.setBounds(10, 193, 1089, 366);
		getContentPane().add(pnlReporte);
		pnlReporte.setLayout(new BorderLayout(0, 0));
		
		lblFechaNacimientoHasta = new JLabel("Fecha de nacimiento hasta");
		lblFechaNacimientoHasta.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFechaNacimientoHasta.setBounds(455, 95, 205, 20);
		getContentPane().add(lblFechaNacimientoHasta);
		
		txtFechaHasta = new JTextField();
		txtFechaHasta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaHasta.setColumns(10);
		txtFechaHasta.setBounds(661, 97, 205, 22);
		getContentPane().add(txtFechaHasta);
		
		btnLimpiar = new JButton("Limpiar filtros");
		btnLimpiar.setBackground(new Color(164, 49, 112));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Arial", Font.BOLD, 14));
		btnLimpiar.setBounds(902, 115, 159, 38);
		getContentPane().add(btnLimpiar);


	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(e);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent e) {
		String nombresUI = txtNombres.getText();
		String apellidosUI = txtApellidos.getText();
		String fechaDesdeUI = txtFechaDesde.getText();
		String fechaHastaUI = txtFechaHasta.getText();
		String paisUI = cboPais.getSelectedItem().toString();
		String gradoUI = cboGrado.getSelectedItem().toString();
		if(paisUI != "[Seleccione]") {
			paisUI = cboPais.getSelectedItem().toString();
		}else {paisUI = "";}
		if(gradoUI != "[Seleccione]") {
			gradoUI = cboGrado.getSelectedItem().toString();
		}else {gradoUI = "";}
		
		AutorModel mAutor = new AutorModel();
		List<Autor> listAutor = mAutor.ConsultaReporteAutor(nombresUI, apellidosUI, fechaDesdeUI, fechaHastaUI, paisUI, gradoUI);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listAutor);
		String jasper = "reporteAutor.jasper";
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		
		JRViewer visor = new JRViewer(print);
		
		pnlReporte.removeAll();
		pnlReporte.add(visor);
		pnlReporte.repaint();
		pnlReporte.revalidate();
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtFechaDesde.setText("");
		txtFechaHasta.setText("");
		cboPais.setSelectedIndex(0);
		cboGrado.setSelectedIndex(0);
		txtNombres.requestFocus();
		pnlReporte.removeAll();
		pnlReporte.repaint();
		pnlReporte.revalidate();
	}
}
