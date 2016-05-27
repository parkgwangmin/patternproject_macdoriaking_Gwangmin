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
public class JalapenoCommand implements Command{
    
    JalapenoBurger jalapeno;

    public JalapenoCommand(JalapenoBurger jalapenoBurger) {
        this.jalapeno = jalapenoBurger;
    }

    @Override
    public void execute() {
        jalapeno.makeBurger();
    }
    
}
