/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.util.comparators;

import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import java.util.Comparator;

/**
 *
 * @author Pedro
 */
public class JogadorComparatorEmpates implements Comparator<HistoricoJogador> {
    public int compare(HistoricoJogador jogador, HistoricoJogador outroJogador) {
        if(jogador.getEmpates() > outroJogador.getEmpates()){

            return -1;
        }
        
        return 1;
        
        
    }
}

