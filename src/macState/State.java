/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macState;

/**
 *
 * @author HaeI
 */
public interface State {
    
    public void Order();//주문하는 행위
    
    public void DoneOrder();//주문완료하는 행위
    
}
