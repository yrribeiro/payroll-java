# Payroll system
:wrench: THIS IS A REFACTORING-FOCUSED BRANCH :wrench:

To observe my progress during this project, the table below keep track of the detected code smells and their proposed solution. In addition, there's a short text describing the behavioral design pattern used on this project.

**Mind the hyperlink at 'Issue Number' column**, each one of them leads to the respective code smell issue, I explain there where and what have I fixed (or tried to).

## Detected code smells
| ID |             Code smell              |        Location        | Progress| Issue Number |
| -------- | -------------------------------| :---:|:---:|:---:|
|     1    |  Negative conditional              | CreatePayment | :heavy_check_mark: |[#12](https://github.com/yrribeiro/payroll-java/issues/12)|
|     2    |  Duplication               | TimeCard | :heavy_check_mark:|[#14](https://github.com/yrribeiro/payroll-java/issues/14)|
|     3    |  Logic conditional not encapsulated               | FindEmployee | :heavy_check_mark: |[#13](https://github.com/yrribeiro/payroll-java/issues/13)|
|     4    |  Long import               | AddEmployee |:heavy_check_mark: |[#15](https://github.com/yrribeiro/payroll-java/issues/15)|

## Behavioral design pattern: Template Method
This pattern defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure. 

The Abstract Class declares methods that act as steps of an algorithm, as well as the actual template method which calls these methods in a specific order. The steps may either be declared abstract or have some default implementation. In this project, the class Employee acts as an Abstract Method with default implementations.

Concrete Classes can override all of the steps, but not the template method itself. All classes inheriting from Employee class (CommissionedEmployee, WageEmployee, HourlyEmployee) overrides the method responsible for setting the schedule payment.
