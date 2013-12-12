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


public class Tabuleiro {

	private PecaAbstrata[][] casas = new PecaAbstrata[8][8];
	/*posicaoReiBranco e posicaoReiPreto serao usados para determinar se houve cheque ou cheque-mate*/
	private String posicaoReiBranco;
	private String posicaoReiPreto;
		
	//o met�do construtor insere as pe�as no tabuleiro	
	public Tabuleiro(){
		
		//inserindo os pe�es
		for (int i = 0; i < 8; i++) {
			PecaAbstrata peao = new Peao(Cores.branco);
			casas[1][i] = peao;
			peao.setPosicao(new Posicao(i, 1));
			
			peao = new Peao(Cores.preto);
			casas[6][i] = peao;
			peao.setPosicao(new Posicao(i, 6));
			
		} 
		
		//inserindo as torres
		PecaAbstrata torre = new Torre(Cores.branco);
		casas[0][0] = torre;
		torre.setPosicao(new Posicao(0, 0));
		
		torre = new Torre(Cores.branco);
		casas[0][7] = torre;
		torre.setPosicao(new Posicao(7, 0));
		
		torre = new Torre(Cores.preto);
		casas[7][0] = torre;
		torre.setPosicao(new Posicao(0, 7));
		
		torre = new Torre(Cores.preto);
		casas[7][7] = torre;
		torre.setPosicao(new Posicao(7, 7));
		
		//inserindo os cavalos
		PecaAbstrata cavalo = new Cavalo(Cores.branco);
		casas[0][1] = cavalo;
		cavalo.setPosicao(new Posicao(1, 0));
		
		cavalo = new Cavalo(Cores.branco);
		casas[0][6] = cavalo;
		cavalo.setPosicao(new Posicao(6, 0));
		
		cavalo = new Cavalo(Cores.preto);
		casas[7][1] = cavalo;
		cavalo.setPosicao(new Posicao(1, 7));
		
		cavalo = new Cavalo(Cores.preto);
		casas[7][6] = cavalo;
		cavalo.setPosicao(new Posicao(6, 7));
		
		
		//inserindo os bispos
		PecaAbstrata bispo = new Bispo(Cores.branco);
		casas[0][2] = bispo;
		bispo.setPosicao(new Posicao(2, 0));
		
		bispo = new Bispo(Cores.branco);
		casas[0][5] = bispo;
		bispo.setPosicao(new Posicao(5, 0));
		
		bispo = new Bispo(Cores.preto);
		casas[7][2] = bispo;
		bispo.setPosicao(new Posicao(2, 7));
		
		bispo = new Bispo(Cores.preto);
		casas[7][5] = bispo;
		bispo.setPosicao(new Posicao(5, 7));
		
		//inserindo rei e dama
		PecaAbstrata rei = new Rei(Cores.branco);
		casas[0][4] = rei;
		rei.setPosicao(new Posicao(4, 0));
		posicaoReiBranco = "40";
		
		rei = new Rei(Cores.preto);
		casas[7][4] = rei;
		rei.setPosicao(new Posicao(4, 7));
		posicaoReiPreto = "47";
		
		PecaAbstrata dama = new Rainha(Cores.branco);
		casas[0][3] = dama;
		dama.setPosicao(new Posicao(3, 0));
		
		dama = new Rainha(Cores.preto);
		casas[7][3] = dama;
		dama.setPosicao(new Posicao(3, 7));
		
	}
	
	public PecaAbstrata getCasas(int coluna, int linha) {
		return casas[linha][coluna];
	}

	public void setCasas(PecaAbstrata peca, int coluna, int linha) {
		this.casas[linha][coluna] = peca;
	}
	
	public void ImprimeTab(){
		int numLinha = 8;
		System.out.print("\n");
		for (int linha = 7; linha >= 0; linha--) {
			System.out.print(numLinha + "   ");
			numLinha-= 1;
			for (int coluna = 0; coluna < 8; coluna++) {
				if (this.getCasas(coluna, linha) == null) 
					System.out.print(" x ");
				else 
					System.out.print(" " + this.getCasas(coluna, linha) + " "); 
						
			}
			System.out.print("\n");
		}
		System.out.print("\n    ");
		for(int numColuna = 1; numColuna < 9; numColuna++){
			System.out.print(" " + numColuna + " ");
		}
		System.out.print("\n\n");
	}
	
	
	public void moverPeca(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal){
		
		PecaAbstrata peca = this.getCasas(colunaInicial,linhaInicial);
		this.setCasas(peca, colunaFinal, linhaFinal);
		this.setCasas(null, colunaInicial, linhaInicial);
		peca.getPosicao().setColuna(colunaFinal);
		peca.getPosicao().setLinha(linhaFinal);
		
	}
	
	public PecaAbstrata capturarPeca(Posicao posicaoInicial, Posicao posicaoFinal){
		
		PecaAbstrata peca = this.getCasas(posicaoInicial.getColuna(),posicaoInicial.getLinha());
		PecaAbstrata pecaCapturada = this.getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha());
		this.setCasas(peca, posicaoFinal.getColuna(), posicaoFinal.getLinha());
		this.setCasas(null, posicaoInicial.getColuna(), posicaoInicial.getLinha());
		peca.setPosicao(posicaoFinal);
		
		return pecaCapturada;
		
	}
	
	
	public boolean verificaCaminhoTorre(Posicao posicaoInicial, Posicao posicaoFinal){
		
		/*movimento horizontal*/
		if (posicaoInicial.getLinha() == posicaoFinal.getLinha()){
			int colunaVariante;
			int colunaInicial = posicaoInicial.getColuna();
			/*verifica a posicao de movimentacao*/
			if(posicaoFinal.getColuna() > posicaoInicial.getColuna())
				/*direita*/
				colunaVariante = 1;
			else
				/*esquerda*/
				colunaVariante = -1;
			for(int i = 0; i < Math.abs(posicaoFinal.getColuna()-posicaoInicial.getColuna()) -1; i++){
				colunaInicial += colunaVariante;
				if(this.getCasas(colunaInicial, posicaoInicial.getLinha()) != null)
					return false;
			}
		/*movimento vertical*/
		}else{
			int linhaVariante;
			int linhaInicial = posicaoInicial.getLinha();
			/*verifica a posicao de movimentacao*/
			if(posicaoFinal.getLinha() > posicaoInicial.getLinha())
				/*cima*/
				linhaVariante = 1;
			else
				/*baixo*/
				linhaVariante = -1;
			for(int i = 0; i < Math.abs(posicaoFinal.getLinha()-posicaoInicial.getLinha()) -1; i++){
				linhaInicial += linhaVariante;
				if(this.getCasas(posicaoInicial.getColuna(), linhaInicial) != null)
					return false;
			}
		}
		return true;
	}
	
	/*verifica se o caminho do bispo está livre para fazer a movimentacao*/
	public boolean verificaCaminhoBispo(Posicao posicaoInicial, Posicao posicaoFinal){
		
		int colunaVariante, linhaVariante;
		
		//determina a posicao de movimentacao
		if (posicaoFinal.getColuna() - posicaoInicial.getColuna() > 0)
			colunaVariante = 1;
		else
			colunaVariante = -1;
		
		if (posicaoFinal.getLinha() - posicaoInicial.getLinha() > 0)
			linhaVariante = 1;
		else
			linhaVariante = -1;
		
		for(int i = 0; i < Math.abs(posicaoFinal.getColuna()-posicaoInicial.getColuna()) -1; i++){
			posicaoInicial.setLinha(posicaoInicial.getLinha() + linhaVariante);
			posicaoInicial.setColuna(posicaoInicial.getColuna() + colunaVariante);
			if(this.getCasas(posicaoInicial.getColuna(), posicaoInicial.getLinha()) != null)
				return false;
		}
		return true;
	}
	
	public boolean verificaCaminho(Posicao posicaoInicial, Posicao posicaoFinal){
		
		// verifica se tem alguma casa no destino
		if (getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha()) != null) {
			return false;
		}
		
		return verificaCaminhos(posicaoInicial, posicaoFinal);
	}


	private boolean verificaCaminhoRainha(Posicao posicaoInicial, Posicao posicaoFinal) {
		if(Math.abs(posicaoFinal.getColuna() - posicaoInicial.getColuna()) == Math.abs(posicaoFinal.getLinha() - posicaoInicial.getLinha()))
			return verificaCaminhoBispo(posicaoInicial, posicaoFinal);
		else
			return verificaCaminhoTorre(posicaoInicial,posicaoFinal);
	}


	public boolean verificaCaminhoCaptura(Posicao posicaoInicial, Posicao posicaoFinal, Jogo jogo) throws CapturaInvalidaPecaInexistenteException, CapturaInvalidaPecaPropriaException {
		
		// verifica se tem alguma casa no destino
		if (getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha()) == null) {
			throw new CapturaInvalidaPecaInexistenteException();
		}
		// verifica a peca que se deseja capturar eh da mesma cor que o jogador que fez a captura
		if (getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha()).getCor().equals(jogo.getVez().getCor())) {
			throw new CapturaInvalidaPecaPropriaException();
		}

		return verificaCaminhos(posicaoInicial, posicaoFinal);
	}
	
	private boolean verificaCaminhos(Posicao posicaoInicial, Posicao posicaoFinal){
		
		PecaAbstrata peca = getCasas(posicaoInicial.getColuna(), posicaoInicial.getLinha());

		switch (peca.toString()) {
		// Se for cavalo, passa direto.
		case "C":
			return true;
			// verificação da torre.
		case "T":
			return verificaCaminhoTorre(posicaoInicial, posicaoFinal);
			// verificação do bispo
		case "B":
			return verificaCaminhoBispo(posicaoInicial, posicaoFinal);
		case "D":
			return verificaCaminhoRainha(posicaoInicial, posicaoFinal);
		}
		return true;
	}


	public String getPosicaoReiBranco() {
		return posicaoReiBranco;
	}


	public void setPosicaoReiBranco(String posicaoReiBranco) {
		this.posicaoReiBranco = posicaoReiBranco;
	}


	public String getPosicaoReiPreto() {
		return posicaoReiPreto;
	}


	public void setPosicaoReiPreto(String posicaoReiPreto) {
		this.posicaoReiPreto = posicaoReiPreto;
	}
        
        
	public boolean roqueMenor(Cores cor){
            if (cor == Cores.branco){
                if (this.getCasas(7, 4).isSeMovimentou() || this.getCasas(7, 4).getNome()== NomePecas.rei || //verifica de é o rei
                    this.getCasas(7, 7).isSeMovimentou() || this.getCasas(7,7).getNome()== NomePecas.torre || 
                    this.getCasas(7, 6)==null || this.getCasas(7,5)== null ){ //verificar se tem peças no meio //verifica se é a torre
                    
                        this.moverPeca(7, 4, 7, 6);
                        this.moverPeca(7, 7, 7, 5);
                        return true;
                    }
            }
            
            if (cor == Cores.preto){
                if (this.getCasas(0, 4).isSeMovimentou() || this.getCasas(0, 4).getNome()== NomePecas.rei || //verifica de é o rei
                    this.getCasas(0, 7).isSeMovimentou() || this.getCasas(0,7).getNome()== NomePecas.torre || 
                    this.getCasas(0, 6)==null || this.getCasas(0,5)== null ){ //verificar se tem peças no meio //verifica se é a torre
                    
                        this.moverPeca(0, 4, 0, 6);
                        this.moverPeca(0, 7, 0, 5);
                        return true;
                }
            }
        return false;
        }
        
        
        public boolean roqueMaior(Cores cor){
            if (cor == Cores.branco){
                if (this.getCasas(7, 4).isSeMovimentou() || this.getCasas(7, 4).getNome()== NomePecas.rei || //verifica de é o rei
                    this.getCasas(7, 0).isSeMovimentou() || this.getCasas(7,0).getNome()== NomePecas.torre || 
                    this.getCasas(7, 3)==null || this.getCasas(7,2)== null || this.getCasas(7,1)== null ){ //verificar se tem peças no meio //verifica se é a torre
                    
                        this.moverPeca(7, 4, 7, 2);
                        this.moverPeca(7, 0, 7, 3);
                        return true;
                    }
            }
            
            if (cor == Cores.preto){
                if (this.getCasas(0, 4).isSeMovimentou() || this.getCasas(0, 4).getNome()== NomePecas.rei || //verifica de é o rei
                    this.getCasas(0,0).isSeMovimentou() || this.getCasas(0,0).getNome()== NomePecas.torre || 
                    this.getCasas(0, 3)==null || this.getCasas(0,2)== null || this.getCasas(0,1)== null ){ //verificar se tem peças no meio //verifica se é a torre
                    
                        this.moverPeca(0, 4, 0, 2);
                        this.moverPeca(0, 0, 0, 3);
                        return true;
                }
            }
        return false;
        }
        
}
