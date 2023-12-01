package edu.neu.csye7374;

import java.util.concurrent.ThreadLocalRandom;

public class GoogleStock extends Stock {

public GoogleStock() {}
	
	public GoogleStock(String iD, double price, String description, double bid, String tradeType) {
		super(iD, price, description, bid, tradeType);
	}

	public  double getBid() {
		int randNum=ThreadLocalRandom.current().nextInt(150, 300 + 1);
		return randNum;
	}
	
	@Override
	public void setBid(double Price) {
		// TODO Auto-generated method stub
		super.setBid(Price);
	}

	@Override
	public  int getMetric() {
		// TODO Auto-generated method stub
		int num = (ThreadLocalRandom.current().nextInt(-20, 50 + 1)*5)/4;
		return num;
	}
}
