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
public class SoldState implements State{// 주문중상태 일 때
    
    StateMachine statemachine;
    
    public SoldState (StateMachine statemachine){
        this.statemachine = statemachine;
    }

    @Override
    public void Order() {// 주문중인상태의 주문행동
        
        if(statemachine.getCount()<1){ //만약 재고량이 1보다 적으면 매진상태로 넘어간다.
            System.out.println("매진상태로 넘어갑니다..");
            statemachine.setState(statemachine.getSoldOutState());
        }
       
       else{// 아니면 주문중상태에 머무면서 계속 주문을 받는다.
            System.out.println("주문중입니다..");
            //statemachine.setCount(statemachine.getCount()-1);//재고 -1-> 임시적으로 재고량을 줄이는 것으로 해두었고 차차 햄버거와 맥카페재고를 분리할 것! 이건 control panel에 배치하는게 나을듯!
            statemachine.setState(statemachine.getSoldState());
            }
           
        }

    @Override
    public void DoneOrder() {//주문중인상태에서의 주문완료행동
        
        if(statemachine.getCount()<1){ //만약 재고량이 1보다 적으면 매진상태로 넘어간다.
            System.out.println("매진상태로 넘어갑니다..");
            statemachine.setState(statemachine.getSoldOutState());
        }
        else{
        statemachine.setState(statemachine.getDoneOrderingState());//주문완료상태로 넘어간다.
        System.out.println("주문완료했습니다.ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
        System.out.println("Count111 : "+statemachine.getCount());//재고를 보여준다.-> 아직 연동안됨!
        }
    }


}
