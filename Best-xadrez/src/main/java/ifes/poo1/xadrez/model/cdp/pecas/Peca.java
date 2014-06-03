package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
/**
 * Camada de interface da peca, contem as funções básicas. Andar e capturar.
 */
public interface Peca extends Cloneable  {

    /**
     * Dada uma posicao, verifica se a peca eh capaz de se movimentar para la
     *
     * @param posicaoFinal
     * @return boolean, se pode capturar ou não.
     */
    public boolean mover(Posicao posicaoFinal);

    /**
     * Dada uma posicao, verifica se a peca eh capaz capturar a peca que la se
     * encontra
     *
     * @param posicaoFinal
     * @return boolean, se pode capturar ou não.
     */
    public boolean capturar(Posicao posicaoFinal);

    public void setCor(Cores cor);

    public Peca clone();

    public void setPosicao(Posicao posicao);

    public Cores getCor();

    public NomePecas getNome();

    public Posicao getPosicao();

    public void actMovimentou();

    public int getValor();

    public boolean isSeMovimentou();

}
