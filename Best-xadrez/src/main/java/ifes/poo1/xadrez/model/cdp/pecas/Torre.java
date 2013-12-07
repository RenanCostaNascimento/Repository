package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;

public class Torre extends Peca {

	public Torre(Cores cor) {
		super(cor, NomePecas.torre, 5);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "T";
	}
	@Override
	public boolean mover(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		
		if((linhaFinal-linhaInicial == 0) || (colunaFinal - colunaInicial == 0))
			return true;
		
		return false;
		
	}

}
