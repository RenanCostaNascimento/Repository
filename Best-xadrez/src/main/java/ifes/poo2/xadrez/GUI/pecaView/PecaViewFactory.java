/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.pecaView;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author pdr
 */
public class PecaViewFactory {
        private static PecaView pecaView; 
        private PecaViewFactory(){}
        /*
        public static PecaView createPeca(NomePecas peca,  Cores cor){
                pecaView = new PecaView();
                
                
                try {
                        pecaView.setMyPicture(ImageIO.read(new File("/home/pdr/Documents/chessPieces/"+cor.toString()+peca.toString()+".png")));
                } catch (IOException ex) {
                        Logger.getLogger(PecaView.class.getName()).log(Level.SEVERE, null, ex);
                }
               pecaView.setIcon(new ImageIcon(pecaView.getMyPicture()));
               
               return pecaView;
        }
        */
                
                
        
}
