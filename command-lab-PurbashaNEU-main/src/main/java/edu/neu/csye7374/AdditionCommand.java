package edu.neu.csye7374;

public class AdditionCommand implements Command{
    private Calculator calc;
    int x;
    int y;

    public AdditionCommand(Calculator calc, int x, int y) {

        this.calc = calc;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        calc.add(x, y);
    }
}