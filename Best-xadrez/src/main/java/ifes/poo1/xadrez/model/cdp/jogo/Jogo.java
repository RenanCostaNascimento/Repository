package ifes.poo1.xadrez.model.cdp.jogo;

import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Jogo {
	
	Tabuleiro tabuleiro;
	Jogador branco;
	Jogador preto;
	GregorianCalendar dataHoraInicio;
	Calendar dataHoraFim;
	Jogador vez;
	
	public Jogo(Tabuleiro tabuleiro, Jogador branco, Jogador preto)
	{
		this.tabuleiro = tabuleiro;
		this.branco = branco;
		this.preto = preto;
		this.dataHoraInicio = new GregorianCalendar();
		this.vez = this.branco;
	}
	
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public Jogador getBranco() {
		return branco;
	}
	public void setBranco(Jogador branco) {
		this.branco = branco;
	}
	public Jogador getPreto() {
		return preto;
	}
	public void setPreto(Jogador preto) {
		this.preto = preto;
	}
	public GregorianCalendar getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(GregorianCalendar dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public Calendar getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(Calendar dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}


	public Jogador getVez() {
		return vez;
	}


	public void setVez(Jogador vez) {
		this.vez = vez;
	}
	
	//rock, en passaint e outras regras de jogo/neg�cio;
	
			
	
}

