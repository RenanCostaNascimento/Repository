/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.control;

/**
 *
 * @author pdro
 */
public class About extends javax.swing.JPanel {

        /**
         * Creates new form About
         */
        public About() {
                initComponents();
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
                jTextPane1 = new javax.swing.JTextPane();

                addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                formMouseClicked(evt);
                        }
                });
                setLayout(new java.awt.GridLayout(0, 1));

                jScrollPane1.setToolTipText("");
                jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

                jTextPane1.setEditable(false);
                jTextPane1.setText("THE BEST CHESS\nDONE.\nHARD CODED.\nBY PEDRO AND RENAN");
                jTextPane1.setAutoscrolls(false);
                jTextPane1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTextPane1MouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(jTextPane1);

                add(jScrollPane1);
        }// </editor-fold>//GEN-END:initComponents

        private void jTextPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPane1MouseClicked
                
        }//GEN-LAST:event_jTextPane1MouseClicked

        private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
                
        }//GEN-LAST:event_formMouseClicked


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextPane jTextPane1;
        // End of variables declaration//GEN-END:variables
}
