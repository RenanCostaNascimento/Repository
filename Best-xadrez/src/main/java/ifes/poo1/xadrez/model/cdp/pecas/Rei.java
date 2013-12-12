package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;

public class Rei extends PecaAbstrata {
	
	private boolean seMovimentou = false;
	
	public Rei(Cores cor) {
		
		super(cor, NomePecas.rei, 999);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	public boolean isSeMovimentou() {
		return seMovimentou;
	}

	public void setSeMovimentou(boolean seMovimentou) {
		this.seMovimentou = seMovimentou;
	}

	@Override
	public boolean mover(Posicao posicaoFinal) {

		if ((Math.abs(posicaoFinal.getColuna() - getPosicao().getColuna()) <= 1)
				&& (Math.abs(posicaoFinal.getLinha() - getPosicao().getLinha()) <= 1))
			return true;

		return false;

	}

	@Override
	public boolean capturar(Posicao posicaoFinal) {

		if ((Math.abs(posicaoFinal.getColuna() - getPosicao().getColuna()) <= 1)
				&& (Math.abs(posicaoFinal.getLinha() - getPosicao().getLinha()) <= 1))
			return true;

		return false;

	}

}
