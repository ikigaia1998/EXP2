package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Libro;
import model.LibroModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmConsultaLibro extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextField txtTitulo;
	private JTextField txtAnioInicio;
	private JTextField txtAnioFin;
	private JTextField txtSerie;
	private JComboBox<String> cbPais;
	private JComboBox<String> cbTipo;
	private JComboBox<String> cbCategoria;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_4;
	private JButton btnFiltro;
	private JButton btnLimpiar;
	
	

	public FrmConsultaLibro() {
		setFrameIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Book.gif")));
		getContentPane().setBackground(new Color(250, 235, 215));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Libro");
		setBounds(100, 100, 910, 629);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Consulta de Libro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(334, 32, 218, 27);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("T\u00EDtulo :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Notes.gif")));
		lblNewLabel_1.setBounds(74, 86, 75, 22);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Anio de Inicio :");
		lblNewLabel_2.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Add.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(74, 127, 121, 26);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Categor\u00EDa :");
		lblNewLabel_3.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Bar chart.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(74, 218, 97, 22);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_7 = new JLabel("Serie :");
		lblNewLabel_7.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Numbered list.gif")));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(479, 86, 72, 31);
		getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_5 = new JLabel("Pa\u00EDs :");
		lblNewLabel_5.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(479, 129, 81, 22);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Tipo :");
		lblNewLabel_6.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Notes.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(479, 175, 104, 24);
		getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_4 = new JLabel("Anio de Fin :");
		lblNewLabel_4.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Add.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(74, 174, 111, 26);
		getContentPane().add(lblNewLabel_4);
		
		cbCategoria = new JComboBox<String>();
		cbCategoria.addItem("Seleccionar");
		cbCategoria.addItem("Científico");
		cbCategoria.addItem("Cuento");
		cbCategoria.addItem("Drama");
		cbCategoria.addItem("Estrategia");
		cbCategoria.addItem("Fúbula");
		cbCategoria.addItem("Leyenda");
		cbCategoria.addItem("Literatura");
		cbCategoria.addItem("Novelas");
		cbCategoria.addItem("Romance");
		cbCategoria.addItem("Poema");
		cbCategoria.setBounds(243, 221, 191, 20);
		getContentPane().add(cbCategoria);
		
		cbPais = new JComboBox<String>();
		cbPais.addItem("Seleccionar");
		cbPais.addItem("Argentina");
		cbPais.addItem("Bolivia");
		cbPais.addItem("Brasil");
		cbPais.addItem("Chile");
		cbPais.addItem("Colombia");
		cbPais.addItem("Ecuador");
		cbPais.addItem("E.E.U.U.");
		cbPais.addItem("México");
		cbPais.addItem("Perú");
		cbPais.setBounds(620, 130, 191, 22);
		getContentPane().add(cbPais);
		
		cbTipo = new JComboBox<String>();
		cbTipo.addItem("Seleccionar");
		cbTipo.addItem("Digital");
		cbTipo.addItem("Físico");
		cbTipo.setBounds(620, 177, 191, 22);
		getContentPane().add(cbTipo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(243, 88, 191, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAnioFin = new JTextField();
		txtAnioFin.setBounds(243, 179, 189, 20);
		getContentPane().add(txtAnioFin);
		txtAnioFin.setColumns(10);
		
		txtAnioInicio = new JTextField();
		txtAnioInicio.setBounds(243, 132, 191, 20);
		getContentPane().add(txtAnioInicio);
		txtAnioInicio.setColumns(10);		
		
		txtSerie = new JTextField();
		txtSerie.setBounds(620, 90, 191, 20);
		getContentPane().add(txtSerie);
		txtSerie.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 275, 874, 313);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Código","Título","A\u00F1o","Categoría","Serie","País","Tipo"
			}
		));
		
		scrollPane.setViewportView(table);
		
		btnFiltro = new JButton("Filtro ");
		btnFiltro.addActionListener(this);
		btnFiltro.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Search.gif")));
		btnFiltro.setBounds(479, 218, 114, 34);
		getContentPane().add(btnFiltro);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/limpieza-de-datos.png")));
		btnLimpiar.setBounds(691, 218, 114, 34);
		getContentPane().add(btnLimpiar);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnFiltro) {
			do_btnFiltro_actionPerformed(e);
		}
	}
	protected void do_btnFiltro_actionPerformed(ActionEvent e) {
		String titulo = txtTitulo.getText();
		String desde = txtAnioInicio.getText();
		String hasta = txtAnioFin.getText();
		
		String categoria = "";
		if(cbCategoria.getSelectedIndex()>0) {
			categoria = cbCategoria.getSelectedItem().toString();	
		}
		String serie = txtSerie.getText();
		
		String pais = "";
		if(cbPais.getSelectedIndex()>0) {
			pais = cbPais.getSelectedItem().toString();	
		}
		String tipo = "";
		if(cbTipo.getSelectedIndex()>0) {
			tipo = cbTipo.getSelectedItem().toString();	
		}
		
		LibroModel model = new LibroModel();
		List<Libro> lstLibro = model.consultaPorTiAnioCateSeriPaTip(titulo,desde,hasta,categoria,serie,pais,tipo);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for (Libro x : lstLibro) {
			fila = new Object[] {x.getIdLibro(), x.getTitulo(), x.getAnio(), x.getCategoria(), x.getSerie(), x.getPais(), x.getTipo()};
			dtm.addRow(fila);
		}
	}
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		LimpiarDatos();
	}
		private void LimpiarDatos(){
			 txtTitulo.setText("");
			 txtAnioInicio.setText("");
			 txtAnioFin.setText("");
			 cbCategoria.setSelectedIndex(0);
			 txtSerie.setText("");
			 cbPais.setSelectedIndex(0);
			 cbTipo.setSelectedIndex(0);
	}
}