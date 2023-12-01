package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class LunchMenu implements RestaurantStateAPI{
    public RestaurantStateContext restaurantStateContext;
    private List<Driver.MenuItem> menu;

    public LunchMenu(){
        menu = new ArrayList<>();
        menu.add(new Driver.MenuItem("Hot Dog", 1.99));
        menu.add(new Driver.MenuItem("Salad", 2.99));
        menu.add(new Driver.MenuItem("Hamburger", 3.99));
    }
    public LunchMenu(RestaurantStateContext restaurantStateContext){
        this.restaurantStateContext = restaurantStateContext;
        menu = new ArrayList<>();
        menu.add(new Driver.MenuItem("Hot Dog", 1.99));
        menu.add(new Driver.MenuItem("Salad", 2.99));
        menu.add(new Driver.MenuItem("Hamburger", 3.99));
    }

    @Override
    public void lunchMenu() {
        System.out.print("In Lunch state!\n\n");
        System.out.println("ITEM\tPRICE\tDESCRIPTION");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i+1) + "\t" + menu.get(i));
        }
    }

    @Override
    public void accessoryMode() {
        restaurantStateContext.setState(restaurantStateContext.getAccessory());
        System.out.print("Restaurant Accessory mode set!\n\n");
    }

    @Override
    public void dinnerMenu() {
        System.out.print("ERROR: Can’t switch Dinner from Lunch state!\n");

    }

    @Override
    public void optionalMenu() {
        System.out.print("ERROR: Can’t switch Optional from Lunch state!\n");
    }
}
