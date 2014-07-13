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
public class EstrategiaMovimentacaoCapturaTorre implements EstrategiaMovimentacaoCaptura, Serializable{

    @Override
    public boolean movimentar(Posicao posicaoInicial, Posicao posicaoFinal) {
        return (posicaoFinal.getLinha() - posicaoInicial.getLinha() == 0) || (posicaoFinal.getColuna() - posicaoInicial.getColuna() == 0);
    }

    @Override
    public boolean capturar(Posicao posicaoInicial, Posicao posicaoFinal) {
        return (posicaoFinal.getLinha() - posicaoInicial.getLinha() == 0) || (posicaoFinal.getColuna() - posicaoInicial.getColuna() == 0);
    }
    
}
