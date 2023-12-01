package edu.neu.csye7374;

import java.util.List;

public class Chase extends Stock {
	public Chase(String name, double price, String description, List<Double> previousPrices) {
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

		int stockPerformance = 0;
		for (int i = 1; i < super.getPreviousPrices().size(); i++) {
			if(super.getPreviousPrices().get(i - 1) > super.getPreviousPrices().get(i)) {
				stockPerformance--;
			}
			else {
				stockPerformance++;
			}
		}
		return stockPerformance;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}