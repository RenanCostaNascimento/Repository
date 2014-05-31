package br.ifes.poo1.model.test;

import static org.junit.Assert.assertTrue;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Cavalo;
import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CavaloTeste {

	Tabuleiro tabuleiro;
	List<Posicao> posicoesPossiveis;

	@Test
	public void testaMoverCapturar(){
		
            tabuleiro = new Tabuleiro();

            posicoesPossiveis = new ArrayList<>();

            PecaAbstrata cavalo = new Cavalo();
            cavalo.setPosicao(new Posicao(4, 3));
            tabuleiro.setCasas(cavalo, 4, 3);
            posicoesPossiveis = tabuleiro.posicoesPossiveisPeca(cavalo.getPosicao());

            for (Posicao posicao : posicoesPossiveis) {
                assertTrue(tabuleiro.getCasas(4, 3).mover(posicao));
            }
	
	}
	

}
