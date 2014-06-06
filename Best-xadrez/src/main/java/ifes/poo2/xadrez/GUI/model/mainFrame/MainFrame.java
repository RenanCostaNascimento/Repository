package ifes.poo2.xadrez.GUI.model.mainFrame;

import ifes.poo1.xadrez.model.cgt.ControlXadrez;
import ifes.poo2.xadrez.GUI.control.About;
import ifes.poo2.xadrez.GUI.control.GUIControl;
import java.awt.Color;
import javax.swing.JTextField;
import ifes.poo2.xadrez.GUI.model.mainPanel.MainPanel;
import ifes.poo2.xadrez.GUI.model.messagePane.MessagePane;
import ifes.poo2.xadrez.GUI.model.splitPane.SplitPane;
import ifes.poo2.xadrez.GUI.model.splitPane.SplitPaneFactory;
import ifes.poo2.xadrez.GUI.model.table.LineFactory;
import ifes.poo2.xadrez.GUI.model.table.ChessTable;
import ifes.poo2.xadrez.GUI.model.table.TableFactory;
import ifes.poo2.xadrez.GUI.model.textBar.TextBar;
import ifes.poo2.xadrez.GUI.model.table.Tile;
import ifes.poo2.xadrez.GUI.model.table.TileFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import sun.awt.AppContext;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pdr
 */
public class MainFrame extends javax.swing.JFrame {

        public static MainFrame create() {
                return new MainFrame(); //To change body of generated methods, choose Tools | Templates.
        }

        private MainPanel mainPanel = MainPanel.create();

        /**
         * Creates new form JFrame
         */
        public MainFrame() {
                initComponents();
                getContentPane().add(mainPanel);
                revalidate();
                pack();
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                topMenu = new javax.swing.JMenuBar();
                gameMenu = new javax.swing.JMenu();
                newSPGameItem = new javax.swing.JMenuItem();
                newMPGameItem = new javax.swing.JMenuItem();
                loadGameItem = new javax.swing.JMenuItem();
                highScoresItem = new javax.swing.JMenuItem();
                exitItem = new javax.swing.JMenuItem();
                helpMenu = new javax.swing.JMenu();
                aboutItem = new javax.swing.JMenuItem();
                howToPlayItem = new javax.swing.JMenu();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setLayout(new java.awt.GridLayout(1, 0));

                gameMenu.setText("Game");

                newSPGameItem.setText("Single Player game");
                newSPGameItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newSPGameItemActionPerformed(evt);
                        }
                });
                gameMenu.add(newSPGameItem);

                newMPGameItem.setText("Multiplayer game");
                newMPGameItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newMPGameItemActionPerformed(evt);
                        }
                });
                gameMenu.add(newMPGameItem);

                loadGameItem.setText("Load Game");
                gameMenu.add(loadGameItem);

                highScoresItem.setText("High Scores");
                gameMenu.add(highScoresItem);

                exitItem.setText("Exit");
                exitItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                exitItemActionPerformed(evt);
                        }
                });
                gameMenu.add(exitItem);

                topMenu.add(gameMenu);

                helpMenu.setText("Help");

                aboutItem.setText("About");
                aboutItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                aboutItemActionPerformed(evt);
                        }
                });
                helpMenu.add(aboutItem);

                howToPlayItem.setText("jMenu1");
                helpMenu.add(howToPlayItem);

                topMenu.add(helpMenu);

                setJMenuBar(topMenu);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar?", "Deseja salvar?", JOptionPane.INFORMATION_MESSAGE);

                if (opcao == 0) {

                } else if (opcao == 1) {
                        System.exit(0);
                }

        }//GEN-LAST:event_exitItemActionPerformed

        private void newSPGameItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSPGameItemActionPerformed
                String nome = "";

                while (nome.isEmpty()) {
                        nome = JOptionPane.showInputDialog(null, "Digite seu nome", "Digite seu nome", JOptionPane.OK_CANCEL_OPTION);

                }

                ControlXadrez.getInstanceOf().iniciarJogoSingleplayer(nome);
                GUIControl.getInstanceOf().startGameFacade();
        }//GEN-LAST:event_newSPGameItemActionPerformed

        private void newMPGameItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMPGameItemActionPerformed
                JTextField jogador1 = new JTextField();
                JTextField jogador2 = new JTextField();
                int option;
                Object[] message = {
                        "Digite o nome dos jogadores",
                        "Jogador1:", jogador1,
                        "Jogador2:", jogador2
                };

                //option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
                while (jogador1.getText().isEmpty() || jogador2.getText().isEmpty() || jogador1.getText().contains(jogador2.getText())) {
                        if (jogador1.getText().isEmpty() || jogador2.getText().isEmpty()) {
                                message[0] = "Digite o nome dos jogadores";
                                option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
                        }

                        if (jogador1.getText().contains(jogador2.getText())) {
                                message[0] = "O nome deve ser diferente!";
                                option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
                        }

                }
                String[] nomes = {jogador1.getText(), jogador2.getText()};
                GUIControl.getInstanceOf().startGameMultiplayer(nomes);


        }//GEN-LAST:event_newMPGameItemActionPerformed

        private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
                
                JOptionPane.showMessageDialog(null, "THE BEST CHESS\n\nHARD CODED.\nDONE.\n\nBY PEDRO AND RENAN","About Best Chess", JOptionPane.PLAIN_MESSAGE, null);
                
        }//GEN-LAST:event_aboutItemActionPerformed

        /**
         * @param args the command line arguments
         */

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenuItem aboutItem;
        private javax.swing.JMenuItem exitItem;
        private javax.swing.JMenu gameMenu;
        private javax.swing.JMenu helpMenu;
        private javax.swing.JMenuItem highScoresItem;
        private javax.swing.JMenu howToPlayItem;
        private javax.swing.JMenuItem loadGameItem;
        private javax.swing.JMenuItem newMPGameItem;
        private javax.swing.JMenuItem newSPGameItem;
        private javax.swing.JMenuBar topMenu;
        // End of variables declaration//GEN-END:variables

        /**
         * @return the mainPanel
         */
        public MainPanel getMainPanel() {
                return mainPanel;
        }

        /**
         * @param mainPanel the mainPanel to set
         */
        public void setMainPanel(MainPanel mainPanel) {
                this.mainPanel = mainPanel;
        }

        public ChessTable getChessTable() {
                return (ChessTable) getMainPanel().getSplitPane().getLeftSplitComponents();
        }

        public JTextField getTextField() {
                return getMainPanel().getTextBar().getTextField();
        }

        public MessagePane getMessagePane() {
                return (MessagePane) getMainPanel().getSplitPane().getRightSplitComponent();
        }
}
