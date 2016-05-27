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
public class BulgogiBurger extends Burger{

    public BulgogiBurger() {
        this.description = "불고기버거";
    }

    public void makeBurger() {
        System.out.println("불고기버거를 만듭니다.");
    }

    @Override
    public int cost() {
        return 4000;
    }

}
