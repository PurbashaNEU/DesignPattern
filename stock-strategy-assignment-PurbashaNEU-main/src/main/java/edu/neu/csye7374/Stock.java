package edu.neu.csye7374;

import java.util.Random;

public class Stock implements Tradable{
	
	private String ID;
	private double price;
	private String description;
	private double bid;
	private String tradeType;
	
	
	public Stock() {}
	
	public Stock(String iD, double price, String description, double bid, String tradeType) {
		super();
		ID = iD;
		this.price = price;
		this.description = description;
		this.bid = bid;
		this.tradeType = tradeType;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		int metric = getMetric();
		this.price = price+metric;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int getMetric() {
		double metric =0.0;
		Random rand = new Random(System.currentTimeMillis());
		for (int i=0; i<10; i++)
		{
			metric+= rand.nextDouble();
		}
		double avg=  metric/10;
		double diff = avg - this.getPrice();
		return (int) diff;
	}
	
	public double getBid() {
		return bid;
	}
	
	@Override
	public String toString()
	{
		return "\nStock: "+this.ID+ "\nPrice: "+this.price + "\nPerformance: "+this.getMetric()+ "\nDescription: "+this.description;
	}
	
	@Override
	public void setBid(double bid) {
		this.bid = bid;
	}
}
