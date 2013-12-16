/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cgd.highscore;

import ifes.poo1.xadrez.util.persist.Deserializador;
import ifes.poo1.xadrez.util.persist.Serializador;
import java.io.Serializable;

/**
 * Classe para armazenar, carregar e manipular o placar.
 * O metodo construtor verifica se ele já existe. Caso sim carrega ele para memória.
 * Para utilizar, apenas inicialize a classe HighScore, se existir algum placar, ele vai agregar ao programa.
 * 
 * Para salver o high score, chame a função serializar.
 * 
 * @author Pedro
 */
public class HighScore {
    private Placar placar;
    
    
    public HighScore(){
        Deserializador d = new Deserializador();
        
        try {
            //verifica se existe o placar
            this.setPlacar((Placar) d.deserializar("placar/"));
        } catch (Exception ex) {
            //System.err.println("Falha ao deserializar! - " + ex.toString());
            //cria um novo placar
            this.placar=new Placar();
        }
    }
    
    public String toString(){
        return this.placar.toString();
    }
    
    public void setPlacar(Placar placar){
        this.placar=placar;
    }
    
    public Placar getPlacar(){
        return this.placar;
    }
    
    /**Metódo para armazenar o placar em memória persistente.
     * O nome do arquivo é placar e está na raiz do programa.
     */
    public void serializar(){
        Serializador s = new Serializador();
        try {
            s.serializar("placar/", this.getPlacar());
            System.out.println("Serializado!");
        } catch (Exception ex) {
            System.err.println("Falha ao serializar! - " + ex.toString());
        }
    }
    
    /**Método para inserir um vencedor de um jogo.
     * Caso o jogador já exista ele vai adcionar uma vitória para ele.
     * Apos inserir um jogador, a lista é ordenada com base no número de vitórias.
     * @param nome Nome do jogador
     */
    public void addVencedor(String nome){
        placar.addVencedor(nome);
    }
    
    /**Método para inserir um empate.
     * Insere dois jogadores.
     * @param nome1 Nome do jogador
     * @param nome2 Nome do jogador
     */
    public void addEmpate(String nome1, String nome2){
        placar.addEmpate(nome1,nome2);
    }
    
    /**Imprime o placar.*/
    public void imprime(){
        placar.imprime();
    }
    
}
