/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import javax.swing.JFrame;
import macKitchen.MacKitchen;

/**
 *
 * @author qra04_000
 */
public class OrderUI extends JFrame {

    JFrame j1;
    JFrame j2;
    
    public OrderUI() {
        j1 = new JFrame("맥도리아킹 오더");
        j2 = new JFrame("맥도리아킹 키친");
        order();
        kitchen();
    }
    
    public void order(){

        j1.setSize(1000, 800);
        j1.setLocationRelativeTo(this);
        j1.add(new OrderPanel());
        
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.setVisible(true);
    }
    
    public void kitchen(){

        j2.setSize(1000, 800);
        j2.setLocationRelativeTo(this);
        j2.add(new OrderKitchen());
        
        j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j2.setVisible(true);
    }
}
