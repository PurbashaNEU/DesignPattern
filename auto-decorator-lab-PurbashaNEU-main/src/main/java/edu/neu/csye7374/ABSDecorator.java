package edu.neu.csye7374;

public class ABSDecorator extends AutoAPIDecorator{

    public ABSDecorator(AutoAPI autoapi) {
        super(autoapi);
    }

    public double getPrice(){
        System.out.println(" ABS Decorator ");
        price = autoapi.getPrice();
        System.out.println(" Price before Adding ABS $" + price);
        double newPrice =  price + 2000.00;
        System.out.println(" Price After Adding ABS $" + newPrice);
        return newPrice;
    }

    public String getDescription(){
        description = autoapi.getDescription();
        return description + "| ABS added through decorator, price increased by $2000 |";
    }
}
