/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import TemplateMethod.ShrimpWithHook;

/**
 *
 * @author HaeI
 */
public class ShrimpBurger extends Burger{
    public  ShrimpBurger() {
        this.description = "새우버거";
    }

    public void makeBurger() {
        System.out.println("\n" + description + " 준비중...");
        ShrimpWithHook BulgogiHook = new ShrimpWithHook();
        BulgogiHook.prepareRecipe();

    }

    @Override
    public int cost() {
        return 3100;
    }
}
