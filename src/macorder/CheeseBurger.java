/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import TemplateMethod.CheeseWithHook;

/**
 *
 * @author HaeI
 */
public class CheeseBurger extends Burger{
    public CheeseBurger() {
        this.description = "치즈버거";
    }

    public void makeBurger() {
       System.out.println("\n" + description + " 준비중...");
        CheeseWithHook BulgogiHook = new CheeseWithHook();
        BulgogiHook.prepareRecipe();
    }

    @Override
    public int cost() {
        return 2100;
    }
}
