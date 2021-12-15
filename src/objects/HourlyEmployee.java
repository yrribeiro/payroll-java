package objects;

import java.util.Scanner;

public class HourlyEmployee extends Employee{
    Scanner scanf = new Scanner(System.in);
    private double hourlyIncome;
    private double workedHours;
    private short maxHours = 8;
    private double grossWage;

    public void setHourlyIncome(double hourlyIncome) {
        this.hourlyIncome = hourlyIncome;
    }

    public double getHourlyIncome() {
        return hourlyIncome;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours += workedHours;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void eraseWorkedHours(){
        this.workedHours = 0.0;
    }

    public double getGrossWage() {
        return grossWage;
    }

    public void setGrossWage(double grossWage) {
        this.grossWage += grossWage;
    }

    public void eraseGrossWage(){
        this.grossWage = 0.0;
    }

    // public short setMaxHours() {        for future project enhancement
    //     return maxHours;
    // }

    public short getMaxHours() {
        return maxHours;
    }

    @Override
    public void setPaymentSchedule(String paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }
}
