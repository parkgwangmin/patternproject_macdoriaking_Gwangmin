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
public class ShrimpCommand implements Command {
    ShrimpBurger shrimp;

    public ShrimpCommand(ShrimpBurger shrimpBurger) {
        this.shrimp = shrimpBurger;
    }

    @Override
    public void execute() {
        shrimp.makeBurger();
    }
}
