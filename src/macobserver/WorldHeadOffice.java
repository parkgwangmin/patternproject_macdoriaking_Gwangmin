/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macobserver;

/**
 * 본사옵저버 클래스 * 
 * @author 광민
 */
public class WorldHeadOffice implements Observer {

    private Subject MyStore;
    public int sales;
    public int order;

    /**
     * 생성자에 myStore이라는 주제 객체가 전달
     * 객체를 써서 옵저버로 등록
     * @param myStore 
     */
    public WorldHeadOffice(Subject myStore) {
        System.out.println("본사가 옵저버로 등록되었습니다.");
        this.MyStore = myStore;
        myStore.registerObserver(this);
    }

    /**
     * update()가 호출되면 필요한 두가지만 저장
     * @param sales
     * @param burgerstock
     * @param beveragestock
     * @param order 
     */
    @Override
    public void update(int sales, int burgerstock, int beveragestock, int order) {
        this.sales = sales;
        this.order = order;
    }
}
