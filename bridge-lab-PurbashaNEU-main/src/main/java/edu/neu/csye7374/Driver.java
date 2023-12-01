package edu.neu.csye7374;


/**
 * @author SaiAkhil
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements
      //Phase 1: ArticulatePersonAPI using PersonAPI
   	 System.out.println("\nArticulatePersonAPI using PersonAPI\n");
   	PersonAPI person = new Person();
       APerson aPerson = new APerson(person);
       aPerson.talk();
       System.out.println("\n==================\n");
       
       //Phase 2: AmbulatePersonAPI using PersonAPI
       System.out.println("\nAmbulatePersonAPI using PersonAPI\n ");
       PersonAPI person1 = new Person();
       BPerson bPerson = new BPerson(person1);
       bPerson.talk();
       bPerson.walk();
       bPerson.run();
       bPerson.jump();
     
       System.out.println("\n==================\n");
       
       //Phase 3: AmbulatePersonAPI using EmployeeAPI
       System.out.println("\nAmbulatePersonAPI using EmployeeAPI\n ");
       EmployeeAPI employee = new Employee();
       CPerson cPerson = new CPerson(employee);
       cPerson.talk();
       cPerson.walk();
       cPerson.run();
       cPerson.jump();
       System.out.println("Wage: " + employee.getWage());
       System.out.println("Job: " + employee.getJob());
       System.out.println("\n==================\n");
       
       //Address builder
       System.out.println("\nAddress Builder implementation\n ");
       Address address = new Address.Builder()
               .setStreet("12 Concord St")
               .setCity("Philadelphia")
               .setState("Pennsylvania")
               .setZipCode("10971")
               .build();
           
           System.out.println("Street: " + address.getStreet());
           System.out.println("City: " + address.getCity());
           System.out.println("State: " + address.getState());
           System.out.println("Zip Code: " + address.getZipCode());
           System.out.println("\n==================\n");

        System.out.println("\n\n============Main Execution End===================");
    }
}
