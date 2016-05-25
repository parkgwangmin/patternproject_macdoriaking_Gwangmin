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
public class OrderControl {

    private Command mCommand;

    public OrderControl() {
    }

    public void setCommand(Command command) {
        this.mCommand = command;
    }

    public void startOrder() {
        mCommand.execute();
    }
}
