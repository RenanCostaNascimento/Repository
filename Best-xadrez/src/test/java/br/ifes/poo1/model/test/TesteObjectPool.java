package br.ifes.poo1.model.test;

import static org.junit.Assert.*;
import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Rei;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasPool;

import org.junit.Test;

public class TesteObjectPool {

    private PecasPool pp = PecasPool.getInstanceOf();

    @Test
    public void testeInseridaIGual() {
        Rei rei = new Rei();
        pp.getPeca(NomePecas.Rei, Cores.branco, new Posicao(5, 5));
        assertTrue(rei.toString() == (pp.getPeca(NomePecas.Rei, Cores.branco, new Posicao(5, 5))).toString());
    }

    @Test
    public void testePegarMesmaPeca() {
        assertTrue(pp.getPeca(NomePecas.Rei, Cores.branco, new Posicao(5, 5)) != pp.getPeca(NomePecas.Rei, Cores.branco, new Posicao(5, 5)));
    }

    @Test
    public void testePegarMesmaPecaMesmaClasse() {
        assertTrue(pp.getPeca(NomePecas.Rei, Cores.branco, new Posicao(5, 5)).getClass() == pp.getPeca(NomePecas.Rei, Cores.branco, new Posicao(5, 5)).getClass());
    }

}
