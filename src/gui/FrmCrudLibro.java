package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;

import entidad.Libro;
import model.LibroModel;

import util.Validaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;


public class FrmCrudLibro extends JInternalFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbCategoria;
	private JTextField txtSerie;
	private JComboBox<String> cbPais;
	private JComboBox<String> cbTipo;
	private JButton btnActualizar;
	private JTextField txtTitulo;
	private JTextField txtAnioo;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	
	int idSeleccionado = -1;
	
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel;
	
	public  FrmCrudLibro() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(new Color(225,110,110));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setTitle("Mantenimiento de Libro");
		setBounds(100, 100, 900, 714);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Mantenimiento de Libro");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(220, 24, 349, 34);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("T\u00EDtulo :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblNewLabel_1.setBounds(112, 85, 75, 22);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("A\u00F1o :");
		
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(112, 124, 75, 26);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Categor\u00EDa :");
		
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(112, 173, 97, 22);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_7 = new JLabel("Serie :");
		
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(431, 83, 72, 31);
		getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_5 = new JLabel("Pa\u00EDs :");
		
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(431, 126, 81, 22);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Tipo :");
		
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(431, 172, 104, 24);
		getContentPane().add(lblNewLabel_6);
		
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
		cbCategoria.setBounds(220, 174, 153, 22);
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
		cbPais.setBounds(601, 128, 153, 22);
		getContentPane().add(cbPais);
		
		cbTipo = new JComboBox<String>();
		cbTipo.addItem("Seleccionar");
		cbTipo.addItem("Digital");
		cbTipo.addItem("Físico");
		cbTipo.setBounds(601, 175, 153, 22);
		getContentPane().add(cbTipo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(220, 87, 153, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAnioo = new JTextField();
		txtAnioo.setBounds(220, 128, 153, 20);
		getContentPane().add(txtAnioo);
		txtAnioo.setColumns(10);
		
		
		txtSerie = new JTextField();
		txtSerie.setBounds(601, 88, 153, 20);
		getContentPane().add(txtSerie);
		txtSerie.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(92,105,205));
		btnRegistrar.addActionListener(this);
		
		btnRegistrar.setBounds(156, 234, 114, 34);
		getContentPane().add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(92,105,205));
		btnEliminar.addActionListener(this);
		
		btnEliminar.setBounds(368, 234, 114, 34);
		getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(92,105,205));
		btnActualizar.addActionListener(this);
		
		btnActualizar.setBounds(585, 234, 114, 34);
		getContentPane().add(btnActualizar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 290, 864, 374);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(213,93,144));
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C�digo","T�tulo","A�o","Categor�a","Serie","Pa�s","Tipo"
			}
		));

		
		
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);	
		table.setSelectionBackground(new Color(255,228,225));
	    table.setDefaultEditor(Object.class, null);
	    
	    
		lista();
	}
		
	
	private void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
		
	}
	
	 void limpiarCajasTexto() {
		 txtTitulo.setText("");
		 txtAnioo.setText("");
		 cbCategoria.setSelectedIndex(0);
		 txtSerie.setText("");
		 cbPais.setSelectedIndex(0);
		 cbTipo.setSelectedIndex(0);
		 txtTitulo.requestFocus();
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			handle_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			handle_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			handle_btnRegistrar_actionPerformed(e);
		}
		

	}
	protected void handle_btnRegistrar_actionPerformed(ActionEvent e) {
		inserta();
	}
	protected void handle_btnEliminar_actionPerformed(ActionEvent e) {
		elimina();
	}
	protected void handle_btnActualizar_actionPerformed(ActionEvent e) {
		actualiza();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			handle_table_mouseClicked(e);
		}		
	}
	public void mousePressed(MouseEvent e) {	
	}
	public void mouseReleased(MouseEvent e) {	
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {	
	}
	protected void handle_table_mouseClicked(MouseEvent e) {
		busca();	
	}
	private void lista() {
		LibroModel model = new LibroModel();
		List<Libro> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for (Libro x : lista) {
			fila = new Object[]{ x.getIdLibro(), x.getTitulo(), x.getAnio(), x.getCategoria(), x.getSerie(), x.getPais(), x.getTipo()};
			dtm.addRow(fila);
		}
	}
	
	private void inserta() {
		String titu  = txtTitulo.getText();
		String anio  = txtAnioo.getText();
		String cate  = cbCategoria.getSelectedItem().toString();
		String serie = txtSerie.getText();	
		String pais  = cbPais.getSelectedItem().toString();
		String tipo  = cbTipo.getSelectedItem().toString();
		
		if (!titu.matches(Validaciones.TEXTO)) {
			mensaje("El Nombre es de 3 a 20 Caracteres");
		}else if (!anio.matches(Validaciones.ANNO)) {
			mensaje("El Año es yyyy");
		}else if (cbCategoria.getSelectedIndex() == 0){
			mensaje("Elija una opción de categoría");
		}else if(!serie.matches(Validaciones.SERIE)){
			mensaje("Escriba solo 1 Número de Serie");
		}else if(cbPais.getSelectedIndex() == 0){
			mensaje("Elija una Opción de País");
		}else if(cbTipo.getSelectedIndex() == 0){
			mensaje("Elija una Opción de Tipo");  
		}else {
			Libro obj = new Libro();
			obj.setTitulo(titu);
			obj.setAnio(anio);
			obj.setCategoria(cate);			
			obj.setSerie(serie);
			obj.setPais(pais);
			obj.setTipo(tipo);
			
			LibroModel model = new LibroModel();
			int salida = model.insertarLibroModel(obj);
			
			if (salida > 0) {
				idSeleccionado = -1;
				lista();
				limpiarCajasTexto();
				mensaje("Se insert� correctamente");
			}else {
				mensaje("Error en el Registro");
			}
		}
	}
	

	private void busca() {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String titu    = (String) table.getValueAt(fila, 1);
		String anio    = (String) table.getValueAt(fila, 2);
		String cate	   = (String) table.getValueAt(fila, 3);
		String seri    = (String) table.getValueAt(fila, 4);
		String pais	   = (String) table.getValueAt(fila, 5);
		String tipo    = (String) table.getValueAt(fila, 6);
		
		
		System.out.println(idSeleccionado + " - " +  titu + " - " + anio + " - " + cate + " - "+ seri  + " - "+ pais + " - " + tipo);
		
		txtTitulo.setText(titu);
		txtAnioo.setText(String.valueOf(anio));
		cbCategoria.setSelectedItem(cate);
		txtSerie.setText(seri);
		cbPais.setSelectedItem(pais);
		cbTipo.setSelectedItem(tipo);
	}
	
	private void actualiza() {
		String titu  = txtTitulo.getText();
		String anio  = txtAnioo.getText();
		String cate  = cbCategoria.getSelectedItem().toString();
		String serie = txtSerie.getText();	
		String pais  = cbPais.getSelectedItem().toString();
		String tipo  = cbTipo.getSelectedItem().toString();
		
		if (idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else if (!titu.matches(Validaciones.TEXTO)) {
			mensaje("El Nombre es de 3 a 20 Caracteres");
		}else if (!anio.matches(Validaciones.ANNO)) {
			mensaje("El Año es yyyy");
		}else if (cbCategoria.getSelectedIndex() == 0){
			mensaje("Elija una opción de categoría");
		}else if(!serie.matches(Validaciones.SERIE)){
			mensaje("Escriba solo 5 Número de Serie");
		}else if(cbPais.getSelectedIndex() == 0){
			mensaje("Elija una Opción de País");
		}else if(cbTipo.getSelectedIndex() == 0){
			mensaje("Elija una Opción de Tipo");  
		}else {
			Libro obj = new Libro();
			obj.setIdLibro(idSeleccionado);
			obj.setTitulo(titu);
			obj.setAnio(anio);
			obj.setCategoria(cate);
			obj.setSerie(serie);
			obj.setPais(pais);
			obj.setTipo(tipo);
			
			LibroModel model = new LibroModel();
			int Actualiza = model.actualizaLibro(obj);
			
			if (Actualiza > 0) {
				idSeleccionado = -1;
				lista();
				limpiarCajasTexto();
				mensaje("Se actualizó correctamente");
			}else {
				mensaje("Error en la Actualización");
			}
		}
		
	}
	
	private void elimina() {
		if (idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else {
			LibroModel model = new LibroModel();
			int salida = model.eliminaLibro(idSeleccionado);
			if (salida > 0) {
				lista();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se elimin� correctamente");
			}else {
				mensaje("Error en la eliminaci�n");
			}
		}
	}
	
	
}
