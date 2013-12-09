package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;

public class Rainha extends Peca {
	
	public Rainha(Cores cor) {
		super(cor, NomePecas.rainha, 9);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "D";
	}

	@Override
	public boolean mover(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		
		if((Math.abs(colunaFinal - colunaInicial) == Math.abs(linhaFinal - linhaInicial)) || ((linhaFinal-linhaInicial == 0) || (colunaFinal - colunaInicial == 0)))
			return true;
		return false;
		
	}

	@Override
	public boolean capturar(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		
		if((Math.abs(colunaFinal - colunaInicial) == Math.abs(linhaFinal - linhaInicial)) || ((linhaFinal-linhaInicial == 0) || (colunaFinal - colunaInicial == 0)))
			return true;
		return false;
		
	}

	

}
