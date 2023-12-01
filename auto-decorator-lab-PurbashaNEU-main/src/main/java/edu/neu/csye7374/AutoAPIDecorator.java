package edu.neu.csye7374;

public abstract class AutoAPIDecorator implements AutoAPI{

    AutoAPI autoapi;

    protected double price;
    protected String description;

    public AutoAPIDecorator(AutoAPI autoapi) {
        this.autoapi = autoapi;
    }

    @Override
    public double getPrice() {
        this.price =  autoapi.getPrice();
        return this.price;
    }

    @Override
    public String getDescription() {
        this.description =  autoapi.getDescription();
        return this.description;
    }
}
