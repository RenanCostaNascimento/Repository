package br.ifes.poo1.Best_xadrez;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
import ifes.poo1.xadrez.model.cdp.pecas.PecaAbstrata;
import ifes.poo1.xadrez.model.cdp.pecas.Rainha;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasPool;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RainhaTeste {

	Tabuleiro tabuleiro;
	List<Posicao> posicoesPossiveis;
                  PecasPool pp = PecasPool.getInstanceOf();
	@Test
	public void testaMoverCapturar(){
		
		tabuleiro = new Tabuleiro();
		
		posicoesPossiveis = new ArrayList<>();
		
		Peca rainha = pp.getPeca(NomePecas.Rainha, Cores.branco);
		rainha.setPosicao(new Posicao(4, 3));
		tabuleiro.setCasas(rainha, 4, 3);
		posicoesPossiveis = tabuleiro.posicoesPossiveisPeca(rainha.getPosicao());
		
		for(Posicao posicao : posicoesPossiveis){
			assertTrue(tabuleiro.getCasas(4, 3).mover(posicao));
		}
	
	}

}
