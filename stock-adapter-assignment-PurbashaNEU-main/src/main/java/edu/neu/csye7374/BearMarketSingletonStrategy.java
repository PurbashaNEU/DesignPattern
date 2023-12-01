package edu.neu.csye7374;

import java.util.concurrent.ThreadLocalRandom;

public class BearMarketSingletonStrategy implements MetricStrategyAPI {

	
private static BearMarketSingletonStrategy instance;
	
	private BearMarketSingletonStrategy() {
		super();
		instance=null;
	}
	
	public static synchronized BearMarketSingletonStrategy getInstance() {
		if (instance == null) {
			instance = new BearMarketSingletonStrategy();
		}
		return instance;
	}
	
	@Override
	public int calculateMetric() {
		int num = (int)((ThreadLocalRandom.current().nextInt( -45 + 1,0)*2.25)/2.75);
		return num;
	}

}
