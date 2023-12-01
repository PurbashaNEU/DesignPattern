package edu.neu.csye7374;

public class GoogleStockStrategy extends StockFactory {

	@Override
	public Stock getObject(String name, double price, String description, double bid, String tradeType) {
		return new GoogleStock(name,price,description,bid,tradeType);
	}

}
