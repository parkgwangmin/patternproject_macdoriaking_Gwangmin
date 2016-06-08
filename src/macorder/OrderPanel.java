/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import macobserver.*;
import mackitchen.*;
import macState.StateMachine;
//import macState.StateMachine;

/**
 *
 * @author qra04_000
 */
public class OrderPanel extends JPanel implements ActionListener {

    private JLabel Burgermenu, Beveragemenu;
    private JLabel koreahead, korea_burgerstock, korea_beveragestock, korea_sales, korea_order;
    private JLabel korea_burgerstockView, korea_beveragestockView, korea_salesView, korea_orderView;
    private JLabel worldhead, world_sales, world_order;
    private JLabel world_salesView, world_orderView;
    private JButton bt_korea, bt_world;
    private JButton bt_cancel;//취소키
    private JButton bt_kitchen;
    private JButton bt_Americano, bt_Espresso, bt_CaramelMacchiato, bt_CafeLatte, bt_Ice, bt_Whip, bt_Shot, take_OK_cafe;
    //아메리카노, 에스프레소, 카라멜 마끼아또, 카페라떼, 얼음추가, 휘핑추가, 시럽추가
    private JButton bt_Sanghai, bt_Bulgogi, bt_Jalapeno, bt_DoubleBulgogi, bt_Shrimp, bt_Cheese, bt_SetMenu, bt_Coke, bt_French, take_OK_burger;
    //상하이버거, 불고기버기, 할라피뇨버거, 더블불고기버거, 새우버거, 치즈버거, 세트메뉴, 콜라, 후렌치후라이
    private OrderControl orderCTL;
    private Macafe macafe;
    private Burger burger;
    private JTextArea textfd;
    private String lists = "";//한 주문을 모두 저장하기 위한 공간
    private int cnt = 0;//리스트 순서저장
    private int rear = 0;//cnt를 저장해서 취소버튼 실행시 줄어든 값을 저장
    private int front = 0;

    private int burgercnt = 0;

    List<String> totalList = new ArrayList<String>();//주문여러개를 한 번에 저장하기 위해 존재
    StateMachine state = new StateMachine();
    MyStore myStore = new MyStore();
    KoreaHeadOffice korea;
    WorldHeadOffice world;

    //옵저버등록버튼 상태를 나타내는 변수
    private boolean Ob1 = false;
    private boolean Ob2 = false;
////////////////////////////////

    public int getCnt() {//MacKitchen에서 필요
        return cnt;
    }

    public void setCnt(int minus) {
        this.cnt = this.cnt - minus;
    }

    public List<String> getTotalList() {
        return totalList;
    }

    public void setTotalList(List<String> totalList) {
        this.totalList = totalList;
    }
///////////////////////////////////////////

    public OrderPanel() {
        setLayout(null);
        makeBurgerView();
        //kitchen.run();
        orderCTL = new OrderControl();
        state.setState(state.getSoldState());
        System.out.println(state.getState());
    }

    public OrderPanel(Macafe macafe) {
        this.macafe = macafe;
    }

    public OrderPanel(Burger burger) {
        this.burger = burger;
    }

    /**
     * 화면 구성 부분.
     *
     * @since 2016-05-26
     */
    public void makeBurgerView() {

        //상태정보창
        textfd = new JTextArea();
        textfd.setBounds(550, 20, 400, 150);
        add(textfd);

        Burgermenu = new JLabel("Burger");
        Burgermenu.setBounds(210, 0, 220, 30);
        add(Burgermenu);

        Beveragemenu = new JLabel("Macafe");
        Beveragemenu.setBounds(210, 520, 220, 30);
        add(Beveragemenu);

        //옵저버 화면 구성 ----------------------------------------------------------------------
        koreahead = new JLabel("한국 지사");
        koreahead.setBounds(530, 270, 100, 30);
        add(koreahead);

        korea_burgerstock = new JLabel("버거 재고 : ");
        korea_burgerstock.setBounds(510, 300, 100, 30);
        add(korea_burgerstock);

        korea_beveragestock = new JLabel("커피 재고 : ");
        korea_beveragestock.setBounds(510, 330, 100, 30);
        add(korea_beveragestock);

        korea_sales = new JLabel("총 매출 : ");
        korea_sales.setBounds(510, 360, 100, 30);
        add(korea_sales);

        korea_order = new JLabel("주문수 : ");
        korea_order.setBounds(510, 390, 100, 30);
        add(korea_order);

        korea_orderView = new JLabel();
        korea_orderView.setBounds(580, 390, 100, 30);
        add(korea_orderView);

        korea_salesView = new JLabel();
        korea_salesView.setBounds(580, 360, 100, 30);
        add(korea_salesView);

        korea_beveragestockView = new JLabel();
        korea_beveragestockView.setBounds(580, 330, 100, 30);
        add(korea_beveragestockView);

        korea_burgerstockView = new JLabel();
        korea_burgerstockView.setBounds(580, 300, 100, 30);
        add(korea_burgerstockView);

        worldhead = new JLabel("본사");
        worldhead.setBounds(700, 270, 100, 30);
        add(worldhead);

        world_sales = new JLabel("총 매출 : ");
        world_sales.setBounds(680, 300, 100, 30);
        add(world_sales);

        world_order = new JLabel("주문수 : ");
        world_order.setBounds(680, 330, 100, 30);
        add(world_order);

        world_salesView = new JLabel();
        world_salesView.setBounds(750, 300, 100, 30);
        add(world_salesView);

        world_orderView = new JLabel();
        world_orderView.setBounds(750, 330, 100, 30);
        add(world_orderView);

        bt_korea = new JButton("한국지사");
        bt_korea.setBounds(550, 200, 120, 40);
        bt_korea.addActionListener(this);
        add(bt_korea);

        bt_world = new JButton("본사");
        bt_world.setBounds(700, 200, 120, 40);
        bt_world.addActionListener(this);
        add(bt_world);
        //옵저버화면 구성 끝 ---------------------------------------------------------------------
        
        //Burger버튼 구성----------------------------------------------------------------------
        bt_Sanghai = new JButton("상하이버거");
        bt_Sanghai.setBounds(100, 30, 130, 50);
        bt_Sanghai.addActionListener(this);
        add(bt_Sanghai);

        bt_Bulgogi = new JButton("불고기버거");
        bt_Bulgogi.setBounds(100, 100, 130, 50);
        bt_Bulgogi.addActionListener(this);
        add(bt_Bulgogi);

        bt_Jalapeno = new JButton("할라피뇨버거");
        bt_Jalapeno.setBounds(100, 170, 130, 50);
        bt_Jalapeno.addActionListener(this);
        add(bt_Jalapeno);

        bt_DoubleBulgogi = new JButton("더블불고기버거");
        bt_DoubleBulgogi.setBounds(230, 30, 130, 50);
        bt_DoubleBulgogi.addActionListener(this);
        add(bt_DoubleBulgogi);

        bt_Shrimp = new JButton("새우버거");
        bt_Shrimp.setBounds(230, 100, 130, 50);
        bt_Shrimp.addActionListener(this);
        add(bt_Shrimp);

        bt_Cheese = new JButton("치즈버거");
        bt_Cheese.setBounds(230, 170, 130, 50);
        bt_Cheese.addActionListener(this);
        add(bt_Cheese);

        bt_Coke = new JButton("콜라");
        bt_Coke.setBounds(100, 240, 130, 50);
        bt_Coke.addActionListener(this);
        add(bt_Coke);

        bt_French = new JButton("후렌치후라이");
        bt_French.setBounds(230, 240, 130, 50);
        bt_French.addActionListener(this);
        add(bt_French);

        bt_SetMenu = new JButton("세트메뉴");
        bt_SetMenu.setBounds(360, 240, 150, 50);
        bt_SetMenu.addActionListener(this);
        add(bt_SetMenu);

        take_OK_burger = new JButton("버거주문");
        take_OK_burger.setBounds(200, 300, 150, 50);
        take_OK_burger.addActionListener(this);
        add(take_OK_burger);
        //버거버튼구성 끝------------------------------------------------------------------------

        //Macafe버튼 구성----------------------------------------------------------------------
        bt_Americano = new JButton("아메리카노");
        bt_Americano.setBounds(100, 550, 150, 50);
        bt_Americano.addActionListener(this);
        add(bt_Americano);

        bt_Espresso = new JButton("에스프레소");
        bt_Espresso.setBounds(250, 550, 150, 50);
        bt_Espresso.addActionListener(this);
        add(bt_Espresso);

        bt_CaramelMacchiato = new JButton("카라멜 마끼아또");
        bt_CaramelMacchiato.setBounds(100, 600, 150, 50);
        bt_CaramelMacchiato.addActionListener(this);
        add(bt_CaramelMacchiato);

        bt_CafeLatte = new JButton("카페라떼");
        bt_CafeLatte.setBounds(250, 600, 150, 50);
        bt_CafeLatte.addActionListener(this);
        add(bt_CafeLatte);

        bt_Ice = new JButton("얼음추가");
        bt_Ice.setBounds(100, 670, 100, 50);
        bt_Ice.addActionListener(this);
        add(bt_Ice);

        bt_Shot = new JButton("샷추가");
        bt_Shot.setBounds(200, 670, 100, 50);
        bt_Shot.addActionListener(this);
        add(bt_Shot);

        bt_Whip = new JButton("휘핑추가");
        bt_Whip.setBounds(300, 670, 100, 50);
        bt_Whip.addActionListener(this);
        add(bt_Whip);

        take_OK_cafe = new JButton("음료주문");
        take_OK_cafe.setBounds(460, 670, 100, 50);
        take_OK_cafe.addActionListener(this);
        add(take_OK_cafe);
        //맥카페버튼 구성 끝------------------------------------------------------------------

        //취소키
        bt_cancel = new JButton("취소");
        bt_cancel.setBounds(200, 380, 150, 50);
        bt_cancel.addActionListener(this);
        add(bt_cancel);

        //주방에서 조리하고 완료시 완료된 주문을 날릴때 필요한 버튼
        bt_kitchen = new JButton("주방");
        bt_kitchen.setBounds(200, 450, 150, 50);
        bt_kitchen.addActionListener(this);
        add(bt_kitchen);

    }

    /**
     * 옵저버가 상태를 나타내는 일을 하는 메소드
     * 완료.
     */
    public void SetObView() {
        if (korea != null) {
            korea_burgerstockView.setText("" + korea.burgerstock);
            korea_beveragestockView.setText("" + korea.beveragestock);
            korea_salesView.setText("" + korea.sales);
            korea_orderView.setText("" + korea.order);
        }

        if (world != null) {
            world_salesView.setText("" + world.sales);
            world_orderView.setText("" + world.order);
        }

    }
    
    /**
     * 각 버튼들의 행동.
     * @param e 
     */
    
    public void actionPerformed(ActionEvent e) {
        
        

        /**
         * 맥카페 메뉴 수정일 : 5.26 2pm 아메리카노, 에스프레소, 카라멜 마끼아또, 카페라떼
         */
        if (e.getSource() == bt_Americano) {
            //state.setDone(false);
            state.Order();
            System.out.println("아메리카노 선택");
            textfd.setText("아메리카노 선택\n");
            Macafe americano = new Americano();
            AmericanoCommand makeAmericano = new AmericanoCommand((Americano) americano);
            orderCTL.setCommand(makeAmericano);
            macafe = americano;
            lists = lists + "+ 아메리카노";
        }

        if (e.getSource() == bt_Espresso) {
            //state.setDone(false);
            state.Order();

            System.out.println("에스프레소 선택");
            textfd.setText("에스프레소 선택\n");
            Macafe espresso = new Espresso();
            EspressoCommand makeEspresso = new EspressoCommand((Espresso) espresso);
            orderCTL.setCommand(makeEspresso);
            macafe = espresso;
            lists = lists + " + 에스프레소";
        }

        if (e.getSource() == bt_CaramelMacchiato) {
            //state.setDone(false);
            state.Order();

            System.out.println("카라멜 마끼아또 선택");
            textfd.setText("카라멜 마끼아또 선택\n");
            Macafe caramelMacchiato = new CaramelMacchiato();
            CaramelMacchiatoCommand makeCaramelMacchiato = new CaramelMacchiatoCommand((CaramelMacchiato) caramelMacchiato);
            orderCTL.setCommand(makeCaramelMacchiato);
            macafe = caramelMacchiato;
            lists = lists + " + 카라멜마끼아또";
        }

        if (e.getSource() == bt_CafeLatte) {
            //state.setDone(false);
            state.Order();

            System.out.println("카페라떼 선택");
            textfd.setText("카페라떼 선택\n");
            Macafe cafeLatte = new CafeLatte();
            CafeLatteCommand makeCafeLatte = new CafeLatteCommand((CafeLatte) cafeLatte);
            orderCTL.setCommand(makeCafeLatte);
            macafe = cafeLatte;
            lists = lists + " + 카페라떼";
        }

        /**
         * 맥카페 데코레이터 수정일 : 5.26 2pm 얼음추가, 휘핑추가, 샷추가
         */
        if (e.getSource() == bt_Ice) {
            //state.setDone(false);
            state.Order();

            System.out.println("얼음추가 선택");
            textfd.append("얼음추가 선택\n");
            macafe = new Ice(macafe);
            lists = lists + " + 얼음추가";
        }

        if (e.getSource() == bt_Whip) {
            //state.setDone(false);
            state.Order();

            System.out.println("휘핑추가 선택");
            textfd.append("휘핑추가 선택\n");
            macafe = new Whip(macafe);
            lists = lists + " + 휘핑추가";
        }

        if (e.getSource() == bt_Shot) {
            //state.setDone(false);
            state.Order();

            System.out.println("샷추가 선택");
            textfd.append("샷추가 선택\n");
            macafe = new Shot(macafe);
            lists = lists + " + 샷추가";
        }

        /**
         * 맥카페 주문버튼 * 수정일 : 5.26 2pm
         */
        if (e.getSource() == take_OK_cafe) {

            // state.setDone(true);
            state.DoneOrder();

            if (myStore.beveragestock > 0) {                
                orderCTL.startOrder();
                myStore.beveragestock--;
                myStore.order++;
                myStore.sales += macafe.cost();
                myStore.notifyObserver();
                macafe.cost();
                textfd.append("주문결과 : " + macafe.getDescription() + "\n"
                        + "가격 : " + macafe.cost() + "\n"
                        + "커피재고량 : " + myStore.beveragestock);
                
                SetObView();

                totalList.add(lists);
                System.out.println("List 출력 :" + cnt + ":" + totalList.get(cnt));
                System.out.println();
                cnt++;
                rear = cnt;

            } else {
                textfd.setText("커피 재고 부족...");
            }

//            String cost = String.valueOf(macafe.cost()); 혹시나 String으로 출력해야한다면..
        }

        /**
         * 햄버거 메뉴 수정일 : 5.26 2pm 상하이버거, 불고기버기, 할라피뇨버거, 더블불고기버거, 새우버거, 치즈버거
         */
        if (e.getSource() == bt_Sanghai) {
            //state.setDone(false);
            state.Order();

            System.out.println("상하이버거 선택");
            textfd.setText("상하이버거 선택\n");
            Burger sanghai = new SanghaiBurger();
            SanghaiCommand makeSanghai = new SanghaiCommand((SanghaiBurger) sanghai);
            orderCTL.setCommand(makeSanghai);
            burger = sanghai;
            lists = lists + "+ 상하이버거";//list추가
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            bt_Bulgogi.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            bt_Cheese.setEnabled(false);

            burgercnt++;

        }
        if (e.getSource() == bt_Bulgogi) {
            //state.setDone(false);
            state.Order();

            System.out.println("불고기버거 선택");
            textfd.setText("불고기버거 선택\n");
            BulgogiBurger bulgogi = new BulgogiBurger();
            BulgogiCommand makeBulgogi = new BulgogiCommand(bulgogi);
            orderCTL.setCommand(makeBulgogi);
            burger = bulgogi;
            lists = lists + "+ 불고기버거";//list추가
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            bt_Sanghai.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            bt_Cheese.setEnabled(false);

            burgercnt++;
        }
        if (e.getSource() == bt_Jalapeno) {
            //state.setDone(false);
            state.Order();

            System.out.println("할라피뇨버거 선택");
            textfd.setText("할라피뇨버거 선택\n");
            Burger jalapeno = new JalapenoBurger();
            JalapenoCommand makeJalapeno = new JalapenoCommand((JalapenoBurger) jalapeno);
            orderCTL.setCommand(makeJalapeno);
            burger = jalapeno;
            lists = lists + "+ 할라피뇨버거";//list추가
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            bt_Sanghai.setEnabled(false);
            bt_Bulgogi.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            bt_Cheese.setEnabled(false);

            burgercnt++;
        }
        if (e.getSource() == bt_DoubleBulgogi) {
            //state.setDone(false);
            state.Order();

            System.out.println("더블불고기버거 선택");
            textfd.setText("더블불고기버거 선택\n");
            DoubleBulgogiBurger doublebulgogi = new DoubleBulgogiBurger();
            DoubleBulgogiCommand makeDoubleBulgogi = new DoubleBulgogiCommand(doublebulgogi);
            orderCTL.setCommand(makeDoubleBulgogi);
            burger = doublebulgogi;
            lists = lists + "+ 더블불고기버거";//list추가
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            bt_Sanghai.setEnabled(false);
            bt_Bulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            bt_Cheese.setEnabled(false);

            burgercnt++;
        }
        if (e.getSource() == bt_Shrimp) {
            //state.setDone(false);
            state.Order();

            System.out.println("새우버거 선택");
            textfd.setText("새우버거 선택\n");
            Burger shrimp = new ShrimpBurger();
            ShrimpCommand makeShrimp = new ShrimpCommand((ShrimpBurger) shrimp);
            orderCTL.setCommand(makeShrimp);
            burger = shrimp;
            lists = lists + "+ 새우버거";//list추가
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해

            bt_Sanghai.setEnabled(false);
            bt_Bulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Cheese.setEnabled(false);

            burgercnt++;
        }
        if (e.getSource() == bt_Cheese) {
            //state.setDone(false);
            state.Order();

            System.out.println("치즈버거 선택");
            textfd.setText("치즈버거 선택\n");
            CheeseBurger cheese = new CheeseBurger();
            CheeseCommand makeCheese = new CheeseCommand(cheese);
            orderCTL.setCommand(makeCheese);
            burger = cheese;
            lists = lists + "+ 치즈버거";//list추가
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해

            bt_Sanghai.setEnabled(false);
            bt_Bulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Shrimp.setEnabled(false);

            burgercnt++;
        }

        /**
         * 햄버거 데코레이터 수정일 : 5.26 2pm 얼음추가, 휘핑추가, 시럽추가
         */
        if (e.getSource() == bt_Coke) {
            //state.setDone(false);
            state.Order();

            System.out.println("콜라 추가선택 + 1500원");
            textfd.append("콜라 추가선택 + 1500원\n");
            burger = new Coke(burger);
            lists = lists + "+ 콜라추가";
        }

        if (e.getSource() == bt_French) {
            //state.setDone(false);
            state.Order();

            System.out.println("후렌치후라이 추가선택 + 1500원");
            textfd.append("후렌치후라이 추가선택 + 1500원\n");
            burger = new FrenchFries(burger);
            lists = lists + "+ 후렌치후라이 추가";
        }

        if (e.getSource() == bt_SetMenu) {
            //state.setDone(false);
            state.Order();

            System.out.println("세트메뉴선택 + 2000원");
            textfd.append("세트메뉴선택 + 1500원\n");
            burger = new SetBurgerMenu(burger);
            lists = lists + "+ 세트메뉴추가";
        }

        /**
         * 햄버거 주문버튼 수정일 : 5.26 2pm
         */
        if (e.getSource() == take_OK_burger) {
            //state.setDone(true);
            state.DoneOrder();

            state.setCount(burgercnt);
            burgercnt = 0;

            
            if (state.getCount() > 0) {
                orderCTL.startOrder();
                myStore.burgerstock--;
                myStore.order++;
                myStore.sales += burger.cost();
                myStore.notifyObserver();
                textfd.append("주문결과 : " + burger.getDescription() + "\n"
                        + "가격 : " + burger.cost() + "\n"
                        + "버거 재고 : " + myStore.burgerstock + "\n");

                totalList.add(lists);
                
                
                
                System.out.println(cnt);
                System.out.println("TotalList 출력 :" + totalList.get(cnt));
                cnt++;
                rear = cnt;

                lists = "";
                //주문 리스트들을 확인해보기 위해 쭉 출력
                for (Object object : totalList) {
                    String element = (String) object;
                    System.out.println("list출력 : " + element);
                }
                SetObView();
                
               

            } else {
                textfd.setText("버거 재고 부족 ...");
                System.out.println("버거재고부족..");

            }
            //버튼 다시 전부 활성화
            bt_Sanghai.setEnabled(true);
            bt_Bulgogi.setEnabled(true);
            bt_Jalapeno.setEnabled(true);
            bt_DoubleBulgogi.setEnabled(true);
            bt_Shrimp.setEnabled(true);
            bt_Cheese.setEnabled(true);
        }
//-------------------------주문끝.-----------------------------------------------------------
        /**
         * 바로 전 주문 취소버튼 수정일 : 5.26 2pm.
         */
        if (e.getSource() == bt_cancel) {
            if (rear < 1) {
                System.out.println("주문이 없습니다.");
            } else {
                rear = rear - 1;
                System.out.println(totalList.remove(rear));
                System.out.println(cnt);
                for (Object object : totalList) {
                    String element = (String) object;
                    System.out.println("list출력 : " + element);
                }
                cnt = rear;
                myStore.burgerstock++;
            }

        }

        if (e.getSource() == bt_kitchen) {
            //java ArrayList에서 기본으로 data가 삭제가 되면 
            //앞으로 당겨져서 저장되기 때문에 항상 제일 앞의 data를 날리면 된다.

            System.out.println(totalList.remove(0));//0번째 data를 삭제
            System.out.println(cnt);//array의 위치를 확인하기 위해
            for (Object object : totalList) {
                String element = (String) object;
                System.out.println("list출력 : " + element);
            }
            cnt--;
        }
        
        /**
         * 옵저버 등록과 삭제를 담당하는 버튼 조작
         * 완료.
         */
        if (e.getSource() == bt_korea) {
            if (Ob1 == false) {
                korea = new KoreaHeadOffice(myStore);
                koreahead.setForeground(Color.blue);
                Ob1 = true;  
            } else if (Ob1 == true) {
                myStore.removeObserver(korea, "한국지사");
                koreahead.setForeground(Color.black);
                Ob1 = false;
            }
        }

        if (e.getSource() == bt_world) {
            if (Ob2 == false) {
                world = new WorldHeadOffice(myStore);
                worldhead.setForeground(Color.blue);
                Ob2 = true;
            } else if (Ob2 == true) {
                myStore.removeObserver(world, "본사");
                worldhead.setForeground(Color.black);
                Ob2 = false;
            }
        }
        OrderKitchen.getTotal(totalList);
        OrderKitchen.outPut();
    }

}
