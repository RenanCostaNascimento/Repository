/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cgd.highscore;

import java.io.Serializable;

/**
 * Classe para armazenar os colocados do ranking e fazer a comparação deles.
 * @author Pedro
 */
public class Colocado implements Serializable, Comparable<Colocado>{
    private String nome;
    private int quantidade = 1;
    
    public Colocado(String nome){
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void addVitoria() {
        this.quantidade++;                
    }
    
    public int getVitorias(){
        return this.quantidade;
    }
    
    public int compareTo(Colocado colocado) {

        if(this.quantidade > colocado.quantidade){

            return -1;

        }

        else if(this.quantidade < colocado.quantidade){

            return 1;

        }

        return this.getNome().compareToIgnoreCase(colocado.getNome());

    }

}
