package edu.neu.csye7374;

public class StockPayment implements StockPaymentAPI {
	
	StockPaymentDigitalAPI stockPaymentDigitalAPI;
	
	public StockPayment(String paymentMethod) {
		if(paymentMethod.equalsIgnoreCase("PayPal") ){
			stockPaymentDigitalAPI = PayPal.getInstance();

        }
		else if (paymentMethod.equalsIgnoreCase("ApplePay")){
			stockPaymentDigitalAPI = ApplePay.getInstance();
		}	
	}

	@Override
	public void Payment(String paymentMethod, double amount) {
		// TODO Auto-generated method stub
		stockPaymentDigitalAPI.PaymentDigital(amount);
	}

}
