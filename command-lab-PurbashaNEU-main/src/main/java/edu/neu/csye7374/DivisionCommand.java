package edu.neu.csye7374;

public class DivisionCommand implements Command{
    private Calculator calc;
    int x;
    int y;

    public DivisionCommand(Calculator calc, int x, int y) {

        this.calc = calc;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        calc.division(x, y);
    }
}
