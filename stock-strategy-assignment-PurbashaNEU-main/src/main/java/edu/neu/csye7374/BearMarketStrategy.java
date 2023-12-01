package edu.neu.csye7374;

import java.util.concurrent.ThreadLocalRandom;

public class BearMarketStrategy implements MetricStrategyAPI {

	@Override
	public int calculateMetric() {
		int num = (int)((ThreadLocalRandom.current().nextInt( -45 + 1,0)*2.25)/2.75);
		return num;
	}

}
