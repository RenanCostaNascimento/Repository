package ifes.poo1.xadrez.model.cdp.jogador;

import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;
import java.util.ArrayList;
import ifes.poo1.xadrez.model.cdp.constantes.Cores;

public class Jogador {
	private String nome;
	private Cores cor;
	private int vitorias;
	private int derrotas;
	private ArrayList<PecaAbstrata> pecasCapturadas = new ArrayList<PecaAbstrata>();
	
	public Jogador(String nome, Cores cor){
		this.nome = nome;
		this.cor = cor;
		this.vitorias = 0;
		this.derrotas = 0;
	}
	
	
	public int getPontuacao() {
		int soma = 0;
		//todo
		//somar os valores de cada pe�a da lista "pecasComidas"
		return soma;
	}
        
	public Cores getCor() {
		return cor; 
	}
	public void setCor(Cores cor) {
		this.cor = cor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
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


	public ArrayList<PecaAbstrata> getPecasCapturadas() {
		return pecasCapturadas;
	}


	public void setPecasCapturadas(ArrayList<PecaAbstrata> pecasCapturadas) {
		this.pecasCapturadas = pecasCapturadas;
	}	
	
}
