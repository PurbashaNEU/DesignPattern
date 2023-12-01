package edu.neu.csye7374;

public class Showroom {
    public static void demo(){
        System.out.println("\nThe car and features selected are : ");
        AutoAPI auto1 = new ACDecorator (new AWDDecorator(new Mazda()));
        String features= auto1.getDescription();
        System.out.println(features);
        System.out.println("\n\n Following features are to be added : ");
        double price1 = auto1.getPrice();
        System.out.println("\n The final price of the auto after modification is $"+price1);

        System.out.println("\nThe car and features selected are : ");
        AutoAPI auto2 = new BDMDecorator (new AWDDecorator(new Mazda()));
        features= auto2.getDescription();
        System.out.println(features);
       
        double price2 = auto2.getPrice();
        System.out.println("\nThe final price of the auto after modification is $"+price2);

        System.out.println("\nThe car and features selected are : ");
        AutoAPI auto3 = new BBDecorator(new ACDecorator (new AWDDecorator(new Mazda())));
        features= auto3.getDescription();
        System.out.println(features);
        System.out.println("\n\nThe following features are to be added : ");
        double price3 = auto3.getPrice();
        System.out.println("\n The final price of the auto after modification is $"+price3);

        System.out.println("\n\nThe car and features selected are:");
        AutoAPI auto4 = new ABSDecorator(new BDMDecorator(new BBDecorator(new SportyCoupeAuto())));
        features= auto4.getDescription();
        auto4.getDescription();
        System.out.println(features);
        System.out.println("\n\nThe following features are to be added : ");
        double price4 = auto4.getPrice();
        System.out.println("\n The final price of the auto after modification is $"+price4);

        System.out.println("\n\nThe car and features selected are : ");
        AutoAPI auto5 = new AWDDecorator(new ACDecorator(new ABSDecorator(new BDMDecorator(new BBDecorator(new SportyCoupeAuto())))));
        features= auto5.getDescription();
        auto5.getDescription();
        System.out.println(features);
        System.out.println("\n\nThe following features are to be added :");
        double price5 = auto5.getPrice();
        System.out.println("\n The final price of the auto after modification is $"+price5);

        System.out.println("\n\nThe car and features selected are : ");
        AutoAPI auto6 = new AWDDecorator(new ACDecorator(new ABSDecorator(new BBDecorator(new SportyCoupeAuto()))));
        features= auto6.getDescription();
        auto6.getDescription();
        System.out.println(features);
        System.out.println("\n\nThe following features are to be added : ");
        double price6 = auto6.getPrice();
        System.out.println("\n The final price of the auto after modification is $"+price6);
    }
}
