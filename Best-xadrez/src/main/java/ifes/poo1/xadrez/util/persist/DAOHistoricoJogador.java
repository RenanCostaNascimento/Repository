/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.poo1.xadrez.util.persist;

import ifes.poo1.xadrez.model.cdp.jogo.HistoricoJogador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class DAOHistoricoJogador extends DAOGeneric implements DAO<HistoricoJogador> {

    public HistoricoJogador create() {

        return new HistoricoJogador();
    }

    public void criarTabela() throws ClassNotFoundException, SQLException {
        this.openConnection();

        String sql
                = " CREATE TABLE IF NOT EXISTS HistoricoJogador( "
                + " ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,"
                + " nome VARCHAR(255) NOT NULL,"
                + " vitorias INTEGER NOT NULL,"
                + " derrotas INTEGER NOT NULL,"
                + " empates INTEGER NOT NULL,"
                + " PRIMARY KEY (ID));"
                + " SHUTDOWN;";

        this.execute(sql);

        this.closeConnection();
    }

    @Override
    public void insert(HistoricoJogador obj) throws SQLException, ClassNotFoundException {
        this.openConnection();
        
        String sql = "INSERT INTO HistoricoJogador (nome, vitorias, empates, derrotas) VALUES ('" + obj.getNome()+ "'," + obj.getVitorias() + "," + obj.getEmpates()+ "," + obj.getDerrotas() +")";

        int id = this.executeUpdate(sql);
        obj.setId(id);

        this.closeConnection();
    }

    @Override
    public void update(HistoricoJogador obj) throws SQLException, ClassNotFoundException {
        this.openConnection();

        String sql = "UPDATE HistoricoJogador SET"
                + "(nome, vitorias, empates, derrotas) ="
                + "('" + obj.getNome()+ "'," + obj.getVitorias() + "," + obj.getEmpates()+ "," + obj.getDerrotas() +")"
                + "WHERE ID =" + obj.getId();

        this.executeUpdate(sql);

        this.closeConnection();
    }

    @Override
    public void delete(HistoricoJogador obj) throws SQLException, ClassNotFoundException {
        this.openConnection();

        String sql = "DELETE FROM HistoricoJogador "
                + "WHERE ID=" + obj.getId();

        this.executeUpdate(sql);

        this.closeConnection();
    }
    
    public void deleteAll() throws SQLException, ClassNotFoundException {
        this.openConnection();

        String sql = "DELETE FROM HistoricoJogador "
                + "WHERE nome LIKE 'Jogador1' "
                + "OR nome LIKE 'Jogador2'";

        this.executeUpdate(sql);

        this.closeConnection();
    }

    @Override
    public HistoricoJogador findbyID(Long id) throws SQLException, ClassNotFoundException {
        this.openConnection();

        String sql = "SELECT * FROM HistoricoJogador WHERE ID =" + id;

        HistoricoJogador historicoJogador = new HistoricoJogador();

        ResultSet rs = this.executeQuery(sql);

        while (rs.next()) {
            historicoJogador.setId(rs.getInt("ID"));
            historicoJogador.setNome(rs.getString("nome"));
            historicoJogador.setVitorias(rs.getInt("vitorias"));
            historicoJogador.setEmpates(rs.getInt("empates"));
            historicoJogador.setDerrotas(rs.getInt("derrotas"));
        }

        this.closeConnection();

        return historicoJogador;
    }
    
    public HistoricoJogador findbyNome(String nome) throws SQLException, ClassNotFoundException {
        this.openConnection();

        String sql = "SELECT * FROM HistoricoJogador WHERE nome like '" + nome +"'";

        HistoricoJogador historicoJogador = new HistoricoJogador();

        ResultSet rs = this.executeQuery(sql);

        while (rs.next()) {
            historicoJogador.setId(rs.getInt("ID"));
            historicoJogador.setNome(rs.getString("nome"));
            historicoJogador.setVitorias(rs.getInt("vitorias"));
            historicoJogador.setEmpates(rs.getInt("empates"));
            historicoJogador.setDerrotas(rs.getInt("derrotas"));
        }

        this.closeConnection();

        return historicoJogador;
    }

    @Override
    public List<HistoricoJogador> findAll() throws SQLException, ClassNotFoundException {
        this.openConnection();

        String sql = "SELECT * FROM HistoricoJogador";

        HistoricoJogador historicoJogador;
        List<HistoricoJogador> listaHistorico = new ArrayList<>();

        ResultSet rs = this.executeQuery(sql);
        while (rs.next()) {
            historicoJogador = new HistoricoJogador();
            
            historicoJogador.setId(rs.getInt("ID"));
            historicoJogador.setNome(rs.getString("nome"));
            historicoJogador.setVitorias(rs.getInt("vitorias"));
            historicoJogador.setEmpates(rs.getInt("empates"));
            historicoJogador.setDerrotas(rs.getInt("derrotas"));
            
            listaHistorico.add(historicoJogador);
        }

        this.closeConnection();

        return listaHistorico;
    }

}