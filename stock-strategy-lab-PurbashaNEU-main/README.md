# Strategy Design Pattern - Payment System
> Northeastern University, College of Engineering


## Purbasha Pan

### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.

### Overview
A payment processing system is implemented using the Strategy pattern. 
Three concrete classes (CreditCardPaymentCalculator, PayPalPaymentCalculator, and BankTransferPaymentCalculator) implement the PaymentCalculator interface, providing different algorithms for calculating payment amounts. 
The PaymentProcessor class acts as the context and utilizes a selected payment calculator strategy.
