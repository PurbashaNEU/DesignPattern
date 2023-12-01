package edu.neu.csye7374;

public class BDMDecorator extends AutoAPIDecorator{
    public BDMDecorator(AutoAPI autoapi) {
        super(autoapi);
    }

    @Override
    public double getPrice(){
        System.out.println(" BDM Decorator ");
        price = autoapi.getPrice();
        System.out.println(" Price before Adding BDM $" + price);
        double newPrice =  price + 2500.00;
        System.out.println(" Price After Adding BDM $" + newPrice);
        return newPrice;
    }

    public String getDescription(){
        description = autoapi.getDescription();
        return description + "| BDM added using BDM Decorator, price increased by $2500 |";
    }
}
