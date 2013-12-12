package ifes.poo1.xadrez.model.cdp.tabuleiro;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
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

import java.util.ArrayList;
import java.util.List;


public class Tabuleiro {

	private PecaAbstrata[][] casas = new PecaAbstrata[8][8];
	private List<PecaAbstrata> pecasBrancas = new ArrayList<>();
	private List<PecaAbstrata> pecasPretas = new ArrayList<>();
	/*posicaoReiBranco e posicaoReiPreto serao usados para determinar se houve cheque ou cheque-mate*/
	/*foi decidido criar um atributo que explicite a posicao dos reis por uma questao de desempenho, ou seja, nao sera
	 * necessario buscar a posicao dos reis sempre que a verificacao do xeque for realizada*/
	private Posicao posicaoReiBranco;
	private Posicao posicaoReiPreto;
		
	//o met�do construtor insere as pe�as no tabuleiro	
	public Tabuleiro(){
		
		//inserindo os pe�es
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
		
		//inserindo as torres
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
		
		//inserindo os cavalos
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
		
		
		//inserindo os bispos
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
		
		//inserindo rei e dama
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
		int colunaInicial = posicaoInicial.getColuna();
		int linhaInicial = posicaoInicial.getLinha();
		
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
			colunaInicial += colunaVariante;
			linhaInicial += linhaVariante;
			if(this.getCasas(colunaInicial, linhaInicial) != null)
				return false;
		}
		return true;
	}
	
	/** Verifica se a peça possuia caminho livre para fazer o movimento.
	 * @param posicaoInicial
	 * @param posicaoFinal
	 * @return true se possuir caminho livre.
	 */
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
	
	public boolean verificaCaminhoXeque(Posicao posicaoInicial, Posicao posicaoFinal, Jogo jogo){
		
		// verifica se tem alguma casa no destino
		if (getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha()) == null) {
			return false;
		}
		// verifica a peca que se deseja capturar eh da mesma cor que o jogador que fez a captura
		if (getCasas(posicaoFinal.getColuna(), posicaoFinal.getLinha()).getCor().equals(jogo.getVez().getCor())) {
			return false;
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
