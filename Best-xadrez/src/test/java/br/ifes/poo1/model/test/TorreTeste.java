package br.ifes.poo1.model.test;

import static org.junit.Assert.assertTrue;
import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;
import ifes.poo1.xadrez.model.cdp.pecas.Torre;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TorreTeste  {

	Tabuleiro tabuleiro;
	List<Posicao> posicoesPossiveis;

	@Test
	public void testaMoverCapturar(){
		
            tabuleiro = new Tabuleiro();

            posicoesPossiveis = new ArrayList<>();

            PecaAbstrata torre = new Torre();
            torre.setPosicao(new Posicao(4, 3));
            tabuleiro.setCasas(torre, 4, 3);
            posicoesPossiveis = tabuleiro.posicoesPossiveisPeca(torre.getPosicao());

            for (Posicao posicao : posicoesPossiveis) {
                assertTrue(tabuleiro.getCasas(4, 3).mover(posicao));
            }
	
	}

}
