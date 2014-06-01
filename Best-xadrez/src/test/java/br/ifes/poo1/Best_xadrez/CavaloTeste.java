package br.ifes.poo1.Best_xadrez;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Cavalo;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasPool;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CavaloTeste {

	Tabuleiro tabuleiro;
	List<Posicao> posicoesPossiveis;
                  PecasPool pp = PecasPool.getInstanceOf();

	@Test
	public void testaMoverCapturar(){
		
		tabuleiro = new Tabuleiro();
		
		posicoesPossiveis = new ArrayList<>();
		
		Peca cavalo = pp.getPeca(NomePecas.Cavalo, Cores.branco);
		cavalo.setPosicao(new Posicao(4, 3));
		tabuleiro.setCasas(cavalo, 4, 3);
		posicoesPossiveis = tabuleiro.posicoesPossiveisPeca(cavalo.getPosicao());
		
		for(Posicao posicao : posicoesPossiveis){
			assertTrue(tabuleiro.getCasas(4, 3).mover(posicao));
		}
	
	}
	

}
