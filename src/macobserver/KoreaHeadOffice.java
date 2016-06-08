/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macobserver;


/**
 * 한국지사옵저버 클래스
 * @author 광민
 */
public class KoreaHeadOffice implements Observer {

    private Subject MyStore; //주제와의 연관
    public int sales;
    public int burgerstock;
    public int beveragestock;
    public int order;

    
    /**
     * 생성자에 myStore라는 주제 객체가 전달
     * 그 객체를 써서 옵저버로 등록. 
     * @param myStore 
     */
    public KoreaHeadOffice(Subject myStore) {
        System.out.println("한국지사가 옵저버로 등록되었습니다.");
        this.MyStore = myStore;
        this.MyStore.registerObserver(this);
    }

    /**
     * update()가 호출되면 네가지 파라미터를 저장.
     * @param sales
     * @param burgerstock
     * @param beveragestock
     * @param order 
     */
    @Override
    public void update(int sales, int burgerstock, int beveragestock, int order) {
        this.sales = sales;
        this.burgerstock = burgerstock;
        this.beveragestock = beveragestock;
        this.order = order;
    }
}
