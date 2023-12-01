package edu.neu.csye7374;

public class Calculator {
    public void add(int x, int y) {
        int result = x + y;
        System.out.println("Addition result: "+result);
    }

    public void subtract(int x, int y) {
        int result = x - y;
        System.out.println("Subtraction result: "+result);
    }

    public void multiply(int x, int y) {
        int result = x * y;
        System.out.println("Multiplication result: "+result);
    }

    public void division(int x, int y) {
        int result = x / y;
        System.out.println("Division result: "+result);
    }

    public void sum(int w, int x, int y, int z) {
        int result = w + x + y + z;
        System.out.println("Sum result: "+result);
    }
}
