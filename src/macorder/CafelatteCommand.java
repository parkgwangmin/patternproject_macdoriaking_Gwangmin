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
public class CafelatteCommand implements Command {

    Cafelatte cafelatte;

    public CafelatteCommand(Cafelatte cafelatte) {
        this.cafelatte = cafelatte;
    }

    @Override
    public void execute() {
        cafelatte.makeCoffee();
    }

}
