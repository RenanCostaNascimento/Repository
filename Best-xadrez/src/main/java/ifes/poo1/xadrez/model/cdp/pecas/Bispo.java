package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.estrategia.EstrategiaMovimentacaoCaptura;
import ifes.poo1.xadrez.model.cdp.pecas.estrategia.EstrategiaMovimentacaoCapturaBispo;

/**
 * Classe da Peça Bispo.
 *
 */
public class Bispo extends PecaAbstrata {
    
    private final EstrategiaMovimentacaoCaptura estrategiaMovimentacaoCaptura;

    public Bispo() {
        super(NomePecas.Bispo, 3);
        estrategiaMovimentacaoCaptura = new EstrategiaMovimentacaoCapturaBispo();

        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean mover(Posicao posicaoFinal) {
        return estrategiaMovimentacaoCaptura.movimentar(this.posicao, posicaoFinal);
     }

    @Override
    public boolean capturar(Posicao posicaoFinal) {
        return estrategiaMovimentacaoCaptura.capturar(getPosicao(), posicaoFinal);
    }

}
