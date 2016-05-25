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
public class Ice extends MacafeDecorator{    

    public Ice(Macafe macafe) {
        this.mMacafe = macafe;
    }

    @Override
    public String getDescription() {
        return mMacafe.getDescription() +  " 얼음추가";
    }

    @Override
    public int cost() {
        return mMacafe.cost() + 500;
    }
    
}
