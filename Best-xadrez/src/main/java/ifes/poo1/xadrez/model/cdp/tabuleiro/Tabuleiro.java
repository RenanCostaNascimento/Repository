package ifes.poo1.xadrez.model.cdp.tabuleiro;



import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.jogo.Jogo;
import ifes.poo1.xadrez.model.cdp.pecas.Bispo;
import ifes.poo1.xadrez.model.cdp.pecas.Cavalo;
import ifes.poo1.xadrez.model.cdp.pecas.Peao;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
import ifes.poo1.xadrez.model.cdp.pecas.Rainha;
import ifes.poo1.xadrez.model.cdp.pecas.Rei;
import ifes.poo1.xadrez.model.cdp.pecas.Torre;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaInexistenteException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaPropriaException;


public class Tabuleiro {
	
	
	
	private Peca[][] casas = new Peca[8][8];

		
	//o met�do construtor insere as pe�as no tabuleiro	
	public Tabuleiro(){
		
		//inserindo os pe�es
		for (int i = 0; i < 8; i++) {
			Peca peao = new Peao(Cores.branco);
			casas[1][i] = peao;
			peao = new Peao(Cores.preto);
			casas[6][i] = peao;
			
		} 
		
		//inserindo as torres
		Peca torre = new Torre(Cores.branco);
		casas[0][0] = torre;
		torre = new Torre(Cores.branco);
		casas[0][7] = torre;
		torre = new Torre(Cores.preto);
		casas[7][0] = torre;
		torre = new Torre(Cores.preto);
		casas[7][7] = torre;
		
		//inserindo os cavalos
		Peca cavalo = new Cavalo(Cores.branco);
		casas[0][1] = cavalo;
		cavalo = new Cavalo(Cores.branco);
		casas[0][6] = cavalo;
		cavalo = new Cavalo(Cores.preto);
		casas[7][1] = cavalo;
		cavalo = new Cavalo(Cores.preto);
		casas[7][6] = cavalo;
		
		
		//inserindo os bispos
		Peca bispo = new Bispo(Cores.branco);
		casas[0][2] = bispo;
		bispo = new Bispo(Cores.branco);
		casas[0][5] = bispo;
		bispo = new Bispo(Cores.preto);
		casas[7][2] = bispo;
		bispo = new Bispo(Cores.preto);
		casas[7][5] = bispo;
		
		//inserindo rei e dama
		Peca rei = new Rei(Cores.branco);
		casas[0][4] = rei;
		rei = new Rei(Cores.preto);
		casas[7][4] = rei;
		
		Peca dama = new Rainha(Cores.branco);
		casas[0][3] = dama;
		dama = new Rainha(Cores.preto);
		casas[7][3] = dama;
		
	}

	
	public Peca getCasas(int linha, int coluna) {
		return casas[coluna][linha];
	}

	public void setCasas(Peca peca, int x, int y) {
		this.casas[y][x] = peca;
	}

	public void ImprimeTab(){
		int numLinha = 8;
		System.out.print("\n");
		for (int coluna = 7; coluna >= 0; coluna--) {
			System.out.print(numLinha + "   ");
			numLinha-= 1;
			for (int linha = 0; linha < 8; linha++) {
				if (this.getCasas(linha,coluna) == null) 
					System.out.print(" x ");
				else 
					System.out.print(" " + this.getCasas(linha,coluna) + " "); 
						
			}
			System.out.print("\n");
		}
		System.out.print("\n    ");
		for(int numColuna = 1; numColuna < 9; numColuna++){
			System.out.print(" " + numColuna + " ");
		}
		System.out.print("\n\n");
	}
	
	
	public void moverPeca(int xIn, int yIn, int xFin, int yFin){
		
		Peca peca = this.getCasas(xIn,yIn);
		this.setCasas(peca, xFin, yFin);
		this.setCasas(null, xIn, yIn);
		
	}
	
	public Peca capturarPeca(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal){
		
		Peca peca = this.getCasas(linhaInicial,colunaInicial);
		Peca pecaCapturada = this.getCasas(linhaFinal, colunaFinal);
		this.setCasas(peca, linhaFinal, colunaFinal);
		this.setCasas(null, linhaInicial, colunaInicial);
		
		return pecaCapturada;
		
	}
	
	
	public boolean verificaCaminhoTorre(int linhaInicial, int colunaInicial, int linhaDestino, int colunaDestino){
		
		if (linhaInicial == linhaDestino){
			for (int contador=0; contador<colunaDestino -1; contador++){
				if (this.getCasas(linhaDestino, contador) != null){ //não tiver peça no meio
					return false;
				}
			}
		}
		if (colunaDestino==colunaInicial){
			for (int contador=0; contador<colunaDestino -1; contador++){
				if (this.getCasas(contador, colunaDestino) != null){ //não tiver peça no meio
					return false;
				}
			}
		}
		return true;
	}
	
	/*verifica se o caminho do bispo está livre para fazer a movimentacao*/
	public boolean verificaCaminhoBispo(int linhaInicial, int colunaInicial, int linhaDestino, int colunaDestino){
		
		int colunaVariante, linhaVariante;
		
		//determina a posicao de movimentacao
		if (colunaDestino - colunaInicial > 0)
			colunaVariante = 1;
		else
			colunaVariante = -1;
		
		if (linhaDestino - linhaInicial > 0)
			linhaVariante = 1;
		else
			linhaVariante = -1;
		
		for(int i = 0; i < Math.abs(colunaDestino-colunaInicial) -1; i++){
			linhaInicial += linhaVariante;
			colunaInicial += colunaVariante;
			if(this.getCasas(linhaInicial, colunaInicial) != null)
				return false;
		}
		return true;
	}
	
	public boolean verificaCaminho(int linhaInicial, int colunaInicial, int linhaDestino, int colunaDestino){
		
		// verifica se tem alguma casa no destino
		if (getCasas(linhaDestino, colunaDestino) != null) {
			return false;
		}
		
		return verificaCaminhos(colunaInicial, linhaInicial, colunaDestino, linhaDestino);
	}


	private boolean verificaCaminhoRainha(int linhaInicial, int colunaInicial, int linhaDestino, int colunaDestino) {
		if(Math.abs(colunaDestino - colunaInicial) == Math.abs(linhaDestino) - linhaInicial)
			return verificaCaminhoBispo(linhaInicial, colunaInicial, linhaDestino, colunaDestino);
		else
			return verificaCaminhoTorre(linhaInicial, colunaInicial, linhaDestino, colunaDestino);
	}


	public boolean verificaCaminhoCaptura(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal, Jogo jogo) throws CapturaInvalidaPecaInexistenteException, CapturaInvalidaPecaPropriaException {
		
		// verifica se tem alguma casa no destino
		if (getCasas(linhaFinal, colunaFinal) == null) {
			throw new CapturaInvalidaPecaInexistenteException();
		}
		// verifica a peca que se deseja capturar eh da mesma cor que o jogador que fez a captura
		if (getCasas(linhaFinal, colunaFinal).getCor().equals(jogo.getVez().getCor())) {
			throw new CapturaInvalidaPecaPropriaException();
		}

		return verificaCaminhos(colunaInicial, linhaInicial, colunaFinal, linhaFinal);
	}
	
	private boolean verificaCaminhos(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal){
		
		Peca peca = getCasas(linhaInicial, colunaInicial);

		switch (peca.toString()) {
		// Se for cavalo, passa direto.
		case "C":
			return true;
			// verificação da torre.
		case "T":
			return verificaCaminhoTorre(linhaInicial, colunaInicial,
					linhaFinal, colunaFinal);
			// verificação do bispo
		case "B":
			return verificaCaminhoBispo(linhaInicial, colunaInicial,
					linhaFinal, colunaFinal);
		case "D":
			return verificaCaminhoRainha(linhaInicial, colunaInicial,
					linhaFinal, colunaFinal);
		}
		return true;
	}

}
