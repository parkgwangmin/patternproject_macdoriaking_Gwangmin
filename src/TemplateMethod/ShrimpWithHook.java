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
public class ShrimpWithHook extends BurgerWithHook{

    @Override
    public void makePatty() {
        System.out.println("패티를 튀기는 중....");
    }
    
}
