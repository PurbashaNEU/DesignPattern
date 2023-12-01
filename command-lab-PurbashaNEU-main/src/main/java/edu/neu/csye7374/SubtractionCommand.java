package edu.neu.csye7374;

public class SubtractionCommand implements Command{
    private Calculator calc;
    int x;
    int y;

    public SubtractionCommand(Calculator calc, int x, int y) {

        this.calc = calc;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        calc.subtract(x, y);
    }
}
