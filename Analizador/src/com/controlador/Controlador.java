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
		
		if (e.getActionCommand().equals("cargar"))
			cargar();
		else if (e.getActionCommand().equals("analizar"))
			analizar();
		else if (e.getActionCommand().equals("salir"))
			System.exit(0);
	}
	
	public void cargar() {
		FileManager lector = new FileManager();
		JTextArea area = vista.getEntrada();
		area.setText(lector.leeArchivo(vista));
	}

	public void analizar() {
		
		//Si no	
		if( !vista.getEntrada().getText().equals("") ){
			
			String programa = vista.getEntrada().getText();
			
			AnalisisLexico lexico = new AnalisisLexico(programa);
			if( lexico.analizar() ){
				vista.setDatosSimbolosSalida( lexico.getTabla() );
				vista.setSalida( lexico.getAnalisis() );
			}else{
				JOptionPane.showMessageDialog(null, "Metodo Por Implementar.  ", 
						"Error!!", JOptionPane.WARNING_MESSAGE);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "No se ha cargado o escrito ningun programa.  ", 
					"Error!!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
