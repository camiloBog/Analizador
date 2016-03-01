package com.controlador.lexico;

import java.util.ArrayList;


public class AnalisisLexico {

	private ArrayList<String[]> lista;
	private String salida;
	private String ID = "id";
	private String NO = "no";

	public AnalisisLexico() {
		this.salida = "";
		this.lista = new ArrayList<String[]>(); 
	}

	public boolean analiza(String fuente) {
		
		//Lee caracter por caracter
		char ch[] = fuente.toCharArray();
		
		String palabra = "";
		String texto = "";
		boolean bandera = false;
		Automata automata = new Automata();
		
		try {
			
			for (int i = 0; i < fuente.length(); i++) {
				
				String letra = String.valueOf(ch[i]);
				
				
				//Si es comillas cambia la bandera
				if( letra.equals("\"") ){
					bandera = !bandera;
					
					if( !texto.equals("") )
						this.salida += "\""+texto+"\"";
					continue;
				}
				
				
				if(bandera){
					
					texto += letra;
					continue;
					
				} else if( automata.esSecuenciaDeEscape(letra) ){
					
					if( !automata.esToken(palabra) ){
						addData(palabra, ID, NO);
					}else{
						this.salida += palabra;
					}
					
					this.salida += letra;
					
					palabra = "";
					texto = "";
				}else if( automata.esToken(letra) ){
					
					if(!"".equals(palabra) && !automata.esToken(palabra) ){
						addData(palabra, ID, NO);
						this.salida += ID;
					}else{
						this.salida += palabra;
					}
					
					this.salida += letra;
					palabra = "";
					texto = "";
				}else{
					
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
