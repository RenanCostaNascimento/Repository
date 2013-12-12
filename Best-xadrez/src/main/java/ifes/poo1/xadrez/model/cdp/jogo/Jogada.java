package ifes.poo1.xadrez.model.cdp.jogo;

import ifes.poo1.xadrez.model.cdp.constantes.TipoJogada;

public class Jogada {
	
	private Posicao posicaoInicial;
	private Posicao posicaoFinal;
	private TipoJogada tipoJogada;
	
	public Jogada(){
		this.posicaoInicial = new Posicao();
		this.posicaoFinal = new Posicao();
	}
	
	public Posicao getPosicaoInicial() {
		return posicaoInicial;
	}
	public void setPosicaoInicial(Posicao posicaoInicial) {
		this.posicaoInicial = posicaoInicial;
	}
	public Posicao getPosicaoFinal() {
		return posicaoFinal;
	}
	public void setPosicaoFinal(Posicao posicaoFinal) {
		this.posicaoFinal = posicaoFinal;
	}
	public TipoJogada getTipoJogada() {
		return tipoJogada;
	}
	public void setTipoJogada(TipoJogada tipoJogada) {
		this.tipoJogada = tipoJogada;
	}
	
	

}
