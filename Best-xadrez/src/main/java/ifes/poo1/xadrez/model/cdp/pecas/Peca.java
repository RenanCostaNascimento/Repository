package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;

public abstract class Peca {
	protected Cores cor; 
	protected int valor;
	protected String nome;
		
	public abstract boolean mover(int xIn, int yIn, int xFin, int yFin);
	
	public Peca(Cores cor, String nome, int valor){
		this.cor = cor;
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor(){
		return this.valor;
	}
	
	public void setCor(Cores cor){
		this.cor = cor;
	}
	
	public Cores getCor(){
		return this.cor;	
	}

}
