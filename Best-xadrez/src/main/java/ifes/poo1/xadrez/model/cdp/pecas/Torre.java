package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.estrategia.EstrategiaMovimentacaoCaptura;
import ifes.poo1.xadrez.model.cdp.pecas.estrategia.EstrategiaMovimentacaoCapturaTorre;

/**
 * Classe da Peça Torre.
 *
 */
public class Torre extends PecaAbstrata {
    private final EstrategiaMovimentacaoCaptura estrategiaMovimentacaoCaptura;

    public Torre() {
        super(NomePecas.Torre, 5, null);
        estrategiaMovimentacaoCaptura = new EstrategiaMovimentacaoCapturaTorre();
    }

    public Torre(Cores cor) {
        super(NomePecas.Torre, 5, cor);
        estrategiaMovimentacaoCaptura = new EstrategiaMovimentacaoCapturaTorre();
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean mover(Posicao posicaoFinal) {
        if(estrategiaMovimentacaoCaptura.movimentar(getPosicao(), posicaoFinal)){
            this.actMovimentou();
            return true;
        }
        return false;
//
//        if ((posicaoFinal.getLinha() - getPosicao().getLinha() == 0) || (posicaoFinal.getColuna() - getPosicao().getColuna() == 0)) {
//            this.actMovimentou();
//            return true;
//        }
//
//        return false;

    }

    @Override
    public boolean capturar(Posicao posicaoFinal) {
        if(estrategiaMovimentacaoCaptura.capturar(getPosicao(), posicaoFinal)){
            this.actMovimentou();
            return true;
        }
        return false;
    }

}
