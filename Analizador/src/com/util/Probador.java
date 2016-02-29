package com.util;

import com.controlador.lexico.Automata;
import com.modelo.FileManager;

public class Probador {

	public static class AnalisisLexico {
		
		private Automata automata;

		public AnalisisLexico() {
			this.automata = new Automata();
		}

		public boolean analiza(String fuente) {
			
			//Lee caracter por caracter
			char ch[] = fuente.toCharArray();
			
			String palabra = "";
			String texto = "";
			boolean bandera = false;
			
			for (int i = 0; i < fuente.length(); i++) {
				
				String letra = String.valueOf(ch[i]);
				
				if(bandera){
					texto += letra;
				}else{
					
				}
				
				//Si es comillas cambia la bandera
				if( letra.equals("\"") ){
					
				}
					bandera = !bandera;
				
				
				
				
				
				
				/*
				if(bandera){
					palabra += letra;
				} else if( automata.esSecuenciaDeEscape(letra) ){
					
					if( !automata.esToken(palabra) )
						System.out.println(palabra);
					palabra = "";
					
				}else if( automata.esToken(letra) ){
					
					if( !automata.esToken(palabra) )
						System.out.println(palabra);
					palabra = "";
					
				}else{
					palabra += letra;
				}
				*/
				
			}

			return false;
		}

	}

	
	
	public static void main(String[] args) {

		String url = "/home/camilo/git/Analizador/Analizador/programa/programa.txt";
		String programa = new FileManager().leeArchivo(url);
		AnalisisLexico lexico = new AnalisisLexico();
		lexico.analiza(programa);

		//System.out.println(programa);
	}

}
