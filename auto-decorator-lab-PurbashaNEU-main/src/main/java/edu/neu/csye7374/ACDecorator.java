package edu.neu.csye7374;

public class ACDecorator extends AutoAPIDecorator{

    public ACDecorator(AutoAPI autoapi) {
        super(autoapi);
    }

    @Override
    public double getPrice(){
        System.out.println(" AC Decorator ");
        price = autoapi.getPrice();
        System.out.println(" Price before Adding AC $" + price);
        double newPrice =  price + 1000.00;
        System.out.println(" Price After Adding AC $" + newPrice);
        return newPrice;
    }

    public String getDescription(){
        description = autoapi.getDescription();
        return description + "| AC added using AC Decorator, price increased by $1000 |";
    }
}
