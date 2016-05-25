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
public class SetBurgerMenu extends BurgerDecorator{

    public SetBurgerMenu(Burger mBurger) {
        this.mBurger = mBurger;
    }
    

    public String getDescription() {
        return mBurger.getDescription() + " 셋트메뉴";
    }

    @Override
    
    public int cost() {
        return mBurger.cost() + 2000;
    }   
    
}
