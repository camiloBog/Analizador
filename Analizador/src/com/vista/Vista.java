package com.vista;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.controlador.Controlador;
import com.modelo.Token;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;

	private Controlador control;
	
	private Container contenedor;
	private JTextArea entrada;
	private JTextArea salida;
	private JScrollPane scrollEntrada;
	private JScrollPane scrollSalida;
	private JButton botonCargar;
	private JButton botonAnalizar;
	private JButton botonCerrar;
	private JButton botonExportar;
	private JButton botonReset;
	
	private JFileChooser fileChooser;
	private Border border;
 	
	private Token token;
	private JTable tablaSimbolosEntrada;
	private JScrollPane scrollPaneEntrada;
	private String[] tituloSimbolos;
	private Object[][] datosSimbolosEntrada;
	
	private JTable tablaSimbolosSalida;
	private JScrollPane scrollPaneSalida;
	private Object[][] datosSimbolosSalida;

	private int x = 790;
	private int y = 600;

	public Vista() {
		crearVista();
	}

	private void crearVista() {
		setLookAndFeel();
		crearObjetos();
		adicionaObjetos();
		configObjetos();
		registrarOyentes();
	}
	
	private void setLookAndFeel() {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void crearObjetos() {
		this.contenedor = new Container();
		this.contenedor = getContentPane();
		this.contenedor.setLayout(null);
		this.entrada = new JTextArea();
		this.botonCargar = new JButton();
		this.botonAnalizar = new JButton();
		this.fileChooser = new JFileChooser();
		this.scrollEntrada = new JScrollPane();
		this.control = new Controlador(this);
		this.salida = new JTextArea();
		this.scrollSalida = new JScrollPane();
		this.botonCerrar = new JButton();
		this.botonExportar = new JButton();
		this.botonReset = new JButton();
		this.token = new Token();
		this.tituloSimbolos = token.getTitle();
		this.datosSimbolosEntrada = token.getTable();
		this.tablaSimbolosEntrada = new JTable(datosSimbolosEntrada, tituloSimbolos);
		this.scrollPaneEntrada = new JScrollPane(tablaSimbolosEntrada);
		this.tablaSimbolosSalida = new JTable();
		this.scrollPaneSalida = new JScrollPane(tablaSimbolosSalida);
		this.border = this.entrada.getBorder();
	}

	private void adicionaObjetos() {
		this.contenedor.add(fileChooser);
		this.contenedor.add(entrada);
		this.contenedor.add(salida);
		this.contenedor.add(scrollEntrada);
		this.contenedor.add(scrollSalida);
		this.contenedor.add(scrollPaneEntrada);
		this.contenedor.add(scrollPaneSalida);
		this.contenedor.add(botonCargar);
		this.contenedor.add(botonAnalizar);
		this.contenedor.add(botonCerrar);
		this.contenedor.add(botonExportar);
		this.contenedor.add(botonReset);
	}

	private void configObjetos() {

		this.setTitle("ANALIZADOR LEXICO");
		this.setSize(x, y);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.botonCargar.setText("Cargar programa");
		this.botonCargar.setBounds(20, 26, 200, 23);
		this.botonCargar.setActionCommand("cargar");
				
		this.botonAnalizar.setText("Analizar programa");
		this.botonAnalizar.setBounds(20, 250, 200, 23);
		this.botonAnalizar.setActionCommand("analizar");
		
		this.botonCerrar.setText("Salir");
		this.botonCerrar.setBounds(550, 500, 200, 23);
		this.botonCerrar.setActionCommand("salir");
		
		this.botonExportar.setText("Exportar Programa");
		this.botonExportar.setBounds(550, 26, 200, 23);
		this.botonExportar.setActionCommand("exportar");
		
		this.botonReset.setText("Reset Analizador");
		this.botonReset.setBounds(550, 250, 200, 23);
		this.botonReset.setActionCommand("reset");
		
		this.botonCargar.setEnabled(true);
		this.botonAnalizar.setEnabled(false);
		this.botonCerrar.setEnabled(true);
		this.botonExportar.setEnabled(false);
		this.botonReset.setEnabled(false);
		
		this.entrada.setLineWrap(true);
		this.entrada.setWrapStyleWord(true);
		this.entrada.setEditable(false);
		this.entrada.setOpaque(false);
		
		this.salida.setLineWrap(true);
		this.salida.setWrapStyleWord(true);
		this.salida.setEditable(false);
		//this.salida.setEnabled(false);
		//this.salida.setOpaque(false);
		
		this.scrollEntrada.setBounds(20, 50, 350, 200);
		this.scrollEntrada.setViewportView(entrada);
		
		this.scrollSalida.setBounds(400, 50, 350, 200);
		this.scrollSalida.setViewportView(salida);
		
		this.scrollPaneEntrada.setBounds(20, 300, 350, 200);
		this.scrollPaneEntrada.setEnabled(false);
		this.scrollPaneEntrada.setBorder(border);
		this.configScrollPaneSalida();
		
		this.tablaSimbolosEntrada.setEnabled(false);
		this.tablaSimbolosSalida.setEnabled(false);
		
		this.contenedor.setBackground(new Color(218,225,255));
		
	}
	
	private void configScrollPaneSalida(){
		this.scrollPaneSalida.setBounds(400, 300, 350, 200);
		this.scrollPaneSalida.setEnabled(false);
		this.scrollPaneSalida.setBorder(border);
	}

	private void registrarOyentes() {
		this.botonCargar.addActionListener(control);
		this.botonAnalizar.addActionListener(control);
		this.botonCerrar.addActionListener(control);
		this.botonExportar.addActionListener(control);
		this.botonReset.addActionListener(control);
	}
	
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	
	public JTextArea getEntrada() {
		return entrada;
	}

	public void setEntrada(JTextArea entrada) {
		this.entrada = entrada;
	}

	public Object[][] getDatosSimbolosSalida() {
		return datosSimbolosSalida;
	}
	
	public JTextArea getSalida() {
		return salida;
	}
	
	public void setSalida(String analisis) {
		this.salida.setText(analisis);
	}
	
	public Object[][] getDatosSimbolosEntrada() {
		return datosSimbolosEntrada;
	}

	public void setDatosSimbolosEntrada(Object[][] datosSimbolosEntrada) {
		this.datosSimbolosEntrada = datosSimbolosEntrada;
	}
	
	public void setDatosSimbolosSalida(Object[][] datosSimbolosSalida) {
		this.contenedor.remove(tablaSimbolosSalida);
		this.contenedor.remove(scrollPaneSalida);
		this.tablaSimbolosSalida = new JTable(datosSimbolosSalida, tituloSimbolos);
		this.scrollPaneSalida = new JScrollPane(tablaSimbolosSalida);
		this.contenedor.add(scrollPaneSalida);
		this.configScrollPaneSalida();
	}

	public JButton getBotonCargar() {
		return botonCargar;
	}

	public void setBotonCargar(JButton botonCargar) {
		this.botonCargar = botonCargar;
	}

	public JButton getBotonAnalizar() {
		return botonAnalizar;
	}

	public void setBotonAnalizar(JButton botonAnalizar) {
		this.botonAnalizar = botonAnalizar;
	}

	public JButton getBotonCerrar() {
		return botonCerrar;
	}

	public void setBotonCerrar(JButton botonCerrar) {
		this.botonCerrar = botonCerrar;
	}

	public JButton getBotonExportar() {
		return botonExportar;
	}

	public void setBotonExportar(JButton botonExportar) {
		this.botonExportar = botonExportar;
	}

	public JButton getBotonReset() {
		return botonReset;
	}

	public void setBotonReset(JButton botonReset) {
		this.botonReset = botonReset;
	}

}