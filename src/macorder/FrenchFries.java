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
public class FrenchFries extends BurgerDecorator{

    public FrenchFries(Burger mBurger) {
        this.mBurger = mBurger;
    }
    
    @Override
    public String getDescription() {
        return mBurger.getDescription() + " 후렌치후라이추가";
    }

    @Override
    public int cost() {
        return mBurger.cost() + 1500;
    }
    
}
