/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

/**
 *
 * @author HaeI
 */
public class JalapenoBurger extends Burger{
    
    public JalapenoBurger() {
        this.description = "할라피뇨버거";
    }

    public void makeBurger() {
        System.out.println("할라피뇨버거를 만듭니다.");
    }

    @Override
    public int cost() {
        return 4000;
    }
}
