package edu.neu.csye7374;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SaiAkhil
 
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements

        System.out.println("\n\n============Main Execution End===================");
    }*/
 
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        StockMarket stockMarket = StockMarket.getInstance();

        Stock1 stock1 = new Stock1("IBM", 131.15, "IBM Common Stock");
        Stock2 stock2 = new Stock2("Google", 2000.0, "Google Alphabet Inc.");

        double[] bids = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };

        for (double bid : bids) {
            stockMarket.tradeStock(stock1, bid);
            stockMarket.tradeStock(stock2, bid);
            System.out.println(stock1);
            System.out.println(stock2);
            System.out.println();
        }

        System.out.println("\n\n============Main Execution End===================");
    }
}

public interface Tradable {
    void setBid(double bid);
    int getMetric();
}

public class Stock {
    private String name;
    private double price;
    private String description;

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

public class Stock1 extends Stock implements Tradable {
    private int metric;

    public Stock1(String name, double price, String description) {
        super(name, price, description);
        metric = 0;
    }

    public void setBid(double bid) {
        metric = (int) (bid * 10);
    }

    public int getMetric() {
        return metric;
    }
}

public class Stock2 extends Stock implements Tradable {
    private int metric;

    public Stock2(String name, double price, String description) {
        super(name, price, description);
        metric = 0;
    }

    public void setBid(double bid) {
        metric = (int) (bid * 5);
    }

    public int getMetric() {
        return metric;
    }
}

public class StockMarket {
    private static volatile StockMarket instance;
    private List<Stock> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void tradeStock(Stock stock, double bid) {
        double currentPrice = stock.getPrice();
        int metric = stock.getMetric();
        double newPrice = currentPrice + bid * metric;
        stock.setPrice(newPrice);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void showAllStocks() {
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }
    
    public interface Tradeable0 extends Tradable {
        default void setBid(double bid) {
            System.out.println("Default implementation of setBid() in Tradeable0");
        }

        default int getMetric() {
            System.out.println("Default implementation of getMetric() in Tradeable0");
            return 0;
        }
    }

    public interface Tradeable1 extends Tradable {
        default int getMetric() {
            System.out.println("Default implementation of getMetric() in Tradeable1");
            return 0;
        }
    }

    public class Stock1 extends Stock implements Tradeable0 {
        private int metric;

        public Stock1(String name, double price, String description) {
            super(name, price, description);
            metric = 0;
        }

        public void setBid(double bid) {
            metric = (int) (bid * 10);
        }

        public int getMetric() {
            return metric;
        }
    }

    public class Stock2 extends Stock implements Tradeable1 {
        private int metric;

        public Stock2(String name, double price, String description) {
            super(name, price, description);
            metric = 0;
        }

        public void setBid(double bid) {
            metric = (int) (bid * 5);
        }
    }

}

