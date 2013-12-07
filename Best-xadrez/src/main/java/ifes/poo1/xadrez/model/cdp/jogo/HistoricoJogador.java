package ifes.poo1.xadrez.model.cdp.jogo;

import java.util.List;

public class HistoricoJogador {
	
	private int vitorias;
	private int derrotas;
	private int empates;
	private String nome;
	
	public HistoricoJogador(String nome){
		this.vitorias = 0;
		this.derrotas = 0;
		this.empates = 0;
		this.nome = nome;
	}
	
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
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

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}	
	
}
