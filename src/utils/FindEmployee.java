package utils;

import java.util.LinkedList;
import java.util.Scanner;
import objects.Employee;

public class FindEmployee {
    Scanner scanf = new Scanner(System.in);

    public int findEmployee(LinkedList<Employee> employeeList){
        int employeeID;

        System.out.println("\n\n|~ Insert the employee's ID: ");
        employeeID = scanf.nextInt();

        for (Employee employee : employeeList){
            if (employee.getUniqueID() == employeeID){
                return employeeList.lastIndexOf(employee);
            }
        }
        return -1;
    }

    public void removeEmployee(LinkedList<Employee> employeeList){
        String confirmation;
        int foundEmployeeIndex;

        foundEmployeeIndex = findEmployee(employeeList);
        if (foundEmployeeIndex < 0){
            System.out.println("{!} Employee not found. Make sure to retype the ID correctly.");
        }else{
            ListAllEmployee.listEmployee(employeeList.get(foundEmployeeIndex));
            System.out.println("| Are you sure you want to delete this employee? [y/n]");
            confirmation = scanf.next();
            if (confirmation.contains("y")){
                employeeList.remove(foundEmployeeIndex);
                System.out.println("\n\n| ~ REMOVED SUCCESSFULLY. EMPLOYEE LIST UPDATED ~ |\n");
            }else{
                System.out.println("\n\n{!} Action canceled.\n");
            }
        }
    }

    public void updateEmployeeInfo(LinkedList<Employee> employeeList){
        int action;
        int foundEmployeeIndex;
        Employee foundEmployee = new Employee();

        foundEmployeeIndex = findEmployee(employeeList);
        if (foundEmployeeIndex < 0){
            System.out.println("{!} Employee not found. Make sure to retype the ID correctly.");
        }else{
            System.out.println("\n|~ Changing data of the following employee:");
            foundEmployee = employeeList.get(foundEmployeeIndex);
            ListAllEmployee.listEmployee(foundEmployee);
            System.out.println("\n|~ Select what you want to change:\n1  Name\n2  Address\n3  Job type\n4  Payment method\n5  Union membership");
            System.out.printf("6  Union ID%n7  Union Fee%n> ");
            action = scanf.nextInt();
            scanf.nextLine();

            switch (action) {
                case 1: // change name
                    System.out.println("|~ Type the new name: ");
                    foundEmployee.setName(scanf.nextLine());
                    System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE    ~|\n");
                    break;
                case 2: // change address
                    System.out.println("|~ Type the new address: ");
                    foundEmployee.setAddress(scanf.nextLine());
                    System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE    ~|\n");
                    break;
                case 3: // change job type
                    System.out.println("|~ Type the new job type [0 for Hourly-paid | 1 for Fixed wage | 2 for Commissioned]");
                    foundEmployee.setJobType(scanf.nextInt());
                    System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE    ~|\n");
                    break;
                case 4: // change payment method
                    System.out.println("|~ Type the new payment method [0 for Mail | 1 for At Hands | 2 for Bank]");
                    foundEmployee.setPaymentType(scanf.nextInt());
                    System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE    ~|\n");
                    break;
                case 5: // change union membership status
                    System.out.println("|~ Is an union member [y/n] ");
                    foundEmployee.setUnionist(scanf.hasNext("y"));
                    System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE    ~|\n");
                    break;
                case 6: // change union ID

                    break;
                case 7: // change union fee

                    break;
                default:
                    break;
            }
        }
    }
}
