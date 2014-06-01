/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.model.table;

/**
 *
 * @author pdr
 */
public class Line extends javax.swing.JPanel {
        private Tile[] tiles = new Tile[8];
        /**
         * Creates new form TableRow
         */
        public Line() {
                initComponents();
                
        }


        public Tile[] getTiles(){
                return tiles;
        }
        public void setTiles(Tile[] tiles){
                this.tiles=tiles;
        }
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                setMaximumSize(new java.awt.Dimension(50, 50));
                setMinimumSize(new java.awt.Dimension(50, 50));
                setLayout(new java.awt.GridLayout(1, 0));
        }// </editor-fold>//GEN-END:initComponents

        public Tile getTile(int i){
                return tiles[i];
        }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        // End of variables declaration//GEN-END:variables
}
