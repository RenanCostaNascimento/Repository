/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.model.mainPanel;

import javax.swing.JPanel;
import ifes.poo2.xadrez.GUI.model.splitPane.SplitPane;
import ifes.poo2.xadrez.GUI.model.splitPane.SplitPaneFactory;
import ifes.poo2.xadrez.GUI.model.textBar.TextBar;

/**
 *
 * @author pdr
 */
public class MainPanel extends javax.swing.JPanel {

     
        
        private SplitPane splitPane = SplitPaneFactory.createMySplitPane();
        private TextBar textBar = TextBar.getInstanceOf();
        
        /**
         * Creates new form MainPanel
         * @return 
         */
        public static MainPanel create(){
                return new MainPanel();
        }
        
        private MainPanel() {
                initComponents();
                java.awt.GridBagConstraints gridBagConstraints;
                
                
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                add(splitPane, gridBagConstraints);
                
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                add(textBar, gridBagConstraints);
                
                revalidate();
        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT
         * modify this code. The content of this method is always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                setLayout(new java.awt.GridBagLayout());
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        // End of variables declaration//GEN-END:variables

        /**
         * @return the splitPane
         */
        public SplitPane getSplitPane() {
                return splitPane;
        }

        /**
         * @param splitPane the splitPane to set
         */
        public void setSplitPane(SplitPane splitPane) {
                this.splitPane = splitPane;
        }

        /**
         * @return the textBar
         */
        public TextBar getTextBar() {
                return textBar;
        }

        /**
         * @param textBar the textBar to set
         */
        public void setTextBar(TextBar textBar) {
                this.textBar = textBar;
        }
}
