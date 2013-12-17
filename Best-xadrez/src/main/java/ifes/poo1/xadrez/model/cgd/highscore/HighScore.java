package ifes.poo1.xadrez.model.cgd.highscore;

import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import ifes.poo1.xadrez.util.persist.Deserializador;
import ifes.poo1.xadrez.util.persist.Serializador;
import java.io.Serializable;
import java.util.ArrayList;

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
            //System.err.println("Falha ao deserializar! - " + ex.toString());
            //cria um novo placar
            this.historico=new Historico();
        }
    }
    
    public String toString(){
        return this.historico.toString();
    }
    
    public void setHistorico(Historico historico){
        this.historico=historico;
        
    }
    
    public Historico getHistorico(){
        return this.historico;
    }
    
    /**Metódo para armazenar o placar em memória persistente.
     * O nome do arquivo é placar e está na raiz do programa.
     */
    private void serializar(){
        Serializador s = new Serializador();
        try {
            s.serializar("placar/", this.getHistorico());
            System.out.println("Serializado!");
        } catch (Exception ex) {
            System.err.println("Falha ao serializar! - " + ex.toString());
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
    
    /**Método para retornar o histórico de jogadores
     * @return ArrayList<HistoricoJogador>
     */
    public ArrayList<HistoricoJogador> getJogadoresAntigos() {
        return historico.jogadoresAntigos;
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
}