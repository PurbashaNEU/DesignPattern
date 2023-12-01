package edu.neu.csye7374;

/**
 * @author SaiAkhil
 */
public class Driver {
    public static void main(String[] args) {
    	System.out.println("============Main Execution Start===================\n");

        System.out.println("**********Used Object Adapter design pattern**********");
        
     // Create an instance of ElectronicDog and store it in an ElectronicDevice reference
        ElectronicDevice ElectronicDog = new ElectronicDog();
        
     // Create an instance of ElectronicAnimalObjectAdapter, passing the electronicDog as the ElectronicDevice    
        ElectronicDevice toy = new ElectronicDog();
		Animal objAnimal = new ElectronicAnimalObjectAdapter(toy);
		
		// Call the move() method, which internally calls the performAction() method of the electronicDog
        objAnimal.move();

        System.out.println("\n**********Used Class Adapter design pattern**********");
        
     // Create an instance of ElectronicAnimalClassAdapter
        Animal classAnimal = new ElectronicAnimalClassAdapter();
     // Call the move() method, which internally calls the performAction() method inherited from ElectronicDog
        classAnimal.move();

        System.out.println("\n============Main Execution End===================\n");
    }
}
