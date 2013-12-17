package ifes.poo1.xadrez.model.cdp.jogador;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;

import java.util.ArrayList;
/**
 * Classe do jogador, que contem o Nome, Cor, e as peças capturadas em jogo.
 * @author Pedro
 */
public class Jogador {
	private String nome;
	private Cores cor;
	private int vitorias;
	private int derrotas;
	private ArrayList<PecaAbstrata> pecasCapturadas = new ArrayList<PecaAbstrata>();
        
	/**Classe do jogador, que contem o Nome, Cor, e as peças capturadas em jogo.
         * 
         * @param nome - String contendo o nome do jogador
         * @param cor - variável do tipos Cores contendo a cor do jogador. (Cores.branco ou Cores.preto)
         */
	public Jogador(String nome, Cores cor){
		this.nome = nome;
		this.cor = cor;
		this.vitorias = 0;
		this.derrotas = 0;
	}
	
     
        public void retornaJaVenci(){
            
            System.out.println("");
        }
	
	public int getPontuacao() {
		int soma = 0;
		for(PecaAbstrata peca : this.pecasCapturadas)
			soma += peca.getValor();
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

        /**
         * Adciona um peça capturada.
         * @param pecasCapturadas 
         */
	public void setPecasCapturadas(ArrayList<PecaAbstrata> pecasCapturadas) {
		this.pecasCapturadas = pecasCapturadas;
	}	
	
}
