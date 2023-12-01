package edu.neu.csye7374;

//Object adapter implementing Animal interface by composition with ElectronicDevice
public class ElectronicAnimalObjectAdapter implements Animal{
	private final ElectronicDevice toy;
	ElectronicAnimalObjectAdapter(ElectronicDevice toy){
		this.toy = toy;
	}
	public void move() {
		System.out.println("Electronic dog object adapter");
        toy.performAction();// Delegate the performAction() behavior to the ElectronicDevice object
	}

}

