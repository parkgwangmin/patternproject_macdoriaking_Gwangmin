/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

import macobserver.Observer;
import macobserver.Subject;

/**
 *
 * @author 광민
 */
public class MyStore implements Subject {

    public int sales = 0;
    public int burgerstock = 100;
    public int beveragestock = 10;
    public int order = 0;

    public MyStore() {

    }

    public void registerObserver(Observer o) {
        mObserver.add(o);
    }

    public void removeObserver(Observer o, String stro) {
        int i = mObserver.indexOf(o);
        if (i >= 0) {
            mObserver.remove(o);
        }
        System.out.println(stro + " 옵저버 객체가 삭제되었습니다.");
    }

    
    public void notifyObserver() {
        for (Observer o : mObserver) {
            o.update(sales, burgerstock, beveragestock, order);
        }
    }

}
