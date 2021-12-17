package utils;

import java.util.ArrayList;
import java.util.Scanner;

import objects.*;

public class RunPayroll {
    Scanner scanf = new Scanner(System.in);
    private static final int WEEK_DAYS = 2;
    private static final int TOTAL_MONTH_WEEK_DAYS = 2;
    private ArrayList<Employee> employeesToPay = new ArrayList<>();

    public void runPayroll(ArrayList<String> availableSchedules, ArrayList<Employee> employeeList, ArrayList<Unionist> unionistList){
        setWageEmployeesWorkedDay(employeeList);
        System.out.println("\n|~ Employees to be paid today:");
        for (String schedule : availableSchedules) {
            System.out.println("\n~~~ " + schedule + ":");
            int neededWorkedDays = splitScheduleString(schedule);
            employeesToPay.clear();
            Boolean isEmptyArray = generateEmployeesArray(schedule, employeeList, neededWorkedDays);
            if (isEmptyArray){
                System.out.println("{!} No employee under this schedule is ready to be paid.\n\n");
            }else{
                for (Employee employee : employeesToPay) {
                    double earnsSoFar = calculateGrossWage(employee);
                    if (employee.getUnionist()){
                        earnsSoFar = deductFees(employee, earnsSoFar, unionistList);
                    }
                    showEmployee(employee, earnsSoFar);
                    eraseRegister(employee);
                }
            }
        }
    }

    private void setWageEmployeesWorkedDay(ArrayList<Employee> employeeList){
        for (Employee employee : employeeList){
            int jobType = employee.getJobType();
            if (jobType > 0){
                employee.setWorkedDays();
            }
        }
    }

    private int splitScheduleString(String schedule){
        String[] splitted = schedule.split("\\s");
        int neededWorkedDays = 0;
        if (splitted.length>2){
            if (splitted[0].equals("weekly")){
                neededWorkedDays = WEEK_DAYS * Integer.parseInt(splitted[1]);
            }else if (splitted[0].equals("monthly")){
                neededWorkedDays = TOTAL_MONTH_WEEK_DAYS * Integer.parseInt(splitted[1]);
            }
        }else{
            if (splitted[0].equals("monthly")){
                neededWorkedDays = TOTAL_MONTH_WEEK_DAYS;
            }
        }
        return neededWorkedDays;
    }

    private Boolean generateEmployeesArray(String schedule, ArrayList<Employee> employeeList, int neededWorkedDays){
        Boolean flag = true;
        for (Employee employee : employeeList) {
            if (employee.getPaymentSchedule().equals(schedule)){
                if (employee.getWorkedDays() == neededWorkedDays){
                    employeesToPay.add(employee);
                    flag = false;
                }
            }
        }
        return flag;
    }

    private double deductFees(Employee employee, double earnsSoFar, ArrayList<Unionist> unionistList){
            double foundUnionistFee = FindEmployee.findUnionist(
                    Unionist.calculateUnionID(employee.getName(), employee.getUniqueID()),
                    unionistList
            ).getUnionFee();
            return (earnsSoFar - foundUnionistFee);
    }

    private double calculateGrossWage(Employee employee){
        int jobType = employee.getJobType();
        double baseIncome = 0.0;
        switch (jobType) {
            case 0: // hourly
                baseIncome = ((HourlyEmployee) employee).getGrossWage();
                break;
            case 1: // fixed wage
                baseIncome = ((WageEmployee) employee).getMonthlyIncome();
                break;
            case 2: // commissioned
                CommissionedEmployee commEmployee = (CommissionedEmployee) employee;
                baseIncome = commEmployee.getMonthlyIncome() + commEmployee.getTotalCommissions();
                break;
            default:
                break;
        }
        return baseIncome;
    }

    private void showEmployee(Employee employee, double earnsSoFar){
        System.out.println("\n~~~~~~~");
        System.out.printf(String.format("~ ID: " + employee.getUniqueID() + "\n~ $%,.2f", earnsSoFar));
        System.out.println("\n~~~~~~~");
    }

    private void eraseRegister(Employee employee){
        int jobType = employee.getJobType();
        employee.eraseWorkedDays();
        switch (jobType) {
            case 0: // hourly
                ((HourlyEmployee) employee).eraseWorkedHours();
                ((HourlyEmployee) employee).eraseGrossWage();
                break;
            case 2: // commissioned
                ((CommissionedEmployee) employee).eraseTotalCommissions();
                break;
            default:
                break;
        }
    }
}
