package edu.neu.csye7374;



//CPerson class (extends BPerson, implements AmbulatePersonAPI)
public class CPerson extends BPerson implements AmbulatePersonAPI {
protected EmployeeAPI implementor;

public CPerson(EmployeeAPI implementor) {
   super(implementor);
   this.implementor = implementor;
}
}