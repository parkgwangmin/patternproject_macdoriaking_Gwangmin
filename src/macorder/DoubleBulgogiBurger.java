/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import TemplateMethod.DoubleBulgogiWithHook;

/**
 *
 * @author HaeI
 */
public class DoubleBulgogiBurger extends Burger{
     public  DoubleBulgogiBurger() {
        this.description = "더블불고기버거";
    }

    public void makeBurger() {
        System.out.println("\n" + description + " 준비중...");
        DoubleBulgogiWithHook BulgogiHook = new DoubleBulgogiWithHook();
        BulgogiHook.prepareRecipe();
    }

    @Override
    public int cost() {
        return 3100;
    }
}
