package utils;
import java.util.ArrayList;
import java.util.Scanner;

import objects.CommissionedEmployee;
import objects.Employee;
import objects.HourlyEmployee;
import objects.Unionist;
import objects.WageEmployee;

public class AddEmployee{
    Scanner scanf = new Scanner(System.in);

    public Employee newEmployee(int uniqueID, ArrayList<String> availableSchedules){
        System.out.println("~~ New employee ID: " + uniqueID);

        System.out.println("~~ Name: ");
        String name = scanf.nextLine();

        System.out.println("~~ Address: ");
        String address = scanf.nextLine();

        System.out.println("~~ Payment method:\n  0 for Mail\n  1 for At Hands\n  2 for Bank");
        int paymentType = scanf.nextInt();
        scanf.nextLine();

        System.out.println("~~ Job type:\n  0 for Hourly-paid\n  1 for Fixed wage\n  2 for Commissioned");
        int jobType = scanf.nextInt();
        Employee employee = new Employee();
        if (jobType == 0){
            employee = addHourly(uniqueID, name, address, paymentType, availableSchedules.get(jobType));
        }else if (jobType == 1){
            employee = addWage(uniqueID, name, address, paymentType, availableSchedules.get(jobType));
        }else if (jobType == 2){
            employee = addCommissioned(uniqueID, name, address, paymentType, availableSchedules.get(jobType));
        }
        scanf.nextLine();

        System.out.println("~~ Is an union member [y/n]");
        String userInput = scanf.next();
        employee.setUnionist(userInput.contentEquals("y"));

        return employee;
    }

    public Employee addHourly(int uniqueID, String name, String address, int paymentType, String defaultHourlyEmployeeSchedule){
        HourlyEmployee newEmployee = new HourlyEmployee();
        newEmployee.setUniqueID(uniqueID);
        newEmployee.setName(name);
        newEmployee.setAddress(address);
        newEmployee.setPaymentType(paymentType);
        newEmployee.setJobType(0);
        newEmployee.setPaymentSchedule(defaultHourlyEmployeeSchedule);

        System.out.println("~~ Type the hourly income [XX,XX]:");
        newEmployee.setHourlyIncome(scanf.nextDouble());

        return newEmployee;
    }

    public Employee addWage(int uniqueID, String name, String address, int paymentType, String defaultWageEmployeeSchedule){
        WageEmployee newEmployee = new WageEmployee();
        newEmployee.setUniqueID(uniqueID);
        newEmployee.setName(name);
        newEmployee.setAddress(address);
        newEmployee.setPaymentType(paymentType);
        newEmployee.setJobType(1);
        newEmployee.setPaymentSchedule(defaultWageEmployeeSchedule);

        System.out.println("~~ Type the monthly income [XXXX,XX]:");
        newEmployee.setMonthlyIncome(scanf.nextDouble());

        return newEmployee;
    }

    public Employee addCommissioned(int uniqueID, String name, String address, int paymentType, String defaultCommEmployeeSchedule){
        CommissionedEmployee newEmployee = new CommissionedEmployee();
        newEmployee.setUniqueID(uniqueID);
        newEmployee.setName(name);
        newEmployee.setAddress(address);
        newEmployee.setPaymentType(paymentType);
        newEmployee.setJobType(2);
        newEmployee.setPaymentSchedule(defaultCommEmployeeSchedule);

        System.out.println("~~ Type the monthly income [XXXX,XX]:");
        newEmployee.setMonthlyIncome(scanf.nextDouble());

        System.out.println("~~ Type the commission rate per sale [XX,XX]:");
        newEmployee.setRatePerSale(scanf.nextDouble());
        newEmployee.setTotalCommissions(0);

        return newEmployee;
    }

    public Unionist addUnionist(String name, int ID){
        Unionist newUnionist = new Unionist();
        newUnionist.setUnionID(Unionist.calculateUnionID(name, ID));
        newUnionist.setName(name);
        newUnionist.setUniqueID(ID);

        System.out.println("~~ Type the union fee [XXXX,XX]:");
        newUnionist.setUnionFee(scanf.nextDouble());
        return newUnionist;
    }
}
