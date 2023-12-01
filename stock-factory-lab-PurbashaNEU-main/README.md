# Singleton factory Design Pattern
> Northeastern University, College of Engineering


## Purbasha Pan

### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.

### Overview
Derived Classes from Stock :
Class StockTypeA: Represents one of the derived classes from Stock.
Class StockTypeB: Represents the second derived class from Stock.

GoF Factory Method Pattern:
For each derived class, created a factory that implements the GoF Factory Method pattern.
FactoryTypeA: Factory for creating instances of StockTypeA.
FactoryTypeB: Factory for creating instances of StockTypeB.

GoF Factory Method and Singleton Pattern (Lazy):
For each derived class, implemented a factory that combines the GoF Factory Method and Singleton patterns using Lazy initialization.
LazySingletonFactoryTypeA: Lazy Singleton Factory for creating instances of StockTypeA.
LazySingletonFactoryTypeB: Lazy Singleton Factory for creating instances of StockTypeB.

GoF Factory Method and Singleton Pattern (Eager):
For each derived class, implemented a factory that combines the GoF Factory Method and Singleton patterns using Eager initialization.
EagerSingletonFactoryTypeA: Eager Singleton Factory for creating instances of StockTypeA.
EagerSingletonFactoryTypeB: Eager Singleton Factory for creating instances of StockTypeB.
