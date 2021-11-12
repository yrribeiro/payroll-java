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

        System.out.println("~~ Job type:\n  0 for Hourly\n  1 for Salaried\n  2 for Comissioned");
        employee.setJobType(scanf.nextInt());
        scanf.nextLine();

        System.out.println("~~ Payment method:\n0 for Mail\n1 for In Hands\n2 for Bank");
        employee.setPaymentType(scanf.nextInt());
        scanf.nextLine();

        System.out.println("~~ Syndicalist [Y/N]:");
        String userInput = scanf.next();
        employee.setSyndicalist(userInput.contentEquals("Y"));

        return employee;
    }

}
