package com.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.vista.Vista;

public class FileManager {
	
	private String [] nomcolumnas;
	private String [][] gramatica;

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
						"Se guardo exitosamente el archivo.", "Informaci�n",
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
	
	public Object[][] CargarSintaxis(Vista vista) {
		
		Workbook libro = CargarArchivo(vista);
		
		if(null!=libro)
			return procesaArchivo(libro);
		else
			return null;
		
	}
	
	private Workbook CargarArchivo(Vista vista) {
		
		Workbook libro;

		JFileChooser fileChooser = vista.getFileChooser();
		
		fileChooser.showOpenDialog(vista);
		File abre = fileChooser.getSelectedFile();
		
		if (abre != null) {
			try {
				
				libro = Workbook.getWorkbook(fileChooser.getSelectedFile());
				return libro;
				
			} catch (BiffException e) {
				JOptionPane.showMessageDialog(null, "Error al leer el archivo cargado./n"+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al leer el archivo cargado./n"+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
				return null;
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo", "Error", JOptionPane.WARNING_MESSAGE);
			return null;
		}

	}
	
	private Object[][] procesaArchivo(Workbook libro) {
		
		String [][]datos;
		Sheet hoja1 = libro.getSheet(0);

		datos = new String[hoja1.getRows()][hoja1.getColumns()];
		
		nomcolumnas = new String[hoja1.getColumns()];

		gramatica = new String[hoja1.getRows()][hoja1.getColumns()];

		for (int fila = 0; fila < hoja1.getRows(); fila++) {
			for (int columna = 0; columna < hoja1.getColumns(); columna++) {

				gramatica[fila][columna] = hoja1.getCell(columna, fila)
						.getContents();

				if (fila == 0) {
					nomcolumnas[columna] = hoja1.getCell(columna, fila).getContents();
				} else {
					datos[fila - 1][columna] = hoja1.getCell(columna, fila).getContents();
				}
			}
		}
		
		return clean(datos);

	}
	
	private String [][] clean(String [][] tableInput){
		
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (String[] strings : tableInput)
			if(null!=strings[0])
				list.add(strings);
		
		String [][] tableOutput = new String[list.size()][list.get(0).length];
		
		for (int i = 0; i < list.size(); i++)
			for (int j = 0; j < list.get(i).length; j++)
				tableOutput[i][j] = list.get(i)[j];
		
		return tableOutput;
	}
			
	public String [] getNomcolumnas() {
		return nomcolumnas;
	}
	
	public String[][] getGramatica() {
		return gramatica;
	}
	
}
