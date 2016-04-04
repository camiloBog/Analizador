package com.controlador.sintactico;

import java.util.ArrayList;

public class AnalizadorSintactico {
	
	public static void main(String[] args) {		
		
		String[] linea = {"id","+","id","*","id",";"}; //Dividir en el String de entrada
		Object[][] tabla = {//Poner el titulo en la tabla.
				{"", "id", "+", "*", "(", ")", "$"},
				{"E", "E -- T E'", "", "", "E -- T E'", "", ""}, 
				{"E'", "", "E' -- + T E'", "", "", "E' -- e", "E' -- e"}, 
				{"T", "T -- F T'", "", "", "T -- F T'", "", ""}, 
				{"T'", "", "T' -- e", "T' --> * F T'", "", "T' -- e", "T' -- e"}, 
				{"F", "F -- id", "", "", "F -- ( E )", "", ""}
				};
		
		analizar(linea, tabla);
	}

	public AnalizadorSintactico() {
		
	}
	
	public static void analizar(String[] cadena, Object[][] tabla){
		
		ArrayList<String> pila = new ArrayList<String>();
		String[][] gramatica = ObjectToString(tabla);
		String ae;
		String x;
		String a;
		String[] M = new String[2]; //M[X,a]
		String salida;
		String estado;
		
		//Inicializa Variables
		pila.add("$");
		pila.add(gramatica[1][0]);
		int c = 0;
		ae = cadena[c];
		x = pila.get(pila.size()-1);
		a = ae;
		M = setM(x, a);
		salida = buscaGramatica(x,a,gramatica);
		estado = "";
		
		System.out.println("Pila\tae\tX\ta\tM[X,a]\tX->Y1,Y2..YK\tSalida");
		System.out.println( imprime(pila,ae,x,a,M,salida,estado) );
		
		//Inicia el algoritmo
		while( pila.get(0).equals("$") && pila.size() != 1 ){
			
			//sea x el simbolo de la cima de la pila
			x = pila.get(pila.size()-1);
			//a el simbolo apuntado por ae
			a = ae;
			
			//Si x es un terminal o $
			if( esTerminal(x) ){
				//Si x es igual a
				if( x.equals(a)){
					pila.remove(x);
					c++; ae = cadena[c]; //REVISAR ESTO
				}else {
					//error();
				}
			}else{ //Si x no es un terminal
				//if(salida.equals(anObject))
			}
			
			
		}
		
	}
	
	private static boolean esTerminal(String x) {
		// TODO Auto-generated method stub
		return false;
	}

	private static String imprime(ArrayList<String> pila, String ae, String x,
			String a, String[] M, String salida, String estado) {
		
		String p = "";
		for (String string : pila)
			p += "|"+string;
		
		String m = "M["+M[0]+","+M[1]+"]";
			
		return p+"\t"+ae+"\t"+x+"\t"+a+"\t"+m+"\t"+salida+"\t"+estado;
	}

	private static String buscaGramatica(String x, String a, String[][] gramatica) {

		try {
			for (int i = 0; i < gramatica.length; i++)
				if(gramatica[i][0].equals(x))
					for (int j = 0; j < gramatica[0].length; j++) 
						if(gramatica[0][j].equals(a))
							return gramatica[i][j];
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private static String[] setM(String X, String a){
		String[] retorno = {X,a};
		return retorno;
	}
	
	private static String[][] ObjectToString(Object[][] object){
		
		String[][] string = new String[object.length][object[0].length];
		for (int i = 0; i < object.length; i++)
			for (int j = 0; j < object[0].length; j++)
				string[i][j] = object[i][j].toString();

		return string;
	}

}
