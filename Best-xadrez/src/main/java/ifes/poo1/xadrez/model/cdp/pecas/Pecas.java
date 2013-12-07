package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;

public abstract class Pecas {
	private Cores cor; 
	private int valor;
		
	public abstract boolean mover(int xIn, int yIn, int xFin, int yFin);
	
	public int getValor(){
		return this.valor;
	}
	
	
	public Pecas(Cores cor){
		this.setCor(cor);
	}
	
	public void setCor(Cores cor){
		this.cor = cor;
	}
	
	public Cores getCor(){
		return this.cor;	
	}

}
