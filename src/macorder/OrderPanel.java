/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 *
 * @author qra04_000
 */
public class OrderPanel extends JPanel implements ActionListener {

    private JLabel Bemenu;
    private JButton bt_Americano, bt_Espresso, bt_CaramelMacchiato, bt_CafeLatte, bt_Ice, bt_Whip, bt_Shot, take_OK_cafe;
    //아메리카노, 에스프레소, 카라멜 마끼아또, 카페라떼, 얼음추가, 휘핑추가, 시럽추가
    private JButton bt_Sanghai, bt_Bulgogi,bt_Jalapeno, bt_DoubleBulgogi,bt_Shrimp, bt_Cheese,bt_SetMenu, bt_Coke, bt_French, take_OK_burger;
    //상하이버거, 불고기버기, 할라피뇨버거, 더블불고기버거, 새우버거, 치즈버거, 세트메뉴, 콜라, 후렌치후라이
    private OrderControl orderCTL;
    private Macafe macafe;
    private Burger burger;
    private JTextArea textfd;
    private int cafestock = 100;
    private int burgerstock = 100;

    public OrderPanel() {
        setLayout(null);
        makeBurgerView();
        orderCTL = new OrderControl();
    }

    public OrderPanel(Macafe macafe) {
        this.macafe = macafe;
    }

    public OrderPanel(Burger burger) {
        this.burger = burger;
    }

    /**
     * 버튼생성
     * @since 2016-05-26
     */
    public void makeBurgerView() {

        textfd = new JTextArea();
        textfd.setBounds(550, 20, 400, 150);
        add(textfd);
        
        Bemenu = new JLabel("Burger");
        Bemenu.setBounds(210, 0, 220, 30);
        add(Bemenu);
        
        //Burger
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
        take_OK_burger.setBounds(200, 410, 150, 50);
        take_OK_burger.addActionListener(this);
        add(take_OK_burger);
        
        
        //Macafe
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

    }

    public void actionPerformed(ActionEvent e) {

        /**
         * 맥카페 메뉴
         * 수정일 : 5.26 2pm
         * 아메리카노, 에스프레소, 카라멜 마끼아또, 카페라떼
         */
        if (e.getSource() == bt_Americano) {
            System.out.println("아메리카노 선택");
            textfd.setText("아메리카노 선택\n");
            Macafe americano = new Americano();
            AmericanoCommand makeAmericano = new AmericanoCommand((Americano) americano);
            orderCTL.setCommand(makeAmericano);
            macafe = americano;
        }
         
        if (e.getSource() == bt_Espresso) {
            System.out.println("에스프레소 선택");
            textfd.setText("에스프레소 선택\n");
            Macafe espresso = new Espresso();
            EspressoCommand makeEspresso = new EspressoCommand((Espresso) espresso);
            orderCTL.setCommand(makeEspresso);
            macafe = espresso;
        }
        
        if (e.getSource() == bt_CaramelMacchiato) {
            System.out.println("카라멜 마끼아또 선택");
            textfd.setText("카라멜 마끼아또 선택\n");
            Macafe caramelMacchiato = new CaramelMacchiato();
            CaramelMacchiatoCommand makeCaramelMacchiato = new CaramelMacchiatoCommand((CaramelMacchiato) caramelMacchiato);
            orderCTL.setCommand(makeCaramelMacchiato);
            macafe = caramelMacchiato;
        }
         
        if (e.getSource() == bt_CafeLatte) {
            System.out.println("카페라떼 선택");
            textfd.setText("카페라떼 선택\n");
            Macafe cafeLatte = new CafeLatte();
            CafeLatteCommand makeCafeLatte = new CafeLatteCommand((CafeLatte) cafeLatte);
            orderCTL.setCommand(makeCafeLatte);
            macafe = cafeLatte;
        }

        /**
         * 맥카페 데코레이터
         * 수정일 : 5.26 2pm
         * 얼음추가, 휘핑추가, 샷추가
         */
        if (e.getSource() == bt_Ice) {
            System.out.println("얼음추가 선택");
            textfd.append("얼음추가 선택\n");
            macafe = new Ice(macafe);
        }
        
        if (e.getSource() == bt_Whip) {
            System.out.println("휘핑추가 선택");
            textfd.append("휘핑추가 선택\n");
            macafe = new Whip(macafe);
        }

        if (e.getSource() == bt_Shot) {
            System.out.println("샷추가 선택");
            textfd.append("샷추가 선택\n");
            macafe = new Shot(macafe);
        }

        
        /**
         * 맥카페 주문버튼         * 
         * 수정일 : 5.26 2pm
         */
        if (e.getSource() == take_OK_cafe) {

            if (cafestock > 0) {
                cafestock--;
                orderCTL.startOrder();
                System.out.println("주문결과 : " + macafe.getDescription());
                System.out.println("가격 : " + macafe.cost());
                macafe.cost();
                textfd.append("주문결과 : " + macafe.getDescription() + "\n"
                              + "가격 : " + macafe.cost() + "\n"
                              + "커피재고량 : " + cafestock);
            } else {
                textfd.setText("커피 재고 부족...");
            }

//            String cost = String.valueOf(macafe.cost()); 혹시나 String으로 출력해야한다면..
        }

        /**
         * 햄버거 메뉴
         * 수정일 : 5.26 2pm
         * 상하이버거, 불고기버기, 할라피뇨버거, 더블불고기버거, 새우버거, 치즈버거
         */
        if (e.getSource() == bt_Sanghai) {
            System.out.println("상하이버거 선택");
            textfd.setText("상하이버거 선택\n");
            Burger sanghai = new SanghaiBurger();
            SanghaiCommand makeSanghai = new SanghaiCommand((SanghaiBurger) sanghai);
            orderCTL.setCommand(makeSanghai);
            burger = sanghai;
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            bt_Bulgogi.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            bt_Cheese.setEnabled(false);
            
            
        }
        if (e.getSource() == bt_Bulgogi) {
            System.out.println("불고기버거 선택");
            textfd.setText("불고기버거 선택\n");
            BulgogiBurger bulgogi = new BulgogiBurger();
            BulgogiCommand makeBulgogi = new BulgogiCommand(bulgogi);
            orderCTL.setCommand(makeBulgogi);
            burger = bulgogi;
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            bt_Sanghai.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            bt_Cheese.setEnabled(false);
            
        }
         if (e.getSource() == bt_Jalapeno) {
            System.out.println("할라피뇨버거 선택");
            textfd.setText("할라피뇨버거 선택\n");
            Burger jalapeno = new JalapenoBurger();
            JalapenoCommand makeJalapeno = new JalapenoCommand((JalapenoBurger) jalapeno);
            orderCTL.setCommand(makeJalapeno);
            burger = jalapeno;
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            bt_Sanghai.setEnabled(false);
            bt_Bulgogi.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            bt_Cheese.setEnabled(false);
            
        }
        if (e.getSource() == bt_DoubleBulgogi) {
            System.out.println("더블불고기버거 선택");
            textfd.setText("더블불고기버거 선택\n");
            DoubleBulgogiBurger doublebulgogi = new DoubleBulgogiBurger();
            DoubleBulgogiCommand makeDoubleBulgogi = new DoubleBulgogiCommand(doublebulgogi);
            orderCTL.setCommand(makeDoubleBulgogi);
            burger = doublebulgogi;
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            bt_Sanghai.setEnabled(false);
            bt_Bulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            bt_Cheese.setEnabled(false);

        }
         if (e.getSource() == bt_Shrimp) {
            System.out.println("새우버거 선택");
            textfd.setText("새우버거 선택\n");
            Burger shrimp = new ShrimpBurger();
            ShrimpCommand makeShrimp = new ShrimpCommand((ShrimpBurger) shrimp);
            orderCTL.setCommand(makeShrimp);
            burger = shrimp;
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            /*
            bt_Sanghai.setEnabled(false);
            bt_Bulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Cheese.setEnabled(false);
            */
        }
        if (e.getSource() == bt_Cheese) {
            System.out.println("치즈버거 선택");
            textfd.setText("치즈버거 선택\n");
            CheeseBurger cheese = new CheeseBurger();
            CheeseCommand makeCheese = new CheeseCommand(cheese);
            orderCTL.setCommand(makeCheese);
            burger = cheese;
            //다른 메뉴를 동시에 선택하지 못하게 하기 위해
            /*
            bt_Sanghai.setEnabled(false);
            bt_Bulgogi.setEnabled(false);
            bt_Jalapeno.setEnabled(false);
            bt_DoubleBulgogi.setEnabled(false);
            bt_Shrimp.setEnabled(false);
            */
        }

        /**
         * 햄버거 데코레이터
         * 수정일 : 5.26 2pm
         * 얼음추가, 휘핑추가, 시럽추가
         */
        if (e.getSource() == bt_Coke) {
            System.out.println("콜라 추가선택 + 1500원");
            textfd.append("콜라 추가선택 + 1500원\n");
            burger = new Coke(burger);
        }

        if (e.getSource() == bt_French) {
            System.out.println("후렌치후라이 추가선택 + 1500원");
            textfd.append("후렌치후라이 추가선택 + 1500원\n");
            burger = new FrenchFries(burger);
        }

        if (e.getSource() == bt_SetMenu) {
            System.out.println("세트메뉴선택 + 2000원");
            textfd.append("세트메뉴선택 + 1500원\n");
            burger = new SetBurgerMenu(burger);
        }

        /**
         * 햄버거 주문버튼
         * 수정일 : 5.26 2pm
         */
        if (e.getSource() == take_OK_burger) {
            if(burgerstock > 0){
                orderCTL.startOrder();
                burgerstock--;
                textfd.append("주문결과 : " + burger.getDescription()+"\n"
                              +"가격 : " + burger.cost() + "\n"
                              +"버거 재고 : " + burgerstock + "\n");
                
                //버튼 다시 전부 활성화
                bt_Sanghai.setEnabled(true);
                bt_Bulgogi.setEnabled(true);
                bt_Jalapeno.setEnabled(true);
                bt_DoubleBulgogi.setEnabled(true);
                bt_Shrimp.setEnabled(true);
                bt_Cheese.setEnabled(true);
                
            } else {
                textfd.setText("버거 재고 부족 ...");
            }
        }
    }

}
