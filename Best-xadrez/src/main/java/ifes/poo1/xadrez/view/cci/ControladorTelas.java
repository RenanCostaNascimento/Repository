package ifes.poo1.xadrez.view.cci;

import ifes.poo1.xadrez.model.cdp.constantes.TipoJogada;
import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import ifes.poo1.xadrez.model.cdp.jogo.Jogada;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import ifes.poo1.xadrez.view.cih.Tela;

import java.util.List;

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

	public void controlarDadosPartidas(List<HistoricoPartida> partidas, List<HistoricoJogador> jogadores) 
	{
		tela.mostrarMenuDadosPartidas(partidas, jogadores);	
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
	
	public int empatarPartida(){
		
		int opcao = tela.empatarPartida();
		
		while(opcao >2 || opcao <1)
		{
			opcao = tela.empatarPartida();
		}
		
		return opcao;
		
	}
	
	public Jogada determinarJogadaUsuario(Jogador jogador)
	{
		Jogada jogada = new Jogada();
		String comando = tela.pegarComandoUsuario(jogador);

		jogada.setComando(comando);
		
		if(comando.length() == 4){
			if(comando.charAt(2) != '=')
				jogada.setTipoJogada(TipoJogada.MOVIMENTO);
			else
				jogada.setTipoJogada(TipoJogada.PROMOCAO);
			return jogada;
		}
		if(comando.length() == 5){
			if(comando.charAt(2) == 'x'){
				jogada.setTipoJogada(TipoJogada.CAPTURA);		
				return jogada;
			}
			if(comando.charAt(4) == '+'){
				jogada.setTipoJogada(TipoJogada.CHEQUE);		
				return jogada;
			}
			if(comando.charAt(4) == '#'){
				jogada.setTipoJogada(TipoJogada.CHEQUE_MATE);		
				return jogada;
			}
		}
		if(comando.contentEquals("O-O")){
			jogada.setTipoJogada(TipoJogada.ROQUE_MENOR);		
			return jogada;
		}
		if(comando.contentEquals("O-O-O")){
			jogada.setTipoJogada(TipoJogada.ROQUE_MAIOR);		
			return jogada;
		}
		if(comando.contentEquals("pontos")){
			jogada.setTipoJogada(TipoJogada.PONTUACAO);		
			return jogada;
		}
		if(comando.contentEquals("desistir")){
			jogada.setTipoJogada(TipoJogada.DESISTENCIA);		
			return jogada;
		}
		if(comando.contentEquals("empate")){
			jogada.setTipoJogada(TipoJogada.EMPATE);		
			return jogada;
		}
		if(true){
			jogada.setTipoJogada(TipoJogada.INEXISTENTE);		
			return jogada;
		}
		return null;
	}
	
	public void exibirMensagem(String mensagem){
		tela.exibirMensagem(mensagem);
	}
	

}
