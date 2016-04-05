package com.controlador.lexico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AnalisisLexico {

	private ArrayList<String[]> lista;
	private String salida;
	private ArrayList<String> listaSeparada; 
	private String ID = "id";
	private String NO = "no";

	public AnalisisLexico() {
		this.salida = "";
		this.lista = new ArrayList<String[]>();
		this.listaSeparada = new ArrayList<String>(); 
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
					
					if( !texto.equals("") ){
						this.salida += "\""+texto+"\"";
						this.listaSeparada.add(texto);
					}
						
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
						//this.list.add(palabra);
					}
					
					this.salida += letra;
					//this.list.add(letra);
					
					palabra = "";
					texto = "";
				}else if( automata.esToken(letra) ){
					
					if(!"".equals(palabra) && !automata.esToken(palabra) ){
						addData(palabra, ID, NO);
						this.salida += ID;
						this.listaSeparada.add(ID);
					}else{
						this.salida += palabra;
						this.listaSeparada.add(palabra);
					}
					
					this.salida += letra;
					this.listaSeparada.add(letra);
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
	
	public Object[][] getTable() {

		Map<String, String[]> map = new HashMap<String, String[]>();
		for (String[] strings : lista) {
			map.put(strings[0], strings);
		}

		Object[][] objeto = new Object[map.size()][3];
		Iterator<String> it = map.keySet().iterator();
		int i = 0;

		while (it.hasNext()) {
			String key = (String) it.next();
			objeto[i] = map.get(key);
			i++;
		}

		return objeto;
	}

	private void addData(String lexema, String Token, String Indicador){
		
		if( !lexema.equals("") ){
			String[] data = { lexema, Token, Indicador };
			lista.add(data);
		}
			
	}

	public String[] getListaSeparada() {
		
		String[] lista = new String[listaSeparada.size()];
		for (int i = 0; i < listaSeparada.size(); i++)
			lista[i] = listaSeparada.get(i);
		
		return lista;
	}

}
