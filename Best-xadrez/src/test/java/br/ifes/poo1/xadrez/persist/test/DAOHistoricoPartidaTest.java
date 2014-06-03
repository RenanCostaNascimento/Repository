/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.poo1.xadrez.persist.test;

import ifes.poo1.xadrez.model.cdp.jogo.HistoricoPartida;
import ifes.poo1.xadrez.util.persist.DAOHistoricoPartida;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Renan
 */
public class DAOHistoricoPartidaTest {
    
    public DAOHistoricoPartida historicoPartidaDAO;

    @Before
    public void before() {
        historicoPartidaDAO = new DAOHistoricoPartida();
    }
    
    @After
    public void after() throws SQLException, ClassNotFoundException{
        historicoPartidaDAO.deleteAll();
    }

    @Test
    public void criarTabelaUsuario() throws ClassNotFoundException, SQLException {

        // Criando a tabela
//        historicoPartidaDAO.dropTabela();
        historicoPartidaDAO.criarTabela();
    }

    @Test
    public void salvarHistoricoPartida() throws ClassNotFoundException, SQLException {
        HistoricoPartida historicoPartida = historicoPartidaDAO.create();

        historicoPartida.setDataHoraInicio(new Date());
        historicoPartida.setDataHoraFim(new Date());
        historicoPartida.setVencedor("Teste");

        // inserindo o usuario no banco de dados
        historicoPartidaDAO.insert(historicoPartida);
        Assert.assertNotSame(0, historicoPartida.getId());

    }

    @Test
    public void buscarHistoricoPartida() throws ClassNotFoundException, SQLException {
        HistoricoPartida historicoPartida = historicoPartidaDAO.create();

        historicoPartida.setDataHoraInicio(new Date());
        historicoPartida.setDataHoraFim(new Date());
        historicoPartida.setVencedor("Teste");

        historicoPartidaDAO.insert(historicoPartida);

        HistoricoPartida historicoPartidaRecuperado = historicoPartidaDAO.findbyID(historicoPartida.getId());
        Assert.assertNotNull(historicoPartidaRecuperado.getVencedor());

    }

    @Test
    public void listarHistoricoPartida() throws ClassNotFoundException, SQLException{

        HistoricoPartida historicoPartida = historicoPartidaDAO.create();

        historicoPartida.setDataHoraInicio(new Date());
        historicoPartida.setDataHoraFim(new Date());
        historicoPartida.setVencedor("Teste");

        historicoPartidaDAO.insert(historicoPartida);

        List<HistoricoPartida> historicos = historicoPartidaDAO.findAll();

        Assert.assertNotNull(historicos);

        Assert.assertNotSame(0, historicos.size());
    }

    @Test
    public void atualizarHistoricoPartida() throws ClassNotFoundException, SQLException{
        
        long id1, id2;
        Date inicio1, inicio2, fim1, fim2;
        String vencedor1, vencedor2;
        
        HistoricoPartida historicoPartida = historicoPartidaDAO.create();
        
        inicio1 = new Date();
        historicoPartida.setDataHoraInicio(inicio1);
        fim1 = new Date();
        historicoPartida.setDataHoraFim(fim1);
        vencedor1 = "Teste1";
        historicoPartida.setVencedor(vencedor1);

        historicoPartidaDAO.insert(historicoPartida);
        id1 = historicoPartida.getId();

        inicio2 = new Date();
        historicoPartida.setDataHoraInicio(inicio2);
        fim2 = new Date();
        historicoPartida.setDataHoraFim(fim2);
        vencedor2 = "Teste2";
        historicoPartida.setVencedor(vencedor2);
        
        historicoPartidaDAO.update(historicoPartida);
        id2 = historicoPartida.getId();
        
        Assert.assertSame(id1, id2);
        Assert.assertNotSame(inicio1, inicio2);
        Assert.assertNotSame(fim1, fim2);
        Assert.assertNotSame(vencedor1, vencedor2);
    }
    
    @Test
    public void deletarHistoricoPartida() throws SQLException, ClassNotFoundException{
        long id;
        HistoricoPartida historicoPartida = historicoPartidaDAO.create();
        HistoricoPartida historicoPartidaDeletado = null;

        historicoPartida.setDataHoraInicio(new Date());
        historicoPartida.setDataHoraFim(new Date());
        historicoPartida.setVencedor("Teste");

        historicoPartidaDAO.insert(historicoPartida);
        id = historicoPartida.getId();
        
        historicoPartidaDAO.delete(historicoPartida);
        historicoPartidaDeletado = historicoPartidaDAO.findbyID(id);
        
        Assert.assertEquals(0, historicoPartidaDeletado.getId());
    }
    
}
