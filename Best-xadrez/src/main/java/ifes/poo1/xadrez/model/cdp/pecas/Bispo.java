package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;

/**
 * Classe da Peça Bispo.
 *
 * @param Cores.branco ou Cores.preto - cor da peça.
 */
public class Bispo extends PecaAbstrata {

    public Bispo() {
        super(NomePecas.Bispo, 3);

        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean mover(Posicao posicaoFinal) {
        /*
		
         for (int aux = 0; aux < 8; aux++){
                                                
                            
         if ((Math.abs(getPosicao().getColuna()-aux) == posicaoFinal.getColuna()) && (getPosicao().getLinha()+aux == posicaoFinal.getLinha())) return true;
         if ((getPosicao().getColuna()+aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()+aux == posicaoFinal.getLinha())) return true;                         
         if ((Math.abs(getPosicao().getColuna()-aux) == posicaoFinal.getColuna()) && (Math.abs(getPosicao().getLinha()-aux) == posicaoFinal.getLinha())) return true;
         if ((getPosicao().getColuna()+aux == posicaoFinal.getColuna()) && (Math.abs(getPosicao().getLinha()-aux) == posicaoFinal.getLinha())) return true;
                            
         }
                                              
                                       
         */
        int distanciaLin;
        int distanciaCol;
        int i, j; //Contadores para o for

        distanciaLin = posicaoFinal.getLinha() - this.posicao.getLinha();
        distanciaCol = posicaoFinal.getColuna() - this.posicao.getColuna();

        i = 0;
        j = 0;

        // Primeira atribuição, para que não verifique a posição inicial da peça
        if (distanciaLin > 0) {
            i++;
        } else {
            i--;
        }

        // Primeira atribuição, para que não verifique a posição inicial da peça
        if (distanciaCol > 0) {
            j++;
        } else {
            j--;
        }

        /* Observando a posição da peça e a sua posição futura, é possível notar que a sua diferença formará um quadrado com lados (x, y);
         mais ainda é necessario aplicar o modulo nos dois valores (|x|, |y|), para obteremos |x| == |y|. */
        if (Math.abs(distanciaLin) != Math.abs(distanciaCol)) {
            // Não sendo iguais, logo, a jogada está inválida
            return false;
        }

        return true;

    }

    @Override
    public boolean capturar(Posicao posicaoFinal) {

        for (int aux = 0; aux < 8; aux++) {
            if ((getPosicao().getColuna() + aux == posicaoFinal.getColuna()) && (getPosicao().getLinha() + aux == posicaoFinal.getLinha())) {
                return true;
            }
            if ((getPosicao().getColuna() - aux == posicaoFinal.getColuna()) && (getPosicao().getLinha() - aux == posicaoFinal.getLinha())) {
                return true;
            }
            if ((getPosicao().getColuna() + aux == posicaoFinal.getColuna()) && (getPosicao().getLinha() - aux == posicaoFinal.getLinha())) {
                return true;
            }
            if ((getPosicao().getColuna() - aux == posicaoFinal.getColuna()) && (getPosicao().getLinha() + aux == posicaoFinal.getLinha())) {
                return true;
            }
        }

        return false;

    }

}
