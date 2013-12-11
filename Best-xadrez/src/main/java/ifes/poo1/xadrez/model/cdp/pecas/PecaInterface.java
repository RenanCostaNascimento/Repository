package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.jogo.Posicao;

public interface PecaInterface {
	
	/*dada uma posicao, verifica se a peca eh capaz de se movimentar para la*/
	public boolean mover(Posicao posicaoFinal);
	
	/*dada uma posicao, verifica se a peca eh capaz capturar a peca que la se encontra*/
	public boolean capturar(Posicao posicaoFinal);

}
