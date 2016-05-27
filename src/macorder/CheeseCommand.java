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
public class CheeseCommand implements Command{
    CheeseBurger cheese;

    public CheeseCommand(CheeseBurger cheeseBurger) {
        this.cheese = cheeseBurger;
    }

    @Override
    public void execute() {
        cheese.makeBurger();
    }
}
