/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macobserver;

import java.util.ArrayList;

/**
 *
 * @author 광민
 */
public class MyStore implements Subject {

    private ArrayList observers;
    private int sales;
    private int stock;
    private int order;

    public MyStore() {
        observers = new ArrayList();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(sales, stock, order);
        }
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements(int sales, int stock, int order) {
        this.sales = sales;
        this.stock = stock;
        this.order = order;
        measurementsChanged();
    }

}
