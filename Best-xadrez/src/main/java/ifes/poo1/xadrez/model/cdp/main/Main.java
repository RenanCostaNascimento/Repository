package ifes.poo1.xadrez.model.cdp.main;

import ifes.poo1.xadrez.model.cgd.highscore.HighScore;
import ifes.poo1.xadrez.model.cgd.highscore.Placar;
import ifes.poo1.xadrez.model.cgt.Control;


public class Main {
    
        
    
    
	public static void main(String[] args) {
//		Control control = new Control();
//		
//		control.controlarMenuInicial();
            
                HighScore hs = new HighScore();
                
                hs.serializar();
                hs.imprime();
                
                
            
             
	}

}
