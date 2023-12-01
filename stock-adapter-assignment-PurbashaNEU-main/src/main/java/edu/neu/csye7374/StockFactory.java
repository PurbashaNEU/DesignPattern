package edu.neu.csye7374;

public abstract class StockFactory {
	public abstract Stock getObject(String name, double price, String description, double bid, String tradeType);
}
