package utils;
import java.util.Scanner;
import objects.Employee;

public class AddEmployee{
    Scanner scanf = new Scanner(System.in);

    public Employee newEmployee(int uniqueID){
        Employee employee = new Employee();
        System.out.println("~~ New employee ID: " + uniqueID);
        employee.setUniqueID(uniqueID);

        System.out.println("~~ Name: ");
        employee.setName(scanf.nextLine());

        System.out.println("~~ Address: ");
        employee.setAddress(scanf.nextLine());

        System.out.println("~~ Job type:\n0 for Hourly-paid\n  1 for Fixed wage\n  2 for Commissioned");
        employee.setJobType(scanf.nextInt());
        scanf.nextLine();

        System.out.println("~~ Payment method:\n0 for Mail\n1 for At Hands\n2 for Bank");
        employee.setPaymentType(scanf.nextInt());
        scanf.nextLine();

        System.out.println("~~ Is an union member [y/n]");
        String userInput = scanf.next();
        employee.setUnionist(userInput.contentEquals("y"));

        return employee;
    }

}
