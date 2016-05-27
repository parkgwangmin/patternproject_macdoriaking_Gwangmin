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
public class CafeLatte extends Macafe{
    public CafeLatte() {
        this.description = "카페라떼";
    }
    
    @Override
    public int cost(){
        return 2500;
    }
    
    public void makeCoffee(){
        System.out.println("카페라떼를 만듭니다.");
    }
    
}
