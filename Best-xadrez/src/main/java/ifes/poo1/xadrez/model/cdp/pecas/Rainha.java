package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.estrategia.EstrategiaMovimentacaoCaptura;
import ifes.poo1.xadrez.model.cdp.pecas.estrategia.EstrategiaMovimentacaoCapturaBispo;
import ifes.poo1.xadrez.model.cdp.pecas.estrategia.EstrategiaMovimentacaoCapturaTorre;

/**
 * Classe da Peça Rainha.
 *
 */
public class Rainha extends PecaAbstrata {
    private final EstrategiaMovimentacaoCaptura estrategiaMovimentacaoCapturaTorre;
    private final EstrategiaMovimentacaoCaptura estrategiaMovimentacaoCapturaBispo;
            
    public Rainha() {
        super(NomePecas.Rainha, 9, null);
        estrategiaMovimentacaoCapturaBispo = new EstrategiaMovimentacaoCapturaBispo();
        estrategiaMovimentacaoCapturaTorre = new EstrategiaMovimentacaoCapturaTorre();
    }

    public Rainha(Cores cor) {
        super(NomePecas.Rainha, 9, cor);
        estrategiaMovimentacaoCapturaBispo = new EstrategiaMovimentacaoCapturaBispo();
        estrategiaMovimentacaoCapturaTorre = new EstrategiaMovimentacaoCapturaTorre();
    }

    @Override
    public String toString() {
        return "D";
    }

    @Override
    public boolean mover(Posicao posicaoFinal) {
        return (estrategiaMovimentacaoCapturaBispo.movimentar(getPosicao(), posicaoFinal) || estrategiaMovimentacaoCapturaTorre.movimentar(getPosicao(), posicaoFinal));

    }

    @Override
    public boolean capturar(Posicao posicaoFinal) {
        
        return (estrategiaMovimentacaoCapturaBispo.movimentar(getPosicao(), posicaoFinal) || estrategiaMovimentacaoCapturaTorre.movimentar(getPosicao(), posicaoFinal));
    }

}
