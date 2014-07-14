/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.poo2.utils.jogadaInterpreter;

import ifes.poo2.xadrez.GUI.control.GUIControl;

/**
 *
 * @author cthulhu
 */
public class MensagemInterpreter extends InterpretadorAbs {

	public void interpretar(String input) {
		if (input.startsWith(":m")) {
			input = input.replace(":m", "");
			GUIControl.getInstanceOf().enviarMensagemJogador(input);
		} else {
			this.next.interpretaProximo(input);
		}
	}

}
