package ifes.poo1.xadrez.view.cih;

import ifes.poo1.xadrez.model.jogador.Jogador;
import ifes.poo1.xadrez.model.tabuleiro.Tabuleiro;

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

	public void mostrarMenuDadosPartidas() {
		
		System.out.println("Dados da partida: Em desenvolvimento!");
		
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

}
