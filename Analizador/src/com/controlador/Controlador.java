package com.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.controlador.lexico.AnalisisLexico;
import com.controlador.sintactico.AnalisisSintactico;
import com.modelo.FileManager;
import com.vista.Vista;

public class Controlador implements ActionListener {
	
	private Vista vista;

	public Controlador(Vista vista) {
		this.vista = vista;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("cargar")) {
			this.cargar();
		} else if (e.getActionCommand().equals("analizar")) {
			this.analizar();
		} else if (e.getActionCommand().equals("exportar")) {
			this.exportar();
		} else if (e.getActionCommand().equals("reset")) {
			this.vista.dispose();
			this.vista = new Vista();
		} else if (e.getActionCommand().equals("cargarSintaxis")) {
			this.cargaSintaxis();
		} else if (e.getActionCommand().equals("analizaSintaxis")) {
			this.analizar();
			//this.analizaSintaxis1();
			this.analizaSintaxis2();
		} else if (e.getActionCommand().equals("salir")) {
			System.exit(0);
		}
	}

	private void bloquearBotones(boolean cargar, boolean analizar, 
			boolean exportar, boolean reset, boolean cargarSintaxis, 
			boolean analisarSintaxis ){
		this.vista.getBotonCargar().setEnabled(cargar);
		this.vista.getBotonAnalizar().setEnabled(analizar);
		this.vista.getBotonExportar().setEnabled(exportar);
		this.vista.getBotonReset().setEnabled(reset);
		this.vista.getBotonCargarSintaxis().setEnabled(cargarSintaxis);
		this.vista.getBotonAnalizarSintaxis().setEnabled(analisarSintaxis);
	}
	
	private void cargar(){
		FileManager lector = new FileManager();
		JTextArea area = vista.getEntrada();
		area.setText(lector.leeArchivo(vista));
		bloquearBotones(false, true, false, true, true, false);
	}
	
	private void exportar(){
		FileManager escritor = new FileManager();
		escritor.escribeArchivo(vista, vista.getSalida().getText());
	}
	
	private void analizar() {

		AnalisisLexico lexico = new AnalisisLexico();
		if (lexico.analiza(vista.getEntrada().getText())) {
			vista.setSalida(lexico.getAnalisis());
			vista.setListaSeparada(lexico.getListaSeparada());
			
			//Object[][] tabla1 = vista.getDatosSimbolosEntrada();
			Object[][] tabla2 = lexico.getTable();
			//vista.setDatosSimbolosSalida( juntarTablas(tabla1,tabla2) );
			vista.setDatosSimbolosSalida( tabla2 );

		} else {
			JOptionPane.showMessageDialog(null,
					"No fue posible analizar el archivo.", "Error!!",
					JOptionPane.WARNING_MESSAGE);
			bloquearBotones(false, true, false, true, true, false);
		}
		
		bloquearBotones(false, false, true, true, true, false);

	}
	/*
	private Object[][] juntarTablas(Object[][] tabla1, Object[][] tabla2){

		Object[][] objeto = new Object[tabla1.length + tabla2.length][3];

		for (int i = 0; i < tabla1.length; i++)
			objeto[i] = tabla1[i];
		
		for (int i = tabla1.length; i < (tabla1.length+tabla2.length); i++)
			objeto[i] = tabla2[i-tabla1.length];
		
		return objeto;
	}
	*/

	private void cargaSintaxis() {
		
		FileManager lector = new FileManager();
		this.vista.setDatosSintaxisEntrada(lector.CargarSintaxis(vista), lector.getNomcolumnas());
		this.vista.setGramatica(lector.getGramatica());
		
		bloquearBotones(false, false, false, true, false, true);
	}
	
	private void analizaSintaxis1() {

		AnalisisSintactico aSintactico = new AnalisisSintactico(
				vista.getListaSeparada(),
				vista.getGramatica());

		Object[][] salida = aSintactico.getSalida();
		String[] titulos = { "Pila", "ae", "X", "a", "M[X,a]", "X->Y1,Y2..YK","Salida", "Entrada" };
		vista.setDatosSintaxisSalida(salida, titulos);
		
	}
	
	private void analizaSintaxis2() {

		AnalisisSintactico aSintactico = new AnalisisSintactico(
				vista.getListaSeparada(), vista.getGramatica());

		Object[][] salida = aSintactico.getTablaSalida();
		String[] titulos = { "Pila", "Entrada", "Salida" };

		vista.setDatosSintaxisSalida(salida, titulos);
		bloquearBotones(false, false, false, true, false, false);
	}
	
	/*
	private String quitarSecuenciaDeEscape(String texto){
		
		texto = texto.replaceAll("\t", "");
		texto = texto.replaceAll("\n", "");
		texto = texto.replaceAll("\r", "");
		texto = texto.replaceAll("\f", "");
		texto = texto.replaceAll("\b", "");
		
		return texto;
	}
	*/
		
}
