package com.controlador.lexico;

public class AnalisisLexico {
	
	private Object[][] tabla;
	private String fuente;
	private String analisis;

	public AnalisisLexico(String fuente) {
		this.fuente = fuente;
	}
	
	public boolean analizar(){
		
		// TODO 
		
		return false;
	}

	public Object[][] getTabla() {
		return tabla;
	}

	public void setTabla(Object[][] tabla) {
		this.tabla = tabla;
	}

	public String getAnalisis() {
		return analisis;
	}

	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}

}
