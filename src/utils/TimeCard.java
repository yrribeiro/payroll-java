package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Employee;
import objects.HourlyEmployee;

public class TimeCard {
    Scanner scanf = new Scanner(System.in);

    public boolean addTimeCard(ArrayList<Employee> employeeList){
        int foundEmployeeIndex = FindEmployee.findEmployee(employeeList);

        if (foundEmployeeIndex < 0 || employeeList.get(foundEmployeeIndex).getJobType() != 0){
            System.out.println("\n\n{!} There's no hourly employee registered under this ID.\n");
        }else{
            HourlyEmployee foundEmployee = (HourlyEmployee) employeeList.get(foundEmployeeIndex);

            System.out.printf("|~ Insert the entry time [dd-MM-yyyy HH:mm]: ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime entryTime = LocalDateTime.parse(scanf.nextLine(), formatter);

            System.out.printf("|~ Insert the departure time [dd-MM-yyyy HH:mm]: ");
            LocalDateTime departureTime = LocalDateTime.parse(scanf.nextLine(), formatter);

            String diffString = Duration.between(entryTime, departureTime).toString();
            double diffDouble = Duration.parse(diffString).toMinutes()/60.0;
            foundEmployee.setWorkedDays();
            foundEmployee.setWorkedHours(diffDouble);

            System.out.println(String.format("\n\n|~ You received from this worked day: $%,.2f", showWorkedDayIncome(foundEmployee, diffDouble)));
            return true;
        }
        return false;
    }

    private double showWorkedDayIncome(HourlyEmployee foundEmployee, double workedHours){
        short maxHours = foundEmployee.getMaxHours();
        double hourlyIncome = foundEmployee.getHourlyIncome();

        if (workedHours > maxHours){
            return maxHours*hourlyIncome + (workedHours-maxHours)*hourlyIncome*1.5;
        }else{
            return foundEmployee.getHourlyIncome()*workedHours;
        }
    }
}
