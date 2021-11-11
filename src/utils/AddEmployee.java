package utils;
import java.util.Scanner;
import objects.Employee;

public class AddEmployee{
    Scanner scanf = new Scanner(System.in);

    public Employee newEmployee(){
        Employee employee = new Employee();
        System.out.println("~~ Employee ID (6 first digits of your CPF):");
        employee.setCpf(scanf.nextInt());

        System.out.println("~~ Name:");
        employee.setName(scanf.nextLine());

        System.out.println("~~ Address:");
        employee.setAddress(scanf.nextLine());

        System.out.println("~~ Job type:\n0 for Hourly\n1 for Salaried\n2 for Comissioned");
        employee.setJobType(scanf.nextInt());

        System.out.println("~~ Payment method:\n0 for Mail\n1 for In Hands\n2 for Bank");
        employee.setPaymentType(scanf.nextInt());

        System.out.println("~~ Syndicalist [Y/N]:");
        employee.setSyndicalist(scanf.nextBoolean());
        scanf.close();
        return employee;
    }

}
