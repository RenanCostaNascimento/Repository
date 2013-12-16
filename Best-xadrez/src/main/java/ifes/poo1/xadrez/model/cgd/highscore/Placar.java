/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cgd.highscore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe para armazenar o vetor dos colocados no ranking/high score e manipular do mesmo.
 * @author Pedro
 */
public class Placar implements Serializable {
    
    protected ArrayList<Colocado> colocados = new ArrayList<Colocado>();
    
    public Placar(){
        
    }
    
   /**Método para procurar por um jogador pelo nome no vetor colocados.
    * @param nome Nome do jogador
    * @return int -Posição no array. Retorna -1 caso não esteja lá.
    */
    private int procuraPeloNome(String nome){
        for (int i=0; i<colocados.size(); i++){
            if (colocados.get(i).getNome().equals(nome)) return i;
        }
        
        return (-1);
    }
    
    
    /**Método para inserir um vencedor de um jogo.
     * Caso o jogador já exista ele vai adcionar uma vitória para ele.
     * Apos inserir um jogador, a lista é ordenada com base no número de vitórias.
     * @param nome Nome do jogador
     */
    public void insereVencedor(String nome){
        int posicao = this.procuraPeloNome(nome);
        if (posicao>=0) colocados.get(posicao).addVitoria();
        else colocados.add(new Colocado(nome));
        Collections.sort(colocados); 
    }
    
    
    /**Método para inserir um empate.
     * Insere dois jogadores.
     * @param nome1 Nome do jogador
     * @param nome2 Nome do jogador
     */
    public void insereEmpate(String nome1, String nome2){
        this.insereVencedor(nome1);
        this.insereVencedor(nome2);
    }
  
    public void imprime(){
        for (int i=0; i<colocados.size(); i++) System.out.println(colocados.get(i).getNome()+" "+colocados.get(i).getVitorias());

    }
    
}
