# Auto-Decorator Design Pattern
> Northeastern University, College of Engineering


## Purbasha Pan


### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.


### Overview
Designed a simple Auto Ordering system so a User can configure their auto for purchase with their choice of following options:
AC: Air Conditioning
AWD: All Wheel Drive
ABS: Anti-lock Braking system
BB: Bumper to Bumper warrantee
BDM: Blind-side Detection Monitor

Designed an AutoAPI 
–getPrice()
–getDescription()

Designed an Auto subclass which implements the AutoAPI:
–SportyCoupeAuto 

The object created from SportyCoupeAuto is my original object to be modified by my decorators
The program shows user configured auto
Price (with all user options) in dollars
Sum cost of all selected user options
Description as configured with all user options

Concatenated description of all user options
