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
 *
 * @author Pedro
 */
public class Placar implements Serializable {
    
    protected ArrayList<Colocado> colocados = new ArrayList<Colocado>();
    
    public Placar(){
        
    }
    
   
    private int procuraPeloNome(String nome){
        for (int i=0; i<colocados.size(); i++){
            if (colocados.get(i).getNome().equals(nome)) return i;
        }
        
        return (-1);
    }
    
    
    public void insereColocado(String nome){
        int posicao = this.procuraPeloNome(nome);
        if (posicao>=0) colocados.get(posicao).addVitoria();
        else colocados.add(new Colocado(nome));
        
        Collections.sort(colocados); 
    }
  
    public void imprime(){
        for (int i=0; i<colocados.size(); i++) System.out.println(colocados.get(i).getNome()+" "+colocados.get(i).getVitorias());

    }
    
}
