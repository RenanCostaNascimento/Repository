/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.model.table;

import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo2.xadrez.GUI.pecaView.PecaView;

/**
 *
 * @author pdr
 */
public class ChessTable extends javax.swing.JPanel {
        private Line[] lines = new Line[8];
        private static ChessTable table = null;
        /**
         * Creates new form Table
         */
        private ChessTable() {
                initComponents();
        }
        
        public static ChessTable getInstanceOf(){
                if (table == null){
                        table = new ChessTable();
                        table.setComponents();
                }
                
                return table;
        }
        
        private void setComponents(){
                table.setLayout(new java.awt.GridLayout(0, 1));
                int index;
                for (index=0; index<8; index++){
                        if (index%2 == 0) lines[index] =LineFactory.createEvenLine();
                        else lines[index] = LineFactory.createOddLine();
                        table.add(lines[index]);
                }
        }
        
        public void addPeca(PecaView p){
                lines[0].getTile(0).add(p);
                lines[0].getTile(0).repaint();
                lines[0].getTile(0).revalidate();
                lines[0].repaint();
                lines[0].revalidate();
                repaint();
                revalidate();
                
                
                
        }
        
        

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT
         * modify this code. The content of this method is always regenerated by the Form Editor.
         */
        
        
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                setLayout(new java.awt.GridLayout(0, 1));
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        // End of variables declaration//GEN-END:variables

        /**
         * @return the lines
         */
        public Line[] getLines() {
                return lines;
        }

        /**
         * @param lines the lines to set
         */
        public void setLines(Line[] lines) {
                this.lines = lines;
        }
        
        public Tile getPosicao(Posicao pos){        
                return lines[pos.getLinha()].getTile(pos.getColuna());
        }
        
        public Posicao getPosicaoTile(Tile t){
                for (int i=0; i<8; i++){
                        for (int j=0; j<8; j++){
                                if (lines[i].getTile(j) == t) return new Posicao(i,j);
                        }
                }
                return null;
        }
}
