package edu.neu.csye7374;

/**
 * @author SaiAkhil
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        FinalComprehensive.demo();
        

        System.out.println("\n\n============Main Execution End===================");
    }
}


/****
 
============Main Execution Start===================



	edu.neu.csye7374.FinalComprehensive.demo() revision [3.27] ...
initial revision
1. Implement Class Adapter (AdapterClass) for API1 to use API2
1.a Create a new Java class named AdapterClass.
1.b Implement the API1 interface in the AdapterClass class
1.c Define private fields to store an instance of API2
1.d Implement the operation method using methods from the API2 interface
1.e Test the AdapterClass by creating an instance, calling the operation method, and verifying the results.
2.Implement AdapterObject for API2 to use API1 Object 
2.a Implement the API2 interface in the AdapterObject class
2.b Implement the API2 interface in the AdapterObject class
2.c Define private fields to store an instance of API1
2.d Implement the add, sub, mult, and div methods using the operation method of the API1 object
2.f Override the toString method to display the operation and result
3. Implement Facade (FacadePOS) Using AdapterObject to Implement FacadeAPI
3.a Define private fields to store instances of AdapterObject, course expense classes, and degree expense classes
3.b Implement methods in the FacadePOS class that provide simplified interfaces for performing operations
3.c Internally used the AdapterObject to perform operations and return results
3.d Test the FacadePOS by creating an instance, calling its methods, and verifying the results
4. Demonstrate Use of Decorator Design Pattern for Detailed Billing
4.a Create classes for each individual course expense (e.g., CSYE6200, CSYE6202, etc.).
4.b Create classes for each degree's billed expense (e.g., NEUBillForIMSISDegree, NEUBillForIMSSEDegree).
4.c Implement the Command Pattern by creating command classes for each course expense using the Decorator pattern
4.d For each command class, implement methods that add the specific course expense to the bill.
4.e Implement the billed expense classes by extending the command classes and implementing methods to add degree expenses.
4.f Implement Singleton Factories for both Eager and Lazy initialization to create instances of command and billed expense objects
4.g Display the detailed bill by invoking the toString method on the decorated bill object
LEAVE THIS AS END OF DEVELOPMENT LOG STRINGS

	edu.neu.csye7374.FinalComprehensive$AdapterObject.demoAdapterObject()...
[6] + [3] = [9]
[6] + [3] = [9]
[6] - [3] = [3]
[6] - [3] = [3]
[6] * [3] = [18]
[6] * [3] = [18]
[6] / [3] = [2]
[6] / [3] = [2]

	edu.neu.csye7374.FinalComprehensive$AdapterObject.demoAdapterObject()... done!

	edu.neu.csye7374.FinalComprehensive$AdapterClass.demoAdapterClass()...
[6] + [3] = [9]
[6] + [3] = [9]
[6] - [3] = [3]
[6] - [3] = [3]
[6] * [3] = [18]
[6] * [3] = [18]
[6] / [3] = [2]
[6] / [3] = [2]

	edu.neu.csye7374.FinalComprehensive$AdapterClass.demoAdapterClass()... done!

	edu.neu.csye7374.FinalComprehensive$FacadePOS.demoPOSFacade()...
TOTAL: [15]
DOLLARS: [$20]
CHANGE: [$5] 

	edu.neu.csye7374.FinalComprehensive$FacadePOS.demoPOSFacade()... done!

	edu.neu.csye7374.FinalComprehensive$DemoDecoratorPattern.demo()...
Decorated Bill for Sam's MSIS degree:

Degree Base Price: 24000.0
CSYE6200 Bill Price: 1000.0
CSYE6202 Bill Price: 1200.0
Total Calculated Bill: 26200.0
Total Bill: $26200.0
******************
Decorated Bill for Joe's MSIS degree:

Degree Base Price: 24000.0
CSYE6200 Bill Price: 1000.0
CSYE6202 Bill Price: 1200.0
CSYE6205 Bill Price: 1500.0
Total Calculated Bill: 27700.0
Total Bill: $27700.0
******************
Decorated Bill for Dan's MSSE degree:

Degree Base Price: 40000.0
CSYE6205 Bill Price: 1500.0
CSYE7374 Bill Price: 2000.0
Total Calculated Bill: 43500.0
Total Bill: $43500.0
******************
Decorated Bill for Jim's MSSE degree:

Degree Base Price: 40000.0
CSYE6200 Bill Price: 1000.0
CSYE6202 Bill Price: 1200.0
CSYE6205 Bill Price: 1500.0
CSYE7374 Bill Price: 2000.0
Total Calculated Bill: 45700.0
Total Bill: $45700.0

	edu.neu.csye7374.FinalComprehensive$DemoDecoratorPattern.demo()... done!

	edu.neu.csye7374.FinalComprehensive.demo() revision [3.27] ... done!


============Main Execution End===================




**********************/