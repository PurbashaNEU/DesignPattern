package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StockMarket {

	private static StockMarket instance;
	private List<Stock> stocks= new ArrayList<>();
	private List<Stock> tradedstocks=new ArrayList<>();
	
	
	private StockMarket() {
		super();
		instance=null;
	}
	
	public static StockMarket getInstance() {
		if (instance == null) {
			instance = new StockMarket();
		}
		return instance;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public List<Stock> getTradedstocks() {
		return tradedstocks;
	}

	public void setTradedstocks(List<Stock> tradedstocks) {
		this.tradedstocks = tradedstocks;
	}

   public void addStock(Stock s)
   {
	   getStocks().add(s);
   }
   public void removeStock(Stock s)
   {
	   getStocks().remove(s);
   }
   
   public void addTrade(Stock s)
   {
	   tradedstocks.add(s);
   } 
   
   public void showTrades()
   {
	   System.out.println("Traded Stocks:\n");
	   for (Stock t : tradedstocks)
	    {
		   System.out.println("Name: " + t.getID()+", "+t.getTradeType()+" price: "+t.getPrice());
		}
   } 
   
   public static void displayTrade(Stock t)
   {
	  System.out.println("New Price: "+t.getPrice());
   } 
   
   public void showStocks()
   {
	   //System.out.println("Stock Market:");
	   for (Stock s : getStocks())
	    {System.out.println(s.toString());}
   }
   
   public void trade(Stock s,String metricStrategyType)
   {
	   int metric=0;
	   
	   if(metricStrategyType=="BullMarketStrategy")
		   metric=new BullMarketStrategy().calculateMetric();
	   else if(metricStrategyType=="BearMarketStrategy")
		   metric=new BearMarketStrategy().calculateMetric();
	  
	  if (metric>0) // positive performance
	  {
		  Stock  tradebuystock = new Stock(s.getID(),s.getPrice(),s.getDescription(),s.getBid(),s.getTradeType());
		  tradebuystock.setTradeType("Buying");
		  addTrade(tradebuystock);
	  }
	  else // negative performance 
	  {
		  Stock  tradesellstock = new Stock(s.getID(),s.getPrice(),s.getDescription(),s.getBid(),s.getTradeType());
		  tradesellstock.setTradeType("Selling");
		  addTrade(tradesellstock);
	  }	 
	  
	  s.setPrice(s.getPrice()+metric);
   }
   
   
   public static void demo() {
	 // Create stock market instance
	StockMarket stkMkt = StockMarket.getInstance();
	
	// Factory object creation to get Stocks Factory Objects
	StockFactory factory1 = new GoogleStockStategy();
	StockFactory factory2 = new ChaseStockStrategy();
	
	// Singleton Factory Stock Objects
	StockFactory singletonFactory1 = GoogleStockSingletonStrategy.getInstance(); // Lazy Singleton
	StockFactory singletonFactory2 = ChaseStockSingletonStrategy.getInstance(); // Eager Singleton
	
	
	
	//Creating Stock Objects using getObject Method
	Stock stock1 = factory1.getObject("Google Stock",230.0,"Google GoF Stocks Description",0.0,null);
	Stock stock2 = factory2.getObject("Chase Stock",170.0,"Chase GoF Stocks Description",0.0,null);
	
	//Creating Singleton Stock Objects using getObject Method
	Stock stock3 = singletonFactory1.getObject("Google Singleton Stock", 97.50, "Google lazy Singleton Stocks Description", 0.0, null);
	Stock stock4 = singletonFactory2.getObject("Chase Singleton Stock", 510.50, "Chase eager Singleton Stocks Description", 0, null);


	   stkMkt.addStock(stock1);
	   stkMkt.addStock(stock2);
	   stkMkt.addStock(stock3);
	   stkMkt.addStock(stock4);
	
	
	//viewing stocks
	System.out.println("Initial Stock Market: \n");
	   stkMkt.showStocks();
	System.out.println("\n---------------------");	
	
	// simulation of trading on stock1
	System.out.println("\n"+stock1.getID()+"\n");
	for (int i=0; i<6; i++)
	{
		double start = stock1.getPrice();
		double end = stock1.getPrice()+ new BullMarketStrategy().calculateMetric();   // Implementation of BullMarketMetricStrategy
		double random = new Random(System.currentTimeMillis()+2150).nextDouble();
		double bid_now = start + (random * (end - start));
		System.out.println("Bid: " + bid_now);
		stock1.setBid(bid_now);
		System.out.println("After trade:");
		stkMkt.trade(stock1,"BullMarketStrategy");
		displayTrade(stock1);
		//stkMkt.showTrades();
		System.out.println();
	}
	
	System.out.println("\n---------------------");
	
	// simulation of trading on stock2
	System.out.println("\n"+stock2.getID()+"\n");
	for (int i=0; i<6; i++)
	{
		double start = stock2.getPrice();
		double end = stock2.getPrice()+ new BearMarketStrategy().calculateMetric(); //// Implementation of BearMarketMetricStrategy
		double random = new Random(System.currentTimeMillis()+1675).nextDouble();
		double bid_now = start + (random * (end - start));
		System.out.println("Bid: " + bid_now);
		stock2.setBid(bid_now);
		System.out.println("After trade:");
		stkMkt.trade(stock2,"BearMarketStrategy");
		displayTrade(stock2);
		
		System.out.println();
	}
	System.out.println("\n---------------------");
	
	// simulation of trading on stock3
	System.out.println("\n"+stock3.getID()+"\n");
	for (int i=0; i<6; i++)
	{
		double start = stock3.getPrice();
		// Implementation of Bear Market Metric Strategy Singleton
		double end = stock3.getPrice()+ BearMarketSingletonStrategy.getInstance().calculateMetric();
		double random = new Random(System.currentTimeMillis()+1835).nextDouble();
		double bid_now = start + (random * (end - start));
		System.out.println("Bid: " + bid_now);
		stock1.setBid(bid_now);
		System.out.println("After trade:");
		stkMkt.trade(stock3,"BearMarketStrategy");
		displayTrade(stock3);
		
		System.out.println();
	}
	System.out.println("\n---------------------");
	
	// simulation of trading on stock4
	System.out.println("\n"+stock4.getID()+"\n");
	for (int i=0; i<6; i++)
	{
		double start = stock4.getPrice();
		// Implementation of Bull market Metric Strategy Singleton
		double end = stock4.getPrice()+BullMarketSingletonStrategy.getInstance().calculateMetric();
		double random = new Random(System.currentTimeMillis()+1350).nextDouble();
		double bid_now = start + (random * (end - start));
		System.out.println("Bid: " + bid_now);
		stock1.setBid(bid_now);
		System.out.println("After trade:");
		stkMkt.trade(stock4,"BullMarketStrategy");
		displayTrade(stock4);
		
		System.out.println();
	}
	System.out.println("\n---------------------");
	
	
	
	
	System.out.println("\nFinal Stock Market:");
	System.out.println();
	   stkMkt.showStocks();
	System.out.println("\n---------------------");
	
	System.out.println();
	   stkMkt.showTrades();
	
   }	   
}
