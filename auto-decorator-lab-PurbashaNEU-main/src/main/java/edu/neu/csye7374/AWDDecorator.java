package edu.neu.csye7374;

public class AWDDecorator extends AutoAPIDecorator{

    public AWDDecorator(AutoAPI autoapi) {
        super(autoapi);
    }

    @Override
    public double getPrice(){
        System.out.println(" AWD Decorator ");
        price = autoapi.getPrice();
        System.out.println(" Price before Adding AWD $" + price);
        double newPrice =  price + 1500.00;
        System.out.println(" Price After Adding AWD $" + newPrice);
        return newPrice;
    }

    public String getDescription(){
        description = autoapi.getDescription();
        return description + "| AWD added using AWD Decorator, price increased by $1500 |";
    }
}
