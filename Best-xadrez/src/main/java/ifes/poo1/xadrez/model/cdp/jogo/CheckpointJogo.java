/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.model.cdp.jogo;

import ifes.poo1.xadrez.model.reuse.Model;

/**
 *
 * @author Renan
 */
public class CheckpointJogo extends Model{
    
    private String nomeJogo;
    private String nomeJogador;
    private String comando;
    private int numeroJogada;

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nome) {
        this.nomeJogo = nome;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public int getNumeroJogada() {
        return numeroJogada;
    }

    public void setNumeroJogada(int numeroJogada) {
        this.numeroJogada = numeroJogada;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }
    
    
}
