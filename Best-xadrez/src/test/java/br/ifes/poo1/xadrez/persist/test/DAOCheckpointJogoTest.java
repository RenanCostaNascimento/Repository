/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.poo1.xadrez.persist.test;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.Checkpoint;
import ifes.poo1.xadrez.model.cdp.jogo.Jogo;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import ifes.poo1.xadrez.util.persist.DAOCheckpoint;
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
public class DAOCheckpointJogoTest {

    public DAOCheckpoint checkpointJogoDAO;

    public void criarCheckpoint(Checkpoint checkpoint) {

        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador("Jogador1", Cores.branco);
        Jogador jogador2 = new Jogador("Jogador2", Cores.preto);
        Jogo jogo = new Jogo(tabuleiro, jogador1, jogador2);

        checkpoint.setNome("Jogo1");
        checkpoint.setJogo(jogo);
        checkpoint.setDataSalvamento(new Date());
    }

    @Before
    public void before() throws ClassNotFoundException, SQLException {
        checkpointJogoDAO = new DAOCheckpoint();
//        checkpointJogoDAO.dropTabela();
//        checkpointJogoDAO.criarTabela();
    }

    @After
    public void after() throws SQLException, ClassNotFoundException {
        checkpointJogoDAO.deleteAllAfterTest();
    }

    @Test
    public void criarTabela() throws ClassNotFoundException, SQLException {
//        checkpointJogoDAO.dropTabela();
        checkpointJogoDAO.criarTabela();
    }

    @Test
    public void insert() throws ClassNotFoundException, SQLException {
        Checkpoint checkpoint = checkpointJogoDAO.create();

        criarCheckpoint(checkpoint);

        checkpointJogoDAO.insert(checkpoint);
        Assert.assertNotSame(0, checkpoint.getId());

    }

//    @Test
//    public void update() throws SQLException, ClassNotFoundException {
//        long id1, id2;
//        int numeroJogada1, numeroJogada2;
//        String nome1, nome2, jogador1, jogador2, comando1, comando2;
//        CheckpointJogo checkpointJogo;
//
//        checkpointJogo = checkpointJogoDAO.create();
//
//        nome1 = "Jogo1";
//        checkpointJogo.setNomeJogo(nome1);
//        jogador1 = "Jogador1";
//        checkpointJogo.setNomeJogador(jogador1);
//        comando1 = "1221";
//        checkpointJogo.setComando(comando1);
//        numeroJogada1 = 1;
//        checkpointJogo.setNumeroJogada(numeroJogada1);
//
//        checkpointJogoDAO.insert(checkpointJogo);
//        id1 = checkpointJogo.getId();
//
//        nome2 = "Jogo2";
//        checkpointJogo.setNomeJogo(nome2);
//        jogador2 = "Jogador2";
//        checkpointJogo.setNomeJogador(jogador2);
//        comando2 = "2112";
//        checkpointJogo.setComando(comando2);
//        numeroJogada2 = 2;
//        checkpointJogo.setNumeroJogada(numeroJogada2);
//
//        checkpointJogoDAO.update(checkpointJogo);
//        id2 = checkpointJogo.getId();
//        
//        Assert.assertSame(id1, id2);
//        Assert.assertNotSame(nome1, nome2);
//        Assert.assertNotSame(jogador1, jogador2);
//        Assert.assertNotSame(comando1, comando2);
//        Assert.assertNotSame(numeroJogada1, numeroJogada2);
//    }
//
//    @Test
//    public void delete() throws SQLException, ClassNotFoundException {
//        long id;
//        CheckpointJogo checkpointJogo = checkpointJogoDAO.create();
//        CheckpointJogo checkpointDeletado = null;
//
//        criarCheckpoint(checkpointJogo);
//
//        checkpointJogoDAO.insert(checkpointJogo);
//        id = checkpointJogo.getId();
//
//        checkpointJogoDAO.delete(checkpointJogo);
//        checkpointDeletado = checkpointJogoDAO.findbyID(id);
//
//        Assert.assertEquals(0, checkpointDeletado.getId());
//    }
//    
//    @Test
//    public void findAllByNome() throws ClassNotFoundException, SQLException{
//
//        Checkpoint checkpoint = checkpointJogoDAO.create();
//
//        criarCheckpoint(checkpoint);
//
//        checkpointJogoDAO.insert(checkpoint);
//
//        List<CheckpointJogo> saves = checkpointJogoDAO.findAll("Jogo1");
//
//        Assert.assertNotNull(saves);
//        Assert.assertNotSame(0, saves.size());
//    }
//    
    @Test
    public void findAll() throws ClassNotFoundException, SQLException {

        Checkpoint checkpoint = checkpointJogoDAO.create();

        criarCheckpoint(checkpoint);

        checkpointJogoDAO.insert(checkpoint);

        List<Checkpoint> saves = checkpointJogoDAO.findAll();
        
        Assert.assertNotNull(saves);
        Assert.assertNotSame(0, saves.size());
    }
//
//    @Test
//    public void findById() throws SQLException, ClassNotFoundException {
//        Checkpoint checkpoint = checkpointJogoDAO.create();
//
//        criarCheckpoint(checkpoint);
//
//        checkpointJogoDAO.insert(checkpoint);
//
//        Checkpoint checkpointRecuperado = checkpointJogoDAO.findbyID(checkpoint.getId());
//        Assert.assertNotSame(0, checkpointRecuperado.getId());
//    }
    
    @Test
    public void findByNome() throws SQLException, ClassNotFoundException {
        Checkpoint checkpoint = checkpointJogoDAO.create();

        criarCheckpoint(checkpoint);

        checkpointJogoDAO.insert(checkpoint);

        Checkpoint checkpointRecuperado = checkpointJogoDAO.findbyNome(checkpoint.getNome());
        Assert.assertNotSame(0, checkpointRecuperado.getId());
    }

}
