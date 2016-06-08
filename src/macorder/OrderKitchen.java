/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author HaeI
 */
public class OrderKitchen extends JPanel{
    
    public static JTextArea textfd1;
    static List<String> totalLists = new ArrayList<String>();//주문여러개를 한 번에 저장하기 위해 존재
    
     public OrderKitchen() {
        setLayout(null);
        textfd1 = new JTextArea();
        textfd1.setBounds(550, 20, 400, 150);
        add(textfd1);
        
    }
     
     public static void getTotal(List ls){
         textfd1.setText("");
         totalLists = ls;
     }
     
     public static void outPut(){
        for (Object object : totalLists) {
            String element = (String) object;
            textfd1.append(element + "\n");
        }
        
     }
     
     
    
}
