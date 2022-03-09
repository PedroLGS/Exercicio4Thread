package controller;

public class SapoCorrida extends Thread {
	
	private String nome;
	private int distanciaCorrida = 0;
	private int distanciaTotalCorrida;
	private int pulo = 0;
	private int pulos = 0;
	private static int colocacao = 0;
	private final static int pulo_maximo = 30;
	
	public SapoCorrida(String nome, int distanciaTotalCorrida) {
		super(nome);
		this.distanciaTotalCorrida = distanciaTotalCorrida;
		this.nome = nome;
	}
	public void SapoMovimentacao() {
		System.out.println("O " + nome + " saltou " + pulo + " e já percorreu " + distanciaCorrida + "cm");		
	}
	public void SapoSaltando() {
		pulos++;
		pulo = (int) (Math.random() * pulo_maximo);
		distanciaCorrida += pulo;
		if (distanciaCorrida > distanciaTotalCorrida) {
			distanciaCorrida = distanciaTotalCorrida;
		}
		
	}
	public void SapoParando() {
	Thread.yield();
	}
	public void ColocacaoSapo() {
		colocacao++;
		System.out.println("\n" + nome + " foi o " + colocacao + "º colocado com " + pulos + " pulos");
		}
	public void run() {
		while (distanciaCorrida < distanciaTotalCorrida) {
			SapoSaltando();
			SapoMovimentacao();
			SapoParando();
			
			try {
				sleep(100);
			} catch (InterruptedException e) {}
		}
		try {
			sleep(1000);
		} catch (InterruptedException e) {}
		ColocacaoSapo();
			
		}
	}

