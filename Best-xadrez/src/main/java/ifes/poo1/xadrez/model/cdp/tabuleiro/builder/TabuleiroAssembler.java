package ifes.poo1.xadrez.model.cdp.tabuleiro.builder;

import java.util.ArrayList;
import java.util.List;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasPool;


public class TabuleiroAssembler implements Cloneable{
	
	private Peca[][] casas = new Peca[8][8];
	private ArrayList<Peca> pecasBrancas = new ArrayList<>();
	private ArrayList<Peca> pecasPretas = new ArrayList<>();
	private PecasPool pecasPool = PecasPool.getInstanceOf();
	private static TabuleiroAssembler tabAsm = null;
	
	public static TabuleiroAssembler getInstanceOf(){
		if (tabAsm == null) tabAsm = new TabuleiroAssembler();
		return tabAsm;
	}
	
	
	private TabuleiroAssembler() {
		Peca peca;
		
		// inserindo os pe�es
		for (int i = 0; i < 8; i++) {
			peca = pecasPool.getPeca(NomePecas.Peao, Cores.branco);
			casas[1][i] = peca;
			pecasBrancas.add(peca);
			peca.setPosicao(new Posicao(i, 1));

			peca = pecasPool.getPeca(NomePecas.Peao, Cores.preto);
			casas[6][i] = peca;
			pecasPretas.add(peca);
			peca.setPosicao(new Posicao(i, 6));

		}

		// inserindo as torres
		peca = pecasPool.getPeca(NomePecas.Torre, Cores.branco);
		casas[0][0] = peca;
		pecasBrancas.add(peca);
		peca.setPosicao(new Posicao(0, 0));

		peca = pecasPool.getPeca(NomePecas.Torre, Cores.branco);
		casas[0][7] = peca;
		pecasBrancas.add(peca);
		peca.setPosicao(new Posicao(7, 0));

		peca = pecasPool.getPeca(NomePecas.Torre, Cores.preto);
		casas[7][0] = peca;
		pecasPretas.add(peca);
		peca.setPosicao(new Posicao(0, 7));

		peca = pecasPool.getPeca(NomePecas.Torre, Cores.preto);
		casas[7][7] = peca;
		pecasPretas.add(peca);
		peca.setPosicao(new Posicao(7, 7));

		// inserindo os cavalos
		peca = pecasPool.getPeca(NomePecas.Cavalo, Cores.branco);
		casas[0][1] = peca;
		pecasBrancas.add(peca);
		peca.setPosicao(new Posicao(1, 0));

		peca = pecasPool.getPeca(NomePecas.Cavalo, Cores.branco);
		casas[0][6] = peca;
		pecasBrancas.add(peca);
		peca.setPosicao(new Posicao(6, 0));

		peca = pecasPool.getPeca(NomePecas.Cavalo, Cores.preto);
		casas[7][1] = peca;
		pecasPretas.add(peca);
		peca.setPosicao(new Posicao(1, 7));

		peca = pecasPool.getPeca(NomePecas.Cavalo, Cores.preto);
		casas[7][6] = peca;
		pecasPretas.add(peca);
		peca.setPosicao(new Posicao(6, 7));

		// inserindo os bispos
		peca = pecasPool.getPeca(NomePecas.Bispo, Cores.branco);
		casas[0][2] = peca;
		pecasBrancas.add(peca);
		peca.setPosicao(new Posicao(2, 0));

		peca = pecasPool.getPeca(NomePecas.Bispo, Cores.branco);
		casas[0][5] = peca;
		pecasBrancas.add(peca);
		peca.setPosicao(new Posicao(5, 0));

		peca = pecasPool.getPeca(NomePecas.Bispo, Cores.preto);
		casas[7][2] = peca;
		pecasPretas.add(peca);
		peca.setPosicao(new Posicao(2, 7));

		peca = pecasPool.getPeca(NomePecas.Bispo, Cores.preto);
		casas[7][5] = peca;
		pecasPretas.add(peca);
		peca.setPosicao(new Posicao(5, 7));

		// inserindo rei e dama
		peca = pecasPool.getPeca(NomePecas.Rei, Cores.branco);
		casas[0][4] = peca;
		pecasBrancas.add(peca);
		peca.setPosicao(new Posicao(4, 0));
		

		peca = pecasPool.getPeca(NomePecas.Rei, Cores.preto);
		casas[7][4] = peca;
		pecasPretas.add(peca);
		peca.setPosicao(new Posicao(4, 7));
		

		peca = pecasPool.getPeca(NomePecas.Rainha, Cores.branco);
		casas[0][3] = peca;
		pecasBrancas.add(peca);
		peca.setPosicao(new Posicao(3, 0));

		peca = pecasPool.getPeca(NomePecas.Rainha, Cores.preto);
		casas[7][3] = peca;
		pecasPretas.add(peca);
		peca.setPosicao(new Posicao(3, 7));

	}

	public Peca[][] getCasas(){
		return casas.clone();
	}
	
	

	public ArrayList<Peca> getPecasBrancas() {
		@SuppressWarnings("unchecked")
		ArrayList<Peca> clone = (ArrayList<Peca>) pecasBrancas.clone();
		return clone;
	}
	
	public List<Peca> getPecasPretas(){
		@SuppressWarnings("unchecked")
		ArrayList<Peca> clone = (ArrayList<Peca>) pecasPretas.clone();
		return clone;
	}
	
	
}
