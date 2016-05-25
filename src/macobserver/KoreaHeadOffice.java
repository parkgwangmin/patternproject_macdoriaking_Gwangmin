/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macobserver;

/**
 *
 * @author 광민
 */
public class KoreaHeadOffice implements Observer, DisplayElement {

    private int sales;
    private int stock;
    private int order;
    private Subject MyStore;

    public KoreaHeadOffice(Subject myStore) {
        this.MyStore = myStore;
        myStore.registerObserver(this);
    }

    @Override
    public void update(int sales, int stock, int order) {
        this.sales = sales;
        this.stock = stock;
        this.order = order;
        display();
    }

    public void display() {
        System.out.println("매출 : " + sales
                + " 현재 재고 : " + stock 
                + " 주문수 : " + order);
    }
}
