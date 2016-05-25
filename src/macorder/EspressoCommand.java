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
public class EspressoCommand implements Command {

    Espresso espresso;

    public EspressoCommand(Espresso espresso) {
        this.espresso = espresso;
    }

    @Override
    public void execute() {
        espresso.makeCoffee();
    }

}