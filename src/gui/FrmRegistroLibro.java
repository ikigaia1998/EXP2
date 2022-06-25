package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Libro;
import model.LibroModel;
import util.Validaciones;

public class FrmRegistroLibro extends JInternalFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTitulo;
	private JTextField txtAnioo;
	private JComboBox<String> cbCategoria;
	private JTextField txtSerie;
	private JComboBox<String> cbPais;
	private JComboBox<String> cbTipo;
	private JButton btnRegistrar;
	
	
	public FrmRegistroLibro() {
		setFrameIcon(new ImageIcon(FrmRegistroLibro.class.getResource("/iconos/Book.gif")));
		getContentPane().setBackground(new Color(126,225,110));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Libro");
		setBounds(100, 100, 472, 392);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Libro");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(114, 32, 204, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Título :");
		
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(79, 89, 74, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Año :");
		
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(79, 124, 61, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categoría :");
		
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(79, 160, 104, 28);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Serie :");
		
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(79, 193, 74, 25);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("País :");
		
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(79, 229, 74, 27);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo :");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(79, 267, 74, 27);
		getContentPane().add(lblNewLabel_7);
		
		txtTitulo = new JTextField();
		txtTitulo.addKeyListener(this);
		txtTitulo.setBounds(234, 93, 146, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAnioo = new JTextField();
		txtAnioo.addKeyListener(this);
		txtAnioo.setBounds(234, 128, 146, 20);
		getContentPane().add(txtAnioo);
		txtAnioo.setColumns(10);

		
		txtSerie = new JTextField();
		txtSerie.addKeyListener(this);
		txtSerie.setBounds(234, 197, 146, 20);
		getContentPane().add(txtSerie);
		txtSerie.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(0,201,255));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(79, 308, 127, 43);
		getContentPane().add(btnRegistrar);
		
		cbCategoria = new JComboBox<String>();
		cbCategoria.addItem("Seleccionar");
		cbCategoria.addItem("Científico");
		cbCategoria.addItem("Cuento");
		cbCategoria.addItem("Drama");
		cbCategoria.addItem("Estrategia");
		cbCategoria.addItem("Fábula");
		cbCategoria.addItem("Leyenda");
		cbCategoria.addItem("Literatura");
		cbCategoria.addItem("Novelas");
		cbCategoria.addItem("Romance");
		cbCategoria.addItem("Poema");
		cbCategoria.setBounds(234, 159, 146, 22);
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
		cbPais.setBounds(234, 233, 146, 22);
		getContentPane().add(cbPais);
		
		cbTipo = new JComboBox<String>();
		cbTipo.addItem("Seleccionar");
		cbTipo.addItem("Digital");
		cbTipo.addItem("FÃ­sico");
		cbTipo.setBounds(234, 271, 146, 22);
		getContentPane().add(cbTipo);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(0,201,255));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiarJButton(e);
			}
		});
		
		btnLimpiar.setBounds(253, 308, 127, 43);
		getContentPane().add(btnLimpiar);
		
	}
	
	private void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String titl = txtTitulo.getText();
		String anioo  =txtAnioo.getText();
		String catg = cbCategoria.getSelectedItem().toString();
		String seri = txtSerie.getText();
		String pais = cbPais.getSelectedItem().toString();
		String tipo = cbTipo.getSelectedItem().toString();
		
		      if(!titl.matches(Validaciones.TEXTO)){
			mensaje("Escriba el titulo del libro");
		}else if(!anioo.matches(Validaciones.ANNO)){
			mensaje("El aï¿½o es yyyy");
		}else if(cbCategoria.getSelectedIndex() == 0){
			mensaje("Elija una opciï¿½n de categoria");
		}else if(!seri.matches(Validaciones.SERIE)){
			mensaje("Escriba el Numero de serie");
		}else if(cbPais.getSelectedIndex() == 0){
			mensaje("Elija una opciï¿½n de Pais");
		}else if(cbTipo.getSelectedIndex() == 0){
			mensaje("Elija una opciï¿½n de Tipo");
		}else {
			Libro obj = new Libro();
			obj.setTitulo(titl);
			obj.setAnio(anioo);
			obj.setSerie(seri);
			obj.setCategoria(catg);
			obj.setPais(pais);
			obj.setTipo(tipo);
			
			LibroModel model = new LibroModel();
			int salida = model.insertarLibroModel(obj);
			System.out.println("=> "+ salida );
			
			if(salida>0) {
				mensaje("'Registro Exitoso'");
			}else {
				mensaje("'Registro Erroneo'");
			}
			getToolkit().beep();
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtSerie) {
			keyTypedTxtSerieJTextField(e);
		}
		if (e.getSource() == txtAnioo) {
			keyTypedTxtAniooJTextField(e);
		}
		if (e.getSource() == txtTitulo) {
			keyTypedTxtTituoJTextField(e);
		}
	}
	

	private void keyTypedTxtTituoJTextField(KeyEvent e) {
		char  tecla;
		tecla=e.getKeyChar();
		if (!Character.isLetter(tecla)&&tecla!=KeyEvent.VK_SPACE&&tecla!=KeyEvent.VK_BACK_SPACE) {
			
			e.consume();
			getToolkit().beep();
		}
		
	}

	protected void keyTypedTxtAniooJTextField(KeyEvent e) {
		if(!Character.isDigit(e.getKeyChar())) {
			e.consume();
			getToolkit().beep();
		}
		String anioo =txtAnioo.getText() + e.getKeyChar();
		if (anioo.length()>4) {
			e.consume();
			getToolkit().beep();
			}
	}
	
	protected void keyTypedTxtSerieJTextField(KeyEvent e) {
		if(!Character.isDigit(e.getKeyChar())) {
			e.consume();
			getToolkit().beep();
		}
		String seri = txtSerie.getText() + e.getKeyChar();
		if (seri.length()>5) {
			e.consume();
			getToolkit().beep();
		}
	}

	protected void actionPerformedBtnLimpiarJButton(ActionEvent e) {
		LimpiarDatos();
	}
		private void LimpiarDatos() {
			 txtTitulo.setText("");
			 txtAnioo.setText("");
			 cbCategoria.setSelectedIndex(0);
			 txtSerie.setText("");
			 cbPais.setSelectedIndex(0);
			 cbTipo.setSelectedIndex(0);
		}
	
}

