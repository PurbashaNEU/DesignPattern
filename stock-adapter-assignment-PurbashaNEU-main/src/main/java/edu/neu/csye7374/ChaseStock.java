package edu.neu.csye7374;

import java.util.concurrent.ThreadLocalRandom;

public class ChaseStock extends Stock {

	public ChaseStock(String iD, double price, String description, double bid, String tradeType) {
		super(iD, price, description, bid, tradeType);
		// TODO Auto-generated constructor stub
	}

	public double getBid() {
		int randNum=ThreadLocalRandom.current().nextInt(250, 350 + 1);
		return randNum;
	}
	
	@Override
	public void setBid(double Price) {
		// TODO Auto-generated method stub
		super.setBid(Price);
	}

	@Override
	public int getMetric() {
		// TODO Auto-generated method stub
		int num = (ThreadLocalRandom.current().nextInt(-25, 25 + 1)*5)/4;
		return num;
	}
}
