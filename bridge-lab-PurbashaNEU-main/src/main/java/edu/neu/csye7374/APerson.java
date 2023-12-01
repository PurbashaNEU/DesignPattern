package edu.neu.csye7374;



//APerson class (implements ArticulatePersonAPI)
public class APerson implements ArticulatePersonAPI {
protected PersonAPI implementor = null;

public APerson(PersonAPI implementor) {
   this.implementor = implementor;
}

@Override
public void talk() {
   System.out.println("APerson is talking...");
   System.out.println("Name: " + implementor.getName());
   System.out.println("Age: " + implementor.getAge());
}
}