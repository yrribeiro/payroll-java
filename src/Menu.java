import java.util.Scanner;

import objects.*;

import java.util.LinkedList;

import utils.*;
import static utils.ListAllEmployee.listEmployee;

public class Menu{
    public void init(){
        Scanner scanf = new Scanner(System.in);
        LinkedList<Employee> employeeList = new LinkedList<>();
        LinkedList<Unionist> unionistList = new LinkedList<>();
        int uniqueID = 0;

        while(true){
            System.out.printf("~~~             ~~~ %n~ Choose an option ~ %n~~~             ~~~ %n");
            System.out.printf("1   Add new employee %n2   Remove an employee");
            System.out.printf("%n3   Post a time card %n4   Post a commission sales result");
            System.out.printf("%n5   Post a union service fee %n6   Change employee info");
            System.out.printf("%n7   Run today's payroll %n8   Undo/redo");
            System.out.printf("%n9   Payment schedule %n10  New payment schedule");
            System.out.printf("%n11  Show all employees%n12  EXIT %n> ");
            int userInput = scanf.nextInt();

            switch(userInput){
                case 1: // add employee
                    AddEmployee addEmployee = new AddEmployee();
                    uniqueID++;
                    Employee employeeToBeAdded = addEmployee.newEmployee(uniqueID);
                    employeeList.add(employeeToBeAdded);
                    if (employeeToBeAdded.getUnionist().booleanValue()){
                        unionistList.add(addEmployee.addUnionist(employeeToBeAdded.getName(), uniqueID));
                    }
                    System.out.println("\n\n| ~ EMPLOYEE ADDED ~ |\n");
                    break;
                case 2: // remove employee
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        FindEmployee rmEmployee = new FindEmployee();
                        rmEmployee.removeEmployee(employeeList);
                    }
                    break;
                case 3: // post time card
                    break;
                case 4: // comission sales
                    break;
                case 5: // syndicate service fee
                    break;
                case 6: // change employee info
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        FindEmployee updateEmployee = new FindEmployee();
                        updateEmployee.updateEmployeeInfo(employeeList);
                    }
                    break;
                case 7: // todays payroll
                    break;
                case 8: // undo redo
                    break;
                case 9: // payment schedule
                    break;
                case 10: // new payment schedule
                    break;
                case 11: // show all employees
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        System.out.println("\n\n| " + employeeList.size() + " employee(s) registered. |");
                        for (Object employees : employeeList) {
                            listEmployee((Employee)employees, unionistList);
                        }
                    }
                    break;
                case 12: // exit
                    System.out.println("Shutting down system...");
                    scanf.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\n{!} Option not available. Please insert one from listed above.\n");
                    break;
            }
        }
    }
}
