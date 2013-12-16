/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.util.comparators;

import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import java.util.Comparator;

/**
 *
 * @author Pedro
 */
public class HistoricoComparatorNome implements Comparator<HistoricoPartida> {
    public int compare(HistoricoPartida partida, HistoricoPartida outraPartida) {
        return partida.getVencedor().compareTo(outraPartida.getVencedor());
    }
}
