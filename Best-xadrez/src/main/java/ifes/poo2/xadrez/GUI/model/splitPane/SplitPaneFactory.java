/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.poo2.xadrez.GUI.model.splitPane;

import java.awt.Component;
import ifes.poo2.xadrez.GUI.model.messagePane.MessagePane;
import ifes.poo2.xadrez.GUI.model.table.ChessTable;
import ifes.poo2.xadrez.GUI.model.table.TableFactory;

/**
 *
 * @author pdr
 */
public class SplitPaneFactory {
        private static SplitPane splitPane;
        
        public static SplitPane createSplitPane(Component left, Component right){
                splitPane = new SplitPane(left, right);
                return splitPane;
        }
        
        public static SplitPane createMySplitPane(){
                  splitPane = new SplitPane(ChessTable.getInstanceOf(), MessagePane.getInstanceOf());
                return splitPane;
        }
}
