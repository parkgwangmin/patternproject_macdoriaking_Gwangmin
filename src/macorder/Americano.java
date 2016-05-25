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
public class Americano extends Macafe{

    public Americano() {
        this.description = "아메리카노";
    }
    
    @Override
    public int cost(){
        return 2000;
    }

    public void makeCoffee(){
        System.out.println("아메리카노를 만듭니다.");
    }
    
}
