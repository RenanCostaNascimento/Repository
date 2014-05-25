/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.poo1.xadrez.util.persist;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Renan
 */
public interface DAO<T> {

    T create();

    void insert(T obj) throws SQLException, ClassNotFoundException;

    void update(T obj) throws SQLException, ClassNotFoundException;

    void delete(T obj) throws SQLException, ClassNotFoundException;

    T findbyID(Long id) throws SQLException, ClassNotFoundException;

    List<T> findAll() throws SQLException, ClassNotFoundException;
}
