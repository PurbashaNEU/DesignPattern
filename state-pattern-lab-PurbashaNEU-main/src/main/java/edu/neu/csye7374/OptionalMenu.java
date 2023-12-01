package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class OptionalMenu implements RestaurantStateAPI{
    public RestaurantStateContext restaurantStateContext;
    private List<Driver.MenuItem> menu;
    public OptionalMenu(){
        menu = new ArrayList<>();
        menu.add(new Driver.MenuItem("Salmon", 14.99));
        menu.add(new Driver.MenuItem("Chicken", 15.99));
    }
    public OptionalMenu(RestaurantStateContext restaurantStateContext){
    this.restaurantStateContext = restaurantStateContext;
        menu = new ArrayList<>();
        menu.add(new Driver.MenuItem("Salmon", 14.99));
        menu.add(new Driver.MenuItem("Chicken", 15.99));
    }

    @Override
    public void lunchMenu() {
        System.out.print("ERROR: Can’t switch Lunch state from Optional state!\n");
    }

    @Override
    public void accessoryMode() {
        restaurantStateContext.setState(restaurantStateContext.getAccessory());
        System.out.print("Restaurant Accessory mode set!\n\n");
    }

    @Override
    public void dinnerMenu() {
        System.out.print("ERROR: Can’t switch Dinner from Optional state!\n");
    }

    @Override
    public void optionalMenu() {
        System.out.print("In Optional state!\n\n");
        System.out.println("ITEM\tPRICE\tDESCRIPTION");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i+1) + "\t" + menu.get(i));
        }
    }
}
