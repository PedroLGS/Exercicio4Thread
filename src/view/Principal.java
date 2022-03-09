package view;

import controller.SapoCorrida;

public class Principal {
	final static int n_sapos = 5;
	final static int distancia = 500;

	public static void main(String[] args) {
		
		SapoCorrida correndo;
		
			for (int i = 1; i <= n_sapos; i++) {
			correndo = new SapoCorrida("SAPO_" + i, distancia);
			correndo.start();
		}

	}

}
