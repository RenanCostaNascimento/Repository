/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.poo2.xadrez.GUI.model.textBar;

import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cgt.ControlXadrez;
import ifes.poo1.xadrez.util.exception.CaminhoBloqueadoException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaInexistenteException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaPropriaException;
import ifes.poo1.xadrez.util.exception.CasaVaziaException;
import ifes.poo1.xadrez.util.exception.MovimentoInvalidoException;
import ifes.poo1.xadrez.util.exception.PecaAlheiaException;
import ifes.poo2.xadrez.GUI.control.GUIControl;
import ifes.poo2.xadrez.GUI.model.messagePane.MessagePane;
import ifes.poo2.xadrez.GUI.model.table.ChessTable;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author pdr
 */
public class TextBar extends javax.swing.JPanel {

        private static TextBar textBar = null;

        /**
         * Creates new form TextBar
         */
        private TextBar() {
                initComponents();
        }

        public static TextBar getInstanceOf() {
                if (textBar == null) {
                        textBar = new TextBar();
                }
                return textBar;
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                textField = new javax.swing.JTextField();

                setLayout(new java.awt.GridLayout(1, 0));

                textField.setText("Entre com a sua jogada ou digite uma mensagem com \":m mensagem\"");
                textField.setToolTipText("");
                textField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                textField.setMaximumSize(new java.awt.Dimension(556, 34));
                textField.setMinimumSize(new java.awt.Dimension(556, 34));
                textField.setPreferredSize(new java.awt.Dimension(556, 34));
                textField.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                textFieldFocusGained(evt);
                        }
                });
                textField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                textFieldActionPerformed(evt);
                        }
                });
                textField.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                textFieldKeyPressed(evt);
                        }
                });
                add(textField);
        }// </editor-fold>//GEN-END:initComponents

        private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_textFieldActionPerformed

        private void textFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldFocusGained
                textField.setText(null);
        }//GEN-LAST:event_textFieldFocusGained

        private void textFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKeyPressed
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                        String input = textField.getText();
                        Calendar cal = Calendar.getInstance();
                        cal.getTime();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                        if (input.startsWith(":m")) {
                                input = input.replace(":m", "");
                                GUIControl.getInstanceOf().enviarMensagemJogador(input);
                                //MessagePane.addMessage("<<" + sdf.format(cal.getTime()) + " Player" + " says >> \n" + input + "\n");
                                //TODO: save in a logfile
                        }
                        if (input.startsWith(":x")) {
                                ChessTable.getInstanceOf().limparTabuleiro();
                        }
                        if (input.startsWith(":r")) {
                                GUIControl.getInstanceOf().populateGUITable();
                        }
                        if (input.contentEquals("roque")) {
                                GUIControl.getInstanceOf().enviarMensagem("Entre com 'roqueMenor' ou 'roqueMaior' para especificar a jogada" );
                        } 
                        if (input.contentEquals("roqueMenor") || input.contentEquals("roquemenor") ) {
                                GUIControl.getInstanceOf().realizarRoqueMenor();
                        } 
                        if (input.contentEquals("roqueMaior") || input.contentEquals("roquemaior") ) {
                                GUIControl.getInstanceOf().realizarRoqueMaior();
                        } 
                        else {
                                if (input.length() == 4) {
                                        Posicao posIni = Posicao.create(Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(1)));
                                        Posicao posFin = Posicao.create(Character.getNumericValue(input.charAt(2)), Character.getNumericValue(input.charAt(3)));
                                        GUIControl.getInstanceOf().moverPeca(posIni, posFin);
                                } else {
                                        GUIControl.getInstanceOf().enviarMensagemJogadaInvalida();
                                }
                        }
                        textField.setText(null);
                }
                
        


        }//GEN-LAST:event_textFieldKeyPressed

public JTextField getTextField() {
                return textField;
        }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTextField textField;
        // End of variables declaration//GEN-END:variables
}
