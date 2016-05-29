/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;

/**
 *
 * @author HaeI
 */
public class Whip extends MacafeDecorator{
    public Whip(Macafe macafe) {
        this.mMacafe = macafe;
    }

    @Override
    public String getDescription() {
        return mMacafe.getDescription() +  " 휘핑추가";
    }

    @Override
    public int cost() {
        return mMacafe.cost() + 300;
    }
}
