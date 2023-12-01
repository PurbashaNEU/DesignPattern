package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Tradable{
	private String stockName;
	private Double price;
	private List<Double> previousPrices = new ArrayList<>();
	private String stockDescription;

	public Stock(String stockName, Double price, List<Double> previousPrices, String stockDescription) {
		super();
		this.stockName = stockName;
		this.price = price;
		this.previousPrices = previousPrices;
		this.stockDescription = stockDescription;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockDescription() {
		return stockDescription;
	}

	public void setStockDescription(String stockDescription) {
		this.stockDescription = stockDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
		this.previousPrices.add(price);
	}

	public List<Double> getPreviousPrices() {
		return previousPrices;
	}

	public void setPreviousPrices(List<Double> previousPrices) {
		this.previousPrices = previousPrices;
	}

	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name:").append(getStockName());
		sb.append("  Description:").append(getStockDescription());
		sb.append("  Stock Price:").append(getPrice());
		sb.append("  Last Stock Price:").append(getPreviousPrices()).append("\n");
		return sb.toString();
	}
	@Override
	public int getMetric() {

		return 0;
	}
	
	@Override
	public void setBid(double bid) {
		previousPrices.add(bid);
	}

	
}