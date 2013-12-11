package ifes.poo1.xadrez.model.cgt;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import ifes.poo1.xadrez.model.cdp.jogo.Jogada;
import ifes.poo1.xadrez.model.cdp.jogo.Jogo;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import ifes.poo1.xadrez.util.exception.CaminhoBloqueadoException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaInexistenteException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaPropriaException;
import ifes.poo1.xadrez.util.exception.CasaVaziaException;
import ifes.poo1.xadrez.util.exception.ChequeInvalidoException;
import ifes.poo1.xadrez.util.exception.MovimentoInvalidoException;
import ifes.poo1.xadrez.util.exception.PecaAlheiaException;
import ifes.poo1.xadrez.view.cci.ControladorTelas;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Control {
	
	private ControladorTelas controladorTela = new ControladorTelas();
	private Jogo jogo;
	private List<HistoricoPartida> partidas = new ArrayList<>();
	private List<HistoricoJogador> jogadores = new ArrayList<>();
		
	public void controlarComandoRecebido(){
		Jogada jogada = controladorTela.determinarJogadaUsuario(jogo.getVez());
		switch(jogada.getTipoJogada()){
		case MOVIMENTO:
			try {
				movimentarPeca(jogada.getPosicaoInicial(), jogada.getPosicaoFinal());
			} catch (PecaAlheiaException | MovimentoInvalidoException | CaminhoBloqueadoException | CasaVaziaException e) {
				controladorTela.exibirMensagem(e.getMessage());
				controlarComandoRecebido();
			}
			break;
		case CAPTURA:
			try {
				capturarPeca(jogada.getPosicaoInicial(), jogada.getPosicaoFinal());
			} catch (CasaVaziaException | PecaAlheiaException
					| CaminhoBloqueadoException | MovimentoInvalidoException
					| CapturaInvalidaPecaInexistenteException
					| CapturaInvalidaPecaPropriaException e) {
				controladorTela.exibirMensagem(e.getMessage());
				controlarComandoRecebido();
			}
			break;
		case EMPATE:
			empatarPartida();
			break;
		case DESISTENCIA:
			System.out.println("DESISTENCIA");
			break;
		case PONTUACAO:
			System.out.println("PONTUACAO");
			break;
		case PROMOCAO:
			System.out.println("PROMOCAO");
			break;
		case ROQUE_MAIOR:
			System.out.println("ROQUE_MAIOR");
			break;
		case ROQUE_MENOR:
			System.out.println("ROQUE_MENOR");
			break;
		case INEXISTENTE:
			controladorTela.exibirMensagem("Que porra eh essa?!");
			controlarComandoRecebido();
		}
	}
	
//	private void validarXeque(String comando) throws PecaAlheiaException, MovimentoInvalidoException, CaminhoBloqueadoException, CasaVaziaException, ChequeInvalidoException {
//		
//		String comandoValidacaoCheque;
//		
//		movimentarPeca(comando);
//		
//		comandoValidacaoCheque = montarComandoValidacaoCheque(comando);
//		if(verificarCheque(comandoValidacaoCheque)){
//			mudarVezJogador();
//			controladorTela.exibirMensagem("XEQUE! Quero ver agora, " + jogo.getVez().getNome() + "!");
//			mudarVezJogador();
//		}else
//			throw new ChequeInvalidoException();
//			
//	}
	
	private String montarComandoValidacaoCheque(String comando){
		
		
		String comandoValidacaoCheque = comando.substring(2, 4);
		if(jogo.getVez().getCor().equals(Cores.branco))
			comandoValidacaoCheque += jogo.getTabuleiro().getPosicaoReiPreto();
		else
			comandoValidacaoCheque += jogo.getTabuleiro().getPosicaoReiBranco();
		
		return comandoValidacaoCheque;
	}

	private void empatarPartida() {
		controladorTela.exibirMensagem("o jogador " + jogo.getVez().getNome() + " deseja empatar a partida.");
		mudarVezJogador();
		controladorTela.exibirMensagem("Voce tambem deseja empatar a partida, " + jogo.getVez().getNome() + "?");
		mudarVezJogador();
		controlarEmpatePartida(controladorTela.empatarPartida());
		
	}
	
	private void controlarEmpatePartida(int opcao){
		
		switch (opcao) {
		case 1:
			controladorTela.exibirMensagem("O empate foi aceito! A partida estava uma vergonha, mesmo...");
			jogo.setDataHoraFim(new GregorianCalendar());			
			
			adicionarHistoricoJogo();
			adicionarHistoricoJogador();
			
			jogo.setEmAndamento(false);
			controlarMenuInicial();
			break;
		default:
			controladorTela.exibirMensagem("O empate nao foi aceito, a partida continuara!");
			controlarComandoRecebido();
			break;
		}
	}
	
	/*verifica se um jogador se encontra na lista, pelo nome*/
	private boolean estahNaLista(List<HistoricoJogador> listaJogadores, String nome){
		for(HistoricoJogador jogador : listaJogadores){
			if(jogador.getNome().equals(nome))
				return true;
		}
		return false;	
	}
	
	/*aumenta a quantidade de empates de um jogador no seu historico, pelo nome*/
	private void aumentarEmpateJogador(List<HistoricoJogador> listaJogadores, String nome){
		for(HistoricoJogador jogador : listaJogadores){
			if(jogador.getNome().equals(nome)){
				jogador.setEmpates(jogador.getEmpates() + 1);
				break;
			}
		}	
	}
	
	private void adicionarHistoricoJogo(){
		HistoricoPartida partida = new HistoricoPartida();
		partida.setDataHoraInicio(jogo.getDataHoraInicio());
		partida.setDataHoraFim(jogo.getDataHoraFim());
		partida.setVencedor("Empate");
		partidas.add(partida);
	}
	
	private void adicionarHistoricoJogador(){
		/*jogador branco*/
		if (estahNaLista(jogadores, jogo.getBranco().getNome()))
			aumentarEmpateJogador(jogadores, jogo.getBranco().getNome());
		else {
			HistoricoJogador jogador = new HistoricoJogador(jogo.getBranco().getNome());
			jogador.setEmpates(jogador.getEmpates() + 1);
			jogadores.add(jogador);
		}
		
		/*jogador preto*/
		if (estahNaLista(jogadores, jogo.getPreto().getNome()))
			aumentarEmpateJogador(jogadores, jogo.getPreto().getNome());
		else {
			HistoricoJogador jogador = new HistoricoJogador(jogo.getPreto().getNome());
			jogador.setEmpates(jogador.getEmpates() + 1);
			jogadores.add(jogador);
		}
	}

	private void movimentarPeca(Posicao posicaoInicial, Posicao posicaoFinal) throws PecaAlheiaException, MovimentoInvalidoException, CaminhoBloqueadoException, CasaVaziaException{
		
		PecaAbstrata peca = jogo.getTabuleiro().getCasas(posicaoInicial.getColuna(), posicaoInicial.getLinha());
		if(peca == null)
			throw new CasaVaziaException();

		if (!peca.getCor().equals(jogo.getVez().getCor()))
			throw new PecaAlheiaException();			
		else {
			/*verifica se a peca eh capaz de fazer o movimento*/
			if (peca.mover(posicaoFinal)) {
				/*verifica se a peca possui caminho desobstruido para fazer o movimento*/
				if(jogo.getTabuleiro().verificaCaminho(posicaoInicial, posicaoFinal)){
					/*se a peca movida for um rei, atualiza sua posicao no tabuleiro*/
					if(peca.getNome().equals(NomePecas.rei)){
						if(peca.getCor().equals(Cores.branco))
							jogo.getTabuleiro().setPosicaoReiBranco(String.valueOf(posicaoFinal.getColuna()) + String.valueOf(posicaoFinal.getLinha()));
						else
							jogo.getTabuleiro().setPosicaoReiPreto(String.valueOf(posicaoFinal.getColuna()) + String.valueOf(posicaoFinal.getLinha()));
					}
					jogo.getTabuleiro().moverPeca(posicaoInicial.getColuna(), posicaoInicial.getLinha(), posicaoFinal.getColuna(), posicaoFinal.getLinha());
				}
				else
					throw new CaminhoBloqueadoException();
			} else
				throw new MovimentoInvalidoException();
		}
	}
	
//	private boolean verificarCheque(String comando){
//		// colunas e linhas sao diminuidas em um para que o jogador possa
//		// escrever comandos entre 1 e 8, e nao entre 0 e 7.
//		int colunaInicial = Character.getNumericValue(comando.charAt(0));
//		colunaInicial -= 1;
//		int linhaInicial = Character.getNumericValue(comando.charAt(1));
//		linhaInicial -= 1;
//
//		int colunaFinal = Character.getNumericValue(comando.charAt(2));
//		colunaFinal -= 1;
//		int linhaFinal = Character.getNumericValue(comando.charAt(3));
//		linhaFinal -= 1;
//
//		Peca peca = jogo.getTabuleiro().getCasas(colunaInicial, linhaInicial);
//
//		/* verifica se a peca eh capaz de fazer o movimento */
//		if (peca.mover(colunaInicial, linhaInicial, colunaFinal, linhaFinal)) {
//			/*
//			 * verifica se a peca possui caminho desobstruido para fazer o
//			 * movimento
//			 */
//			if (jogo.getTabuleiro().verificaCaminho(colunaInicial,
//					linhaInicial, colunaFinal, linhaFinal)) {
//				return true;
//			} else
//				return false;
//		} else
//			return false;
//	}
	
	private void capturarPeca(Posicao posicaoInicial, Posicao posicaoFinal) throws CasaVaziaException, PecaAlheiaException, CaminhoBloqueadoException, MovimentoInvalidoException, CapturaInvalidaPecaInexistenteException, CapturaInvalidaPecaPropriaException{
				
		PecaAbstrata peca = jogo.getTabuleiro().getCasas(posicaoInicial.getColuna(), posicaoInicial.getLinha());
		if(peca == null)
			throw new CasaVaziaException();
		
		if (!peca.getCor().equals(jogo.getVez().getCor()))
			throw new PecaAlheiaException();	
		else {
			/*verifica se a peca eh capaz de fazer o movimento*/
			if (peca.capturar(posicaoFinal)) {
				/*verifica se a peca possui caminho desobstruido para fazer o movimento*/
				if(jogo.getTabuleiro().verificaCaminhoCaptura(posicaoInicial, posicaoFinal, jogo)){
					if(peca.getNome().equals(NomePecas.rei)){
						if(peca.getCor().equals(Cores.branco))
							jogo.getTabuleiro().setPosicaoReiBranco(String.valueOf(posicaoFinal.getColuna()) + String.valueOf(posicaoFinal.getLinha()));
						else
							jogo.getTabuleiro().setPosicaoReiPreto(String.valueOf(posicaoFinal.getColuna()) + String.valueOf(posicaoFinal.getLinha()));
					}
					PecaAbstrata pecaCapturada = jogo.getTabuleiro().capturarPeca(posicaoInicial, posicaoFinal);
					jogo.getVez().getPecasCapturadas().add(pecaCapturada);
					if(jogo.getQuantidadePecasCapturadas() == 0)
						controladorTela.exibirMensagem("FIRST BLOOD!");
					controladorTela.exibirMensagem(jogo.getVez().getNome() + " capturou " + pecaCapturada.getNome() + "! Mais " + pecaCapturada.getValor() + " pontos para voce!");
					jogo.setQuantidadePecasCapturadas(jogo.getQuantidadePecasCapturadas() + 1);
				}
				else
					throw new CaminhoBloqueadoException();
			} else
				throw new MovimentoInvalidoException();
		}
	}
	
	public void controlarMenuInicial()
	{
		int opcao = controladorTela.controlarMenuInicial();
		switch(opcao)
		{
		case 1:
			String nomeJogadores[] = new String[2];
			nomeJogadores = controladorTela.controlarNovoJogo();
			iniciarJogo(nomeJogadores);
			break;
		case 2:
			controladorTela.controlarDadosPartidas(partidas, jogadores);
			controlarMenuInicial();
			break;
		default:
			controladorTela.controlarSair();
		}
	}
	
	private void iniciarJogo(String[] nomeJogadores)
	{	
		
		Jogador branco = new Jogador(nomeJogadores[0], Cores.branco);
		Jogador preto = new Jogador(nomeJogadores[1], Cores.preto);
                
		Tabuleiro tabuleiro = new Tabuleiro();
		
		jogo = new Jogo(tabuleiro, branco, preto);
		
		controlarJogo();
	}
	
	
	private void controlarJogo()
	{	
		while(jogo.isEmAndamento())
			realizarJogada();
	}	
	
	private void realizarJogada(){
		
		controladorTela.mostrarTabuleiro(jogo.getTabuleiro());
		controlarComandoRecebido();
		mudarVezJogador();
	}
	
	private void mudarVezJogador()
	{
		if(jogo.getVez().equals(jogo.getBranco()))
			jogo.setVez(jogo.getPreto());
		else
			jogo.setVez(jogo.getBranco());
	}
}
