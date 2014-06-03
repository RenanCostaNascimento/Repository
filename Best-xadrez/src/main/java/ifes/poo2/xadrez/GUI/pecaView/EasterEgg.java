/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.pecaView;

/**
 *
 * @author pdr
 */
public class EasterEgg {
        private static EasterEgg ee = null;
        private EasterEgg(){}
        
        private static String type = "normal";
        
        public static EasterEgg getInstanceOf(){
                if (ee == null) ee = new EasterEgg();
                return ee;
        }
        
        public static String getTypeEE(){
                return type;
        }
        
        public void changeGameType(){
                if (type.contains("normal")) type = "starwars";
                else type = "normal";
        }
        
}
