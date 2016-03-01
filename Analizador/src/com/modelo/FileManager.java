package com.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.vista.Vista;

public class FileManager {

	public void escribeArchivo(Vista vista, String salida) {

		JFileChooser fileChooser = vista.getFileChooser();
		fileChooser.showSaveDialog(vista);

		File file = null;
		FileWriter fileWriter = null;

		try {
			file = fileChooser.getSelectedFile();

			if (null != file) {

				fileWriter = new FileWriter(file + ".txt");
				fileWriter.write(salida);

				JOptionPane.showMessageDialog(null,
						"El archivo se a guardado Exitosamente", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo.",
					"Error!!", JOptionPane.WARNING_MESSAGE);
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public String leeArchivo(Vista vista){
		
		String texto = "";
		String aux = "";
		
		JFileChooser fileChooser = vista.getFileChooser();
		fileChooser.showOpenDialog(vista);
		
		File file = fileChooser.getSelectedFile();
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			
			if (file != null) {
				
				fileReader = new FileReader(file);
				buffer = new BufferedReader(fileReader);
				
				while ((aux = buffer.readLine()) != null)
					texto += aux + "\r\n";
								
			}else{
				JOptionPane.showMessageDialog(null, "No se encontro el archivo.", "Error!!", JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo.", "Error!!", JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al leer el archivo.", "Error!!", JOptionPane.WARNING_MESSAGE);
		}finally{
			
			try {
				buffer.close();
				fileReader.close();
			} catch (IOException e) {
			}
		}
		
		return texto;
		
	}
	
}