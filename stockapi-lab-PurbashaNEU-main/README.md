# Lazy Singleton - StockAPI
> Northeastern University, College of Engineering


## Purbasha Pan

### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.

### Overview
Designed a StockMarket class as a lazy Singleton that facilitates the trading of Stock objects. 
The StockMarket supports adding, trading, and removing Stock objects, as well as displays the details of all traded stocks. 
The Stock class, serving as the superclass, includes attributes such as name, price, and description, and implemented the Tradable interface, defining methods for setting bids and getting performance metrics.

Additionally, derived two unique subclasses of the Stock class, each implementing its algorithm for calculating the performance metric. 
Provided six bids for each stock subclass and showcase how the stock price and metric change based on these bids.

The Tradable interface has default implementations for the setBid() and getMetric() methods in the Tradeable0 API, while the Tradeable1 API has a default implementation for the getMetric() method.


