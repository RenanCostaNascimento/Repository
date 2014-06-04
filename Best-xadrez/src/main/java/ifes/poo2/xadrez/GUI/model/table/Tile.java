package ifes.poo2.xadrez.GUI.model.table;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.util.exception.MuitosComponentesException;
import ifes.poo2.xadrez.GUI.control.GUIControl;
import ifes.poo2.xadrez.GUI.pecaView.PecaView;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pdr
 */
public class Tile extends javax.swing.JPanel {

        private Color originalColor;

        /**
         * Creates new form Tile
         */
        public Tile() {
                initComponents();
                originalColor = getBackground();

        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT
         * modify this code. The content of this method is always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                setBackground(new java.awt.Color(121, 138, 245));
                setBorder(javax.swing.BorderFactory.createEtchedBorder());
                setMaximumSize(new java.awt.Dimension(300, 300));
                setMinimumSize(new java.awt.Dimension(60, 60));
                setPreferredSize(new java.awt.Dimension(60, 60));
                addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                formMouseClicked(evt);
                        }
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                formMousePressed(evt);
                        }
                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                                formMouseReleased(evt);
                        }
                });
        }// </editor-fold>//GEN-END:initComponents

        private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        }//GEN-LAST:event_formMouseClicked

        private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        }//GEN-LAST:event_formMouseReleased

        private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
                GUIControl.getInstanceOf().restoreAllOriginalTileColors();
                if (this.getComponentCount() > 0) {
                        GUIControl.getInstanceOf().iluminarPosicoesPossiveis(this);
                        System.out.println(this.getPecaView().getPeca().getPosicao());
                }

                if ((getComponentCount() == 1) && GUIControl.getInstanceOf().getPosicaoBuffer() != null) {
                        GUIControl.getInstanceOf().moverPeca(GUIControl.getInstanceOf().getPosicaoBuffer(), this.getPecaView().getPeca().getPosicao());
                        GUIControl.getInstanceOf().setPosicaoBuffer(null);
                } else if (getComponentCount() > 0) {
                        GUIControl.getInstanceOf().setPosicaoBuffer(getPecaView().getPeca().getPosicao());
                } else if ((getComponentCount() == 0) && GUIControl.getInstanceOf().getPosicaoBuffer() != null) {
                        GUIControl.getInstanceOf().moverPeca(GUIControl.getInstanceOf().getPosicaoBuffer(),
                                GUIControl.getInstanceOf().getChessTable().getPosicaoTile(this));
                        GUIControl.getInstanceOf().setPosicaoBuffer(null);
                }


        }//GEN-LAST:event_formMousePressed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        // End of variables declaration//GEN-END:variables
        public void setColor(Color color) {
                this.setBackground(color);
                this.revalidate();
                this.repaint();
        }

        public void setOriginalColor() {
                this.setBackground(originalColor);
                this.revalidate();
                this.repaint();
        }

        /**
         * @return the originalColor
         */
        public Color getOriginalColor() {
                return originalColor;
        }

        public void iluminarCaptura() {
                setColor(Color.RED);
        }

        public void iluminar() {
                if (getComponentCount() > 0) {
                        setColor(Color.RED);
                } else if (getOriginalColor() == TileFactory.getWhiteTile()) {
                        setColor(new java.awt.Color(0, 204, 255));
                } else if (getOriginalColor() == TileFactory.getBlackTile()) {
                        setColor(new java.awt.Color(121, 138, 245));
                } else {
                        setColor(new java.awt.Color(0, 204, 255));
                }
        }

        /**
         * @param originalColor the originalColor to set
         */
        public void setOriginalColor(Color originalColor) {
                this.originalColor = originalColor;
        }

        public void addPecaView(PecaView pecaView) throws MuitosComponentesException {
                if (getComponentCount() >= 1) {
                        throw new MuitosComponentesException();
                } else {
                        pecaView.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        pecaView.setLabelFor(pecaView);
                        pecaView.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                        add(pecaView);
                        revalidate();
                        repaint();
                }

        }

        public void removerPeca() {
                if (getComponentCount() > 0) {
                        this.removeAll();
                        revalidate();
                        repaint();
                }
        }

        public PecaView getPecaView() {
                return (PecaView) this.getComponent(0);
        }

}
