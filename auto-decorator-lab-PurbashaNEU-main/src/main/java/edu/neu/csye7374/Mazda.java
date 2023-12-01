package edu.neu.csye7374;

public class Mazda implements AutoAPI{

	@Override
	public double getPrice() {
		System.out.println("\n Price of Mazda is: $20000");
		return 20000.00;
	}

	@Override
	public String getDescription() {
		return " Mazda";
	}
	
	

}
