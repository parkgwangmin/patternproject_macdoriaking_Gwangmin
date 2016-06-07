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
public class StateMachine {

        State DoneOrderingState;//주문완료상태
        State SoldOutState;//매진상태
        State SoldState;//판매중상태
        State state;//대표 상태가 될 상태
        int count = 3;//재고
        boolean done = false;
/*
        public boolean isDone() {
            return done;
        }
        public void setDone(boolean done) {
            this.done = done;
        }
*/
        public StateMachine(){
            SoldOutState = new SoldOutState(this);//판매중상태 생성
            DoneOrderingState = new DoneOrderingState(this);//주문완료상태 생성
            SoldState = new SoldState(this);//판매중상태 생성
            count =3;//재고는 3

            if(count > 0){// 만약 재고가 0이 아니라면, 
                state = SoldState;//주문중상태로 기본설정
            }
        }

        public void Order(){//order호출시 필요
            state.Order();
        }
        public void DoneOrder(){//doneOrder호출시 필요
            state.DoneOrder();
        }

        //state패턴에서 재고량에 접근할 필요없음. 왜냐하면, 상태만으론 버거를 몇개 주문할지 알 수 없기 때문 
        public int getCount(){//재고량에 접근하기 위해 필요
            return count;
        }
        public void setCount(int cnt) {//재고량을 수정하기 위해 필요
            this.count = this.count-cnt;
            System.out.println("burgercnt : "+count);
        }
        
        
        
        public State getState(){//현재 상태에 접근하기 위해 필요
            return state;
        }
        public void setState(State state){//현재 상태를 설정할 때 필요
            this.state = state;
        }
        public State getSoldOutState(){//매진상태를 들고온다.
            return SoldOutState;
        }
        public State getSoldState(){//주문중상태를 들고온다.
            return SoldState;
        }
        public State getDoneOrderingState(){//주문완료상태를 들고온다.
            return DoneOrderingState;
        }
    
    }
