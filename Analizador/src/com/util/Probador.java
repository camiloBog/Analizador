package com.util;

import java.util.ArrayList;

import com.controlador.lexico.Automata;
import com.modelo.FileManager;

public class Probador {

	public static class AnalisisLexico {
		
		private Automata automata;
		private ArrayList<String[]> lista;
		private String salida;
		private String ID = "id";
		private String NO = "no";

		public AnalisisLexico() {
			this.salida = "";
			this.automata = new Automata();
			this.lista = new ArrayList<String[]>(); 
		}

		public boolean analiza(String fuente) {
			
			//Lee caracter por caracter
			char ch[] = fuente.toCharArray();
			
			String palabra = "";
			String texto = "";
			boolean bandera = false;
			
			try {
				
				for (int i = 0; i < fuente.length(); i++) {
					
					String letra = String.valueOf(ch[i]);
					
					//Si es comillas cambia la bandera
					if( letra.equals("\"") ){
						bandera = !bandera;
						
						if( !texto.equals("") )
							salida += "\""+texto+"\"";

						continue;
					}
					
					if(bandera){
						
						texto += letra;
						
					} else if( automata.esSecuenciaDeEscape(letra) ){
						
						if( !automata.esToken(palabra) ){
							addData(palabra, ID, NO);
						//	salida += letra;
						}else{
						//	salida += ID;
						}

						//salida += letra;
						palabra = "";
						texto = "";
					}else if( automata.esToken(letra) ){
						
						if( !automata.esToken(palabra) ){
							addData(palabra, ID, NO);
							//salida += ID;
						}else{
							//salida += letra;							
						}
						
						salida += letra;
						palabra = "";
						texto = "";
					}else{

						//salida += letra;
						palabra += letra;
						texto = "";
					}
				}
				
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}
		
		public String getAnalisis() {
			return this.salida;
		}
		
		public Object[][] getTable(){
			
			Object[][] objeto = new Object[lista.size()][3];
			for (int i = 0; i < lista.size(); i++)
				objeto[i] =  lista.get(i);
			return objeto;
		}

		private void addData(String lexema, String Token, String Indicador){
			
			if( !lexema.equals("") ){
				String[] data = { lexema, Token, Indicador };
				lista.add(data);
			}
				
		}

	}
	
	

	
	
	public static void main(String[] args) {

		//String url = "/home/camilo/git/Analizador/Analizador/programa/programa.txt";
		String url = "C:\\Users\\cabustamantes\\git\\Analizador\\Analizador\\programa\\programa.txt";
		String programa = new FileManager().leeArchivo(url);
		AnalisisLexico lexico = new AnalisisLexico();
		lexico.analiza(programa);
		
		String programa2 = lexico.getAnalisis();
		
		Object[][] objeto = lexico.getTable();
		for (int i = 0; i < objeto.length; i++) {
		//	System.out.println("-> "+objeto[i][0]+"\t\t"+objeto[i][1]+"\t\t"+objeto[i][2]);
		}
		
		
		//System.out.println(programa);
		System.out.println(programa2);
	}

}
