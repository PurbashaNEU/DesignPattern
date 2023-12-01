package edu.neu.csye7374;


//Class adapter implementing Animal interface by extending ElectronicDog
public class ElectronicAnimalClassAdapter extends ElectronicDog implements Animal {
	public void move() {
        System.out.println("Electronic Dog class adapter");
         performAction();// Call the inherited performAction() method
   }
}
