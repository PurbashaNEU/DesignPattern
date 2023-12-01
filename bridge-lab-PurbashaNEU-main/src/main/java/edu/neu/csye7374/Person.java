package edu.neu.csye7374;


//Person class (implements PersonAPI)
public class Person implements PersonAPI {
private int age = 47;

@Override
public int getAge() {
   return age;
}

@Override
public void setAge(int age) {
   this.age = age;
}

@Override
public String getName() {
   return "Michael Kirk";
}


//public void setAddress(Address address) {
   //this.address = address;
//}
}