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
 *
 * @author Pedro
 */
public class HighScore {
    private Placar placar;
    
    public HighScore(){
        Deserializador d = new Deserializador();
        Placar placar;
        try {
            //verifica se existe o placar
            this.setPlacar((Placar) d.deserializar("placar/"));
        } catch (Exception ex) {
            //System.err.println("Falha ao deserializar! - " + ex.toString());
            //cria um novo placar
            this.placar=new Placar();
        }
    }
    
    public void setPlacar(Placar placar){
        this.placar=placar;
    }
    
    public Placar getPlacar(){
        return this.placar;
    }
    
    //armazenar em memória
    public void serializar(){
        Serializador s = new Serializador();
        try {
            s.serializar("placar/", this.getPlacar());
            System.out.println("Serializado!");
        } catch (Exception ex) {
            System.err.println("Falha ao serializar! - " + ex.toString());
        }
    }
    
    public void insere(String nome){
        placar.insereColocado(nome);
    }
    
    public void imprime(){
        placar.imprime();
    }
    
}
