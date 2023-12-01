package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class Google extends Stock {
	public Google(String name, double price, String description, List<Double> previousPrices) {
		super(name, price, previousPrices, description);
		setStockName(name);
		setPrice(price);
		setStockDescription(description);
		setPreviousPrices(previousPrices);
	}

	@Override
	public void setBid(double bid) {
		super.setBid(bid);
	}

	@Override
	public int getMetric() {
		
		double avgStockPrice = 0.0d;
		int n = this.getPreviousPrices().size();
		for(int i = 0; i < n; i++) {
			avgStockPrice += this.getPreviousPrices().get(i);
		}
		avgStockPrice = avgStockPrice / n;
		double currentPrice = this.getPreviousPrices().get(n - 1);

		int stockPerformance = 0;

		if(currentPrice >= avgStockPrice) stockPerformance++;
		else stockPerformance--;

		return  stockPerformance;
	}

	@Override
	public String toString() {return super.toString();}

}