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
public class AmericanoCommand implements Command {

    Americano americano;

    public AmericanoCommand(Americano americano) {
        this.americano = americano;
    }

    @Override
    public void execute() {
        americano.makeCoffee();
    }

}
