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
public class LineFactory {
        private static Line line;
        
         public static Line createOddLine(){
                line = new Line();
                Tile[] tiles = line.getTiles();
                for(int index=0; index<8; index++){
                        if (index%2 == 0) tiles[index] =TileFactory.createBlackTile();
                        else tiles[index] = TileFactory.createWhiteTile();
                  /*      
                         javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(tiles[index]);
                         tiles[index].setLayout(jPanelLayout);
                         jPanelLayout.setHorizontalGroup(
                                 jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGap(0, 133, Short.MAX_VALUE)
                         );
                         jPanelLayout.setVerticalGroup(
                                 jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGap(0, 100, Short.MAX_VALUE)
                        );
                  */      
                        line.add(tiles[index]);
                }
                line.setTiles(tiles);
                return line;
                
        }
         
         public static Line createEvenLine(){
                line = new Line();
                Tile[] tiles = line.getTiles();
                for(int index=0; index<8; index++){
                        if (index%2 == 0) tiles[index] =TileFactory.createWhiteTile();
                        else tiles[index] = TileFactory.createBlackTile();
                        /*
                         javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(tiles[index]);
                         tiles[index].setLayout(jPanelLayout);
                         jPanelLayout.setHorizontalGroup(
                                 jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGap(0, 133, Short.MAX_VALUE)
                         );
                         jPanelLayout.setVerticalGroup(
                                 jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGap(0, 100, Short.MAX_VALUE)
                        );
                        */
                         line.add(tiles[index]);
                }
        
                line.setTiles(tiles);
                return line; 
         }
}
