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
public class Coke extends BurgerDecorator{

    public Coke(Burger mBurger) {
        this.mBurger = mBurger;
    }
    
    @Override
    public String getDescription() {
        return mBurger.getDescription() + " 콜라추가";
    }

    @Override
    public int cost() {
        return mBurger.cost() + 1500;
    }
    
}
