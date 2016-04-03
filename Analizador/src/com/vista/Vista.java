package com.vista;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JLabel labelIni;
	private JLabel labelFin;
	private JScrollPane scrollEntrada;
	private JScrollPane scrollSalida;
	private JButton botonCargar;
	private JButton botonAnalizar;
	private JButton botonCerrar;
	private JButton botonExportar;
	private JButton botonReset;
	private JButton botonCargarSintaxis;
	private JButton botonAnalizarSintaxis;
	
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
	
	private JTable tablaSintaxisEntrada;
	private JScrollPane scrollPaneSintaxisEntrada;
	private Object[][] datosSimbolosSintaxisEntrada;
	
	private JTable tablaSintaxisSalida;
	private JScrollPane scrollPaneSintaxisSalida;
	private Object[][] datosSimbolosSintaxisSalida;

	private int ancho = 1250;
	private int alto = 600;

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
		this.fileChooser = new JFileChooser();
		this.scrollEntrada = new JScrollPane();
		this.control = new Controlador(this);
		this.salida = new JTextArea();
		this.scrollSalida = new JScrollPane();
		this.labelIni = new JLabel();
		this.labelFin = new JLabel();
		this.botonCerrar = new JButton();
		this.botonExportar = new JButton();
		this.botonReset = new JButton();
		this.botonCargar = new JButton();
		this.botonAnalizar = new JButton();
		this.token = new Token();
		this.tituloSimbolos = token.getTitle();
		this.datosSimbolosEntrada = token.getTable();
		this.tablaSimbolosEntrada = new JTable(datosSimbolosEntrada, tituloSimbolos);
		this.scrollPaneEntrada = new JScrollPane(tablaSimbolosEntrada);
		this.tablaSimbolosSalida = new JTable();
		this.scrollPaneSalida = new JScrollPane(tablaSimbolosSalida);
		this.border = this.entrada.getBorder();
		this.botonCargarSintaxis = new JButton();  
		this.botonAnalizarSintaxis = new JButton();
		this.tablaSintaxisEntrada = new JTable();
		this.scrollPaneSintaxisEntrada = new JScrollPane(tablaSintaxisEntrada);
		//this.datosSimbolosSintaxisEntrada = new ;
		this.tablaSintaxisSalida = new JTable();
		this.scrollPaneSintaxisSalida = new JScrollPane(tablaSintaxisSalida);
		//this.datosSimbolosSintaxisSalida = new ;
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
		this.contenedor.add(labelIni);
		this.contenedor.add(labelFin);
		this.contenedor.add(botonCargarSintaxis);
		this.contenedor.add(botonAnalizarSintaxis);
		this.contenedor.add(scrollPaneSintaxisEntrada);
		this.contenedor.add(scrollPaneSintaxisSalida);
	}

	private void configObjetos() {

		this.setTitle("ANALIZADOR LEXICO");
		this.setSize(ancho, alto);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.labelIni.setText("Tabla de Simbolos (Inicial)");
		this.labelIni.setBounds(20, 190, 370, 200);
		
		this.labelFin.setText("Tabla de Simbolos (Final)");
		this.labelFin.setBounds(430, 190, 370, 200);
		
		this.botonCargar.setText("Cargar programa");
		this.botonCargar.setBounds(20, 26, 200, 23);
		this.botonCargar.setActionCommand("cargar");
				
		this.botonAnalizar.setText("Analizar programa");
		this.botonAnalizar.setBounds(20, 250, 200, 23);
		this.botonAnalizar.setActionCommand("analizar");
		
		this.botonCerrar.setText("Salir");
		this.botonCerrar.setBounds(1000, 500, 200, 23);
		this.botonCerrar.setActionCommand("salir");
		
		this.botonExportar.setText("Exportar Programa");
		this.botonExportar.setBounds(600, 26, 200, 23);
		this.botonExportar.setActionCommand("exportar");
		
		this.botonReset.setText("Reset Analizador");
		this.botonReset.setBounds(600, 250, 200, 23);
		this.botonReset.setActionCommand("reset");
		
		this.botonCargarSintaxis.setText("Cargar Sintaxis");
		this.botonCargarSintaxis.setBounds(1000, 26, 200, 23);
		this.botonCargarSintaxis.setActionCommand("cargarSintaxis");
		
		this.botonAnalizarSintaxis.setText("Analizar Sintaxis");
		this.botonAnalizarSintaxis.setBounds(1000, 250, 200, 23);
		this.botonAnalizarSintaxis.setActionCommand("analizaSintaxis");
		
		this.botonCargar.setEnabled(true);
		this.botonAnalizar.setEnabled(false);
		this.botonCerrar.setEnabled(true);
		this.botonExportar.setEnabled(false);
		this.botonReset.setEnabled(false);
		
		this.botonCargarSintaxis.setEnabled(true);
		this.botonAnalizarSintaxis.setEnabled(true);
		
		this.entrada.setLineWrap(true);
		this.entrada.setWrapStyleWord(true);
		this.entrada.setEditable(false);
		this.entrada.setOpaque(false);
		
		this.salida.setLineWrap(true);
		this.salida.setWrapStyleWord(true);
		this.salida.setEditable(false);
		
		this.scrollEntrada.setBounds(20, 50, 370, 200);
		this.scrollEntrada.setViewportView(entrada);
		
		this.scrollSalida.setBounds(430, 50, 370, 200);
		this.scrollSalida.setViewportView(salida);
		
		this.scrollEntrada.setBounds(20, 50, 370, 200);
		this.scrollEntrada.setViewportView(entrada);
		
		this.scrollPaneEntrada.setBounds(20, 300, 370, 200);
		this.scrollPaneEntrada.setEnabled(false);
		this.scrollPaneEntrada.setBorder(border);
		this.configScrollPaneSalida();
		this.configScrollPaneEntradaSintaxis();
		this.configScrollPaneSalidaSintaxis();
		
		this.tablaSimbolosEntrada.setEnabled(false);
		this.tablaSimbolosSalida.setEnabled(false);
		
		this.contenedor.setBackground(new Color(218,225,255));
		
	}
	
	private void configScrollPaneSalida(){
		this.scrollPaneSalida.setBounds(430, 300, 370, 200);
		this.scrollPaneSalida.setEnabled(false);
		this.scrollPaneSalida.setBorder(border);
	}
	
	private void configScrollPaneEntradaSintaxis(){
		this.scrollPaneSintaxisEntrada.setBounds(830, 50, 370, 200);
		this.scrollPaneSintaxisEntrada.setEnabled(false);
		this.scrollPaneSintaxisEntrada.setBorder(border);
	}
	
	private void configScrollPaneSalidaSintaxis(){
		this.scrollPaneSintaxisSalida.setBounds(830, 300, 370, 200);
		this.scrollPaneSintaxisSalida.setEnabled(false);
		this.scrollPaneSintaxisSalida.setBorder(border);
	}
	
	private void registrarOyentes() {
		this.botonCargar.addActionListener(control);
		this.botonAnalizar.addActionListener(control);
		this.botonCerrar.addActionListener(control);
		this.botonExportar.addActionListener(control);
		this.botonReset.addActionListener(control);
		this.botonCargarSintaxis.addActionListener(control);
		this.botonAnalizarSintaxis.addActionListener(control);
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
	
	public void setDatosSintaxisEntrada(Object[][] datos, String[] titulos) {
		this.contenedor.remove(tablaSintaxisEntrada);
		this.contenedor.remove(scrollPaneSintaxisEntrada);
		this.tablaSintaxisEntrada = new JTable(datos, titulos);
		this.scrollPaneSintaxisEntrada = new JScrollPane(tablaSintaxisEntrada);
		this.contenedor.add(scrollPaneSintaxisEntrada);
		this.configScrollPaneEntradaSintaxis();
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