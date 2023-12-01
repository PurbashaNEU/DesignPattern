package edu.neu.csye7374;

//BPerson class (extends APerson, implements AmbulatePersonAPI)
public class BPerson extends APerson implements AmbulatePersonAPI {
public BPerson(PersonAPI implementor) {
   super(implementor);
}

@Override
public void walk() {
   System.out.println("BPerson is walking...");
}

@Override
public void run() {
   System.out.println("BPerson is running...");
}

@Override
public void jump() {
   System.out.println("BPerson is jumping...");
}
}