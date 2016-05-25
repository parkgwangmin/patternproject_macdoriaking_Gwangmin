/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

/**
 *
 * @author qra04_000
 */
public abstract class BurgerDecorator extends Burger{

    protected Burger mBurger;
    
    public abstract String getDescription();
}
