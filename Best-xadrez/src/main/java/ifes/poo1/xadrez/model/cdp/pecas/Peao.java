package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
/**
 * Classe da Peça Peao.
 * @param Cores.branco ou Cores.preto - cor da peça.
 */
public class Peao extends PecaAbstrata {
	
	public Peao(Cores cor) {
		super(cor, NomePecas.peao, 1);
	}

	@Override
	public String toString() {
		return "P";
	}
	
	@Override
	public boolean mover(Posicao posicaoFinal) {

		/* peao preto */
		if (this.getCor().equals(Cores.preto)) {
			if (posicaoFinal.getColuna() == getPosicao().getColuna()) {
				/* primeiro movimento */
				if ((getPosicao().getLinha() == 6)
						&& (posicaoFinal.getLinha() == getPosicao().getLinha() - 2)
						|| (posicaoFinal.getLinha() == getPosicao().getLinha() - 1))
					return true;
				/* movimento comum */
				if (posicaoFinal.getLinha() == getPosicao().getLinha() - 1)
					return true;
			}
			/* peao branco */
		} else {
			/* movimento comum */
			if (posicaoFinal.getColuna() == getPosicao().getColuna()) {
				/* primeiro movimento */
				if ((getPosicao().getLinha() == 1)
						&& (posicaoFinal.getLinha() == getPosicao().getLinha() + 2)
						|| (posicaoFinal.getLinha() == getPosicao().getLinha() + 1))
					return true;
				/* movimento comum */
				if (posicaoFinal.getLinha() == getPosicao().getLinha() + 1)
					return true;
			}
		}

		return false;
	}

	@Override
	public boolean capturar(Posicao posicaoFinal) {

		/* peao preto */
		if (this.getCor().equals(Cores.preto)) {
			if ((posicaoFinal.getLinha() == getPosicao().getLinha() - 1)
					&& ((posicaoFinal.getColuna() == getPosicao().getColuna() + 1) || (posicaoFinal
							.getColuna() == getPosicao().getColuna() - 1)))
				return true;
		}
		/* peao branco */
		else {
			if ((posicaoFinal.getLinha() == getPosicao().getLinha() + 1)
					&& ((posicaoFinal.getColuna() == getPosicao().getColuna() + 1) || (posicaoFinal
							.getColuna() == getPosicao().getColuna() - 1)))
				return true;
		}

		return false;

	}



}
