/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.poo1.Best_xadrez;


import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author pdr
 */
public class CriarTabuleiroTeste {

	

	@Test
	public void testarMesmoTabuleiro() {
		Tabuleiro tab1 = new Tabuleiro();
		Tabuleiro tab2 = new Tabuleiro();
		assertTrue(tab1.hashCode() != tab2.hashCode());
	}
	
	@Test
	public void testarPecas() {
		Tabuleiro tab1 = new Tabuleiro();
		Tabuleiro tab2 = new Tabuleiro();
		assertTrue(tab1.getCasas(0, 0).hashCode() != tab2.getCasas(0, 0).hashCode());
	}

}
