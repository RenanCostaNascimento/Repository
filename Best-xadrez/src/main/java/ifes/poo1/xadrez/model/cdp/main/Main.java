package ifes.poo1.xadrez.model.cdp.main;

import ifes.poo1.xadrez.model.cgt.ControlXadrez;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        ControlXadrez control;
        try {
            control = new ControlXadrez();
            control.controlarMenuInicial();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não foi possível carregar os dados!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
