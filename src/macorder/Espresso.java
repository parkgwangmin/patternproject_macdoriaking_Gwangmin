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
public class Espresso extends Macafe{

    public Espresso() {
        this.description = "에스프레소";
    }

    @Override
    public int cost() {
        return 2000;
    }
    
    public void makeCoffee(){
        System.out.println("에스프레소를 만듭니다.");
    }
    
}
