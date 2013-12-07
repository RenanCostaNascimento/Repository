package ifes.poo1.xadrez.view.cci;

import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import ifes.poo1.xadrez.view.cih.Tela;

public class ControladorTelas {
	
	Tela tela = new Tela();
	
	public int controlarMenuInicial()
	{
		int opcao = 10;
		
		while(opcao >3 || opcao <1)
		{
			opcao = tela.menuInicial();
		}
		
		return opcao;		
		
	}

	public void controlarDadosPartidas() 
	{
		tela.mostrarMenuDadosPartidas();	
	}
	
	public void controlarSair()
	{
		tela.mostrarMenuSair();
	}

	public String[] controlarNovoJogo() 
	{
		int opcao = 10;
		String [] nomeJogadores = new String[2];

		while (opcao > 2 || opcao < 1) {
			opcao = tela.novoJogo();
			switch (opcao) {
			case 1:
				nomeJogadores = tela.singlePlayer();
				break;
			case 2:
				nomeJogadores = tela.multiPlayer();
				break;
			default:
				tela.opcaoInvalida();
			}
		}
		return nomeJogadores;
	}
	
	public void mostrarTabuleiro(Tabuleiro tabuleiro)
	{
		tela.mostrarTabuleiro(tabuleiro);
	}
	
	public String pegarComandoUsuario(Jogador jogador)
	{
		return tela.pegarComandoUsuario(jogador);
	}

}
