package edu.neu.csye7374;

/**
 * @author SaiAkhil
 
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements

        System.out.println("\n\n============Main Execution End===================");
    }
}*/

import java.util.ArrayList;
import java.util.List;

// Tradable interface with setBid() and getMetric() methods
interface Tradable {
    void setBid(double bid);
    int getMetric();
}

// Tradeable0 interface with default implementations for setBid() and getMetric() methods
interface Tradeable0 extends Tradable {
    default void setBid(double bid) {
        // Default implementation for setBid() method
        // Can be overridden by implementing classes
        // No implementation provided here as it's not specified in the requirements
    }

    default int getMetric() {
        // Default implementation for getMetric() method
        // Can be overridden by implementing classes
        // No implementation provided here as it's not specified in the requirements
        return 0; // Default metric value
    }
}

// Tradeable1 interface with default implementation ONLY FOR getMetric() method
interface Tradeable1 extends Tradable {
    default void setBid(double bid) {
        // No implementation for setBid() method in Tradeable1
        // As per requirements, it should not have a default implementation for setBid()
    }

    default int getMetric() {
        // Default implementation for getMetric() method
        // Can be overridden by implementing classes
        // No implementation provided here as it's not specified in the requirements
        return 0; // Default metric value
    }
}

// Stock class implementing Tradable interface
abstract class Stock implements Tradable {
    private String name;
    private double price;
    private String description;

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters and setters for the attributes

    @Override
    public String toString() {
        return "Stock [name=" + name + ", price=" + price + ", description=" + description + "]";
    }

	public void setPrice(double newPrice) {
		// TODO Auto-generated method stub
		
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}

// Stock subclass with its own implementation of getMetric()
class TechStock extends Stock implements Tradeable0 {
    private int metric;

    public TechStock(String name, double price, String description) {
        super(name, price, description);
        this.metric = 0; // Default metric value
    }

    @Override
    public void setBid(double bid) {
        // Implement setBid() method for TechStock
        // Update the metric based on the bid or any other custom logic
        // Example:
        if (bid > 0) {
            metric++;
        } else {
            metric--;
        }
    }

    @Override
    public int getMetric() {
        // Implement getMetric() method for TechStock
        // Return the calculated metric value or any other custom logic
        return metric;
    }
}

// Stock subclass with its own implementation of getMetric()
class BankStock extends Stock implements Tradeable1 {
    private int metric;

    public BankStock(String name, double price, String description) {
        super(name, price, description);
        this.metric = 0; // Default metric value
    }

    @Override
    public void setBid(double bid) {
        // Implement setBid() method for BankStock
        // Update the metric based on the bid or any other custom logic
        // Example:
        if (bid > 0) {
            metric++;
        } else {
            metric--;
        }
    }

    @Override
    public int getMetric() {
        // Implement getMetric() method for BankStock
        // Return the calculated metric value or any other custom logic
        return metric;
    }
}

// StockMarket class as a lazy Singleton
class StockMarkets {
    private static StockMarkets instance;
    private List<Stock> stocks;

    private StockMarkets() {
        stocks = new ArrayList<>();
    }

    public static synchronized StockMarkets getInstance() {
        if (instance == null) {
            instance = new StockMarkets();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void tradeStocks() {
        for (Stock stock : stocks) {
            // Calculate new stock price based on current price, bid, and metric
            double newPrice = stock.getPrice() + stock.getMetric(); // Example calculation
            stock.setPrice(newPrice);
        }
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void showAllStocks() {
        for (Stock stock : stocks) {
            System.out.println(stock.toString());
        }
    }
}

// Main class to test the functionality
public class Driver {
    public static void main(String[] args) {
        // Create instances of stock subclasses
    	 System.out.println("============Main Execution Start===================\n\n");
        TechStock techStock = new TechStock("IBM", 131.15, "IBM Common Stock");
        BankStock bankStock = new BankStock("XYZ", 50.0, "XYZ Bank Stock");

        // Add stocks to the stock market
        StockMarkets stockMarket = StockMarkets.getInstance();
        stockMarket.addStock(techStock);
        stockMarket.addStock(bankStock);

        // Provide 6 bids for each stock
        for (int i = 1; i <= 6; i++) {
            techStock.setBid(i * 10);
            bankStock.setBid(i * -5);
        }

        // Trade stocks
        stockMarket.tradeStocks();

        // Show all stocks
        stockMarket.showAllStocks();
        System.out.println("\n\n============Main Execution End===================");
    }
}
