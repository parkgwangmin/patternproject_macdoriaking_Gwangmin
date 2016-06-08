/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macobserver;

import java.util.LinkedList;

/**
 * Subject 클래스
 * 옵저버를 등록,삭제
 * 옵저버에 전달 역할
 * 하위클래스는 macorder패키지의 MyStore.
 * @author 광민
 */
public interface Subject {
    
    LinkedList<Observer> mObserver = new LinkedList<Observer>();

    public void registerObserver(Observer o);

    public void removeObserver(Observer o,String stro);

    public void notifyObserver();

}
