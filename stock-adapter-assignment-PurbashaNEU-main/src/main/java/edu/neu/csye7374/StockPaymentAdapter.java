package edu.neu.csye7374;

public class StockPaymentAdapter implements StockPaymentAPI {
	
	
	public StockPaymentAdapter() {
		super();
	}

	static StockPayment stockPaymentAdapter;

	@Override
	public void Payment(String paymentMethod, double amount) {
		// TODO Auto-generated method stub
		if(paymentMethod.equalsIgnoreCase("Check")){
			System.out.println("Stock Payment of $" + amount + " done through Check");		
		} 
		else if(paymentMethod.equalsIgnoreCase("BankTransfer")) {
			System.out.println("Stock Payment of $" + amount + " done through Bank Transfer");	
		}
		else if(paymentMethod.equalsIgnoreCase("PayPal") || paymentMethod.equalsIgnoreCase("ApplePay")){
			stockPaymentAdapter = new StockPayment(paymentMethod);
			stockPaymentAdapter.Payment(paymentMethod,amount);
		}
		else{
			System.out.println(paymentMethod + " is not valid!");
		}
	}
	
	public static void demo() {
		System.out.println("\nDemo for GooglePay:");
		StockPaymentAPI stockPaymentAdapter1 = new StockPaymentAdapter();
		stockPaymentAdapter1.Payment("GooglePay", 1000.00);
		System.out.println("\nDemo for BankTransfer:");
		StockPaymentAPI stockPaymentAdapter2 = new StockPaymentAdapter();
		stockPaymentAdapter2.Payment("BankTransfer", 1500.50);
		System.out.println("\nDemo for PayPal:");
		StockPaymentAPI stockPaymentAdapter3 = new StockPaymentAdapter();
		stockPaymentAdapter3.Payment("PayPal", 7000.67);
		System.out.println("\nDemo for ApplePay:");
		StockPaymentAPI stockPaymentAdapter4 = new StockPaymentAdapter();
		stockPaymentAdapter4.Payment("ApplePay", 2000.90);
		System.out.println("\nDemo for CreditCard:");
		StockPaymentAPI stockPaymentAdapter5 = new StockPaymentAdapter();
		stockPaymentAdapter5.Payment("CreditCard", 9000.00);
	}

}
