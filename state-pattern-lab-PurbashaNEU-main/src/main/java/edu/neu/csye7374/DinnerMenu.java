package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class DinnerMenu implements RestaurantStateAPI{
    public RestaurantStateContext restaurantStateContext;
    private List<Driver.MenuItem> menu;

    public DinnerMenu(){
//        this.restaurantStateContext = restaurantStateContext;
        menu = new ArrayList<>();
        menu.add(new Driver.MenuItem("Soup", 11.99));
        menu.add(new Driver.MenuItem("Salad", 12.99));
        menu.add(new Driver.MenuItem("Steak", 13.99));
    }

    public DinnerMenu(RestaurantStateContext restaurantStateContext) {
        this.restaurantStateContext = restaurantStateContext;
//        this.restaurantStateContext = restaurantStateContext;
        menu = new ArrayList<>();
        menu.add(new Driver.MenuItem("Soup", 11.99));
        menu.add(new Driver.MenuItem("Salad", 12.99));
        menu.add(new Driver.MenuItem("Steak", 13.99));
    }

//    public DinnerMenu(RestaurantStateContext restaurantStateContext) {
//
//    }

    @Override
    public void lunchMenu() {
        restaurantStateContext.setState(restaurantStateContext.getLunch());
        System.out.print("Lunch state set\n\n");
    }

    @Override
    public void accessoryMode() {
        System.out.print("ERROR: Can’t switch Accessory from Dinner state!\n");
    }

    @Override
    public void dinnerMenu() {
        System.out.print("In Dinner state!\n\n");
        System.out.println("ITEM\tPRICE\tDESCRIPTION");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i+1) + "\t" + menu.get(i));
        }
    }

    @Override
    public void optionalMenu() {
        restaurantStateContext.setState(restaurantStateContext.getOptional());
        System.out.print("Optional state set\n\n");
    }

}
