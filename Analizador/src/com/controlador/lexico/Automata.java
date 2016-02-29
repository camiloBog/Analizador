package com.controlador.lexico;

import com.modelo.Token;

public class Automata {
	
	private Token token;
	private Object[][] data;

	public Automata() {
		this.token = new Token();
		this.data = token.getTable();
	}

	public boolean esToken(String tokenTxt) {

		for (int i = 0; i < data.length; i++)
			if (tokenTxt.equalsIgnoreCase(data[i][1].toString()))
				return true;
		
		return false;
	}
	
	public boolean esSecuenciaDeEscape(String tokenTxt){
		
		if( tokenTxt.equals(" ") || tokenTxt.equals("\t") || tokenTxt.equals("\n") 
				|| tokenTxt.equals("\r") || tokenTxt.equals("\f") || tokenTxt.equals("\b") ){
			return true;
		}
		
		return false;
	}
	
	
}
