/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.pecaView;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
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
public class PecaView extends JLabel{
        private Peca peca;
        private BufferedImage myPicture;    
        private BufferedImage image;
        
        public PecaView(Peca peca) {
                this.peca = peca;
                try {
                        myPicture = ImageIO.read(new File("imagens/"+peca.getCor().toString()+peca.getNome().toString()+".png"));
                } catch (IOException ex) {
                        Logger.getLogger(PecaView.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.setIcon(new ImageIcon(getMyPicture()));
        }
        

        /**
         * @return the peca
         */
        public Peca getPeca() {
                return peca;
        }

        /**
         * @param peca the peca to set
         */
        public void setPeca(Peca peca) {
                this.peca = peca;
        }

        /**
         * @return the cor
         */
        public Cores getCor() {
                return peca.getCor();
        }

        /**
         * @param cor the cor to set
         */
        

        /**
         * @return the myPicture
         */
        public BufferedImage getMyPicture() {
                return myPicture;
        }

        /**
         * @param myPicture the myPicture to set
         */
        public void setMyPicture(BufferedImage myPicture) {
                this.myPicture = myPicture;
        }

        /**
         * @return the image
         */
        public BufferedImage getImage() {
                return image;
        }

        /**
         * @param image the image to set
         */
        public void setImage(BufferedImage image) {
                this.image = image;
        }
        
        
}
