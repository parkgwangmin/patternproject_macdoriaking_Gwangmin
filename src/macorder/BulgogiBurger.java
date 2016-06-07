/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import TemplateMethod.BulgogiWithHook;

/**
 *
 * @author qra04_000
 */
public class BulgogiBurger extends Burger{

    public BulgogiBurger() {
        this.description = "불고기버거";
    }

    public void makeBurger() {
       System.out.println("\n" + description + " 준비중...");
        BulgogiWithHook BulgogiHook = new BulgogiWithHook();
        BulgogiHook.prepareRecipe();
    }

    @Override
    public int cost() {
        return 4000;
    }

}
