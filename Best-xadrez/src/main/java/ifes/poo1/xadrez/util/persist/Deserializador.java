/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.util.persist;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Classe para carregar um objeto serializado em memória persistente.
 * @author Pedro
 */
public class Deserializador {
    /**
     * Carrega um objeto serializado para a memória.
     * 
     * @param path - Diretório, URL, de onde está o objeto serializado.
     * @return Object - Retorna o Objeto, que agora está em memória. 
     * @throws Exception - Não for possível acessar o local para armazenamento.
     */
    public Object deserializar(String path) throws Exception {
        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream d = new ObjectInputStream(inFile);
        Object o = d.readObject();
        d.close();
        return o;
    }



}
