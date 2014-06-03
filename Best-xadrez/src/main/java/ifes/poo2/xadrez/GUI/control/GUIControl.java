/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.control;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasPool;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import ifes.poo1.xadrez.util.exception.MuitosComponentesException;
import ifes.poo2.xadrez.GUI.model.mainFrame.MainFrame;
import ifes.poo2.xadrez.GUI.model.messagePane.MessagePane;
import ifes.poo2.xadrez.GUI.model.table.ChessTable;
import ifes.poo2.xadrez.GUI.model.table.Line;
import ifes.poo2.xadrez.GUI.model.table.TableFactory;
import ifes.poo2.xadrez.GUI.model.table.Tile;
import ifes.poo2.xadrez.GUI.model.textBar.TextBar;
import ifes.poo2.xadrez.GUI.pecaView.PecaView;
import ifes.poo2.xadrez.GUI.pecaView.PecaViewFactory;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author pdr
 */
public class GUIControl {
        private Tabuleiro tabuleiro = new Tabuleiro();
        private MainFrame mf = MainFrame.create();
        private static GUIControl gc = null;
        public static GUIControl getInstanceOf(){
                if (gc == null) gc = new GUIControl();
                return gc;
        }
        private GUIControl(){}
        
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
        
        private void addPeca(PecaView com, Posicao pos){
                 
                try {
                        mf.getChessTable().getPosicao(pos).addPecaView(com);
                } catch (MuitosComponentesException ex) {
                        Logger.getLogger(GUIControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
        }
        
        private void removePeca(Posicao pos){
                mf.getChessTable().getPosicao(pos).removeAll();
        }
        
        private PecaView getPecaPos(Posicao pos){
                return (PecaView) mf.getChessTable().getPosicao(pos).getComponent(0);
        }
        
        private void iluminarTile(Posicao pos){
                mf.getChessTable().getPosicao(pos).iluminar();
        }
        
        private void restoreOriginalTileColor(Posicao pos){
                mf.getChessTable().getPosicao(pos).setOriginalColor();
        }
        
        public void restoreAllOriginalTileColors(){
                ChessTable ct = getChessTable();
                Line[] ln = ct.getLines();
                
                for (int i = 0; i<8; i++){
                        for (int j=0; j<8; j++){
                                ln[i].getTile(j).setOriginalColor();
                        }
                        
                }
                
        }
        
        public void moverPeca(Posicao posInicial, Posicao posFinal){
                ChessTable ct = getChessTable();
                Tile tileInicial = ct.getPosicao(posInicial);
                Tile tileFinal = ct.getPosicao(posFinal);
                
                PecaView pv =  tileInicial.getPecaView();
                if ((tileFinal.getComponentCount() == 0 ) && (tileInicial.getPecaView().getPeca().mover(posFinal))) {
                        try {
                                tileFinal.addPecaView(pv);
                                tileInicial.remove(pv);
                                pv.getPeca().setPosicao(ct.getPosicaoTile(tileFinal));
                        } catch (MuitosComponentesException ex) {
                                Logger.getLogger(GUIControl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                }                
                
                
        }
        
        public void iluminarPosicoesPossiveis(Tile t ){
                
                ChessTable ct = getChessTable();
                
                t.setColor(Color.GREEN);
                List<Posicao> posicoes = tabuleiro.posicoesPossiveisPeca(t.getPecaView().getPeca().getPosicao());
                //for (int i=0; i<posicoes.size(); i++) ct.getPosicao(posicoes.get(i)).iluminar();  
                for (int i=0; i<posicoes.size(); i++) (ct.getPosicao(posicoes.get(i))).iluminar();
                System.out.println(t.getPecaView().getPeca().getNome());
                for (int i=0; i<posicoes.size(); i++) System.out.println("Coluna: "+posicoes.get(i).getColuna()+"\nLinha:"+posicoes.get(i).getLinha());
                
                /*
                ChessTable ct = getChessTable();
                PecaView pv = t.getPecaView();
                
                for (int i = 0; i<8; i++){
                        for (int j=0; j<8; j++){
                                Posicao pos = new Posicao(i, j);
                                if (pv.getPeca().mover(pos)){
                                        ct.getPosicao(pos).iluminar();                                     
                                }
                                if ((ct.getPosicao(pos).getComponentCount() > 0) && pv.getPeca().capturar(pos) && (ct.getPosicao(pos).getPecaView().getCor() != t.getPecaView().getCor())){
                                                ct.getPosicao(pos).setColor(Color.RED);
                                }
                        }
                        
                }
                t.setColor(Color.GREEN);
                   
                */
                        
                
                
        }
        
        private void addPecaOnPosition(Posicao pos, Peca peca){
                peca.setPosicao(pos);
                try {
                        getChessTable().getPosicao(pos).addPecaView(new PecaView(peca));
                } catch (MuitosComponentesException ex) {
                        Logger.getLogger(GUIControl.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        private void addPecaOnPosition(Posicao pos, NomePecas np, Cores cor){
                 addPecaOnPosition(pos, PecasPool.getInstanceOf().getPeca(np, cor, pos));
         }
        
        private void populateGUITable(){
                
                for (int i=0; i<8; i++){
                        for (int j=0; j<8; j++){
                                Posicao pos = Posicao.create(i, j);
                                if (tabuleiro.getCasas(pos) != null) addPecaOnPosition(pos, tabuleiro.getCasas(pos));
                        }
                }
        } 
         
        
        public void startGameFacade(){
                populateGUITable();
        }
                
        public void debug(){
                startGameFacade();
                
        }
}

