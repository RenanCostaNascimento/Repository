package ifes.poo1.xadrez.view.cih;

import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Tela {
	
	Scanner scanner = new Scanner(System.in);
	
	public int menuInicial()
	{
		System.out.println("1. Iniciar uma nova partida\n"
				+ "2. Dados das partidas\n"
				+ "3. Sair");
		return scanner.nextInt();
	}
	
	public int novoJogo()
	{
		System.out.println("1. Singleplayer\n"
				+ "2. Multiplayer");
		return scanner.nextInt();
	}
	
	public String[] singlePlayer()
	{
		String nomeJogadores[] = new String[2] ;
		
		System.out.println("Digite seu nome, jogador branco:");
		nomeJogadores[0] = scanner.next();
		System.out.println("Seu oponente, o jogador preto, se chamara ZEUS!");
		nomeJogadores[1] = "ZEUS";
		
		apresentarJogadores(nomeJogadores);
		
		return nomeJogadores;
	}
	
	public String[] multiPlayer()
	{
		String nomeJogadores[] = new String[2] ;
		
		System.out.println("Digite seu nome, jogador branco:");
		nomeJogadores[0] = scanner.next();
		System.out.println("Digite seu nome, jogador preto:");
		nomeJogadores[1] = scanner.next();
		
		apresentarJogadores(nomeJogadores);
		
		return nomeJogadores;
	}
	
	private void apresentarJogadores(String[] nomeJogadores)
	{
		System.out.println("A partida se dara entre os jogadores " + nomeJogadores[0] + " e " + nomeJogadores[1] + "!\n"
				+ "BEGIN!\n");
	}
	
	public void opcaoInvalida() 
	{
		System.out.println("Digite um numero dentre as opcoes possiveis!");
	}

	public void mostrarMenuSair() {
		System.out.println("------- GAME OVER -------");
		
	}

	public void mostrarMenuDadosPartidas(List<HistoricoPartida> partidas, List<HistoricoJogador> jogadores) {
		
		if(partidas.isEmpty())
			System.out.println("Ainda não houve nenhuma partida!");
		else{
			int quantPartidas = 0;
			int quantJogadores = 0;
			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
			
			System.out.println("Partidas realizadas...");
			System.out.println("N°  -  Inicio  -  Fim  -  Vencedor");
			for(HistoricoPartida partida : partidas){
				System.out.println(quantPartidas + "  -  " + formatoData.format(partida.getDataHoraInicio().getTime()) + "  -  " + formatoData.format(partida.getDataHoraFim().getTime()) + "  -  " + partida.getVencedor());
				quantPartidas++;
			}
			
			System.out.println("... e os seus jogadores...");
			System.out.println("N°  -  Nome  -  Vitorias  -  Empates  -  Derrotas");
			for(HistoricoJogador jogador : jogadores){
				System.out.println(quantJogadores + "  -  " + jogador.getNome() + "  -  " + jogador.getVitorias() + "  -  " + jogador.getEmpates() + "  -  " + jogador.getDerrotas());
				quantJogadores++;
			}
		}
		System.out.println();
	}
	
	public void exibirMensagem(String mensagem)
	{
		System.out.println(mensagem);
	}
	
	public void mostrarTabuleiro(Tabuleiro tabuleiro)
	{
		tabuleiro.ImprimeTab();
	}
	
	public String pegarComandoUsuario(Jogador jogador)
	{
		System.out.println("O que vai fazer agora, " + jogador.getNome() + "?");
		return scanner.next();
	}
	
	public int empatarPartida(){
		System.out.println("1. Sim\n"
				+ "2. Nao");
		
		return scanner.nextInt();
	}

}
