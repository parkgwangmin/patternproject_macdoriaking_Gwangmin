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
public class DoneOrderingState implements State{
    
    StateMachine statemachine;
    
    public DoneOrderingState(StateMachine statemachine){
        this.statemachine = statemachine;
    }

    @Override
    public void Order() {// 주문완료상태의 주문행동-> 주문중상태로 돌아가야지!
      // System.out.println("주문중상태로 넘어갑니다.");
        System.out.println("주문중입니다!");
        statemachine.setState(statemachine.getSoldState());
    }

    @Override
    public void DoneOrder() {// 주문완료상태의 주문완료행동-> 주문중상태로 돌아가야지!
        
        if(statemachine.getCount()<1){// 만약 재고가 없다면 매진상태로 돌린다.
            statemachine.setState(statemachine.getSoldOutState());
        }
        else{// 아니면 판매중상태로 돌린다.
            //System.out.println("DoneOrdering to SoldeState");
            statemachine.setState(statemachine.getSoldState());
        }
    }

}
