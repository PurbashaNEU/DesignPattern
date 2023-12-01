# Facade Design Pattern
> Northeastern University, College of Engineering


## Purbasha Pan

### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.

### Overview 
Used Java code to read and write files,

Used the Facade Pattern to Implement a simple API for saving program data to file (SSD or disk) which can be loaded at any later time using the following high level API for Facade:
void save(List<String> programData);
List<String> programDataLoad();

Above Facade API can be used with a Roster (list of registered students) application to save all registered students so a subsequent invocation does not have to re-register each student.
