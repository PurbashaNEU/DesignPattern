package edu.neu.csye7374;

public class Accessory implements RestaurantStateAPI{
    public RestaurantStateContext restaurantStateContext;

    public Accessory(RestaurantStateContext restaurantStateContext){
        this.restaurantStateContext = restaurantStateContext;
    }

    public Accessory() {

    }

    @Override
    public void lunchMenu() {
        System.out.print("ERROR: Can’t go LunchMenu from Accessory state!\n");
    }

    @Override
    public void accessoryMode() {
        System.out.print("In Accessory mode!\n\n");
    }

    @Override
    public void dinnerMenu() {
        restaurantStateContext.setState(restaurantStateContext.getDinner());
        System.out.print("Dinner state set\n\n");
    }

    @Override
    public void optionalMenu() {
        System.out.print("ERROR: Can’t go OptionalMenu from Accessory state!\n");
    }
}

