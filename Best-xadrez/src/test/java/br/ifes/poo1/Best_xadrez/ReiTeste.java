package br.ifes.poo1.Best_xadrez;

import static org.junit.Assert.assertTrue;
import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;
import ifes.poo1.xadrez.model.cdp.pecas.Rei;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReiTeste {

	Tabuleiro tabuleiro;
	List<Posicao> posicoesPossiveis;
	@Test
	public void testaMoverCapturar(){
		
		tabuleiro = new Tabuleiro();
		
		posicoesPossiveis = new ArrayList<>();
		
		PecaAbstrata rei = new Rei(Cores.preto);
		rei.setPosicao(new Posicao(4, 3));
		tabuleiro.setCasas(rei, 4, 3);
		posicoesPossiveis = tabuleiro.posicoesPossiveisPeca(rei.getPosicao());
		
		for(Posicao posicao : posicoesPossiveis){
			assertTrue(tabuleiro.getCasas(4, 3).mover(posicao));
		}
	
	}
	

}
