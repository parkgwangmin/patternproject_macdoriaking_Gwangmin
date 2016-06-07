/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import TemplateMethod.JalapenoWithHook;

/**
 *
 * @author HaeI
 */
public class JalapenoBurger extends Burger{
    
    public JalapenoBurger() {
        this.description = "할라피뇨버거";
    }

    public void makeBurger() {
        System.out.println("\n" + description + " 준비중...");
        JalapenoWithHook BulgogiHook = new JalapenoWithHook();
        BulgogiHook.prepareRecipe();
    }

    @Override
    public int cost() {
        return 4000;
    }
}
