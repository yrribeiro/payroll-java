package utils;

import java.util.LinkedList;
import java.util.Scanner;
import objects.Employee;
import objects.Unionist;

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

    public static Unionist findUnionist(String ID, LinkedList<Unionist> unionistList){
        for (Unionist unionist : unionistList) {
            if (unionist.getUnionID().equals(ID)){
                return unionist;
            }
        }
        return null;
    }

    public void removeEmployee(LinkedList<Employee> employeeList, LinkedList<Unionist> unionistList){
        String confirmation;
        int foundEmployeeIndex;

        foundEmployeeIndex = findEmployee(employeeList);
        if (foundEmployeeIndex < 0){
            System.out.println("{!} Employee not found. Make sure to retype the ID correctly.");
        }else{
            Employee foundEmployee = employeeList.get(foundEmployeeIndex);
            ListAllEmployee.listEmployee(foundEmployee, unionistList);
            System.out.println("| Are you sure you want to delete this employee (including from the union)? [y/n]");
            confirmation = scanf.next();
            if (confirmation.contains("y")){
                Unionist foundUnionist = findUnionist(
                    Unionist.calculateUnionID(foundEmployee.getName(), foundEmployee.getUniqueID()),
                    unionistList
                );
                employeeList.remove(foundEmployeeIndex);
                unionistList.remove(foundUnionist);
                System.out.println("\n\n| ~ REMOVED SUCCESSFULLY. EMPLOYEE LIST UPDATED ~ |\n");
            }else{
                System.out.println("\n\n{!} Action canceled.\n");
            }
        }
    }

    public void updateEmployeeInfo(LinkedList<Employee> employeeList, LinkedList<Unionist> unionistList){
        int action;
        int foundEmployeeIndex;
        Employee foundEmployee = new Employee();


        foundEmployeeIndex = findEmployee(employeeList);
        if (foundEmployeeIndex < 0){
            System.out.println("{!} Employee not found. Make sure to retype the ID correctly.");
        }else{
            System.out.println("\n|~ Changing data of the following employee:");
            foundEmployee = employeeList.get(foundEmployeeIndex);
            ListAllEmployee.listEmployee(foundEmployee, unionistList);
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
                    System.out.println("|~ Type the OLD ID: ");
                    Unionist foundUnionist = findUnionist(scanf.nextLine(), unionistList);
                    if (foundUnionist != null){
                        System.out.println("|~ Type the NEW ID: ");
                        foundUnionist.setUnionID(scanf.nextLine());
                        System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE    ~|\n");
                        break;
                    }else{
                        System.out.println("{!} Unionist not found. Make sure to retype the ID correctly.");
                    }
                    break;
                case 7: // change union fee
                    System.out.println("|~ Type the unionist ID: ");
                    Unionist foundUnionist2 = findUnionist(scanf.nextLine(), unionistList);
                    if (foundUnionist2 != null){
                        System.out.println("|~ Type the new fee: ");
                        foundUnionist2.setUnionFee(scanf.nextDouble());
                        System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE    ~|\n");
                        break;
                    }else{
                        System.out.println("{!} Unionist not found. Make sure to retype the ID correctly.");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
