/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.util.persist;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *Classe para guardar um objeto em memória persistente.
 * @author Pedro
 */
public class Serializador<T extends Serializable> {
    /**
     * Guarda o objeto em memória persistente.
     * @param path - String com o diretório/URL do local aonde se quer armazenar o objeto.
     * @param object - O objeto o qual se quer armazenar.
     * @throws Exception - Não for possível acessar o local para armazenamento.
     */
    public void serializar(String path, T object) throws Exception {
        FileOutputStream outFile = new FileOutputStream(path);
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        s.writeObject(object);
        s.close();
        
    }



    
}
