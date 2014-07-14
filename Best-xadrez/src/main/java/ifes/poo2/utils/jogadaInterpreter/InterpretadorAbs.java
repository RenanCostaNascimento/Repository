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
public abstract class InterpretadorAbs {
	protected InterpretadorAbs next = null;
	
	abstract public void interpretar(String input);
	
	public void interpretaProximo(String input){
		if (this.next != null) this.next.interpretar(input);
	}
	
	public void addNext(InterpretadorAbs n){
		this.next = n;
	}
}
