package edu.neu.csye7374;

import java.util.List;

public class GoogleStockFactory implements StockFactory{
	@Override
	public Stock getObject(String name, double price, String description, List<Double> previousPrices) {
		return new Google(name, price, description, previousPrices);
	}
}
