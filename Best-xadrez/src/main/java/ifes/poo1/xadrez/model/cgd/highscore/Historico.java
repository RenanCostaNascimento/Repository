/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cgd.highscore;

import ifes.poo1.xadrez.model.cdp.jogo.Checkpoint;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Historico implements Serializable{
    protected ArrayList<HistoricoPartida> partidasAntigos = new ArrayList<HistoricoPartida>();
    protected ArrayList<HistoricoJogador> jogadoresAntigos = new ArrayList<HistoricoJogador>();
    protected ArrayList<Checkpoint> checkpoints = new ArrayList<Checkpoint>();
    
    public void addPartida(HistoricoPartida partida){
        partidasAntigos.add(partida);
    }
    
    public void addJogador(HistoricoJogador jogador){
        jogadoresAntigos.add(jogador);
    }
    
    public void addCheckpoint(Checkpoint checkpoint){
    	checkpoints.add(checkpoint);
    }

    public void setJogadoresAntigos(ArrayList<HistoricoJogador> jogadoresAntigos) {
        this.jogadoresAntigos = jogadoresAntigos;
    }

    public void setPartidasAntigos(ArrayList<HistoricoPartida> partidasAntigos) {
        this.partidasAntigos = partidasAntigos;
    }
    
    
    public ArrayList<HistoricoJogador> getJogadoresAntigos() {
        return jogadoresAntigos;
    }

    public ArrayList<HistoricoPartida> getPartidasAntigos() {
        return partidasAntigos;
    }

	public ArrayList<Checkpoint> getCheckpoints() {
		return checkpoints;
	}

	public void setCheckpoints(ArrayList<Checkpoint> checkpoints) {
		this.checkpoints = checkpoints;
	} 
    
    
}
