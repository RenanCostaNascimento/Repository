/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.poo2.utils.jogadaInterpreter;

import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo2.xadrez.GUI.control.GUIControl;

/**
 *
 * @author cthulhu
 */
public class JogadaInterpreter extends InterpretadorAbs {	
	private void roque() {
		GUIControl.getInstanceOf().enviarMensagem("Entre com 'roqueMenor' ou 'roqueMaior' para especificar a jogada");
	}

	private void roqueMenor() {
		GUIControl.getInstanceOf().realizarRoqueMenor();
	}

	private void roqueMaior() {
		GUIControl.getInstanceOf().realizarRoqueMaior();
	}

	private void jogada(String input) {
		if (input.length() == 4) {
			Posicao posIni = Posicao.create(Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(1)));
			Posicao posFin = Posicao.create(Character.getNumericValue(input.charAt(2)), Character.getNumericValue(input.charAt(3)));
			GUIControl.getInstanceOf().moverPeca(posIni, posFin);
		} else {
			GUIControl.getInstanceOf().enviarMensagemJogadaInvalida();
		}
	}

	@Override
	public void interpretar(String input) {
		if (input.contentEquals("roque")) {
			roque();
		}
		if (input.contentEquals("roqueMenor") || input.contentEquals("roquemenor")) {
			roqueMenor();
		}
		if (input.contentEquals("roqueMaior") || input.contentEquals("roquemaior")) {
			roqueMaior();
		} else {
			jogada(input);
		}
		
		this.next.interpretaProximo(input);
	}

}
