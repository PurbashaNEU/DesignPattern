package edu.neu.csye7374;

/**
 * @author SaiAkhil
 */

public class Driver {
    public static class MenuItem {
        private String name;
        private double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "$" + price + "\t" + name;
        }
    }

    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements
        RestaurantStateContext context = new RestaurantStateContext();
        context.lunchMenu();
        // context.dinnerMenu(); // will show error as dinner menu cant be accessed from lunch state
        // context.optionalMenu(); // will show error as optional menu cant be accessed from lunch state
        context.accessoryMode();
        // context.lunchMenu(); // will show error as lunch menu cant be accessed from accessory state
        // context.optionalMenu(); // will show error as optional menu cant be accessed from accessory state
        context.dinnerMenu();
        // context.lunchMenu(); // Can go to lunch state from dinner state
        // context.accessoryMode(); // will show error as accessory state cant be reached from dinner state
        context.optionalMenu();
//        context.dinnerMenu(); // will show error as dinner state cant be accessed from optional state
//         context.lunchMenu(); // will show error as lunch menu cant be accessed from optional state
        context.accessoryMode(); // Can go to accessory state from optional state
         context.dinnerMenu(); // Can set dinner menu again
        context.lunchMenu(); // Can set lunch state from dinner state


        System.out.println("\n\n============Main Execution End===================");
    }
}
