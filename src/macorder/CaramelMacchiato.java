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
public class CaramelMacchiato extends Macafe{

    public CaramelMacchiato() {
        this.description = "카라멜마끼아또";
    }
    
    @Override
    public int cost(){
        return 3000;
    }
    
    public void makeCoffee(){
        System.out.println("카라멜마끼아또를 만듭니다.");
    }
}
