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
public class DoubleBulgogiCommand implements Command{
    DoubleBulgogiBurger doubleBulgogi;

    public DoubleBulgogiCommand(DoubleBulgogiBurger doubleBulgogiBurger) {
        this. doubleBulgogi =  doubleBulgogiBurger;
    }

    @Override
    public void execute() {
         doubleBulgogi.makeBurger();
    }
}
