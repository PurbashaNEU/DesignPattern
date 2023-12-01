package edu.neu.csye7374;

import java.util.List;

public class GoogleSingletonFactory  implements StockFactory{
	private static GoogleSingletonFactory instance;
	private GoogleSingletonFactory() {
		instance = null;
	}

	public static synchronized GoogleSingletonFactory getInstance(){
		if(instance == null) {
			instance = new GoogleSingletonFactory();
		}
		return instance;
	}

	@Override
	public Stock getObject(String name, double price, String description, List<Double> previousPrices) {
		return new Google(name, price, description, previousPrices);
	}
}