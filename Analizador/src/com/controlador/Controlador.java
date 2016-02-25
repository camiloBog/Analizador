package com.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.controlador.lexico.AnalisisLexico;
import com.modelo.FileManager;
import com.vista.Vista;

public class Controlador implements ActionListener {
	
	Vista vista;

	public Controlador(Vista vista) {
		this.vista = vista;
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getActionCommand().equals("cargar")){
			cargar();
		}else if (e.getActionCommand().equals("analizar")){
			analizar();
		}else if (e.getActionCommand().equals("salir")){
			System.exit(0);
		}
	}
	
	public void cargar(){
		FileManager lector = new FileManager();
		JTextArea area = vista.getEntrada();
		area.setText(lector.leeArchivo(vista));
	}
	
	public void analizar(){
		
		AnalisisLexico lexico = new AnalisisLexico();
		if( lexico.analiza( vista.getEntrada().getText() ) ){
			vista.setDatosSimbolosSalida( lexico.getTable() );
			vista.setSalida( lexico.getAnalisis() );
		}else{
			JOptionPane.showMessageDialog(null, "Metodo Por Implementar.  ", 
					"Error!!", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
}
