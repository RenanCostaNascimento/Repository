/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cdp.pecas.estrategia;

import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import java.io.Serializable;

/**
 *
 * @author Renan
 */
public class EstrategiaMovimentacaoCapturaBispo implements EstrategiaMovimentacaoCaptura, Serializable{

    @Override
    public boolean movimentar(Posicao posicaoInicial, Posicao posicaoFinal) {
        int distanciaLin;
        int distanciaCol;
        int i, j; //Contadores para o for

        distanciaLin = posicaoFinal.getLinha() - posicaoInicial.getLinha();
        distanciaCol = posicaoFinal.getColuna() - posicaoInicial.getColuna();

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
    public boolean capturar(Posicao posicaoInicial, Posicao posicaoFinal) {
        for (int aux = 0; aux < 8; aux++) {
            if ((posicaoInicial.getColuna() + aux == posicaoFinal.getColuna()) && (posicaoInicial.getLinha() + aux == posicaoFinal.getLinha())) {
                return true;
            }
            if ((posicaoInicial.getColuna() - aux == posicaoFinal.getColuna()) && (posicaoInicial.getLinha() - aux == posicaoFinal.getLinha())) {
                return true;
            }
            if ((posicaoInicial.getColuna() + aux == posicaoFinal.getColuna()) && (posicaoInicial.getLinha() - aux == posicaoFinal.getLinha())) {
                return true;
            }
            if ((posicaoInicial.getColuna() - aux == posicaoFinal.getColuna()) && (posicaoInicial.getLinha() + aux == posicaoFinal.getLinha())) {
                return true;
            }
        }

        return false;
    }
    
}
