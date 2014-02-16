/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.util.persist;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Classe para carregar um objeto serializado em mem�ria persistente.
 * @author Pedro
 */
public class Deserializador<T> implements Serializable {

	/**
     * Carrega um objeto serializado para a mem�ria.
     * 
     * @param path - Diret�rio, URL, de onde est� o objeto serializado.
     * @return Object - Retorna o Objeto, que agora est� em mem�ria. 
     * @throws Exception - N�o for poss�vel acessar o local para armazenamento.
     */
    public Object deserializar(String path) throws Exception {
        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream d = new ObjectInputStream(inFile);
        T o = (T) d.readObject();
        d.close();
        return o;
    }



}
