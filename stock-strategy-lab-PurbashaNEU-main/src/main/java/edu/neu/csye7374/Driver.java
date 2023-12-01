package edu.neu.csye7374;

/**
 * @author SaiAkhil

public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements

        System.out.println("\n\n============Main Execution End===================");
    }
} */
//Abstract PaymentCalculator interface
interface PaymentCalculator {
 double calculatePaymentAmount(double totalAmount);
}

//Concrete CreditCardPaymentCalculator
//the payment amount is calculated by adding a convenience fee to the total amount
class CreditCardPaymentCalculator implements PaymentCalculator {
 private static final double CONVENIENCE_FEE_PERCENTAGE = 0.06;

 @Override
 public double calculatePaymentAmount(double totalAmount) {
     // Calculate payment amount for credit card payments
     double convenienceFee = totalAmount * CONVENIENCE_FEE_PERCENTAGE;
     return totalAmount + convenienceFee;
 }
}

//Concrete PayPalPaymentCalculator
//the payment amount is calculated by deducting a percentage discount from the total amount
class PayPalPaymentCalculator implements PaymentCalculator {
 private static final double DISCOUNT_PERCENTAGE = 0.15;

 @Override
 public double calculatePaymentAmount(double totalAmount) {
     // Calculate payment amount for PayPal payments
     double discount = totalAmount * DISCOUNT_PERCENTAGE;
     return totalAmount - discount;
 }
}

//Concrete BankTransferPaymentCalculator
// the payment amount remains the same without any additional fees or discounts
class BankTransferPaymentCalculator implements PaymentCalculator {
 @Override
 public double calculatePaymentAmount(double totalAmount) {
     // Calculate payment amount for bank transfer payments
     return totalAmount;
 }
}

//Context class that uses the PaymentCalculator
class PaymentProcessor {
 private PaymentCalculator paymentCalculator;

 public PaymentProcessor(PaymentCalculator paymentCalculator) {
     this.paymentCalculator = paymentCalculator;
 }

 public void setPaymentCalculator(PaymentCalculator paymentCalculator) {
     this.paymentCalculator = paymentCalculator;
 }

 public double processPayment(double totalAmount) {
	// Delegate the payment calculation to the selected payment calculator
     return paymentCalculator.calculatePaymentAmount(totalAmount);
 }
}

//Usage
public class Driver {
 public static void main(String[] args) {
     // Create an instance of PaymentProcessor
     PaymentProcessor paymentProcessor = new PaymentProcessor(new CreditCardPaymentCalculator());

     // Credit Card Payment
     double creditCardPaymentAmount = paymentProcessor.processPayment(200.0);
     System.out.println("Credit Card Payment Amount: $" + creditCardPaymentAmount);

     // PayPal Payment
     paymentProcessor.setPaymentCalculator(new PayPalPaymentCalculator());
     double payPalPaymentAmount = paymentProcessor.processPayment(200.0);
     System.out.println("PayPal Payment Amount: $" + payPalPaymentAmount);

     // Bank Transfer Payment
     paymentProcessor.setPaymentCalculator(new BankTransferPaymentCalculator());
     double bankTransferPaymentAmount = paymentProcessor.processPayment(200.0);
     System.out.println("Bank Transfer Payment Amount: $" + bankTransferPaymentAmount);
 }
}
