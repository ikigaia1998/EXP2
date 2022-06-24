package gui;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import entidad.Sala;
import model.SalaModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

public class FrmReporteSala extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField txtNumero;
	private JLabel lblNewLabel_1;
	private JComboBox<String> cboPiso;
	private JTextField txtInicio;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtFin;
	private JComboBox<String> cboSede;
	private JLabel lblNewLabel_4;
	private JTextField txtRecursos;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtNumAl;
	private JLabel lblReporteSala;
	private JButton btnReporte;
	private JPanel panel;

	public FrmReporteSala() {
		getContentPane().setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de Sala");
		setBounds(100, 100, 1200, 550);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("N\u00FAmero:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(139, 64, 99, 13);
		getContentPane().add(lblNewLabel);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(309, 64, 96, 19);
		getContentPane().add(txtNumero);
		
		lblNewLabel_1 = new JLabel("Piso:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(139, 89, 99, 13);
		getContentPane().add(lblNewLabel_1);
		
		cboPiso = new JComboBox<String>();
		cboPiso.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "1", "2", "3", "4", "5"}));
		cboPiso.setBounds(306, 88, 99, 21);
		getContentPane().add(cboPiso);
		
		txtInicio = new JTextField();
		txtInicio.setColumns(10);
		txtInicio.setBounds(696, 76, 120, 19);
		getContentPane().add(txtInicio);
		
		lblNewLabel_2 = new JLabel("Fecha de inicio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(562, 79, 99, 13);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Fecha fin:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(562, 106, 99, 13);
		getContentPane().add(lblNewLabel_3);
		
		txtFin = new JTextField();
		txtFin.setColumns(10);
		txtFin.setBounds(696, 103, 120, 19);
		getContentPane().add(txtFin);
		
		cboSede = new JComboBox<String>();
		cboSede.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Lima", "Bellavista ", "Bre\u00F1a", "Arequipa", "Trujillo", "Independencia", "Surco"}));
		cboSede.setBounds(696, 132, 120, 21);
		getContentPane().add(cboSede);
		
		lblNewLabel_4 = new JLabel("Sede:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(562, 136, 99, 13);
		getContentPane().add(lblNewLabel_4);
		
		txtRecursos = new JTextField();
		txtRecursos.setColumns(10);
		txtRecursos.setBounds(306, 144, 160, 19);
		getContentPane().add(txtRecursos);
		
		lblNewLabel_5 = new JLabel("Recursos:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(139, 144, 99, 13);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("N\u00FAmero de alumnos:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(139, 119, 139, 13);
		getContentPane().add(lblNewLabel_6);
		
		txtNumAl = new JTextField();
		txtNumAl.setColumns(10);
		txtNumAl.setBounds(306, 119, 96, 19);
		getContentPane().add(txtNumAl);
		
		lblReporteSala = new JLabel("Reporte Sala");
		lblReporteSala.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteSala.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblReporteSala.setBounds(10, 10, 924, 36);
		getContentPane().add(lblReporteSala);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReporte.setBounds(882, 91, 111, 36);
		getContentPane().add(btnReporte);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reporte Sala", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 173, 1168, 338);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		String numero = txtNumero.getText();
		String piso = cboPiso.getSelectedItem().toString();
		String numAlu = txtNumAl.getText();
		String recursos = txtRecursos.getText();
		String fecIni = txtInicio.getText();
		String fecFin = txtFin.getText();
		String sede = cboSede.getSelectedItem().toString();
		if (piso == "[Seleccione]") {
			piso = "";
		}else {
			cboPiso.getSelectedItem().toString();
		}
		if (sede == "[Seleccione]") {
			sede = "";
		}else {
			cboSede.getSelectedItem().toString();
		}
		
		SalaModel model = new SalaModel();
		List<Sala> lstSala = model.consultaSala(numero, piso, numAlu, recursos, fecIni, fecFin, sede);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstSala);
		
		String reporte ="ReporteSala.jasper";
		
		JasperPrint print = GeneradorReporte.genera(reporte, dataSource,null);
		
		JRViewer jasperViewer = new JRViewer(print);
		panel.removeAll();
		panel.add(jasperViewer);
		panel.repaint();
		panel.revalidate();
		
	}
}
