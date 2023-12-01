package edu.neu.csye7374;



//EmployeeAPI interface extending PersonAPI
public interface EmployeeAPI extends PersonAPI {
double getWage();
void setWage(double wage);
String getJob();
void setJob(String job);
}

