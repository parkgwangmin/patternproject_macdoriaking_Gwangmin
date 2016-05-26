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

/**
 *
 * @author qra04_000
 */
public class OrderPanel extends JPanel implements ActionListener {

    private JLabel Bemenu;
    private JButton bt_Americano, bt_Ice, take_OK_cafe;
    private JButton bt_Sanghai, bt_Bulgogi, bt_SetMenu, bt_Coke, bt_French, take_OK_burger;
    private OrderControl orderCTL;
    private Macafe macafe;
    private Burger burger;
    private JTextArea textfd;
    private int cafestock = 100;
    private int bugerstock = 100;

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

    public void makeBurgerView() {

        textfd = new JTextArea();
        textfd.setBounds(550, 20, 400, 150);
        add(textfd);

        Bemenu = new JLabel("Burger");
        Bemenu.setBounds(210, 0, 220, 30);
        add(Bemenu);

        bt_Sanghai = new JButton("상하이버거");
        bt_Sanghai.setBounds(100, 30, 260, 50);
        bt_Sanghai.addActionListener(this);
        add(bt_Sanghai);

        bt_Bulgogi = new JButton("불고기버거");
        bt_Bulgogi.setBounds(100, 100, 260, 50);
        bt_Bulgogi.addActionListener(this);
        add(bt_Bulgogi);

        bt_Americano = new JButton("아메리카노");
        bt_Americano.setBounds(100, 600, 260, 50);
        bt_Americano.addActionListener(this);
        add(bt_Americano);

        bt_Ice = new JButton("얼음추가");
        bt_Ice.setBounds(100, 670, 100, 50);
        bt_Ice.addActionListener(this);
        add(bt_Ice);

        take_OK_cafe = new JButton("음료주문");
        take_OK_cafe.setBounds(260, 670, 100, 50);
        take_OK_cafe.addActionListener(this);
        add(take_OK_cafe);

        bt_Coke = new JButton("콜라");
        bt_Coke.setBounds(100, 240, 100, 50);
        bt_Coke.addActionListener(this);
        add(bt_Coke);

        bt_French = new JButton("후렌치후라이");
        bt_French.setBounds(230, 240, 130, 50);
        bt_French.addActionListener(this);
        add(bt_French);

        bt_SetMenu = new JButton("세트메뉴");
        bt_SetMenu.setBounds(200, 340, 150, 50);
        bt_SetMenu.addActionListener(this);
        add(bt_SetMenu);

        take_OK_burger = new JButton("버거주문");
        take_OK_burger.setBounds(200, 410, 150, 50);
        take_OK_burger.addActionListener(this);
        add(take_OK_burger);
    }

    public void actionPerformed(ActionEvent e) {

        /**
         * 맥카페 메뉴
         * 수정일 : 5.26 2pm
         */
        if (e.getSource() == bt_Americano) {
            System.out.println("아메리카노 선택");
            textfd.setText("아메리카노 선택\n");
            Macafe americano = new Americano();
            AmericanoCommand makeAmericano = new AmericanoCommand((Americano) americano);
            orderCTL.setCommand(makeAmericano);
            macafe = americano;
        }

        /**
         * 맥카페 데코레이터
         * 수정일 : 5.26 2pm
         */
        if (e.getSource() == bt_Ice) {
            System.out.println("얼음추가 선택");
            textfd.append("얼음추가 선택\n");
            macafe = new Ice(macafe);
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
         */
        if (e.getSource() == bt_Sanghai) {
            System.out.println("상하이버거 선택");
            textfd.setText("상하이버거 선택\n");
            Burger sanghai = new SanghaiBuger();
            SanghaiCommand makeSanghai = new SanghaiCommand((SanghaiBuger) sanghai);
            orderCTL.setCommand(makeSanghai);
            burger = sanghai;
            bt_Bulgogi.setEnabled(false);
        }
        if (e.getSource() == bt_Bulgogi) {
            System.out.println("불고기버거 선택");
            textfd.setText("불고기버거 선택\n");
            BulgogiBuger bulgogi = new BulgogiBuger();
            BulgogiCommand makeBulgogi = new BulgogiCommand(bulgogi);
            orderCTL.setCommand(makeBulgogi);
            burger = bulgogi;
            bt_Sanghai.setEnabled(false);
        }

        /**
         * 햄버거 데코레이터
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
         */
        if (e.getSource() == take_OK_burger) {
            if(bugerstock > 0){
                orderCTL.startOrder();
                bugerstock--;
                textfd.append("주문결과 : " + burger.getDescription()+"\n"
                              +"가격 : " + burger.cost() + "\n"
                              +"버거 재고 : " + bugerstock + "\n");
                bt_Sanghai.setEnabled(true);
                bt_Bulgogi.setEnabled(true);
            } else {
                textfd.setText("버거 재고 부족 ...");
            }
        }
    }

}
