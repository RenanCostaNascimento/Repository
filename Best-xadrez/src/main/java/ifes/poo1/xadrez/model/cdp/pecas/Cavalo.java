package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
/**
 * Classe da Peça Cavalo.
 * @param Cores.branco ou Cores.preto - cor da peça.
 */
public class Cavalo extends PecaAbstrata {
	
	public Cavalo() {
		super(NomePecas.Cavalo, 3);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return "C";
		
	}
	
	@Override
	public boolean mover(Posicao posicaoFinal) {
		if ((posicaoFinal.getColuna() > 7) || (posicaoFinal.getColuna() < 0)
				|| (posicaoFinal.getLinha() < 0)
				|| (posicaoFinal.getLinha() > 7))
			return false;

		if (((posicaoFinal.getColuna() == getPosicao().getColuna() + 2) || (posicaoFinal
				.getColuna() == getPosicao().getColuna() - 2))
				&& ((posicaoFinal.getLinha() == getPosicao().getLinha() + 1) || (posicaoFinal
						.getLinha() == getPosicao().getLinha() - 1)))
			return true;
		if ((((posicaoFinal.getLinha() == getPosicao().getLinha() + 2) || (posicaoFinal
				.getLinha() == getPosicao().getLinha() - 2)))
				&& (((posicaoFinal.getColuna() == getPosicao().getColuna() + 1) || (posicaoFinal
						.getColuna() == getPosicao().getColuna() - 1))))
			return true;

		return false;

	}

	@Override
	public boolean capturar(Posicao posicaoFinal) {
		if ((posicaoFinal.getColuna() > 7) || (posicaoFinal.getColuna() < 0)
				|| (posicaoFinal.getLinha() < 0)
				|| (posicaoFinal.getLinha() > 7))
			return false;

		if (((posicaoFinal.getColuna() == getPosicao().getColuna() + 2) || (posicaoFinal
				.getColuna() == getPosicao().getColuna() - 2))
				&& ((posicaoFinal.getLinha() == getPosicao().getLinha() + 1) || (posicaoFinal
						.getLinha() == getPosicao().getLinha() - 1)))
			return true;
		if ((((posicaoFinal.getLinha() == getPosicao().getLinha() + 2) || (posicaoFinal
				.getLinha() == getPosicao().getLinha() - 2)))
				&& (((posicaoFinal.getColuna() == getPosicao().getColuna() + 1) || (posicaoFinal
						.getColuna() == getPosicao().getColuna() - 1))))
			return true;

		return false;

	}

	
}
