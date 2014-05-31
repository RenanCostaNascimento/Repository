package ifes.poo2.xadrez.GUI.model.table;


import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pdr
 */
public class TileFactory {
       
        
        private static Tile tile;
        public static Tile createTile(int a, int b, int c){
                return createTile(new java.awt.Color(a, b, c));
        }
        public static Tile createTile(Color color){
                tile = new Tile();
                tile.setBackground(color);
                tile.setOriginalColor(color);
                return tile;
        }
        
        public static Tile createBlackTile(){
                return createTile(102, 25, 0);
        }
        
        public static Tile createWhiteTile(){
                return createTile(206,148,0);
        }
        
        
        
}
