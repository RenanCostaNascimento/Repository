package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;

public abstract class Peca {
	protected Cores cor; 
	protected int valor;
	protected NomePecas nome;
		
	public abstract boolean mover(int xIn, int yIn, int xFin, int yFin);
        
        	
	public Peca(Cores cor, NomePecas nome, int valor){
		this.cor = cor;
		this.nome = nome;
		this.valor = valor;
	}
	
	public NomePecas getNome() {
		return nome;
	}

	public void setNome(NomePecas nome) {
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
