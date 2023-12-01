package edu.neu.csye7374;

public class ApplePay implements StockPaymentDigitalAPI {

private static ApplePay applePayInstance = new ApplePay();
	
	private ApplePay() {}
	
	public static ApplePay getInstance() {
		return applePayInstance;
	}
	
	@Override
	public void PaymentDigital(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Stock Payment of $" + amount + " done through ApplePay");
	}

}
