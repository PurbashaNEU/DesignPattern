package edu.neu.csye7374;

public class ChaseStockSingletonStrategy extends StockFactory {
	
private static ChaseStockSingletonStrategy instance = new ChaseStockSingletonStrategy();
	
	private ChaseStockSingletonStrategy() {}
	
	public static ChaseStockSingletonStrategy getInstance() {
		return instance;
	}

	@Override
	public Stock getObject(String name, double price, String description, double bid, String tradeType) {
		return new ChaseStock(name,price,description,bid,tradeType);
	}

}