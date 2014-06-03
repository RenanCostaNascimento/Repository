/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.poo1.xadrez.persist.test;

import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import ifes.poo1.xadrez.util.persist.DAOHistoricoJogador;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Renan
 */
public class DAOHistoricoJogadorTest {

    public DAOHistoricoJogador historicoJogadorDAO;

    @Before
    public void before() {
        historicoJogadorDAO = new DAOHistoricoJogador();
    }

    @After
    public void after() throws SQLException, ClassNotFoundException {
        historicoJogadorDAO.deleteAll();
    }

    @Test
    public void criarTabelaUsuario() throws ClassNotFoundException, SQLException {

        // Criando a tabela
//        historicoJogadorDAO.dropTabela();
        historicoJogadorDAO.criarTabela();
    }

    @Test
    public void salvarHistoricoPartida() throws ClassNotFoundException, SQLException {
        HistoricoJogador historicoJogador = historicoJogadorDAO.create();

        historicoJogador.setNome("Jogador1");
        historicoJogador.setDerrotas(0);
        historicoJogador.setEmpates(1);
        historicoJogador.setVitorias(2);

        // inserindo o usuario no banco de dados
        historicoJogadorDAO.insert(historicoJogador);
        Assert.assertNotSame(0, historicoJogador.getId());

    }
    
    @Test
    public void buscarHistoricoJogador() throws SQLException, ClassNotFoundException{
        HistoricoJogador historicoJogador = historicoJogadorDAO.create();

        historicoJogador.setNome("Jogador1");
        historicoJogador.setVitorias(0);
        historicoJogador.setEmpates(1);
        historicoJogador.setDerrotas(2);

        historicoJogadorDAO.insert(historicoJogador);

        HistoricoJogador historicoJogadorRecuperado = historicoJogadorDAO.findbyID(historicoJogador.getId());
        Assert.assertNotSame(0, historicoJogadorRecuperado.getId());
    }
    
    @Test
    public void atualizarHistoricoJogador() throws SQLException, ClassNotFoundException{
        long id1, id2;
        int vitorias1, vitorias2, empates1, empates2, derrotas1, derrotas2;
        String nome1, nome2;
        
        HistoricoJogador historicoJogador = historicoJogadorDAO.create();
        
        nome1 = "Jogador1";
        historicoJogador.setNome(nome1);
        vitorias1 = 1;
        historicoJogador.setVitorias(vitorias1);
        empates1 = 1;
        historicoJogador.setEmpates(empates1);
        derrotas1 = 1;
        historicoJogador.setDerrotas(derrotas1);
        
        historicoJogadorDAO.insert(historicoJogador);
        id1 = historicoJogador.getId();

        nome2 = "Jogador2";
        historicoJogador.setNome(nome2);
        vitorias2 = 2;
        historicoJogador.setVitorias(vitorias2);
        empates2 = 2;
        historicoJogador.setEmpates(empates2);
        derrotas2 = 2;
        historicoJogador.setDerrotas(derrotas2);
        
        historicoJogadorDAO.update(historicoJogador);
        id2 = historicoJogador.getId();
        
        Assert.assertSame(id1, id2);
        Assert.assertNotSame(nome1, nome2);
        Assert.assertNotSame(vitorias1, vitorias2);
        Assert.assertNotSame(empates1, empates2);
        Assert.assertNotSame(derrotas1, derrotas2);
    }
    
    @Test
    public void deletarHistoricoJogador() throws SQLException, ClassNotFoundException{
        long id;
        HistoricoJogador historicoJogador = historicoJogadorDAO.create();
        HistoricoJogador historicoJogadorDeletado = null;

        historicoJogador.setNome("Jogador1");
        historicoJogador.setVitorias(0);
        historicoJogador.setEmpates(1);
        historicoJogador.setDerrotas(2);

        historicoJogadorDAO.insert(historicoJogador);
        id = historicoJogador.getId();
        
        historicoJogadorDAO.delete(historicoJogador);
        historicoJogadorDeletado = historicoJogadorDAO.findbyID(id);
        
        Assert.assertEquals(0, historicoJogadorDeletado.getId());
    }
    
    @Test
    public void listarHistoricoJogador() throws ClassNotFoundException, SQLException{

        HistoricoJogador historicoJogador = historicoJogadorDAO.create();

        historicoJogador.setNome("Jogador1");
        historicoJogador.setVitorias(0);
        historicoJogador.setEmpates(1);
        historicoJogador.setDerrotas(2);

        historicoJogadorDAO.insert(historicoJogador);

        List<HistoricoJogador> historicos = historicoJogadorDAO.findAll();

        Assert.assertNotNull(historicos);
        Assert.assertNotSame(0, historicos.size());
    }
}
