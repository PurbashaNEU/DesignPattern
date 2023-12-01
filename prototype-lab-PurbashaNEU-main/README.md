# Prototype Design Pattern
> Northeastern University, College of Engineering


## Purbasha Pan

### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.

### Overview 
Designed and implemented a system that utilizes the Abstract Factory, Builder, and Prototype design patterns to sell uppercase letters with associated prices.
This involved creating a MyCloneable class with a Builder pattern and implementing inner classes such as MyCloneableItem. 
Additionally, developed a MyCloneableAbstractFactory class based on the supplied MyCloneableAbstractFactoryAPI. 
The MyCloneableAbstractFactory is a Singleton and capable of loading 26 MyCloneableItem prototypes, which can be cloned upon request.

The implementation demonstrates the use of console output to show the creation and attributes of 26 Letter Items with their respective IDs, prices, and names.
