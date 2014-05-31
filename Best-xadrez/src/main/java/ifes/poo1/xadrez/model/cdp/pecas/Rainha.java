package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
/**
 * Classe da Peça Rainha.
 * @param Cores.branco ou Cores.preto - cor da peça.
 */
public class Rainha extends PecaAbstrata {
	
	public Rainha(Cores cor) {
		super(NomePecas.Rainha, 9, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "D";
	}

	@Override
	public boolean mover(Posicao posicaoFinal) {

		if ((Math.abs(posicaoFinal.getColuna() - getPosicao().getColuna()) == Math
				.abs(posicaoFinal.getLinha() - getPosicao().getLinha()))
				|| ((posicaoFinal.getLinha() - getPosicao().getLinha() == 0) || (posicaoFinal
						.getColuna() - getPosicao().getColuna() == 0)))
			return true;
		return false;

	}

	@Override
	public boolean capturar(Posicao posicaoFinal) {

		if ((Math.abs(posicaoFinal.getColuna() - getPosicao().getColuna()) == Math
				.abs(posicaoFinal.getLinha() - getPosicao().getLinha()))
				|| ((posicaoFinal.getLinha() - getPosicao().getLinha() == 0) || (posicaoFinal
						.getColuna() - getPosicao().getColuna() == 0)))
			return true;
		return false;

	}

	

}
