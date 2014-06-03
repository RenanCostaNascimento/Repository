/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo1.xadrez.util.exception;

/**
 *
 * @author pdr
 */
public class MuitosComponentesException extends Exception {
	public MuitosComponentesException(){
		super("Você está tentando adcionar mais de um componente ao jPanel!");
	}
}
