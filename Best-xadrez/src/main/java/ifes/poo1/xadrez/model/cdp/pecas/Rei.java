package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;

public class Rei extends Peca {
	
	private boolean seMovimentou = false;
	
	public Rei(Cores cor) {
		
		super(cor, NomePecas.rei, 999);
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

	public boolean isSeMovimentou() {
		return seMovimentou;
	}

	public void setSeMovimentou(boolean seMovimentou) {
		this.seMovimentou = seMovimentou;
	}
}
