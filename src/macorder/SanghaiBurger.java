/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import TemplateMethod.SanghaiWithHook;

/**
 *
 * @author qra04_000
 */
public class SanghaiBurger extends Burger{

    public SanghaiBurger() {
        this.description = "상하이버거";
    }

    public void makeBurger() {
        System.out.println("\n" + description + " 준비중...");
        SanghaiWithHook BulgogiHook = new SanghaiWithHook();
        BulgogiHook.prepareRecipe();
    }

    @Override
    public int cost() {
        return 4500;
    }

}
