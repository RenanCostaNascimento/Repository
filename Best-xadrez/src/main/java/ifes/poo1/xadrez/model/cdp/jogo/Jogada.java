package ifes.poo1.xadrez.model.cdp.jogo;

import ifes.poo1.xadrez.model.cdp.constantes.TipoJogada;

public class Jogada {
	
	String comando;
	TipoJogada tipoJogada;
	
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public TipoJogada getTipoJogada() {
		return tipoJogada;
	}
	public void setTipoJogada(TipoJogada tipoJogada) {
		this.tipoJogada = tipoJogada;
	}
	
	

}
