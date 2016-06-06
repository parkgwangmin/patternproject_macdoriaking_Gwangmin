/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macState;

/**
 *
 * @author HaeI
 */
public class SoldOutState implements State{
    StateMachine statemachine;
    
    public SoldOutState(StateMachine statemachine){
        this.statemachine = statemachine;
    }

    @Override
    public void Order() {//매진상태의 주문행동
        System.out.println("매진입니다.");
        System.out.println("Count : "+statemachine.getCount());
    }

    @Override
    public void DoneOrder() {//매진상태의 주문완료상태
        System.out.println("매진입니다.");
        System.out.println("Count : "+statemachine.getCount());
    }


}
