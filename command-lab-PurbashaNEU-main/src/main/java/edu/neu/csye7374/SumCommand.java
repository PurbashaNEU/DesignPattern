package edu.neu.csye7374;

public class SumCommand implements Command{
    private Calculator calc;
    int w;
    int x;
    int y;
    int z;

    public SumCommand(Calculator calc, int w, int x, int y, int z) {

        this.calc = calc;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void execute() {
        calc.sum(w, x, y, z);
    }
}
