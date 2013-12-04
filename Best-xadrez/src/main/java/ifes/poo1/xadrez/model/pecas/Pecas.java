package ifes.poo1.xadrez.model.pecas;

public abstract class Pecas {
	private String cor; 
	private int valor;
		
	public abstract boolean mover(int xIn, int yIn, int xFin, int yFin);
	
	public int getValor(){
		return this.valor;
	}
	
	
	public Pecas(String cor){
		this.setCor(cor);
	}
	
	public void setCor(String cor){
		this.cor = cor;
	}
	
	public String getCor(){
		return this.cor;	
	}

}
