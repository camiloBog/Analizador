package com.modelo;

public class Token {

	private String token1;
	private String token2;
	private String token3;
	private String token4;
	private String token5;
	private String token6;
	private String token7;
	private String token8;
	private String token9;
	private String token10;
	private String token11;
	private String token12;
	private String token13;
	private String token14;
	private String token15;
	private String token16;
	private String token17;
	private String token18;
	private String token19;
	private String token20;
	private String token21;
	private String token22;
	private String token23;
	private String token24;
	private String token25;
	private String token26;
	private String token27;
	private String token28;
	private String token29;

	private String lexema1;
	private String lexema2;
	private String lexema3;
	private String lexema4;
	private String lexema5;
	private String lexema6;
	private String lexema7;
	private String lexema8;
	private String lexema9;
	private String lexema10;
	private String lexema11;
	private String lexema12;
	private String lexema13;
	private String lexema14;
	private String lexema15;
	private String lexema16;
	private String lexema17;
	private String lexema18;
	private String lexema19;
	private String lexema20;
	private String lexema21;
	private String lexema22;
	private String lexema23;
	private String lexema24;
	private String lexema25;
	private String lexema26;
	private String lexema27;
	private String lexema28;
	private String lexema29;

	private String indicador;

	
	public Token() {

		this.token1 = "programa";
		this.token2 = "int";
		this.token3 = "char";
		this.token4 = "float";
		this.token5 = "leer";
		this.token6 = "imprimir";
		this.token7 = "terminar";
		this.token8 = "mientras";
		this.token9 = "si";
		this.token10 = "no";
		this.token11 = "sino";
		this.token12 = "+";
		this.token13 = "-";
		this.token14 = "*";
		this.token15 = "/";
		this.token16 = "\\";
		this.token17 = "=";
		this.token18 = "'";
		this.token19 = "\"";
		this.token20 = ",";
		this.token21 = ";";
		this.token22 = "(";
		this.token23 = ")";
		this.token24 = "{";
		this.token25 = "}";
		this.token26 = "&";
		this.token27 = "&&";
		this.token28 = "|";
		this.token29 = "||";

		this.lexema1 = "programa";
		this.lexema2 = "int";
		this.lexema3 = "char";
		this.lexema4 = "float";
		this.lexema5 = "leer";
		this.lexema6 = "imprimir";
		this.lexema7 = "terminar";
		this.lexema8 = "mientras";
		this.lexema9 = "si";
		this.lexema10 = "no";
		this.lexema11 = "sino";
		this.lexema12 = "+";
		this.lexema13 = "-";
		this.lexema14 = "*";
		this.lexema15 = "/";
		this.lexema16 = "\\";
		this.lexema17 = "=";
		this.lexema18 = "'";
		this.lexema19 = "\"";
		this.lexema20 = ",";
		this.lexema21 = ";";
		this.lexema22 = "(";
		this.lexema23 = ")";
		this.lexema24 = "{";
		this.lexema25 = "}";
		this.lexema26 = "&";
		this.lexema27 = "&&";
		this.lexema28 = "|";
		this.lexema29 = "||";

		this.indicador = "Si";

	}
	
	public String[] getTitle() {
		String[] data = { "LEXEMA", "TOKEN", "INDICADOR" };
		return data;
	}

	public Object[][] getTable() {

		Object[][] data = { 
				{ lexema1, token1, indicador },
				{ lexema2, token2, indicador }, 
				{ lexema3, token3, indicador },
				{ lexema4, token4, indicador }, 
				{ lexema5, token5, indicador },
				{ lexema6, token6, indicador }, 
				{ lexema7, token7, indicador },
				{ lexema8, token8, indicador }, 
				{ lexema9, token9, indicador },
				{ lexema10, token10, indicador },
				{ lexema11, token11, indicador },
				{ lexema12, token12, indicador },
				{ lexema13, token13, indicador },
				{ lexema14, token14, indicador },
				{ lexema15, token15, indicador },
				{ lexema16, token16, indicador },
				{ lexema17, token17, indicador },
				{ lexema18, token18, indicador },
				{ lexema19, token19, indicador },
				{ lexema20, token20, indicador },
				{ lexema21, token21, indicador },
				{ lexema22, token22, indicador },
				{ lexema23, token23, indicador },
				{ lexema24, token24, indicador },
				{ lexema25, token25, indicador },
				{ lexema26, token26, indicador },
				{ lexema27, token27, indicador },
				{ lexema28, token28, indicador },
				{ lexema29, token29, indicador }, 
				};

		return data;

	}

}
