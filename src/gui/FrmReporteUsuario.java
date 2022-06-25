package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
//imports
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import entidad.Usuario;
import model.UsuarioModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;
import javax.swing.ImageIcon;

public class FrmReporteUsuario extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtInicio;
	private JTextField txtFin;
	private JTextField txtApellidos;
	private JButton btnFiltrar;
	private JPanel panelReporte;

	public FrmReporteUsuario() {
		setFrameIcon(new ImageIcon(FrmReporteUsuario.class.getResource("/imgs/reporte.png")));
		getContentPane().setBackground(new Color(48,155,210));
		getContentPane().setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de Usuario");
		setBounds(100, 100, 1137, 550);
		getContentPane().setLayout(null);
		
		JLabel lblReporteDeUsuario = new JLabel("Reporte de Usuario");
		lblReporteDeUsuario.setForeground(Color.BLACK);
		lblReporteDeUsuario.setBackground(Color.WHITE);
		lblReporteDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeUsuario.setFont(new Font("Arial", Font.BOLD, 30));
		lblReporteDeUsuario.setBounds(106, 11, 886, 48);
		getContentPane().add(lblReporteDeUsuario);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(156, 120, 87, 14);
		getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(253, 118, 149, 20);
		getContentPane().add(txtNombre);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(156, 198, 67, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(253, 196, 149, 20);
		getContentPane().add(txtDNI);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio");
		lblFechaDeInicio.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFechaDeInicio.setBounds(432, 153, 116, 20);
		getContentPane().add(lblFechaDeInicio);
		
		txtInicio = new JTextField();
		txtInicio.setColumns(10);
		txtInicio.setBounds(578, 154, 149, 20);
		getContentPane().add(txtInicio);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de Fin");
		lblFechaDeFin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFechaDeFin.setBounds(432, 198, 116, 14);
		getContentPane().add(lblFechaDeFin);
		
		txtFin = new JTextField();
		txtFin.setColumns(10);
		txtFin.setBounds(578, 196, 149, 20);
		getContentPane().add(txtFin);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(156, 157, 87, 13);
		getContentPane().add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(253, 154, 149, 20);
		getContentPane().add(txtApellidos);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(new Color(164, 49, 112));
		btnFiltrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(768, 188, 162, 33);
		getContentPane().add(btnFiltrar);
		
		panelReporte = new JPanel();
		panelReporte.setBackground(new Color(206, 246,255));
		panelReporte.setBorder(new TitledBorder(null, "Reportes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelReporte.setBounds(10, 250, 1099, 259);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(new BorderLayout());

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		String nombre = txtNombre.getText();
		String apellido = txtApellidos.getText();
		String dni = txtDNI.getText();
		String desde = txtInicio.getText();
		String hasta = txtFin.getText();
		
		UsuarioModel model = new UsuarioModel();
		List<Usuario>  listaUsuario = model.consultaPorNombreDNIFecha(nombre, apellido, dni, desde, hasta);
		
		JRBeanCollectionDataSource dataSource = new  JRBeanCollectionDataSource(listaUsuario);
		
		String jasper = "reporteUsu.jasper";
		
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		
		JRViewer JRViewer = new JRViewer(print);
		
		panelReporte.removeAll();
		panelReporte.add(JRViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
	}
}
