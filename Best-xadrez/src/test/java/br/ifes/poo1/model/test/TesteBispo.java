package br.ifes.poo1.model.test;

import static org.junit.Assert.assertTrue;
import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasPool;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TesteBispo {
	PecasPool pp = PecasPool.getInstanceOf();
	Tabuleiro tabuleiro;
	List<Posicao> posicoesPossiveis;
	
	
	@Test
	public void testaBispo(){
		
//		tabuleiro = new Tabuleiro();
//		posicoesPossiveis = new ArrayList<>();
//		
//		Peca bispo = pp.getPeca(NomePecas.Bispo, Cores.branco);
//		bispo.setPosicao(new Posicao(4, 3));
//		tabuleiro.setCasas(bispo, 4, 3);
//		posicoesPossiveis = tabuleiro.posicoesPossiveisPeca(bispo.getPosicao());
//		
//		for(Posicao posicao : posicoesPossiveis){
//			assertTrue(tabuleiro.getCasas(4, 3).mover(posicao));
//		}
	
	}
	
}
