package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;

public class Dama extends Pecas {
	private int valor = 9;
	
	public Dama(Cores cor) {
		super(cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "D";
	}

	@Override
	public boolean mover(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		
		if((Math.abs(colunaFinal - colunaInicial) == Math.abs(linhaFinal) - linhaInicial) || ((linhaFinal-linhaInicial == 0) || (colunaFinal - colunaInicial == 0)))
			return true;
		return false;
		
	}

	

}
