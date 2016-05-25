/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macorder;


/**
 *
 * @author 광민
 */
public abstract class MacafeDecorator extends Macafe{
    
    protected Macafe mMacafe;

    @Override //annotation --> compiler에게 정보는 주는 것
    public abstract String getDescription();
    
}
