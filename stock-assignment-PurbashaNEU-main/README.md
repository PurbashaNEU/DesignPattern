
# API and Interfaces 
> Northeastern University, College of Engineering


## Purbasha Pan

### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.

### Overview
Designed and implemented a StockAPI super class with essential attributes, including ID, price, and description, and a toString() method.
Additionally, created a Tradable interface with methods for placing bids and calculating performance metrics for stocks.
Implemented the Stock class that extends the StockAPI, deriving two subclasses with their own performance metric algorithms, simulating market trends with six bids for each subclass, and observing changes in stock prices and metrics based on these bids. 
The goal is to showcase the design of a flexible and extensible stock trading system that incorporates interfaces and subclasses to represent various stocks and their market behaviors.
