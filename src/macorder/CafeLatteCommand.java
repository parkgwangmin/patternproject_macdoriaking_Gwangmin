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
public class CafeLatteCommand implements Command {

    CafeLatte cafelatte;

    public CafeLatteCommand(CafeLatte cafelatte) {
        this.cafelatte = cafelatte;
    }

    @Override
    public void execute() {
        cafelatte.makeCoffee();
    }

}
