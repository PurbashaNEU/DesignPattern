package edu.neu.csye7374;

/**
 * @author SaiAkhil
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements

        CommandController c = new CommandController();
        // Addition Command
        c.setCommand(new AdditionCommand(new Calculator(), 6, 3));
        // Executing command
        c.execute();

        CommandController m = new CommandController();
        m.setCommand(new MultiplicationCommand(new Calculator(), 6, 3));
        m.execute();

        CommandController s = new CommandController();
        s.setCommand(new SubtractionCommand(new Calculator(), 6, 3));
        s.execute();

        CommandController d = new CommandController();
        d.setCommand(new DivisionCommand(new Calculator(), 6, 3));
        d.execute();

        CommandController a = new CommandController();
        a.setCommand(new SumCommand(new Calculator(), 1, 2, 3, 4));
        a.execute();

        System.out.println("\n\n============Main Execution End===================");
    }
}
