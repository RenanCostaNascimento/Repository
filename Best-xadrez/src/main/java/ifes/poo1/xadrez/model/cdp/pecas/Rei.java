package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;

public class Rei extends Pecas {
	private int valor = 999;
	private boolean seMovimentou = false;
	
	public Rei(Cores cor) {
		
		super(cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean mover(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		
		if((Math.abs(colunaFinal - colunaInicial) <= 1) && (Math.abs(linhaFinal - linhaInicial) <= 1))
			return true;
		
		return false;
		
	}

	

}
