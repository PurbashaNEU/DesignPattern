package edu.neu.csye7374;

//Employee class (extends Person, implements EmployeeAPI)
public class Employee extends Person implements EmployeeAPI {
private double wage = 65d;
private String job = "cook";

@Override
public double getWage() {
   return wage;
}

@Override
public void setWage(double wage) {
   this.wage = wage;
}

@Override
public String getJob() {
   return job;
}

@Override
public void setJob(String job) {
   this.job = job;
}
}