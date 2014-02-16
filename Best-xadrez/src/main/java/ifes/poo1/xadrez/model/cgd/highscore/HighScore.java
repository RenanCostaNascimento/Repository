/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cgd.highscore;

import ifes.poo1.xadrez.model.cdp.jogo.Checkpoint;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import ifes.poo1.xadrez.util.persist.Deserializador;
import ifes.poo1.xadrez.util.persist.Serializador;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe para armazenar, carregar e manipular o placar.
 * O metodo construtor verifica se ele já existe. Caso sim carrega ele para memória.
 * Para utilizar, apenas inicialize a classe HighScore, se existir algum placar, ele vai agregar ao programa.
 * 
 * 
 * 
 * @author Pedro
 */
public class HighScore {
    private Historico historico;
    
    
    public HighScore(){
        Deserializador d = new Deserializador();
        
        try {
            //verifica se existe o placar
            this.setHistorico((Historico) d.deserializar("placar/"));
        } catch (Exception ex) {
            //cria um novo placar
            this.historico=new Historico();
        }
    }
       
    /**Metódo para armazenar o placar em memória persistente.
     * O nome do arquivo é placar e está na raiz do programa.
     */
    public String serializar(){
        Serializador s = new Serializador();
        try {
            s.serializar("placar/", this.getHistorico());
            return "Dados das partidas e jogadores salvos!";
        } catch (Exception ex) {
            return "Falha ao salvar dados! - " + ex.toString();
        }
    }
    
    
    /**Método para adcionar partidas para o histórico*/
    public void addPartida(HistoricoPartida partida){
        historico.addPartida(partida);
        this.serializar();
    }
    
    /**Método para adcionar jogadores para o histórico*/
    public void addJogador(HistoricoJogador jogador){
        historico.addJogador(jogador);
        this.serializar();
    }
    
    /**Método para adcionar jogadores para o histórico*/
    public void addCheckpoint(Checkpoint checkpoint){
    	
    	Iterator iterator = historico.getCheckpoints().iterator();
    	boolean inserido = true;
    	
    	while(iterator.hasNext()){
    		Checkpoint cp = (Checkpoint) iterator.next();
    		/*checkpoint ja existe, tem que substituir*/
    		if(cp.getNome().equals(checkpoint.getNome())){
    			iterator.remove();
    			historico.addCheckpoint(checkpoint);
    			inserido = false;
    			break;
    		}
    	}
    	/*checkpoint ainda nao existe*/
    	if(inserido)
    		historico.addCheckpoint(checkpoint);
    	
        this.serializar();
    }
    
    /**Método para retornar o histórico de jogadores
     * @return ArrayList<HistoricoJogador>
     */
    public ArrayList<HistoricoJogador> getJogadoresAntigos() {
        return historico.jogadoresAntigos;
    }
    
    public ArrayList<Checkpoint> getChecpoints() {
        return historico.checkpoints;
    }
    
    /**Método para retornar o historico de partidas
     *@return ArrayList<HistoricoPartida>
     */
    public ArrayList<HistoricoPartida> getPartidasAntigos() {
        return historico.partidasAntigos;
    }
    public void setJogadoresAntigos(ArrayList<HistoricoJogador> historicoJogador){
        historico.setJogadoresAntigos(historicoJogador);
    }
    
    public void setPartidasAntigos(ArrayList<HistoricoPartida> partidasAntigos){
        historico.setPartidasAntigos(partidasAntigos);
    }
    public void setCheckpoint(ArrayList<Checkpoint> checkpoints){
        historico.setCheckpoints(checkpoints);
    }
    public void setHistorico(Historico historico){
        this.historico=historico;
        
    }
    
    public Historico getHistorico(){
        return this.historico;
    }
    
    public Checkpoint getCheckpointByNome(String nome){
    	
    	for(Checkpoint checkpoint : historico.getCheckpoints()){
    		if(checkpoint.getNome().equals(nome))
    			return checkpoint;
    	}
    	
    	return null;
    	
    }
}

