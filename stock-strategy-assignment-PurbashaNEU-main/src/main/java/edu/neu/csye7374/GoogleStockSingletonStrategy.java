package edu.neu.csye7374;

public class GoogleStockSingletonStrategy extends StockFactory {
	
private static GoogleStockSingletonStrategy instance;
	
	private GoogleStockSingletonStrategy() {
		super();
		instance=null;
	}
	
	public static synchronized GoogleStockSingletonStrategy getInstance() {
		if (instance == null) {
			instance = new GoogleStockSingletonStrategy();
		}
		return instance;
	}

	@Override
	public Stock getObject(String name, double price, String description, double bid, String tradeType) {
		return new GoogleStock(name,price,description,bid,tradeType);
	}

}
