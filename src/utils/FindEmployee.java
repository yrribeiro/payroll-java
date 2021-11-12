package utils;
import java.util.LinkedList;
import java.util.Scanner;
import objects.Employee;

public class FindEmployee{
    Scanner scanf = new Scanner(System.in);

    public Employee findEmployee(int employeeID, LinkedList<Employee> employeeList){
        int sizeOfList = employeeList.size();

        while(true){
            if (employeeID<1 | employeeID>sizeOfList){
                System.out.println("{!} This ID is not been used. Make sure to type it correctly.");
            }else{
                return employeeList.get(employeeID);
            }
        }
    }

    public void removeEmployee(LinkedList<Employee> employeeList){
        int employeeID;
        String confirmation;
        Employee foundEmployee = new Employee();

        System.out.println("\n\n|~ Insert the employee-to-be-removed's ID: ");
        employeeID = scanf.nextInt();
        employeeID -= 1;

        foundEmployee = findEmployee(employeeID, employeeList);
        ListAllEmployee.listEmployee(foundEmployee);
        System.out.println("| Are you sure you want to delete this employee? [Y/N]");
        confirmation = scanf.next();
        if (confirmation.contains("Y")){
            employeeList.remove(employeeID);
            System.out.println("\n\n| ~ REMOVED SUCCESSFULLY. EMPLOYEE LIST UPDATED ~ |\n");
        }else{
            System.out.println("{!} Canceled action.");
        }
    }
}
