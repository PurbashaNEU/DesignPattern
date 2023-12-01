package edu.neu.csye7374;

public class ChaseStockStrategy extends StockFactory {

	@Override
	public Stock getObject(String name, double price, String description, double bid, String tradeType) {

		return new ChaseStock(name,price,description,bid,tradeType);

	}

}
