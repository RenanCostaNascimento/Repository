/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.utils.jogadaInterpreter;

/**
 *
 * @author cthulhu
 */
public class Interpretador extends InterpretadorAbs{
	private static Interpretador interpretador = null;
	
	private Interpretador(){
		InterpretadorAbs jogada = new JogadaInterpreter();
		jogada.addNext(new MensagemInterpreter());
		this.addNext(jogada);
	}
	
	public static Interpretador getInstanceOf(){
		if (interpretador == null) interpretador = new Interpretador();
		return interpretador;
	}
	
	@Override
	public void interpretar(String input) {
		this.interpretaProximo(input);
	}
	
	
	
	
	
}
