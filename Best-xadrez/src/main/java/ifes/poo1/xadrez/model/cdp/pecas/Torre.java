package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
/**
 * Classe da Peça Torre.
 * @param Cores.branco ou Cores.preto - cor da peça.
 */
public class Torre extends PecaAbstrata {

	public Torre(Cores cor) {
		super(cor, NomePecas.torre, 5);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean mover(Posicao posicaoFinal) {
		
		if((posicaoFinal.getLinha()-getPosicao().getLinha() == 0) || (posicaoFinal.getColuna() - getPosicao().getColuna() == 0)){
                    this.actMovimentou();
                    return true;
                }
		
		return false;
		
	}
	
	@Override
	public boolean capturar(Posicao posicaoFinal) {
		
		if((posicaoFinal.getLinha()-getPosicao().getLinha() == 0) || (posicaoFinal.getColuna() - getPosicao().getColuna() == 0)){
                    this.actMovimentou();
                    return true;
                }
		
		return false;
		
	}

}
