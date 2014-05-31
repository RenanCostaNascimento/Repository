package br.ifes.poo1.model.test;

import static org.junit.Assert.*;
import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.pecas.Rei;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasPool;

import org.junit.Test;

public class TesteObjectPool {

    private PecasPool pp = PecasPool.getInstanceOf();

    @Test
    public void testeInseridaIGual() {
        Rei rei = new Rei(Cores.branco);
        pp.getPeca(NomePecas.Rei, Cores.branco);
        assertTrue(rei.toString() == (pp.getPeca(NomePecas.Rei, Cores.branco)).toString());
    }

    @Test
    public void testePegarMesmaPeca() {
        assertTrue(pp.getPeca(NomePecas.Rei, Cores.branco) != pp.getPeca(NomePecas.Rei, Cores.branco));
    }

    @Test
    public void testePegarMesmaPecaMesmaClasse() {
        assertTrue(pp.getPeca(NomePecas.Rei, Cores.branco).getClass() == pp.getPeca(NomePecas.Rei, Cores.branco).getClass());
    }

}
