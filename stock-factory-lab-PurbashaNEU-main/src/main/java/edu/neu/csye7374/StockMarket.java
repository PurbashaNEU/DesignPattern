package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockMarket {
	private List<Stock> stockList = new ArrayList<>();
	private static StockMarket instance;
	private List<StockFactory> factories = new ArrayList<>();
	private StockMarket() {
		
		instance = null;
	}

	public static synchronized StockMarket getInstance()
	{
		if (instance == null)
		{
			
			instance = new StockMarket();
		}
		return instance;
	}

	public void AddStock(ArrayList<Stock> stockList) {
		this.stockList = stockList;
	}

	public void DeleteStock(Stock stock) {
		stockList.remove(stock);
	}

	public Double getPrice(Stock stock) {
		Double nPrice = 0.0;

		Double prev = 0.0;
		for (int i = 0; i < stock.getPreviousPrices().size(); i++) {
			prev = prev + stock.getPreviousPrices().get(i);
		}
		nPrice = ((stock.getPreviousPrices().get(5) + (prev/stock.getPreviousPrices().size()))/2) + (4 * stock.getMetric());

		return nPrice;
	}

	public void TradeStock(ArrayList<Stock> stockList) {
		for(Stock st : stockList){
			int performanceIndex = st.getMetric();
			double currentPrice = st.getPrice();
			int numberOfBids = st.getPreviousPrices().size();
			st.setPrice(currentPrice + performanceIndex*numberOfBids);
		}
	}

	@Override
	public String toString() {
		StringBuilder stockInfo = new StringBuilder();
		for(Stock st: stockList) {
			stockInfo.append(st.toString());
			
		}
		return stockInfo.toString();
	}

	public void add(StockFactory stockFactory) {
		this.factories.add(stockFactory);
	}

	public void demo() {
		this.add(new ChaseStockFactory());
		this.add(new GoogleStockFactory());

		stockList.add(factories.get(0).getObject("Chase", 6.5, "Chase stock", new ArrayList<>(Arrays.asList(3.4,4.5,5.6,6.1,8.6,9.7))));
		stockList.add(factories.get(1).getObject("Google", 21.5, "Google stock", new ArrayList<>(Arrays.asList(29.0,41.0,52.0,63.0,68.0,75.0))));

		System.out.println("GoF Design Pattern");
		for(int i = 0; i < 2; i++) {
			System.out.println("Chase Stock:");
			System.out.println();
			stockList.get(0).setBid(12.5);
			System.out.println(stockList.get(0));
			
			stockList.get(0).setBid(13.5);
			System.out.println(stockList.get(0));
			
			stockList.get(0).setBid(14.5);
			System.out.println(stockList.get(0));

			System.out.println();
			System.out.println("Google Stock:");
			System.out.println();
			stockList.get(1).setBid(25);
			System.out.println(stockList.get(1));
			
			stockList.get(1).setBid(26);
			System.out.println(stockList.get(1));
			
			stockList.get(1).setBid(27);
			System.out.println(stockList.get(1));

			if(i > 0) break;
			
			System.out.println("Singleton Design Pattern");
			factories.add(ChaseSingletonFactory.getInstance());
			factories.add(GoogleSingletonFactory.getInstance());
			stockList.add(factories.get(0).getObject("Chase", 6.5, "Chase Stock", new ArrayList<>(Arrays.asList(3.4,4.5,5.6,6.1,8.6,9.7))));
			stockList.add(factories.get(1).getObject("Google", 21.5, "Google Stock", new ArrayList<>(Arrays.asList(29.0,41.0,52.0,63.0,68.0,75.0))));
		}
	}
}