package br.ifes.poo1.Best_xadrez;

import static org.junit.Assert.assertTrue;
import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.pecas.Cavalo;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasFactory;

import org.junit.Test;

public class PecasFactoryTeste {
	PecasFactory pecasfactory;
	
	@Test
	public void testaCriarPeca(){
		pecasfactory = new PecasFactory();
		assertTrue(PecasFactory.fabricate("Cavalo", Cores.branco) != PecasFactory.fabricate("Cavalo", Cores.branco));
	}
}
