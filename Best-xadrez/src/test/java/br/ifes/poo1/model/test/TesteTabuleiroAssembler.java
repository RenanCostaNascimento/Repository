package br.ifes.poo1.model.test;

import ifes.poo1.xadrez.model.cdp.tabuleiro.builder.TabuleiroAssembler;
import static org.junit.Assert.*;
import org.junit.Test;

public class TesteTabuleiroAssembler {

    TabuleiroAssembler tabAsm = TabuleiroAssembler.getInstanceOf();

    @Test
    public void testeCopiaPecasBrancas() {
        assertTrue(tabAsm.getCasas() != tabAsm.getCasas());
    }

    @Test
    public void testeCopiaPecasPretas() {
        assertTrue(tabAsm.getPecasBrancas() != tabAsm.getPecasBrancas());
    }

    @Test
    public void testeCopiaPecasCasas() {
        assertTrue(tabAsm.getPecasPretas() != tabAsm.getPecasPretas());
    }

}
