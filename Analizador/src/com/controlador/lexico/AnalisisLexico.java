package com.controlador.lexico;

import java.util.ArrayList;

public class AnalisisLexico {

	public AnalisisLexico() {
		// TODO Auto-generated constructor stub
	}

	public boolean analiza(String fuente){
		
		String palabra = "";
		ArrayList<String> palabras = new ArrayList<String>();
		
		for (int i = 0; i < fuente.length(); i++) {
			
			char t = fuente.charAt(i);
			
			if( automataID(t) ){
				palabra += t;
			}else {
				palabras.add(palabra);
				palabra = "";
			}

		}
		
		for (String string : palabras) {
			System.out.println(string);
		}
		
		
		return false;
	}
	
	public boolean automataID(char caracter) {

		boolean estadoAcepta;
		int estado = 0;
		
		if (Character.isLetter(caracter) && estado == 0) {
			estado = 1;
			estadoAcepta = true;
		} else if (Character.isLetterOrDigit(caracter) && estado == 1) {
			estado = 1;
			estadoAcepta = true;			
		} else {
			estadoAcepta = false;
		}

		return estadoAcepta;
	}
	
	public Object[][] getTable(){
		return null;
	}
	
	public String getAnalisis(){
		return "Este es algun texto de Prueba";
	}

}
