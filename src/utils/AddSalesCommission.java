package utils;

import java.util.ArrayList;
import java.util.Scanner;

import objects.CommissionedEmployee;
import objects.Employee;

public class AddSalesCommission {
    Scanner scanf = new Scanner(System.in);

    public boolean addCommission(ArrayList<Employee> employeeList){
        int foundEmployeeIndex = FindEmployee.findEmployee(employeeList);

        if (foundEmployeeIndex < 0 || employeeList.get(foundEmployeeIndex).getJobType() != 2){
            System.out.println("\n\n{!} There's no commissioned employee registered under this ID.\n");
        }else{
            CommissionedEmployee foundEmployee = (CommissionedEmployee) employeeList.get(foundEmployeeIndex);
            double percentage = foundEmployee.getRatePerSale();
            System.out.printf("|~ Insert the sales total price [XXXX,XX]: $");
            double salesPrice = scanf.nextDouble();
            double commission = salesPrice*percentage;
            foundEmployee.setTotalCommissions(commission);
            System.out.println("\n\n|~ You received from this sale: $" + commission);
            return true;
        }
        return false;
    }
}
