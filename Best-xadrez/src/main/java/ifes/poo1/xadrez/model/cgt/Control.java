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
import ifes.poo1.xadrez.model.cgd.highscore.HighScore;
import ifes.poo1.xadrez.util.exception.CaminhoBloqueadoException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaInexistenteException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaPropriaException;
import ifes.poo1.xadrez.util.exception.CasaVaziaException;
import ifes.poo1.xadrez.util.exception.MovimentoInvalidoException;
import ifes.poo1.xadrez.util.exception.PecaAlheiaException;
import ifes.poo1.xadrez.view.cci.ControladorTelas;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/**Classe de controle do modelo. Controla o tabuleiro e as peças.*/

public class Control {
	
	private ControladorTelas controladorTela = new ControladorTelas();
	private Jogo jogo;
	private List<HistoricoPartida> partidas = new ArrayList<>();
	private List<HistoricoJogador> jogadores = new ArrayList<>();
	private HighScore highScore = new HighScore();
	public void controlarComandoRecebido(){
		Jogada jogada = controladorTela.determinarJogadaUsuario(jogo.getVez());
		switch(jogada.getTipoJogada()){
		case MOVIMENTO:
			controlarMovimentoPeca(jogada);
			controlarXeque();
			break;
		case CAPTURA:
			controlarCapturaPeca(jogada);
			controlarXeque();
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
	
	public void controlarComandoZeus(){
		
		Random gerador = new Random();
		List<Posicao> posicoesPossiveis = new ArrayList<>();
		Posicao posicaoRandomica;
		PecaAbstrata pecaRandomica = null, pecaDestino;
		
		/*enquanto a peca escolhida nao conseguir se mover, escolha outra peca*/
		while(posicoesPossiveis.size() == 0){
			/*randomiza uma peca da lista de pecas de zeus*/
			pecaRandomica = jogo.getTabuleiro().getPecasPretas().get(gerador.nextInt(jogo.getTabuleiro().getPecasPretas().size()));
			/*pega as posicoes possiveis que a peca consegue se mover*/
			posicoesPossiveis = jogo.getTabuleiro().posicoesPossiveisPeca(pecaRandomica.getPosicao());
		}

		/*randomiza uma posicao da lista de posicoes possiveis*/
		posicaoRandomica = posicoesPossiveis.get(gerador.nextInt(posicoesPossiveis.size()));
		/*pega a peca na posicao randomica de destino*/
		pecaDestino = jogo.getTabuleiro().getCasas(posicaoRandomica.getColuna(), posicaoRandomica.getLinha());
			
		/* se a peca de destino for null, movimenta a peca */
		if (pecaDestino == null) {
			movimentarPecaZeus(pecaRandomica, posicaoRandomica);
		/* senao, realiza uma captura */
		} else {
			capturarPecaZeus(pecaRandomica, posicaoRandomica);
		}
	}
	
	/** Move uma peça para a posição especificada, e anuncia a jogada.
	 * @param pecaRandomica - a peça que será movida.
	 * @param posicaoRandomica - a posição para a qual a pecaRandomica será movida.
	 */
	private void movimentarPecaZeus(PecaAbstrata pecaRandomica, Posicao posicaoRandomica) {
		
		controladorTela.exibirMensagem("Zeus fez o comando "
				+ (pecaRandomica.getPosicao().getColuna()+1) + ""
				+ (pecaRandomica.getPosicao().getLinha()+1) + ""
				+ (posicaoRandomica.getColuna()+1) + ""
				+ (posicaoRandomica.getLinha()+1) + ".");
		
		if(pecaRandomica.getNome().equals(NomePecas.rei)){
			jogo.getTabuleiro().setPosicaoReiPreto(posicaoRandomica);
			pecaRandomica.actMovimentou();
		}

		/*nao eh necessario fazer verificacoes de movimento, pois a funcao que retorna a lista de posicoes possiveis
		 * ja cuida disso*/
		jogo.getTabuleiro().moverPeca(
				pecaRandomica.getPosicao().getColuna(),
				pecaRandomica.getPosicao().getLinha(),
				posicaoRandomica.getColuna(),
				posicaoRandomica.getLinha());

	}

	/** Captura uma peça e faz as devidas alterações e anúncios.
	 * @param pecaRandomica - a peça que fara o movimento.
	 * @param posicaoRandomica - a posição da peça que será capturada.
	 */
	private void capturarPecaZeus(PecaAbstrata pecaRandomica, Posicao posicaoRandomica) {
		
		controladorTela.exibirMensagem("Zeus fez o comando "
				+ (pecaRandomica.getPosicao().getColuna()+1) + ""
				+ (pecaRandomica.getPosicao().getLinha()+1) + "x"
				+ (posicaoRandomica.getColuna()+1) + ""
				+ (posicaoRandomica.getLinha()+1) + ".");

		/* se a peca movida for o rei, atualiza sua posicao */
		if (pecaRandomica.getNome().equals(NomePecas.rei)) {
			jogo.getTabuleiro().setPosicaoReiPreto(posicaoRandomica);
			pecaRandomica.actMovimentou();
		}
		/* por fim captura a peca */
		PecaAbstrata pecaCapturada = jogo.getTabuleiro().capturarPeca(
				pecaRandomica.getPosicao(), posicaoRandomica);
		/* remove a peca da lista das brancas */
		jogo.getTabuleiro().getPecasBrancas().remove(pecaCapturada);
		/* e adiciona a sua lista de pecas capturadas */
		jogo.getVez().getPecasCapturadas().add(pecaCapturada);
		if (jogo.getQuantidadePecasCapturadas() == 0)
			controladorTela.exibirMensagem("FIRST BLOOD!");
		controladorTela.exibirMensagem(jogo.getVez().getNome() + " capturou "
				+ pecaCapturada.getNome() + "! Mais "
				+ pecaCapturada.getValor() + " pontos para voce!");
		jogo.setQuantidadePecasCapturadas(jogo.getQuantidadePecasCapturadas() + 1);
				
		
	}
	private Jogada espelharJogada(Jogada jogada) {
		
		Jogada jogadaEspelhada = new Jogada();
		
		jogadaEspelhada.getPosicaoInicial().setColuna(Math.abs(jogada.getPosicaoInicial().getColuna() - 7));
		jogadaEspelhada.getPosicaoInicial().setLinha(Math.abs(jogada.getPosicaoInicial().getLinha() - 7));
		jogadaEspelhada.getPosicaoFinal().setColuna(Math.abs(jogada.getPosicaoFinal().getColuna() - 7));
		jogadaEspelhada.getPosicaoFinal().setLinha(Math.abs(jogada.getPosicaoFinal().getLinha() - 7));
		jogadaEspelhada.setTipoJogada(jogada.getTipoJogada());
		
		return jogadaEspelhada;
	}

	private void controlarMovimentoPeca(Jogada jogada) {
		try {
			movimentarPeca(jogada.getPosicaoInicial(), jogada.getPosicaoFinal());
		} catch (PecaAlheiaException | MovimentoInvalidoException | CaminhoBloqueadoException | CasaVaziaException e) {
			controladorTela.exibirMensagem(e.getMessage());
			controlarComandoRecebido();
		}
	}
	
	private void controlarCapturaPeca(Jogada jogada) {
		try {
			capturarPeca(jogada.getPosicaoInicial(), jogada.getPosicaoFinal());
		} catch (CasaVaziaException | PecaAlheiaException
				| CaminhoBloqueadoException | MovimentoInvalidoException
				| CapturaInvalidaPecaInexistenteException
				| CapturaInvalidaPecaPropriaException e) {
			controladorTela.exibirMensagem(e.getMessage());
			controlarComandoRecebido();
		}
	}

	private void controlarXeque() {
		/* se for a vez do branco, valida o cheque no rei preto */
		if (jogo.getVez().equals(jogo.getBranco())) {
			/* verifica xeque */
			if (validarXeque(jogo.getTabuleiro().getPosicaoReiPreto(), jogo
					.getTabuleiro().getPecasBrancas())) {
				/* verifica xeque-mate */
				if (validarXequeMate(jogo.getTabuleiro().getPosicaoReiPreto(),
						jogo.getTabuleiro().getPecasBrancas())) {
					finalizarJogo(jogo.getBranco(), jogo.getPreto());
				} else {
					controladorTela.exibirMensagem("XEQUE do jogador " + jogo.getVez().getNome() + "!");
				}
			}
		/* senao, valida o xeque no rei branco */
		} else {
			/* verifica xeque */
			if (validarXeque(jogo.getTabuleiro().getPosicaoReiBranco(), jogo
					.getTabuleiro().getPecasPretas())) {
				/* verifica xeque-mate */
				if (validarXequeMate(jogo.getTabuleiro().getPosicaoReiBranco(),
						jogo.getTabuleiro().getPecasPretas())) {
					finalizarJogo(jogo.getPreto(), jogo.getBranco());
				} else {
					controladorTela.exibirMensagem("XEQUE do jogador " + jogo.getVez().getNome() + "!");
				}
			}
		}
		
	}

	private void finalizarJogo(Jogador vencedor, Jogador perdedor) {
		
		controladorTela.exibirMensagem("XEQUE-MATE do jogador " + vencedor.getNome() + ", parabéns!\n");
		jogo.setDataHoraFim(new GregorianCalendar());
		
		adicionarHistoricoJogo(vencedor.getNome());
		adicionarHistoricoJogadorVitoria(vencedor.getNome());
		adicionarHistoricoJogadorDerrota(perdedor.getNome());
                highScore.addVencedor(vencedor.getNome());
		
		jogo.setEmAndamento(false);
		controlarMenuInicial();
				
	}

	/** Verifica se o posicionamento das peças no tabuleiro configuram um xeque.
	 * @param posicaoRei - posição do rei que está sob ameaça de xeque.
	 * @param pecasAtacantes - lista de peças do jogador que está ameaçando o rei.
	 * @return true se o rei está em xeque.
	 */
	private boolean validarXeque(Posicao posicaoRei, List<PecaAbstrata> pecasAtacantes) {
		
		for (PecaAbstrata peca : pecasAtacantes) {
			/* verifica se a peca consegue capturar o rei */
			if (peca.capturar(posicaoRei)) {
				/*
				 * verifica se a peca tem caminho desobstruido para capturar o
				 * rei
				 */
				if (jogo.getTabuleiro().verificaCaminhoXeque(peca.getPosicao(),
						posicaoRei, jogo)) {
					/* esse momento configura XEQUE */
					return true;
				}
			}
		}
		return false;
	}
	
	/** Verifica se o posicionamento das peças configuram um xeque-mate.
	 * @param posicaoRei - posição do rei que está sob ameaça
	 * @param pecasAtacantes - lista de peças do jogador que está ameaçando o rei
	 * @return true se o rei está sob xeque-mate
	 */
	private boolean validarXequeMate(Posicao posicaoRei, List<PecaAbstrata> pecasAtacantes) {
		
		/*quantidade de posicoes seguras que o rei pode se movimentar*/
		int posicoesSeguras;
		/*pega todas as posicoes ao redor do rei*/
		List<Posicao> posicoesAdjacentesRei = posicoesAdjacentesPeca(posicaoRei);
		/*verifica de quais posicoes ao redor do rei sao viaveis para realizacao de um movimento*/
		posicoesAdjacentesRei = movimentosPossiveisRei(posicoesAdjacentesRei);
		posicoesSeguras = posicoesAdjacentesRei.size();
		
		/*para cada posicao possivel, verifica se ela esta sob ameaca*/
		for (Posicao posicao : posicoesAdjacentesRei) {
			for (PecaAbstrata peca : pecasAtacantes) {
				/* verifica se a peca consegue capturar o rei */
				if(peca.capturar(posicao)){
					/*
					 * verifica se a peca tem caminho desobstruido para capturar o
					 * rei
					 */
					if(jogo.getTabuleiro().verificaCaminhoXeque(peca.getPosicao(), posicao, jogo)){
						/*essa posicao nao eh segura*/
						posicoesSeguras--;
						break;
					}
				}
			}
		}
		/*se o rei nao tiver posicoes seguras para se movimentar, eh xeque-mate*/
		if(posicoesSeguras == 0)
			return true;
		return false;
		
	}

	/** Encontra as posições adjacentes de uma peca/posicao, incluindo a propria posição.
	 * @param posicao - a posição em que a peça se encontra.
	 * @return A lista de posições encontradas.
	 */
	private List<Posicao> posicoesAdjacentesPeca(Posicao posicao){
		
		List<Posicao> posicoesAdjacentes = new ArrayList<>();
		int coluna;
		int linha;
		
		for(int varianteColuna = -1; varianteColuna < 2; varianteColuna++){
			for(int varianteLinha = -1; varianteLinha < 2; varianteLinha++){
				coluna = posicao.getColuna();
				linha = posicao.getLinha();
				coluna += varianteColuna;
				linha += varianteLinha;
				if(coluna >= 0 && coluna <= 7)
					if(linha >= 0 && linha <= 7)
						posicoesAdjacentes.add(new Posicao(coluna, linha));
			}
		}
			
		return posicoesAdjacentes;
	}
	
	
	/** Valida para quais posições o rei pode se movimentar/capturar, excluindo a propria posicao. 
	 * @param posicoesAdjacentes - todas as posições em torno do rei
	 * @return A lista de posições que o rei pode se movimentar e/ou capturar alguma peça.
	 */
	private List<Posicao> movimentosPossiveisRei(List<Posicao> posicoesAdjacentes){
		
		Iterator<Posicao> iterator = posicoesAdjacentes.iterator();
		/*a vez do jogador eh alterada para verificar se as pecas ao redor do rei sao da mesma cor que ele*/
		mudarVezJogador();
		
		while(iterator.hasNext()){
			Posicao posicao = iterator.next();
			PecaAbstrata peca = jogo.getTabuleiro().getCasas(posicao.getColuna(), posicao.getLinha());
			/*se a peca for null, nao eh preciso remover, pois o rei pode se movimentar para la*/
			if(peca != null){
				/*se a peca NAO for null, eh preciso verificar se a peca eh da mesma cor que o rei.
				 * se nao for, significa que o rei pode realizar uma captura naquela posicao, entao nada eh feito*/
				if(peca.getCor().equals(jogo.getVez().getCor()))
					/*se for, significa que o rei nao pode se movimentar para aquela posicao*/
					iterator.remove();
			}
		}
		/*volta a vez para o jogador original*/
		mudarVezJogador();
		
		return posicoesAdjacentes;
		
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
			
			adicionarHistoricoJogo("Empate");
			adicionarHistoricoJogadorEmpate();
			
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
                                highScore.addVencedor(nome);
				break;
			}
		}
                
	}
	
	private void adicionarHistoricoJogo(String vencedor){
		HistoricoPartida partida = new HistoricoPartida();
		partida.setDataHoraInicio(jogo.getDataHoraInicio());
		partida.setDataHoraFim(jogo.getDataHoraFim());
		partida.setVencedor(vencedor);
		partidas.add(partida);
	}
	
	private void adicionarHistoricoJogadorVitoria(String vencedor){
		
		if(estahNaLista(jogadores, vencedor))
			aumentarVitoriaJogador(jogadores, vencedor);
		else{
			HistoricoJogador jogador = new HistoricoJogador(vencedor);
			jogador.setVitorias(jogador.getVitorias() + 1);
			jogadores.add(jogador);
		}
	}
	
	private void adicionarHistoricoJogadorDerrota(String perdedor){
		
		if(estahNaLista(jogadores, perdedor))
			aumentarDerrotaJogador(jogadores, perdedor);
		else{
			HistoricoJogador jogador = new HistoricoJogador(perdedor);
			jogador.setDerrotas(jogador.getDerrotas() + 1);
			jogadores.add(jogador);
		}
	}
	
	private void aumentarDerrotaJogador(List<HistoricoJogador> listaJogadores, String perdedor) {

		for(HistoricoJogador jogador : listaJogadores){
			if(jogador.getNome().equals(perdedor)){
				jogador.setDerrotas(jogador.getDerrotas() + 1);
				break;
			}
		}
		
	}

	private void aumentarVitoriaJogador(List<HistoricoJogador> listaJogadores, String vencedor) {
		
		for(HistoricoJogador jogador : listaJogadores){
			if(jogador.getNome().equals(vencedor)){
				jogador.setVitorias(jogador.getVitorias() + 1);
				break;
			}
		}
		
	}

	private void adicionarHistoricoJogadorEmpate(){
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

	/** Tenta movimentar uma peça.
	 * @param posicaoInicial - posição inicial da peça.
	 * @param posicaoFinal - posição final da peça.
	 * @throws PecaAlheiaException - se a peça de posicaoInicial não for do jogador da vez.
	 * @throws MovimentoInvalidoException - se a peça não conseguir fazer o movimento especificado.
	 * @throws CaminhoBloqueadoException - se a peça conseguir realizar o movimento, mas tiver o caminho obstruído.
	 * @throws CasaVaziaException - se a posicaoInicial não tiver nenhuma peça.
	 */
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
				if(jogo.getTabuleiro().verificaCaminhoMovimento(posicaoInicial, posicaoFinal)){
					/*se a peca movida for um rei, atualiza sua posicao*/
					if(peca.getNome().equals(NomePecas.rei)){
						if(peca.getCor().equals(Cores.branco))
							jogo.getTabuleiro().setPosicaoReiBranco(posicaoFinal);
						else
							jogo.getTabuleiro().setPosicaoReiPreto(posicaoFinal);
						peca.actMovimentou();
					}
					jogo.getTabuleiro().moverPeca(posicaoInicial.getColuna(), posicaoInicial.getLinha(), posicaoFinal.getColuna(), posicaoFinal.getLinha());
				}
				else
					throw new CaminhoBloqueadoException();
			} else
				throw new MovimentoInvalidoException();
		}
	}
	
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
							jogo.getTabuleiro().setPosicaoReiBranco(posicaoFinal);
						else
							jogo.getTabuleiro().setPosicaoReiPreto(posicaoFinal);
						peca.actMovimentou();
					}
					PecaAbstrata pecaCapturada = jogo.getTabuleiro().capturarPeca(posicaoInicial, posicaoFinal);
					if(jogo.getVez().equals(jogo.getBranco()))
						jogo.getTabuleiro().getPecasBrancas().remove(pecaCapturada);
					else
						jogo.getTabuleiro().getPecasPretas().remove(pecaCapturada);
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
			if(nomeJogadores[1] == "ZEUS")
				iniciarJogoSingleplayer(nomeJogadores);
			else
				iniciarJogoMultiplayer(nomeJogadores);
			break;
		case 2:
			controladorTela.controlarDadosPartidas(partidas, jogadores);
			controlarMenuInicial();
			break;
		default:
			controladorTela.controlarSair();
		}
	}
	
	private void iniciarJogoSingleplayer(String[] nomeJogadores) {
		
		Jogador branco = new Jogador(nomeJogadores[0], Cores.branco);
		Jogador preto = new Jogador(nomeJogadores[1], Cores.preto);
                
		Tabuleiro tabuleiro = new Tabuleiro();
		
		jogo = new Jogo(tabuleiro, branco, preto);
		
		controlarJogoSingleplayer();
		
	}

	private void controlarJogoSingleplayer() {
		
		while(jogo.isEmAndamento())
			realizarJogadaSingleplayer();
		
	}

	private void realizarJogadaSingleplayer() {
		
		controladorTela.mostrarTabuleiro(jogo.getTabuleiro());
		
		if(jogo.getVez().equals(jogo.getBranco()))
			controlarComandoRecebido();
		else
			controlarComandoZeus();
			
		if(jogo.getVez().getPontuacao() >= 999){
			Jogador vencedor;
			Jogador perdedor;
			vencedor = jogo.getVez();
			mudarVezJogador();
			perdedor = jogo.getVez();
			finalizarJogo(vencedor, perdedor);
		}
		mudarVezJogador();
		
	}

	private void iniciarJogoMultiplayer(String[] nomeJogadores)
	{	
		
		Jogador branco = new Jogador(nomeJogadores[0], Cores.branco);
		Jogador preto = new Jogador(nomeJogadores[1], Cores.preto);
                
		Tabuleiro tabuleiro = new Tabuleiro();
		
		jogo = new Jogo(tabuleiro, branco, preto);
		
		controlarJogoMultiplayer();
	}
	
	
	private void controlarJogoMultiplayer()
	{	
		while(jogo.isEmAndamento())
			realizarJogadaMultiplayer();
	}	
	
	private void realizarJogadaMultiplayer(){
		
		controladorTela.mostrarTabuleiro(jogo.getTabuleiro());
		controlarComandoRecebido();
		if(jogo.getVez().getPontuacao() >= 999){
			Jogador vencedor;
			Jogador perdedor;
			vencedor = jogo.getVez();
			mudarVezJogador();
			perdedor = jogo.getVez();
			finalizarJogo(vencedor, perdedor);
		}
		mudarVezJogador();
	}
	
	/** Muda a vez do jogador atual.
	 * 
	 */
	private void mudarVezJogador()
	{
		if(jogo.getVez().equals(jogo.getBranco()))
			jogo.setVez(jogo.getPreto());
		else
			jogo.setVez(jogo.getBranco());
	}
}
