# Payroll system
:point_right: proglang: JAVA (openjdk 11.0.13)

## Summary
This system aims to ease the management of a company's employee payments. In addition, this system must manage employee data, such as timecards. Employees must receive their salary at the correct time, using the method they prefer, obeying rates and taxes deducted from the salary.

## Available functionalities and descriptions
| ID |             Functionality              |     Description               |
| -------- | -------------------------------| :---:|
|     1    |  Add new employee               | A new employee is added to the system. The following attributes are provided: name, address, job type (hourly, salaried, commissioned) and the associated attributes (hourly wage, monthly wage, commission per sale). A unique employee number is chosen automatically by the system. |
|     2    |  Remove an employee            | An employee is removed from the system. |
|     3    |  Post a time card               | The system will note the time card information, entry and exit times, and associate it with the correct employee.  |
|     4    |  Post a sales commission              | The system notes the information about the sales result and associates it with the correct employee. |
|     5    |  Post a union service fee            | The system will note the union service fee information and associate it with the correct employee.  |
|     6    |  Change employee info       | The following attributes of an employee can be changed: name, address, job type (hourly, salaried, commisioned payment method, whether he belongs to the union or not, identification in the union, union taxes  |
|     7    |  Run today's payroll           | The system finds all employees who must be paid on the day, calculates the wage amount and arranges for the payment according to the method chosen by the employee.  |
|     8    |  Undo/Redo                     | Any transaction associated with features 1 to 7 must be undone (undo) or redone (redo).  |
|     9    |  Choose payment schedule              | Employees can select the pay schedule they want. |
|    10    |  New payment schedule | Each employee is paid according to a payment schedule. The administrator can set default schedules and/or add new ones. |
|    11    |  Show all employees | Shows all employees who have been registered so far |
|    12    |  Show all unionists | Shows all the employees, who are part of the union, registered so far |
|    13    |  Exit system | Invokes an unicorn |

## Motivation and futher details
This project was a request for COMP372 - Projeto de Software (Software Project), one of the compulsory academic subjects in the Computer Science bachelor's. It was given the choice of doing it in Python, but since I had no experience with Java and a reasonable background with Python, the first proglang was a smarter choice.

:heavy_exclamation_mark: There's another branch called "refactoring" in which you can find improvements of the current system :heavy_exclamation_mark:

For further details see [the original document (PT-BR)](https://drive.google.com/file/d/1dYvDUATETdUz5uoEeJu2VTR8d5zrCSDA/view?usp=sharing) by which I based my system.