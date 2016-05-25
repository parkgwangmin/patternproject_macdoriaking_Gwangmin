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
public class SanghaiCommand implements Command {

    SanghaiBuger sanghai;

    public SanghaiCommand(SanghaiBuger sanghai) {
        this.sanghai = sanghai;
    }

    @Override
    public void execute() {
        sanghai.makeBurger();
    }

}
