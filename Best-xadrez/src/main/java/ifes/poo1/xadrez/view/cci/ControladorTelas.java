package ifes.poo1.xadrez.view.cci;

import ifes.poo1.xadrez.model.cdp.constantes.TipoJogada;
import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.Checkpoint;
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
		
		while(opcao >4 || opcao <1)
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
	
	public int promoverPeca(){
		
	int opcao = tela.promoverPeca();
		
		while(opcao >2 || opcao <1)
		{
			opcao = tela.empatarDesistirPartida();
		}
		
		return opcao;
	}
	
	public void mostrarTabuleiro(Tabuleiro tabuleiro)
	{
		tela.mostrarTabuleiro(tabuleiro);
	}
	
	public int empatarDesistirPartida(){
		
		int opcao = tela.empatarDesistirPartida();
		
		while(opcao >2 || opcao <1)
		{
			opcao = tela.empatarDesistirPartida();
		}
		
		return opcao;
		
	}
	
	public Jogada determinarJogadaUsuario(Jogador jogador)
	{
		Jogada jogada = new Jogada();
		String comando = tela.pegarComandoUsuario(jogador);
		
		if(!comando.equals("sair") && comando.length() == 4){
			
			jogada.getPosicaoInicial().setColuna(Character.getNumericValue(comando.charAt(0)) -1);
			jogada.getPosicaoInicial().setLinha(Character.getNumericValue(comando.charAt(1)) -1);
			jogada.getPosicaoFinal().setColuna(Character.getNumericValue(comando.charAt(2)) -1);
			jogada.getPosicaoFinal().setLinha(Character.getNumericValue(comando.charAt(3)) -1);
			jogada.setTipoJogada(TipoJogada.MOVIMENTO);
			return jogada;
		}
		if (comando.charAt(2) == 'x') {
			jogada.setTipoJogada(TipoJogada.CAPTURA);
			jogada.getPosicaoInicial().setColuna(Character.getNumericValue(comando.charAt(0)) -1);
			jogada.getPosicaoInicial().setLinha(Character.getNumericValue(comando.charAt(1)) -1);
			jogada.getPosicaoFinal().setColuna(Character.getNumericValue(comando.charAt(3)) -1);
			jogada.getPosicaoFinal().setLinha(Character.getNumericValue(comando.charAt(4)) -1);
			return jogada;
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
		if(comando.contentEquals("salvar")){
			jogada.setTipoJogada(TipoJogada.SALVAR);		
			return jogada;
		}
		if(comando.contentEquals("sair")){
			jogada.setTipoJogada(TipoJogada.SAIR);		
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

	public String controlarSalvarSairPartida() {
		
		return tela.controlarSalvarSairPartida();
	}

	public String  controlarMenuJogosSalvos(List<Checkpoint> checkpoints) {
		
		return tela.controlarMenuJogosSalvos(checkpoints);
		
	}
	

}
