package objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HourlyEmployee extends Employee{
    Scanner scanf = new Scanner(System.in);
    private double hourlyIncome;

    public void setHourlyIncome(double hourlyIncome) {
        this.hourlyIncome = hourlyIncome;
    }

    public double getHourlyIncome() {
        return hourlyIncome;
    }

    protected void newTimeCard(){
        String inputEntryTime, inputDepartureTime;
        LocalDateTime entryTime, departureTime;
        System.out.println("~~ Type the entry time [dd-MM-yyyy HH:mm]: ");
        inputEntryTime = scanf.nextLine();
        System.out.println(formatDateInput(inputEntryTime));

        
    }

    private LocalDateTime formatDateInput(String userInput){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(userInput, formatter);
        return date;
    }

}
