/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cgd.highscore;

import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import ifes.poo1.xadrez.model.cdp.jogo.Jogo;
import ifes.poo1.xadrez.model.util.comparators.HistoricoComparatorNome;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 *
 * @author Pedro
 */
public class Historico implements Serializable{
    protected ArrayList<HistoricoPartida> partidasAntigos = new ArrayList<HistoricoPartida>();
    protected ArrayList<HistoricoJogador> jogadoresAntigos = new ArrayList<HistoricoJogador>();
    
    public void addPartida(HistoricoPartida partida){
        partidasAntigos.add(partida);
    }
    
    public void addJogador(HistoricoJogador jogador){
        jogadoresAntigos.add(jogador);
    }

    public ArrayList<HistoricoJogador> getJogadoresAntigos() {
        return jogadoresAntigos;
    }

    public ArrayList<HistoricoPartida> getPartidasAntigos() {
        return partidasAntigos;
    } 
}
