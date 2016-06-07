/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemplateMethod;

/**
 *
 * @author HaeI
 */
public abstract class BurgerWithHook {

    public void prepareRecipe(){
        bakeBread();
        makePatty();
        sprinkleSource();
        stuffVegetables();
    }
    
    public void bakeBread(){
        System.out.println("빵을 굽는 중....");
    }
    
    public abstract void makePatty();
    
    public void sprinkleSource(){
        System.out.println("소스를 뿌리는 중....");
    }
    
    public void stuffVegetables(){
        System.out.println("채소를 채우는 중....");
    }
}