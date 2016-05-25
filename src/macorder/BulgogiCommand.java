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
public class BulgogiCommand implements Command {

    BulgogiBuger bulgogi;

    public BulgogiCommand(BulgogiBuger bulgogiBurger) {
        this.bulgogi = bulgogiBurger;
    }

    @Override
    public void execute() {
        bulgogi.makeBurger();
    }

}
