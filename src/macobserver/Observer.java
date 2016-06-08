/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macobserver;

/**
 *
 * @author 광민
 */
public interface Observer {

    public void update(int sales, int burgerstock,int beverage, int order);
    
}
