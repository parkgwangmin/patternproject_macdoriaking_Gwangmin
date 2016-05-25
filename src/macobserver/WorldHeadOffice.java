/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macobserver;

/**
 *
 * @author qra04_000
 */
public class WorldHeadOffice implements Observer,DisplayElement{
 
    private int sales;
    private int stock;
    private Subject MyStore;

    public WorldHeadOffice(Subject myStore) {
        this.MyStore = myStore;
        myStore.registerObserver(this);
    }

    @Override
    public void update(int sales, int stock, int order) {
        this.sales = sales;
        this.stock = stock;
        display();
    }

    public void display() {
        System.out.println("매출 : " + sales
                + " 현재 재고 : " + stock);
    }
}
