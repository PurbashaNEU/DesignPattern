package edu.neu.csye7374;

import java.util.List;

public interface StockFactory {
	public Stock getObject(String name, double price, String description, List<Double> previousPrices);
}
