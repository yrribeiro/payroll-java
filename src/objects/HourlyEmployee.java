package objects;

import java.util.Scanner;

public class HourlyEmployee extends Employee{
    Scanner scanf = new Scanner(System.in);
    private double hourlyIncome;
    private double workedHours;
    private int workedDays;
    private short maxHours = 8;
    private int idealWorkedHours = maxHours*workedDays;

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

    public void setWorkedDays() {
        this.workedDays += 1;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public int getIdealWorkedHours() {
        return idealWorkedHours;
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
