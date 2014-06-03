package ifes.poo1.xadrez.model.cdp.main;

import ifes.poo1.xadrez.model.cgt.ControlXadrez;

public class Main {

    public static void main(String[] args) {

        ControlXadrez control;
        control = ControlXadrez.getInstanceOf();
        control.controlarMenuInicial();
    }
}
