package ifes.poo1.xadrez.model.cdp.jogo;

import java.io.Serializable;


public class HistoricoJogador implements Comparable<HistoricoJogador>, Serializable{
	
	private int vitorias;
	private int derrotas;
	private int empates;
	private String nome;
        
        public String toString(){
            return nome+" V:"+vitorias+" D:"+derrotas+" E:"+empates;
        }
	
	public HistoricoJogador(String nome){
		this.vitorias = 0;
		this.derrotas = 0;
		this.empates = 0;
		this.nome = nome;
	}
	public void addVitorias(){
            this.setVitorias(vitorias+1);
        }
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
        public void addDerrotas(){
            this.setDerrotas(derrotas+1);
        }
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
        public void addEmpates(){
            this.setEmpates(empates+1);
        }
	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}	
	
        public int compareTo(HistoricoJogador jogador) {

        if(this.vitorias > jogador.vitorias){

            return -1;

        }

        else if(this.vitorias < jogador.vitorias){

            return 1;

        }

        return this.getNome().compareToIgnoreCase(jogador.getNome());

    }
}

