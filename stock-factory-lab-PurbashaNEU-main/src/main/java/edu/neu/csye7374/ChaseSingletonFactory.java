package edu.neu.csye7374;

import java.util.List;

public class ChaseSingletonFactory implements StockFactory{
	private static final ChaseSingletonFactory instance = new ChaseSingletonFactory();
	private ChaseSingletonFactory() {
	}

	public static ChaseSingletonFactory getInstance() {
		return instance;
	}

	@Override
	public Stock getObject(String name, double price, String description, List<Double> previousPrices) {
		return new Chase(name, price, description, previousPrices);
	}
}