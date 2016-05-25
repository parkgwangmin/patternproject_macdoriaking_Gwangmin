/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import javax.swing.JFrame;

/**
 *
 * @author qra04_000
 */
public class OrderUI extends JFrame {

    public OrderUI() {
        setTitle("맥도리아킹!!");

        setSize(1000, 800);
        setLocationRelativeTo(this);
        add(new OrderPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
