package edu.neu.csye7374;

public class BBDecorator extends AutoAPIDecorator{
    public BBDecorator(AutoAPI autoapi) {
        super(autoapi);
    }

    @Override
    public double getPrice(){
        System.out.println(" BBD Decorator ");
        price = autoapi.getPrice();
        System.out.println(" Price before Adding BBD $" + price);
        double newPrice =  price + 900.00;
        System.out.println(" Price After Adding BBD $" + newPrice);
        return newPrice;
    }

    public String getDescription(){
        description = autoapi.getDescription();
        return description + "| BBD added using BBD Decorator, price increased by $900 |";
    }
}
