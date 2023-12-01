package edu.neu.csye7374;

import java.util.List;

public class ChaseStockFactory implements StockFactory{
	@Override
	public Stock getObject(String name, double price, String description, List<Double> previousPrices) {
		return new Chase(name, price, description, previousPrices);
	}
}
