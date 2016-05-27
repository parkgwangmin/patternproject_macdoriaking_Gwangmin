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
public class ShrimpBurger extends Burger{
    public  ShrimpBurger() {
        this.description = "새우버거";
    }

    public void makeBurger() {
        System.out.println("새우버거를 만듭니다.");
    }

    @Override
    public int cost() {
        return 3100;
    }
}
