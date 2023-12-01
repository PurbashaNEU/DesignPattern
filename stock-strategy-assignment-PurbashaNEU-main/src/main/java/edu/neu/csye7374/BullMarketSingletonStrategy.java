package edu.neu.csye7374;

import java.util.concurrent.ThreadLocalRandom;

public class BullMarketSingletonStrategy implements MetricStrategyAPI {

private static BullMarketSingletonStrategy instance = new BullMarketSingletonStrategy();
	
	private BullMarketSingletonStrategy() {}
	
	public static BullMarketSingletonStrategy getInstance() {
		return instance;
	}
	
	@Override
	public int calculateMetric() {
		int num = (int)((ThreadLocalRandom.current().nextInt(1, 45 + 1)*3.33)/2.75);
		return num;
	}

}
