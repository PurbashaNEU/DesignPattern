package edu.neu.csye7374;

/**
 * @author SaiAkhil
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        GrubHub.demo();

        System.out.println("\n\n============Main Execution End===================");
    }
}
/* ============Main Execution Start===================



	edu.neu.csye7374.GrubHubdemo()...
GrubHub Development Log 1.0.18
1.0: initial version of class created
2.0: Developed adapter patter
3.0: Developed Builder pattern
3.1: Developed individual and combo builder and composite design pattern
4.0: Developed item classes
4.1: Developed decorators
5.0: Developed item factory
5.1: Developed Strategy pattern for discounts
6.0: Updated Order class
6.1: implemented OrderComponentAPI
6.2: corrected OrderBuilder API
7.0: Updated implementation of Individual Order and ComboOrder builder pattern
8:0: Updated decorator pattern implementation by removing Icecream and individual menu order item classes
9.0: Updated singleton pattern implentations, by adding overriden methods of ItemAPI
10.0: Added implementation pf OrderComponentFactoryAPI by factory design pattern
11.0: Implemented bridge pattern on calculator apis 
12.0: Added demo method to show demo of the implemented patterns and users Dan, Pam, Jim, Jen, Len and Sam
** End of Log Entry List **


	edu.neu.csye7374.GrubHub.testCalculator()...

	edu.neu.csye7374.GrubHub.demoCalculator()...
TESTING Calculator1 (add 4.2,2.1):...
Calculator1{result=6.300000000000001}
TESTING Calculator2 (add,sub,mult,div 4.2,2.1):...
Calculator2{result=6.300000000000001}
Calculator2{result=2.1}
Calculator2{result=8.82}
Calculator2{result=2.0}

	edu.neu.csye7374.GrubHub.demoCalculator()... done!

	edu.neu.csye7374.GrubHub.testCalculator()... done!

	edu.neu.csye7374.GrubHub.testPos()...

	edu.neu.csye7374.GrubHub.demoPos()...
TESTING Pos1 (sumTotal(1.1, 2.2, 3.3):...
Pos1{sum=Sum Total is $6.6, calculator1=Calculator1{result=0.0}, discountStrategy=null}
applying 0% Normal Discount
Pos1{sum=Sum Total is $13.2, calculator1=Calculator1{result=0.0}, discountStrategy=edu.neu.csye7374.GrubHub$NormalDiscount@30f39991}
applying 10% Member Discount
Pos1{sum=Sum Total is $19.8, calculator1=Calculator1{result=0.0}, discountStrategy=edu.neu.csye7374.GrubHub$MemberDiscount@4a574795}
applying 20% Special Discount
Pos1{sum=Sum Total is $26.400000000000002, calculator1=Calculator1{result=0.0}, discountStrategy=edu.neu.csye7374.GrubHub$SpecialDiscount@23fc625e}
applying 20% SuperBowl MarkUp
Pos1{sum=Sum Total is $33.0, calculator1=Calculator1{result=0.0}, discountStrategy=edu.neu.csye7374.GrubHub$SuperBowlDiscount@4f023edb}
TESTING Pos2 (sumTotal(1.1, 2.2, 3.3):...
Pos2{sum=6.6, discountStrategy=null, cash=Cash submitted: $20.0, change=Change received: $13.4, calculator2=Calculator2{result=13.4}}
applying 10% Normal Discount
Pos2{sum=13.2, discountStrategy=edu.neu.csye7374.GrubHub$NormalDiscount@85ede7b, cash=Cash submitted: $20.0, change=Change received: $6.800000000000001, calculator2=Calculator2{result=6.800000000000001}}
applying 10% Member Discount
Pos2{sum=19.8, discountStrategy=edu.neu.csye7374.GrubHub$MemberDiscount@5674cd4d, cash=Cash submitted: $20.0, change=Change received: $0.1999999999999993, calculator2=Calculator2{result=0.1999999999999993}}
applying 20% Special Discount
Pos2{sum=26.400000000000002, discountStrategy=edu.neu.csye7374.GrubHub$SpecialDiscount@63961c42, cash=Cash submitted: $20.0, change=Change received: $-6.400000000000002, calculator2=Calculator2{result=-6.400000000000002}}
applying 20% SuperBowl MarkUp
Pos2{sum=33.0, discountStrategy=edu.neu.csye7374.GrubHub$SuperBowlDiscount@65b54208, cash=Cash submitted: $20.0, change=Change received: $-13.0, calculator2=Calculator2{result=-13.0}}

	edu.neu.csye7374.GrubHub.demoPos()... done!

	edu.neu.csye7374.GrubHub.testPos()... done!

edu.neu.csye7374.GrubHub.demoGrubHub()...
=====================================================
=====================================================
Dan's GrubHub order ID #1
Item: Hamburger, 3.49
Item: Medium Drink, 1.29
Total Amount: $4.78
=====================================================
=====================================================
Pam's GrubHub HotDogCombo order ID #2
Item: Hot Dog, 1.49
Item: French Fries, 0.99
Item: Medium Drink, 1.29
Total Amount: $3.77
=====================================================
=====================================================
Jim's GrubHub BurgerCombo order ID #3
Item: Hamburger, 3.49
Item: French Fries, 0.99
Item: Medium Drink, 1.29
Total Amount: $5.7700000000000005
=====================================================
=====================================================
Jen's GrubHub order ID #4
Item: Cheeseburger, 3.79
Item: French Fries, 0.99
Total Amount: $4.78
=====================================================
=====================================================
Len's GrubHub WingCombo order ID #5
Item: Buffalo Wings, 4.49
Item: Medium Drink, 1.29
Item: Salad, 2.49
Total Amount: $8.27
=====================================================
******** Price before adding cherry ====> 5.49
******** Price after adding cherry ====> 6.49
******** Price before Adding Kitkat ====> 6.49
******** Price After Adding Kitkat ====> 7.49
******** Price before Adding Sprinkles ====> 7.49
******** Price After Adding Sprinkles ====> 8.49
=====================================================
Sam's GrubHub IcecreamCombo order ID #6
Item: Buffalo Wings, 4.49
Item: French Fries, 0.99
Item: Salad, 2.49
Item: Medium Drink, 1.29
edu.neu.csye7374.GrubHub$SprinklesDecorator@723279cf
Total Amount: $17.75
=====================================================
=====================================================

edu.neu.csye7374.GrubHub.demoPos()... done!

	edu.neu.csye7374.GrubHubdemo()... done!


============Main Execution End===================

*/