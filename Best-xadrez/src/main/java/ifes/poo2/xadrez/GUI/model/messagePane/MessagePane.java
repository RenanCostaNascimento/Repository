package ifes.poo2.xadrez.GUI.model.messagePane;

import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pdr
 */
public class MessagePane extends javax.swing.JPanel {

        private static MessagePane messagePane = null;

        private MessagePane() {
                initComponents();
        }

        public static MessagePane getInstanceOf() {
                if (messagePane == null) {
                        messagePane = new MessagePane();
                }
                return messagePane;
        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT
         * modify this code. The content of this method is always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jScrollPane1 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();

                setLayout(new java.awt.GridLayout(1, 0));

                jTextArea1.setEditable(false);
                jTextArea1.setColumns(20);
                jTextArea1.setLineWrap(true);
                jTextArea1.setRows(5);
                jTextArea1.setWrapStyleWord(true);
                jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTextArea1MouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(jTextArea1);

                add(jScrollPane1);
        }// </editor-fold>//GEN-END:initComponents

        private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked

        }//GEN-LAST:event_jTextArea1MouseClicked

        /**
         *
         * @param message
         */
        public static void addMessage(String message) {
                jTextArea1.append(message);
        }

        public static void addMessageJogada(Posicao posI, Posicao posF, Jogador jogador) {
                String msg = "<<" + getTime() + " " + jogador.getNome() + " jogou:" + posI.toString() + " para " + posF.toString() + ">>\n";
                addMessage(msg);
        }

        public static void addMessageJogador(Jogador jogador,String message) {
                addMessage("<<" + getTime() + " " + jogador.getNome() + " says: \n" + message + ">>\n");
        }
        
        public static void addMessageJogadaInvalida(){
                addMessage("<<" + getTime() + " jogada inválida >>\n");
        }
        
        private static String getTime(){
                Calendar cal = Calendar.getInstance();
                cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                return sdf.format(cal.getTime());
        }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JScrollPane jScrollPane1;
        private static javax.swing.JTextArea jTextArea1;
        // End of variables declaration//GEN-END:variables
}
