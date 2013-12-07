package ifes.poo1.xadrez.model.cdp.jogo;

import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Jogo {
	
	private Tabuleiro tabuleiro;
	private Jogador branco;
	private Jogador preto;
	private GregorianCalendar dataHoraInicio;
	private GregorianCalendar dataHoraFim;
	private Jogador vez;
	private int quantidadePecasCapturadas;
	private boolean emAndamento;
	
	public Jogo(Tabuleiro tabuleiro, Jogador branco, Jogador preto)
	{
		this.tabuleiro = tabuleiro;
		this.branco = branco;
		this.preto = preto;
		this.dataHoraInicio = new GregorianCalendar();
		this.vez = this.branco;
		this.quantidadePecasCapturadas = 0;
		this.emAndamento = true;
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
	
	public GregorianCalendar getDataHoraFim() {
		return dataHoraFim;
	}


	public Jogador getVez() {
		return vez;
	}


	public void setVez(Jogador vez) {
		this.vez = vez;
	}

	public int getQuantidadePecasCapturadas() {
		return quantidadePecasCapturadas;
	}


	public void setQuantidadePecasCapturadas(int quantidadePecasCapturadas) {
		this.quantidadePecasCapturadas = quantidadePecasCapturadas;
	}


	public boolean isEmAndamento() {
		return emAndamento;
	}


	public void setEmAndamento(boolean emAndamento) {
		this.emAndamento = emAndamento;
	}


	public void setDataHoraFim(GregorianCalendar dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	
	//rock, en passaint e outras regras de jogo/neg�cio;
	
			
	
}

