package ifes.poo1.xadrez.model.cdp.tabuleiro;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Jogo;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Bispo;
import ifes.poo1.xadrez.model.cdp.pecas.Cavalo;
import ifes.poo1.xadrez.model.cdp.pecas.Peao;
import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;
import ifes.poo1.xadrez.model.cdp.pecas.Rainha;
import ifes.poo1.xadrez.model.cdp.pecas.Rei;
import ifes.poo1.xadrez.model.cdp.pecas.Torre;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaInexistenteException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaPropriaException;
import ifes.poo1.xadrez.util.exception.RoqueInvalidoReiMovimentadoException;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

	private PecaAbstrata[][] casas = new PecaAbstrata[8][8];
	private List<PecaAbstrata> pecasBrancas = new ArrayList<>();
	private List<PecaAbstrata> pecasPretas = new ArrayList<>();
	/*
	 * posicaoReiBranco e posicaoReiPreto serao usados para determinar se houve
	 * cheque ou cheque-mate
	 *
	*
	 * foi decidido criar um atributo que explicite a posicao dos reis por uma
	 * questao de desempenho, ou seja, nao sera necessario buscar a posicao dos
	 * reis sempre que a verificacao do xeque for realizada
	 */
        
	private Posicao posicaoReiBranco;
	private Posicao posicaoReiPreto;

	// o met�do construtor insere as pe�as no tabuleiro
	public Tabuleiro() {

		// inserindo os pe�es
		for (int i = 0; i < 8; i++) {
			PecaAbstrata peao = new Peao(Cores.branco);
			casas[1][i] = peao;
			pecasBrancas.add(peao);
			peao.setPosicao(new Posicao(i, 1));

			peao = new Peao(Cores.preto);
			casas[6][i] = peao;
			pecasPretas.add(peao);
			peao.setPosicao(new Posicao(i, 6));

		}

		// inserindo as torres
		PecaAbstrata torre = new Torre(Cores.branco);
		casas[0][0] = torre;
		pecasBrancas.add(torre);
		torre.setPosicao(new Posicao(0, 0));

		torre = new Torre(Cores.branco);
		casas[0][7] = torre;
		pecasBrancas.add(torre);
		torre.setPosicao(new Posicao(7, 0));

		torre = new Torre(Cores.preto);
		casas[7][0] = torre;
		pecasPretas.add(torre);
		torre.setPosicao(new Posicao(0, 7));

		torre = new Torre(Cores.preto);
		casas[7][7] = torre;
		pecasPretas.add(torre);
		torre.setPosicao(new Posicao(7, 7));

		// inserindo os cavalos
		PecaAbstrata cavalo = new Cavalo(Cores.branco);
		casas[0][1] = cavalo;
		pecasBrancas.add(cavalo);
		cavalo.setPosicao(new Posicao(1, 0));

		cavalo = new Cavalo(Cores.branco);
		casas[0][6] = cavalo;
		pecasBrancas.add(cavalo);
		cavalo.setPosicao(new Posicao(6, 0));

		cavalo = new Cavalo(Cores.preto);
		casas[7][1] = cavalo;
		pecasPretas.add(cavalo);
		cavalo.setPosicao(new Posicao(1, 7));

		cavalo = new Cavalo(Cores.preto);
		casas[7][6] = cavalo;
		pecasPretas.add(cavalo);
		cavalo.setPosicao(new Posicao(6, 7));

		// inserindo os bispos
		PecaAbstrata bispo = new Bispo(Cores.branco);
		casas[0][2] = bispo;
		pecasBrancas.add(bispo);
		bispo.setPosicao(new Posicao(2, 0));

		bispo = new Bispo(Cores.branco);
		casas[0][5] = bispo;
		pecasBrancas.add(bispo);
		bispo.setPosicao(new Posicao(5, 0));

		bispo = new Bispo(Cores.preto);
		casas[7][2] = bispo;
		pecasPretas.add(bispo);
		bispo.setPosicao(new Posicao(2, 7));

		bispo = new Bispo(Cores.preto);
		casas[7][5] = bispo;
		pecasPretas.add(bispo);
		bispo.setPosicao(new Posicao(5, 7));

		// inserindo rei e dama
		PecaAbstrata rei = new Rei(Cores.branco);
		casas[0][4] = rei;
		pecasBrancas.add(rei);
		rei.setPosicao(new Posicao(4, 0));
		posicaoReiBranco = new Posicao(4, 0);

		rei = new Rei(Cores.preto);
		casas[7][4] = rei;
		pecasPretas.add(rei);
		rei.setPosicao(new Posicao(4, 7));
		posicaoReiPreto = new Posicao(4, 7);

		PecaAbstrata dama = new Rainha(Cores.branco);
		casas[0][3] = dama;
		pecasBrancas.add(dama);
		dama.setPosicao(new Posicao(3, 0));

		dama = new Rainha(Cores.preto);
		casas[7][3] = dama;
		pecasPretas.add(dama);
		dama.setPosicao(new Posicao(3, 7));

	}

	public PecaAbstrata getCasas(int coluna, int linha) {
		return casas[linha][coluna];
	}

	public void setCasas(PecaAbstrata peca, int coluna, int linha) {
		this.casas[linha][coluna] = peca;
	}
        
        /**
         * Move uma peça de um ponto inicial para um ponto final.
         * @param colunaInicial
         * @param linhaInicial
         * @param colunaFinal
         * @param linhaFinal 
         */
	public void moverPeca(int colunaInicial, int linhaInicial, int colunaFinal,
			int linhaFinal) {

		PecaAbstrata peca = this.getCasas(colunaInicial, linhaInicial);
		this.setCasas(peca, colunaFinal, linhaFinal);
		this.setCasas(null, colunaInicial, linhaInicial);
		peca.getPosicao().setColuna(colunaFinal);
		peca.getPosicao().setLinha(linhaFinal);

	}

        /**
         * Captura uma peça na posição final.
         * @param posicaoInicial
         * @param posicaoFinal
         * @return 
         */
	public PecaAbstrata capturarPeca(Posicao posicaoInicial,
			Posicao posicaoFinal) {

		PecaAbstrata peca = this.getCasas(posicaoInicial.getColuna(),
				posicaoInicial.getLinha());
		PecaAbstrata pecaCapturada = this.getCasas(posicaoFinal.getColuna(),
				posicaoFinal.getLinha());
		this.setCasas(peca, posicaoFinal.getColuna(), posicaoFinal.getLinha());
		this.setCasas(null, posicaoInicial.getColuna(),
				posicaoInicial.getLinha());
		peca.setPosicao(posicaoFinal);

		return pecaCapturada;

	}
        /**Verifica se a torre pode fazer tal caminho.
         * 
         * @param posicaoInicial
         * @param posicaoFinal
         * @return booleano: true (pode) ou false (não pode)
         */
	public boolean verificaCaminhoTorre(Posicao posicaoInicial,
			Posicao posicaoFinal) {

		/* movimento horizontal */
		if (posicaoInicial.getLinha() == posicaoFinal.getLinha()) {
			int colunaVariante;
			int colunaInicial = posicaoInicial.getColuna();
			/* verifica a posicao de movimentacao */
			if (posicaoFinal.getColuna() > posicaoInicial.getColuna())
				/* direita */
				colunaVariante = 1;
			else
				/* esquerda */
				colunaVariante = -1;
			for (int i = 0; i < Math.abs(posicaoFinal.getColuna()
					- posicaoInicial.getColuna()) - 1; i++) {
				colunaInicial += colunaVariante;
				if (this.getCasas(colunaInicial, posicaoInicial.getLinha()) != null)
					return false;
			}
			/* movimento vertical */
		} else {
			int linhaVariante;
			int linhaInicial = posicaoInicial.getLinha();
			/* verifica a posicao de movimentacao */
			if (posicaoFinal.getLinha() > posicaoInicial.getLinha())
				/* cima */
				linhaVariante = 1;
			else
				/* baixo */
				linhaVariante = -1;
			for (int i = 0; i < Math.abs(posicaoFinal.getLinha()
					- posicaoInicial.getLinha()) - 1; i++) {
				linhaInicial += linhaVariante;
				if (this.getCasas(posicaoInicial.getColuna(), linhaInicial) != null)
					return false;
			}
		}
		return true;
	}

	/**
	 * Dada uma peça, retorna uma lista de possíveis movimentos e/ou capturas
	 * que ela pode realizar.
	 * 
	 * @param posicao
	 *            - a posição da peça.
	 * @return A lista de possíveis movimentos.
	 */
	public List<Posicao> posicoesPossiveisPeca(Posicao posicao) {

		List<Posicao> posicoesPossiveis = new ArrayList<>();
		PecaAbstrata peca = this.getCasas(posicao.getColuna(),
				posicao.getLinha());

		switch (peca.toString()) {
		// verificacao do peao
		case "P":
			posicoesPossiveis = posicoesPossiveisPeaoPreto(posicao);
			break;
		// verificacao do cavalo
		case "C":
			posicoesPossiveis = posicoesPossiveisCavalo(posicao);
			break;
		// verificacao da torre
		case "T":
			posicoesPossiveis = posicoesPossiveisTorre(posicao);
			break;
		// verificacao do bispo
		case "B":
			posicoesPossiveis = posicoesPossiveisBispo(posicao);
			break;
		// verificacao da rainha
		case "D":
			posicoesPossiveis = posicoesPossiveisRainha(posicao);
			break;
		// verificacao do rei
		case "R":
			posicoesPossiveis = posicoesPossiveisRei(posicao);
		}

		return posicoesPossiveis;
	}

	/**
	 * Retorna uma lista de posições possíveis que uma torre pode se movimentar
	 * ou capturar.
	 * 
	 * @param posicao
	 *            - a posição da torre.
	 * @return A lista com as posições possíveis.
	 */
	private List<Posicao> posicoesPossiveisTorre(Posicao posicao) {

		List<Posicao> posicoesPossiveis = new ArrayList<>();
		int[] posicoesVariantes = new int[2];
		int colunaAtual, linhaAtual;

		/*
		 * a cada etapa de iteracao serao verificadas uma horizontal e uma
		 * vertical. o sentido da verificacao depende do sinhal do numero, a
		 * saber: 1- direita e cima 2- esquerda e baixo
		 */
		posicoesVariantes[0] = 1;
		posicoesVariantes[1] = -1;

		/* inicializa a posicao original */
		colunaAtual = posicao.getColuna();
		linhaAtual = posicao.getLinha();

		for (int posicaoVariante = 0; posicaoVariante <= 1; posicaoVariante++) {
			/* movimento horizontal */
			colunaAtual += posicoesVariantes[posicaoVariante];
			/*
			 * verifica se a posicao esta dentro do tabuleiro. nao eh necessario
			 * verificar a linha, pois a mesma nao eh alterada
			 */
			while (colunaAtual >= 0 && colunaAtual <= 7) {
				PecaAbstrata peca = this.getCasas(colunaAtual, linhaAtual);
				/* verifica se tem alguma coisa na posicao */
				if (peca != null) {
					/*
					 * se tiver e a cor for branca, pode capturar alem disso,
					 * nao eh necessario continuar verificando a reta apos
					 * encontrar o primeiro obstaculo
					 */
					if (peca.getCor().equals(Cores.branco))
						posicoesPossiveis.add(new Posicao(colunaAtual,
								linhaAtual));
					break;
				} else {
					/* pode se mover para a posicao */
					posicoesPossiveis.add(new Posicao(colunaAtual, linhaAtual));
					colunaAtual += posicoesVariantes[posicaoVariante];
				}

			}

			/* movimento vertical */
			/* reseta a coluna */
			colunaAtual = posicao.getColuna();
			linhaAtual += posicoesVariantes[posicaoVariante];
			/*
			 * verifica se a posicao esta dentro do tabuleiro. nao eh necessario
			 * verificar a coluna, pois a mesma nao eh alterada
			 */
			while (linhaAtual >= 0 && linhaAtual <= 7) {
				PecaAbstrata peca = this.getCasas(colunaAtual, linhaAtual);
				/* verifica se tem alguma coisa na posicao */
				if (peca != null) {
					/*
					 * se tiver e a cor for branca, pode capturar alem disso,
					 * nao eh necessario continuar verificando a reta apos
					 * encontrar o primeiro obstaculo
					 */
					if (peca.getCor().equals(Cores.branco))
						posicoesPossiveis.add(new Posicao(colunaAtual,
								linhaAtual));
					break;
				} else {
					/* pode se mover para a posicao */
					posicoesPossiveis.add(new Posicao(colunaAtual, linhaAtual));
					linhaAtual += posicoesVariantes[posicaoVariante];
				}
			}
			/* reseta a linha */
			linhaAtual = posicao.getLinha();

		}

		return posicoesPossiveis;
	}

	/**
	 * Retorna uma lista de posições possíveis que um bispo pode se movimentar
	 * ou capturar.
	 * 
	 * @param posicao
	 *            - a posição do bispo.
	 * @return A lista com as posições possíveis.
	 */
	private List<Posicao> posicoesPossiveisBispo(Posicao posicao) {

		List<Posicao> posicoesPossiveis = new ArrayList<>();
		int[] posicoesVariantes = new int[2];
		int colunaAtual, linhaAtual;

		/*
		 * a combinacao das posicoes variantes fara o bispo se mover nas quatro
		 * diagonais, a saber:11 -> diagonal direita superior *1-1 -> diagonal
		 * direita inferior *-11 -> diagonal esquerda superior *-1-1 -> diagonal
		 * esquerda inferior
		 */
		posicoesVariantes[0] = 1;
		posicoesVariantes[1] = -1;

		/* os for determinam a direcao */
		for (int colunaVariante = 0; colunaVariante <= 1; colunaVariante++) {
			for (int linhaVariante = 0; linhaVariante <= 1; linhaVariante++) {
				/* reseta a posicao inicial para verificar outra diagonal */
				colunaAtual = posicao.getColuna();
				linhaAtual = posicao.getLinha();
				colunaAtual += posicoesVariantes[colunaVariante];
				linhaAtual += posicoesVariantes[linhaVariante];
				/* verifica se a posicao esta dentro do tabuleiro */
				while (colunaAtual >= 0 && colunaAtual <= 7 && linhaAtual >= 0
						&& linhaAtual <= 7) {
					PecaAbstrata peca = this.getCasas(colunaAtual, linhaAtual);
					/* verifica se tem alguma coisa na posicao */
					if (peca != null) {
						/*
						 * se tiver e a cor for branca, pode capturar alem
						 * disso, nao eh necessario continuar verificando a
						 * diagonal apos encontrar o primeiro obstaculo
						 */
						if (peca.getCor().equals(Cores.branco))
							posicoesPossiveis.add(new Posicao(colunaAtual,
									linhaAtual));
						break;
					} else {
						/* pode se mover para a posicao */
						posicoesPossiveis.add(new Posicao(colunaAtual,
								linhaAtual));
						colunaAtual += posicoesVariantes[colunaVariante];
						linhaAtual += posicoesVariantes[linhaVariante];
					}
				}
			}
		}

		return posicoesPossiveis;

	}

	/**
	 * Retorna uma lista de posições possíveis que uma rainha pode se movimentar
	 * ou capturar.
	 * 
	 * @param posicao
	 *            - a posição da rainha.
	 * @return A lista com as posições possíveis.
	 */
	private List<Posicao> posicoesPossiveisRainha(Posicao posicao) {

		List<Posicao> posicoesPossiveis = new ArrayList<>();

		posicoesPossiveis = posicoesPossiveisBispo(posicao);
		posicoesPossiveis.addAll(posicoesPossiveisTorre(posicao));

		return posicoesPossiveis;

	}

	/**
	 * Retorna uma lista de posições possíveis que um rei pode se movimentar ou
	 * capturar.
	 * 
	 * @param posicao
	 *            - a posição da rei.
	 * @return A lista com as posições possíveis.
	 */
	private List<Posicao> posicoesPossiveisRei(Posicao posicao) {

		List<Posicao> posicoesPossiveis = new ArrayList<>();
		PecaAbstrata peca;
		int coluna;
		int linha;

		for (int varianteColuna = -1; varianteColuna < 2; varianteColuna++) {
			for (int varianteLinha = -1; varianteLinha < 2; varianteLinha++) {
				coluna = posicao.getColuna();
				linha = posicao.getLinha();
				coluna += varianteColuna;
				linha += varianteLinha;
				if (coluna >= 0 && coluna <= 7)
					if (linha >= 0 && linha <= 7) {
						peca = this.getCasas(coluna, linha);
						/* verifica se tem alguma coisa na posicao */
						if (peca != null) {
							/* se tiver e a cor for branca, pode capturar */
							if (peca.getCor().equals(Cores.branco))
								posicoesPossiveis
										.add(new Posicao(coluna, linha));
						} else
							/* pode se mover para a posicao */
							posicoesPossiveis.add(new Posicao(coluna, linha));
					}
			}
		}

		return posicoesPossiveis;
	}

	/**
	 * Retorna uma lista de posições possíveis que um cavalo pode se movimentar
	 * ou capturar.
	 * 
	 * @param posicao
	 *            - a posição da cavalo.
	 * @return A lista com as posições possíveis.
	 */
	private List<Posicao> posicoesPossiveisCavalo(Posicao posicao) {

		List<Posicao> posicoesPossiveis = new ArrayList<>();
		int[] posicoesVariantesMaior = new int[2];
		int[] posicoesVariantesMenor = new int[2];
		int colunaAtual, linhaAtual;

		/*
		 * as posicoes variantes irao servir para fazer o cavalo andar duas
		 * casas horizontais ou verticais e uma casa vertical ou horizontal
		 */
		posicoesVariantesMaior[0] = 2;
		posicoesVariantesMaior[1] = -2;
		posicoesVariantesMenor[0] = 1;
		posicoesVariantesMenor[1] = -1;

		/*
		 * a cada iteracao, serao verificadas dois movimentos, os que se movem:
		 * 1- duas colunas e uma linha 2- duas linhas e uma coluna a direcao do
		 * movimento varia de acordo com o sinal do numero: + para cima e para
		 * direita - para baixo e para esquerda
		 */
		for (int varianteMaior = 0; varianteMaior <= 1; varianteMaior++) {
			for (int varianteMenor = 0; varianteMenor <= 1; varianteMenor++) {
				/* reseta a posicao inicial */
				colunaAtual = posicao.getColuna();
				linhaAtual = posicao.getLinha();
				/* duas colunas e uma linha */
				colunaAtual += posicoesVariantesMaior[varianteMaior];
				linhaAtual += posicoesVariantesMenor[varianteMenor];
				/* verifica se a posicao esta dentro do tabuleiro */
				if (colunaAtual >= 0 && colunaAtual <= 7) {
					if (linhaAtual >= 0 && linhaAtual <= 7) {
						PecaAbstrata peca = this.getCasas(colunaAtual,
								linhaAtual);
						/* verifica se tem alguma coisa na posicao */
						if (peca != null) {
							/* se tiver e a cor for branca, pode capturar */
							if (peca.getCor().equals(Cores.branco))
								posicoesPossiveis.add(new Posicao(colunaAtual,
										linhaAtual));
						} else
							/* pode se mover para a posicao */
							posicoesPossiveis.add(new Posicao(colunaAtual,
									linhaAtual));
					}
				}

				/* reseta a posicao inicial */
				colunaAtual = posicao.getColuna();
				linhaAtual = posicao.getLinha();
				/* duas linha e uma coluna */
				colunaAtual += posicoesVariantesMenor[varianteMenor];
				linhaAtual += posicoesVariantesMaior[varianteMaior];
				/* verifica se a posicao esta dentro do tabuleiro */
				if (colunaAtual >= 0 && colunaAtual <= 7) {
					if (linhaAtual >= 0 && linhaAtual <= 7) {
						PecaAbstrata peca = this.getCasas(colunaAtual,
								linhaAtual);
						/* verifica se tem alguma coisa na posicao */
						if (peca != null) {
							/* se tiver e a cor for branca, pode capturar */
							if (peca.getCor().equals(Cores.branco))
								posicoesPossiveis.add(new Posicao(colunaAtual,
										linhaAtual));
						} else
							/* pode se mover para a posicao */
							posicoesPossiveis.add(new Posicao(colunaAtual,
									linhaAtual));
					}
				}
			}
		}

		return posicoesPossiveis;
	}

	/**
	 * Retorna uma lista com todas as posições de movimento e captura que um
	 * peão consegue realizar.
	 * 
	 * @param posicao
	 *            - a posição na qual o peão se encontra;
	 * @return A lista com as posições possíveis.
	 */
	private List<Posicao> posicoesPossiveisPeaoPreto(Posicao posicao) {

		List<Posicao> posicoesPossiveis = new ArrayList<>();

		posicoesPossiveis.addAll(capturasPossiveisPeaoPreto(posicao));
		posicoesPossiveis.addAll(movimentosPossiveisPeaoPreto(posicao));

		return posicoesPossiveis;

	}

	/**
	 * Retorna a lista de posições possiveis que um peão consegue capturar
	 * alguma peça.
	 * 
	 * @param posicao
	 *            - a posição em que o peão se encontra.
	 * @return - a lista de posições possíveis.
	 */
	private List<Posicao> capturasPossiveisPeaoPreto(Posicao posicao) {

		List<Posicao> capturasPossiveis = new ArrayList<>();
		PecaAbstrata peca;

		/* verifica se nao esta na primeira linha */
		if (posicao.getLinha() - 1 >= 0) {
			/* verifica se nao esta na primeira coluna */
			if (posicao.getColuna() - 1 >= 0) {
				peca = this.getCasas(posicao.getColuna() - 1,
						posicao.getLinha() - 1);
				if (peca != null)
					/* se a peca de destino for branca, pode capturar */
					if (peca.getCor().equals(Cores.branco))
						capturasPossiveis
								.add(new Posicao(posicao.getColuna() - 1,
										posicao.getLinha() - 1));
			}
			/* verifica se nao esta na ultima coluna */
			if (posicao.getColuna() + 1 <= 7) {
				peca = this.getCasas(posicao.getColuna() + 1,
						posicao.getLinha() - 1);
				if (peca != null)
					/* se a peca de destino for branca, pode capturar */
					if (peca.getCor().equals(Cores.branco))
						capturasPossiveis
								.add(new Posicao(posicao.getColuna() + 1,
										posicao.getLinha() - 1));
			}
		}

		return capturasPossiveis;

	}

	/**
	 * Retorna uma lista com todas as posições possíveis que um peão consegue se
	 * movimentar.
	 * 
	 * @param posicao
	 *            - a posição do peão do qual deseja-se saber as posições
	 *            possíveis.
	 * @return A lista com todas as posições possíveis de movimento do peão.
	 */
	private List<Posicao> movimentosPossiveisPeaoPreto(Posicao posicao) {

		List<Posicao> movimentosPossiveis = new ArrayList<>();

		/* movimento inicial */
		if (posicao.getLinha() == 6) {
			if (this.getCasas(posicao.getColuna(), posicao.getLinha() - 1) == null) {
				movimentosPossiveis.add(new Posicao(posicao.getColuna(),
						posicao.getLinha() - 1));
				if (this.getCasas(posicao.getColuna(), posicao.getLinha() - 2) == null)
					movimentosPossiveis.add(new Posicao(posicao.getColuna(),
							posicao.getLinha() - 2));
			}
				
			return movimentosPossiveis;
		}

		/* movimento comum */
		if (posicao.getLinha() - 1 >= 0)
			if (this.getCasas(posicao.getColuna(), posicao.getLinha() - 1) == null)
				movimentosPossiveis.add(new Posicao(posicao.getColuna(),
						posicao.getLinha() - 1));

		return movimentosPossiveis;

	}

	
        /**verifica se o caminho do bispo está livre para fazer a movimentacao 
         * 
         * @param posicaoInicial
         * @param posicaoFinal
         * @return boolean
         */
	public boolean verificaCaminhoBispo(Posicao posicaoInicial,
			Posicao posicaoFinal) {

		int colunaVariante, linhaVariante;
		int colunaInicial = posicaoInicial.getColuna();
		int linhaInicial = posicaoInicial.getLinha();

		// determina a posicao de movimentacao
		if (posicaoFinal.getColuna() - posicaoInicial.getColuna() > 0)
			colunaVariante = 1;
		else
			colunaVariante = -1;

		if (posicaoFinal.getLinha() - posicaoInicial.getLinha() > 0)
			linhaVariante = 1;
		else
			linhaVariante = -1;

		for (int i = 0; i < Math.abs(posicaoFinal.getColuna()
				- posicaoInicial.getColuna()) - 1; i++) {
			colunaInicial += colunaVariante;
			linhaInicial += linhaVariante;
			if (this.getCasas(colunaInicial, linhaInicial) != null)
				return false;
		}
		return true;
	}

	/**
	 * Verifica se a peça possuia caminho livre para fazer o movimento.
	 * 
	 * @param posicaoInicial
	 * @param posicaoFinal
	 * @return true se possuir caminho livre.
	 */
	public boolean verificaCaminhoMovimento(Posicao posicaoInicial,
			Posicao posicaoFinal) {

		// verifica se tem alguma casa no destino
		if (getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha()) != null) {
			return false;
		}

		return verificaCaminhos(posicaoInicial, posicaoFinal);
	}

	private boolean verificaCaminhoRainha(Posicao posicaoInicial,
			Posicao posicaoFinal) {
		if (Math.abs(posicaoFinal.getColuna() - posicaoInicial.getColuna()) == Math
				.abs(posicaoFinal.getLinha() - posicaoInicial.getLinha()))
			return verificaCaminhoBispo(posicaoInicial, posicaoFinal);
		else
			return verificaCaminhoTorre(posicaoInicial, posicaoFinal);
	}

	public boolean verificaCaminhoCaptura(Posicao posicaoInicial,
			Posicao posicaoFinal, Jogo jogo)
			throws CapturaInvalidaPecaInexistenteException,
			CapturaInvalidaPecaPropriaException {

		// verifica se tem alguma casa no destino
		if (getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha()) == null) {
			throw new CapturaInvalidaPecaInexistenteException();
		}
		// verifica a peca que se deseja capturar eh da mesma cor que o jogador
		// que fez a captura
		if (getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha())
				.getCor().equals(jogo.getVez().getCor())) {
			throw new CapturaInvalidaPecaPropriaException();
		}

		return verificaCaminhos(posicaoInicial, posicaoFinal);
	}

	public boolean verificaCaminhoXeque(Posicao posicaoInicial,
			Posicao posicaoFinal) {

		return verificaCaminhos(posicaoInicial, posicaoFinal);
	}

	public boolean verificaCaminhos(Posicao posicaoInicial, Posicao posicaoFinal) {

		PecaAbstrata peca = getCasas(posicaoInicial.getColuna(),
				posicaoInicial.getLinha());

		switch (peca.toString()) {
		// verificacao do peao
		case "P":
			return verificaCaminhoPeao(posicaoInicial, posicaoFinal);
			// Se for cavalo, passa direto.
		case "C":
			return true;
			// verificação da torre.
		case "T":
			return verificaCaminhoTorre(posicaoInicial, posicaoFinal);
			// verificação do bispo
		case "B":
			return verificaCaminhoBispo(posicaoInicial, posicaoFinal);
			// verificação da rainha
		case "D":
			return verificaCaminhoRainha(posicaoInicial, posicaoFinal);
		}
		return true;
	}

	/**
	 * Esse método verifica se o caminho realizado por um peão em sua primeira
	 * jogada, quando este se move duas casas, é valido, ou seja, informa se o
	 * peão tem o caminho obstruído. Esse método só é chamado na situação em que
	 * o peão anda duas casas.
	 * 
	 * @param posicaoInicial
	 *            - posição inicial do peão.
	 * @param posicaoFinal
	 *            - posição para onde se quer verificar se o peão consegue fazer
	 *            o movimento.
	 * @return true se o peão não tiver o caminho obstruído.
	 */
	private boolean verificaCaminhoPeao(Posicao posicaoInicial,
			Posicao posicaoFinal) {

		/* peao preto */
		if (posicaoInicial.getLinha() == 6) {
			if (this.getCasas(posicaoInicial.getColuna(),
					posicaoInicial.getLinha() - 1) != null)
				return false;
			/* peao branco */
		} else {
			if (this.getCasas(posicaoInicial.getColuna(),
					posicaoInicial.getLinha() + 1) != null)
				return false;
		}

		return true;
	}

	public PecaAbstrata[][] getCasas() {
		return casas;
	}

	public void setCasas(PecaAbstrata[][] casas) {
		this.casas = casas;
	}

	public List<PecaAbstrata> getPecasBrancas() {
		return pecasBrancas;
	}

	public void setPecasBrancas(List<PecaAbstrata> pecasBrancas) {
		this.pecasBrancas = pecasBrancas;
	}

	public List<PecaAbstrata> getPecasPretas() {
		return pecasPretas;
	}

	public void setPecasPretas(List<PecaAbstrata> pecasPretas) {
		this.pecasPretas = pecasPretas;
	}

	public Posicao getPosicaoReiBranco() {
		return posicaoReiBranco;
	}

	public void setPosicaoReiBranco(Posicao posicaoReiBranco) {
		this.posicaoReiBranco = posicaoReiBranco;
	}

	public Posicao getPosicaoReiPreto() {
		return posicaoReiPreto;
	}

	public void setPosicaoReiPreto(Posicao posicaoReiPreto) {
		this.posicaoReiPreto = posicaoReiPreto;
	}

}
