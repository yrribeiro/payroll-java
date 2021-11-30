package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class CreatePaymentSchedule {
    Scanner scanf = new Scanner(System.in);

    public static void setDefaultSchedule(ArrayList<String> scheduleList){
        String hourlyEmployeeDefault = "semanal 1 sexta";
        String wageEmployeeDefault = "mensal $";
        String commissionedEmployeeDefault = "semanal 2 sexta";
        scheduleList.add(0, hourlyEmployeeDefault);
        scheduleList.add(1, wageEmployeeDefault);
        scheduleList.add(2, commissionedEmployeeDefault);
    }

    public void newPaymentSchedule(ArrayList<String> scheduleList){
        int action;

        System.out.printf("%n|~ Select what you want to do: %n 1  Change default options%n 2  Add new option%n 3  List all available options%n> ");
        action = scanf.nextInt();
        scanf.nextLine();

        switch(action){
            case 1:
                changeDefaultSchedule(scheduleList);
                break;
            case 2:
                addNewOptions(scheduleList);
                break;
            case 3:
                listAllOptions(scheduleList);
                break;
            default:
                break;
        }
    }

    private void changeDefaultSchedule(ArrayList<String> scheduleList){
        String input;
        String[] newOption;

        listAllOptions(scheduleList);
        System.out.println("|~ Type the new default schedules [hourly:fixed:commissioned]\n|  If you don't want to change one of them just write the next colon:");
        input = scanf.nextLine();
        newOption = input.split(":", -2);
        for (int i=0; i<3; i++){
            if (!newOption[i].isEmpty()){
                scheduleList.remove(i);
                scheduleList.add(i, newOption[i]);
            }
        }
        listAllOptions(scheduleList);
        System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE.    ~|\n");
    }

    private void addNewOptions(ArrayList<String> scheduleList){
        int totalNewOp;

        System.out.println("|~ How many new options do you want to add? [an integer]");
        totalNewOp = scanf.nextInt();
        scanf.nextLine();
        for (int i=0; i<totalNewOp; i++){
            System.out.printf("%n~~~~~~~   ~~~~~~~\n" + (i+1) + "° option: ");
            scheduleList.add(scanf.nextLine());
        }
        listAllOptions(scheduleList);
        System.out.println("\n\n|~    NEW PAYMENT SCHEDULES ADDED.    ~|\n");
    }

    private void listAllOptions(ArrayList<String> scheduleList){
        System.out.println("\n~~~~~~~   ~~~~~~~");
        for (String option : scheduleList) {
            System.out.println(option);
        }
        System.out.println("~~~~~~~   ~~~~~~~\n\n");
    }
}
