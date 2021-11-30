package objects;

import java.util.Scanner;

public class HourlyEmployee extends Employee{
    Scanner scanf = new Scanner(System.in);
    private double hourlyIncome;
    // ArrayList<TimeCard> dailyWorkedHours = new ArrayList<>();

    public void setHourlyIncome(double hourlyIncome) {
        this.hourlyIncome = hourlyIncome;
    }

    public double getHourlyIncome() {
        return hourlyIncome;
    }

    @Override
    public void setPaymentSchedule(String paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }
}
