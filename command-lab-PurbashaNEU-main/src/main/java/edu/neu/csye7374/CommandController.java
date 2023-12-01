package edu.neu.csye7374;

public class CommandController {
    Command command;

    // Set command
    public void setCommand(Command command) {
        this.command = command;
    }

    // Execute the command
    public void execute(){
        command.execute();
    }

}