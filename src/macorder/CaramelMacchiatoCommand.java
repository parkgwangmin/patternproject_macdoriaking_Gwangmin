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
public class CaramelMacchiatoCommand implements Command {

    CaramelMacchiato caramelMacchiato;

    public CaramelMacchiatoCommand(CaramelMacchiato caramelMacchiato) {
        this.caramelMacchiato = caramelMacchiato;
    }

    @Override
    public void execute() {
        caramelMacchiato.makeCoffee();
    }

}
