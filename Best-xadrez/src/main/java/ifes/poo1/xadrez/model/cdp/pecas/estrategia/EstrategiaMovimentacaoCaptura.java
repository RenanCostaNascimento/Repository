/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cdp.pecas.estrategia;

import ifes.poo1.xadrez.model.cdp.jogo.Posicao;

/**
 *
 * @author Renan
 */
public interface EstrategiaMovimentacaoCaptura {
    
    public boolean movimentar(Posicao posicaoInicial, Posicao posicaoFinal);
    
    public boolean capturar(Posicao posicaoInicial, Posicao posicaoFinal);
    
}
