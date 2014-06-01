/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.control;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.util.exception.MuitosComponentesException;
import javax.swing.JTextField;
import ifes.poo2.xadrez.GUI.model.mainFrame.MainFrame;
import ifes.poo2.xadrez.GUI.model.messagePane.MessagePane;
import ifes.poo2.xadrez.GUI.model.table.ChessTable;
import ifes.poo2.xadrez.GUI.model.table.Posicao;
import ifes.poo2.xadrez.GUI.model.table.TableFactory;
import ifes.poo2.xadrez.GUI.model.textBar.TextBar;
import ifes.poo2.xadrez.GUI.pecaView.PecaView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author pdr
 */
public class GUIControl {
        private MainFrame mf = MainFrame.create();
        public void startGUI() {
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
                 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
        //</editor-fold>

                /* Create and display the form */
               java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                mf.setVisible(true);
                        }
                });
        }
        
        public MainFrame getMainframe(){
                return mf;
        }
        
        private ChessTable getChessTable(){
                return mf.getChessTable();
        }
        
        private MessagePane getMessagePane(){
                return mf.getMessagePane();
        }
        
        private JTextField getTextField(){
                return mf.getTextField();
        }
        
        public void add(){
                 PecaView jlabel1 = new PecaView(NomePecas.Bispo, Cores.branco);
                try {
                        mf.getChessTable().getPosicao(new Posicao(0,0)).addPecaView(jlabel1);
                } catch (MuitosComponentesException ex) {
                        Logger.getLogger(GUIControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
        }
        
        
        
        
}
