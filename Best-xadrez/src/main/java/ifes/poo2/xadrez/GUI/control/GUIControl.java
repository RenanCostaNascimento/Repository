/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.poo2.xadrez.GUI.control;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.Checkpoint;
import ifes.poo1.xadrez.model.cdp.jogo.Jogo;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
import ifes.poo1.xadrez.model.cdp.pecas.factory.PecasPool;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import ifes.poo1.xadrez.model.cgt.ControlXadrez;
import ifes.poo1.xadrez.util.exception.CaminhoBloqueadoException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaInexistenteException;
import ifes.poo1.xadrez.util.exception.CapturaInvalidaPecaPropriaException;
import ifes.poo1.xadrez.util.exception.CasaVaziaException;
import ifes.poo1.xadrez.util.exception.JogoInexistenteExcpetion;
import ifes.poo1.xadrez.util.exception.MovimentoInvalidoException;
import ifes.poo1.xadrez.util.exception.MuitosComponentesException;
import ifes.poo1.xadrez.util.exception.PecaAlheiaException;
import ifes.poo1.xadrez.util.exception.RoqueInvalidoCaminhoBloqueadoException;
import ifes.poo1.xadrez.util.exception.RoqueInvalidoReiAmeacadoException;
import ifes.poo1.xadrez.util.exception.RoqueInvalidoReiMovimentadoException;
import ifes.poo1.xadrez.util.exception.RoqueInvalidoTorreMovimentadaException;
import ifes.poo2.xadrez.GUI.model.mainFrame.MainFrame;
import ifes.poo2.xadrez.GUI.model.messagePane.MessagePane;
import ifes.poo2.xadrez.GUI.model.table.ChessTable;
import ifes.poo2.xadrez.GUI.model.table.Line;
import ifes.poo2.xadrez.GUI.model.table.Tile;
import ifes.poo2.xadrez.GUI.model.textBar.TextBar;
import ifes.poo2.xadrez.GUI.pecaView.PecaView;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author pdr
 */
public class GUIControl {

        public enum TipoJogo {

                singleplayer, multiplayer
        }

        private ControlXadrez controlXadrez = ControlXadrez.getInstanceOf();
        private MainFrame mf = MainFrame.create();
        private Posicao posicaoBuffer = null;
        private TipoJogo tipoJogo = null;
        private static GUIControl gc = null;

        public static GUIControl getInstanceOf() {
                if (gc == null) {
                        gc = new GUIControl();
                }
                return gc;
        }

        private GUIControl() {
        }

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
                                getMf().setVisible(true);
                        }
                });
        }

        public Tabuleiro getTabuleiro() {
                return controlXadrez.getJogo().getTabuleiro();
        }

        public MainFrame getMainframe() {
                return getMf();
        }

        public ChessTable getChessTable() {
                return getMf().getChessTable();
        }

        private MessagePane getMessagePane() {
                return getMf().getMessagePane();
        }

        private JTextField getTextField() {
                return getMf().getTextField();
        }

        private void addPeca(PecaView com, Posicao pos) {

                try {
                        getMf().getChessTable().getPosicao(pos).addPecaView(com);
                } catch (MuitosComponentesException ex) {
                        Logger.getLogger(GUIControl.class.getName()).log(Level.SEVERE, null, ex);
                }

        }

        private void removePeca(Posicao pos) {
                getMf().getChessTable().getPosicao(pos).removeAll();
        }

        private PecaView getPecaPos(Posicao pos) {
                return (PecaView) getMf().getChessTable().getPosicao(pos).getComponent(0);
        }

        private void iluminarTile(Posicao pos) {
                getMf().getChessTable().getPosicao(pos).iluminar();
        }

        private void iluminarTile(Posicao pos, Color cor) {
                getMf().getChessTable().getPosicao(pos).setColor(cor);
        }

        private void restoreOriginalTileColor(Posicao pos) {
                getMf().getChessTable().getPosicao(pos).setOriginalColor();
        }

        public void restoreAllOriginalTileColors() {
                ChessTable ct = getChessTable();
                Line[] ln = ct.getLines();

                for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                                Tile t = ln[i].getTile(j);
                                if (t.getBackground() != t.getOriginalColor()) {
                                        t.setOriginalColor();
                                }
                        }

                }

        }

        public void moverPeca(Posicao posInicial, Posicao posFinal) {

                try {
                        if (getTipoJogo() == TipoJogo.singleplayer) {
                                ControlXadrez.getInstanceOf().realizarJogadaSingleplayer(posInicial, posFinal);
                        } else {
                                ControlXadrez.getInstanceOf().realizarJogadaMultiplayer(posInicial, posFinal);
                        }

                        restoreAllOriginalTileColors();
                } catch (PecaAlheiaException | MovimentoInvalidoException | CaminhoBloqueadoException |
                        CasaVaziaException | CapturaInvalidaPecaInexistenteException | CapturaInvalidaPecaPropriaException ex) {
                        //Logger.getLogger(TextBar.class.getName()).log(Level.SEVERE, null, ex);
                        MessagePane.addMessage(ex.getMessage() + "\n");
                        setPosicaoBuffer(null);
                }

                this.populateGUITable();

        }

        public void mensagemMoverPeca(Posicao posicaoInicial, Posicao posicaoFinal, Jogador jogador) {
                MessagePane.addMessageJogada(posicaoInicial, posicaoFinal, jogador);
        }

        public void iluminarPosicoesPossiveis(Tile t) {

                ChessTable ct = getChessTable();

                t.setColor(Color.GREEN);
                List<Posicao> posicoes = getTabuleiro().posicoesPossiveisPeca(t.getPecaView().getPeca().getPosicao());
                for (int i = 0; i < posicoes.size(); i++) {
                        (ct.getPosicao(posicoes.get(i))).iluminar();
                }
        }

        private void addPecaOnPosition(Posicao pos, Peca peca) {
                peca.setPosicao(pos);
                try {
                        getChessTable().getPosicao(pos).addPecaView(new PecaView(peca));

                } catch (MuitosComponentesException ex) {
                        Logger.getLogger(GUIControl.class
                                .getName()).log(Level.SEVERE, null, ex);
                }
        }

        private void addPecaOnPosition(Posicao pos, NomePecas np, Cores cor) {
                addPecaOnPosition(pos, PecasPool.getInstanceOf().getPeca(np, cor, pos));
        }

        public void startGameSingleplayer(String nome) {
                ControlXadrez.getInstanceOf().iniciarJogoSingleplayer(nome);
                setTipoJogo(TipoJogo.singleplayer);
                startGameFacade();
        }

        public void startGameMultiplayer(String[] nomes) {
                ControlXadrez.getInstanceOf().iniciarJogoMultiplayer(nomes);
                setTipoJogo(TipoJogo.multiplayer);
                startGameFacade();
        }

        public void populateGUITable() {
                ChessTable.getInstanceOf().limparTabuleiro();

                for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                                Posicao pos = Posicao.create(i, j);
                                if (getTabuleiro().getCasas(pos) != null) {
                                        addPecaOnPosition(pos, getTabuleiro().getCasas(pos));
                                }
                        }
                }
        }

        public void reiniciarTabuleiro() {
                getChessTable().limparTabuleiro();
                GUIControl.getInstanceOf().populateGUITable();
        }

        public void startGameFacade() {
                getChessTable().limparTabuleiro();
                getMessagePane().clear();
                populateGUITable();
        }

        public void debug() {
                startGameFacade();
        }

        public void enviarMensagem(String msg) {
                MessagePane.addMessage(msg);
        }

        public void enviarMensagemXeque(Jogador jogador) {/*
                 Tabuleiro tab = controlXadrez.getJogo().getTabuleiro();
                 Posicao posRei;
                 if (jogador.getCor() == Cores.branco) posRei = tab.getPosicaoReiPreto();
                 else posRei = tab.getPosicaoReiBranco();
                
                 iluminarTile(posRei, Color.YELLOW);
                 */

                MessagePane.addMessageXeque(jogador);

        }

        public void enviarMensagemJogador(String msg) {
                MessagePane.addMessageJogador(controlXadrez.getJogo().getVez(), msg);

        }

        public void enviarMensagemJogadaInvalida() {
                MessagePane.addMessageJogadaInvalida();
        }

        public void popUpXeque(Jogador jogador) {
                mf.popUpXeque(jogador);

        }

        /**
         * @return the mf
         */
        public MainFrame getMf() {
                return mf;
        }

        public void realizarRoqueMaior() {
                try {
                        controlXadrez.controlarRoqueMenor();
                        MessagePane.addJogadaRoque(controlXadrez.getJogo().getVez(), "Maior");
                        this.populateGUITable();
                } catch (RoqueInvalidoReiMovimentadoException | RoqueInvalidoTorreMovimentadaException | RoqueInvalidoCaminhoBloqueadoException | RoqueInvalidoReiAmeacadoException ex) {
                        MessagePane.addMessage(ex.getMessage() + "\n");
                }

        }

        public void realizarRoqueMenor() {
                try {
                        controlXadrez.controlarRoqueMaior();
                        MessagePane.addJogadaRoque(controlXadrez.getJogo().getVez(), "Menor");
                        this.populateGUITable();

                } catch (RoqueInvalidoReiMovimentadoException | RoqueInvalidoTorreMovimentadaException | RoqueInvalidoCaminhoBloqueadoException | RoqueInvalidoReiAmeacadoException ex) {
                        MessagePane.addMessage(ex.getMessage() + "\n");
                }
        }

        /**
         * @param mf the mf to set
         */
        public void setMf(MainFrame mf) {
                this.mf = mf;
        }

        /**
         * @return the posicaoBuffer
         */
        public Posicao getPosicaoBuffer() {
                return posicaoBuffer;
        }

        /**
         * @param posicaoBuffer the posicaoBuffer to set
         */
        public void setPosicaoBuffer(Posicao posicaoBuffer) {
                this.posicaoBuffer = posicaoBuffer;
        }

        /**
         * @return the tipoJogo
         */
        public TipoJogo getTipoJogo() {
                return tipoJogo;
        }

        /**
         * @param tipoJogo the tipoJogo to set
         */
        public void setTipoJogo(TipoJogo tipoJogo) {
                this.tipoJogo = tipoJogo;
        }

        public void carregarJogo(Checkpoint jogoCarregado) {
                try {
                         controlXadrez.carregarJogo(jogoCarregado);
                        enviarMensagem("Jogo carregado com sucesso");
                        if (jogoCarregado.getJogo().getPreto().getNome().contentEquals("ZEUS")) {
                                setTipoJogo(TipoJogo.singleplayer);
                        } else {
                                setTipoJogo(TipoJogo.multiplayer);
                        }

                        startGameFacade();
                } catch (JogoInexistenteExcpetion ex) {
                        enviarMensagem(ex.toString());
                }
        }



public void salvarJogo(String nomePartida) {
                controlXadrez.salvarPartida(nomePartida);
        }
}
