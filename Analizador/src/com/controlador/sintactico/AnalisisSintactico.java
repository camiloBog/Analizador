package com.controlador.sintactico;

import java.util.Stack;

public class AnalisisSintactico {

	private String[] cadena1, cadenacopia;
	public Object[][] tabla1, salida, salidacopia, salida1;

	private String pilar;
	private String x;
	private String a;
	private String p = "$";
	private String finala;
	private String val = "ok";
	private int pos = 0, cont = 0, band1 = 0, blocks = 8;

	public AnalisisSintactico(String[] cadena, Object[][] tabla) {

		this.cadena1 = cadena;
		this.tabla1 = tabla;

		cadenacopia = new String[cadena1.length];
		for (int i = 0; i < cadenacopia.length; i++)
			cadenacopia[i] = cadena1[i];

		cadena1 = new String[(cadena1.length) + 1];

		for (int i = 0; i < cadenacopia.length; i++)
			cadena1[i] = cadenacopia[i];

		cadena1[(cadena1.length) - 1] = p;

		Stack<String> pila = new Stack<String>();
		pila.push(p);
		pilar = tabla1[1][0].toString();
		pila.push(pilar);

		salida = new Object[0][blocks];

		while (!pila.get((pila.size()) - 1).toString().equals("$")) {

			salidacopia = salida;
			salida = new Object[salidacopia.length + 1][blocks];

			for (int m = 0; m < salidacopia.length; m++)
				salida[m] = salidacopia[m];

			finala = "";
			for (int i = 0; i < pila.size(); i++)
				finala += pila.get(i);

			salida[pos][0] = finala;

			if ((pila.get((pila.size()) - 1)).equals(a))
				cont++;
			
			salida[pos][1] = cadena1[cont];
			x = pila.get((pila.size()) - 1);
			pila.pop();
			a = cadena1[cont];
			salida[pos][4] = "M[" + x + "," + a + "]";

			for (int i = 1; i < tabla1.length; i++) {

				if (tabla1[i][0].equals(x)) {

					for (int j = 1; j < tabla1[i].length; j++) {

						if (tabla1[0][j].equals(a)) {

							pilar = tabla1[i][j].toString();

							salida[pos][5] = pilar;
							char[] car = new char[pilar.length()];
							char[] carcopia;
							car = pilar.toCharArray();

							for (int k = 0; k < car.length; k++) {

								if (car[k] == '-') {

									band1 = k;
								}

							}

							String concatenar = "", concatenarcopia = "";
							for (int f = (car.length) - 1; f > band1; f--) {

								if (car[f] != ' ') {

									concatenar += car[f];

								} else {

									carcopia = new char[concatenar.length()];
									carcopia = concatenar.toCharArray();

									for (int q = (concatenar.length()) - 1; q >= 0; q--) {

										concatenarcopia += carcopia[q];
									}

									if (concatenarcopia != "e") {
										pila.push(concatenarcopia);

									}

									concatenar = "";
									concatenarcopia = "";

								}
							}
						}
					}
				}
			}

			salida[pos][5] = pilar;
			salida[pos][6] = val;
			salida[pos][2] = x;
			salida[pos][3] = cadena1[0];
			salida[pos][7] = getEntrada(cadena1, cont);

			pos++;

		}

		salidacopia = salida;
		salida = new Object[salidacopia.length + 1][blocks];

		for (int m = 0; m < salidacopia.length; m++) {
			salida[m] = salidacopia[m];
		}

		salida[pos][0] = pila.get((pila.size()) - 1).toString();
		salida[pos][2] = a;

		setSalida1(salida);

	}

	private String getEntrada(String[] entrada, int obj) {

		String salida = "";
		for (int i = obj; i < entrada.length; i++)
			salida += entrada[i];

		return salida;
	}
	
	public Object[][] getTablaSalida() {
		
		Object[][] tabla = new Object[this.salida.length][3];
		for (int i = 0; i < this.salida.length; i++) {
			tabla[i][0] =  salida[i][0];
			tabla[i][1] =  salida[i][7];
			tabla[i][2] =  salida[i][5];
		}
		
		return tabla;
	}

	public Object[][] getSalida() {
		return salida;
	}

	public void setSalida(Object[][] salida) {
		this.salida = salida;
	}

	public Object[][] getSalida1() {
		return salida1;
	}

	public void setSalida1(Object[][] salida1) {
		this.salida1 = salida1;
	}
}
