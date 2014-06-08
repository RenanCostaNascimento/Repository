package ifes.poo2.xadrez.GUI.model.mainFrame;

import ifes.poo1.xadrez.model.cdp.jogo.Checkpoint;
import ifes.poo1.xadrez.model.cdp.pecas.Peao;
import ifes.poo1.xadrez.model.cgt.ControlXadrez;
import ifes.poo2.xadrez.GUI.control.GUIControl;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cthulhu
 */
public class SelectSavedGame extends javax.swing.JPanel {

        /**
         * Creates new form SelectSavedGame
         */
       private  DefaultListModel listModel = new DefaultListModel();
        
        public SelectSavedGame() {
                initComponents();
                carregarJogosSalvos();
                
                
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jScrollPane1 = new javax.swing.JScrollPane();
                jList1 = new javax.swing.JList();

                setLayout(new java.awt.GridLayout());

                jList1.setModel(listModel);
                jScrollPane1.setViewportView(jList1);

                add(jScrollPane1);
        }// </editor-fold>//GEN-END:initComponents

        public JList getList(){
                return jList1;
        }
        
        public void addElement(Object object){
                listModel.addElement(object);
        }
        
        public void carregarJogosSalvos(){
                List jogosSalvos = ControlXadrez.getInstanceOf().exibirJogosSalvos();
               for (Object jogosSalvo : jogosSalvos) {
                       listModel.addElement(jogosSalvo);
               }
        }
        
        public void carregarJogoSalvo(){
                GUIControl.getInstanceOf().carregarJogo((Checkpoint) jList1.getSelectedValue());
        }
        
        
        
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JList jList1;
        private javax.swing.JScrollPane jScrollPane1;
        // End of variables declaration//GEN-END:variables
}
