package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entidad.Sala;
import model.SalaModel;

public class FrmConsultaSala extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtNumero;
	private JComboBox<String> cboPiso;
	private JTextField txtNumAl;
	private JTextField txtRecursos;
	private JTextField txtInicio;
	private JTextField txtFin;
	private JComboBox<String> cboSede;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable table;
	int hoveredRow = -1, hoveredColumn = -1;

	public FrmConsultaSala() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Sala");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Consulta Sala");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 924, 36);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 56, 99, 13);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Piso:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 94, 99, 13);
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("N\u00FAmero de alumnos:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 146, 139, 13);
		getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Recursos:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(20, 194, 99, 13);
		getContentPane().add(lblNewLabel_4);

		lblNewLabel_6 = new JLabel("Fecha de inicio:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(437, 70, 99, 13);
		getContentPane().add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Fecha fin:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(437, 122, 99, 13);
		getContentPane().add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Sede:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(437, 170, 99, 13);
		getContentPane().add(lblNewLabel_8);

		txtNumero = new JTextField();
		txtNumero.setBounds(171, 55, 96, 19);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		cboPiso = new JComboBox<String>();
		cboPiso.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "1", "2", "3", "4", "5"}));
		cboPiso.setBounds(168, 92, 99, 21);
		getContentPane().add(cboPiso);

		txtNumAl = new JTextField();
		txtNumAl.setBounds(171, 145, 96, 19);
		getContentPane().add(txtNumAl);
		txtNumAl.setColumns(10);

		txtRecursos = new JTextField();
		txtRecursos.setBounds(171, 193, 160, 19);
		getContentPane().add(txtRecursos);
		txtRecursos.setColumns(10);

		txtInicio = new JTextField();
		txtInicio.setBounds(571, 67, 120, 19);
		getContentPane().add(txtInicio);
		txtInicio.setColumns(10);

		txtFin = new JTextField();
		txtFin.setBounds(571, 119, 120, 19);
		getContentPane().add(txtFin);
		txtFin.setColumns(10);

		cboSede = new JComboBox<String>();
		cboSede.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Lima", "Bellavista ", "Bre\u00F1a", "Arequipa", "Trujillo", "Independencia", "Surco"}));
		cboSede.setBounds(571, 166, 120, 21);
		getContentPane().add(cboSede);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setBounds(752, 72, 99, 35);
		getContentPane().add(btnBuscar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 968, 281);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "N\u00FAmero sala",
				"Piso", "N\u00FAmero alumnos", "Recursos", "Estado", "Fecha registro", "Sede" }));
		scrollPane.setViewportView(table);
		// alineación
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);

		// tamano de la fila
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// selecciona una sola fila
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// desabilita mover las columnas
		table.getTableHeader().setReorderingAllowed(false);

		scrollPane.setViewportView(table);

		// color de la fila seleccionada
		table.setSelectionBackground(Color.blue);

		// No se pueda editar
		table.setDefaultEditor(Object.class, null);

		// Efecto Rollover
		table.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = e.getPoint();
				hoveredRow = table.rowAtPoint(p);
				hoveredColumn = table.columnAtPoint(p);
				table.setRowSelectionInterval(hoveredRow, hoveredRow);
				table.repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				hoveredRow = hoveredColumn = -1;
				table.repaint();
			}
		});
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
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

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		SalaModel model = new SalaModel();
		List<Sala> lstSala = model.consultaSala(numero, piso, numAlu, recursos, fecIni, fecFin, sede);
		Object[] fila = null;
		for (Sala x : lstSala) {
			fila = new Object[] { x.getIdSala(), x.getNumero(), x.getPiso(), x.getNumAlumnos(), x.getRecursos(),
					getFormatoEstado(x.getestado()), x.getFechaRegistro(), x.getSede() };
			dtm.addRow(fila);
		}
	}

	private String getFormatoEstado(int estado) {
		return estado == 1 ? "Activo" : "Inactivo";
	}
}
