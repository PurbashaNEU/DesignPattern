package edu.neu.csye7374;

public class PayPal implements StockPaymentDigitalAPI {

	
	private static PayPal payPalInstance = new PayPal();
	
	private PayPal() {}
	
	public static PayPal getInstance() {
		return payPalInstance;
	}
	
	@Override
	public void PaymentDigital(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Stock Payment of $" + amount + " done through PayPal");
	}

}
