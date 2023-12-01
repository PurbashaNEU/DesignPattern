package edu.neu.csye7374;

public class MultiplicationCommand implements Command{
    private Calculator calc;
    int x;
    int y;

    public MultiplicationCommand(Calculator calc, int x, int y) {

        this.calc = calc;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        calc.multiply(x, y);
    }
}