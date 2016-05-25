/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;


/**
 *
 * @author qra04_000
 */
public class Shot extends MacafeDecorator{

    public Shot(Macafe macafe) {
        this.mMacafe = macafe;
    }    
    
    @Override
    public String getDescription() {
        return this.mMacafe.getDescription() + " 샷추가";
    }

    @Override
    public int cost() {
        return this.mMacafe.cost() + 500;
    }
    
}
