package utils;
import java.util.LinkedList;

import objects.*;

public class ListAllEmployee{
    public static void listEmployee(Employee foundEmployee, LinkedList<Unionist> unionistList){
        System.out.println("\n~~~~~~~   ~~~~~~~");
        System.out.println("~ employee ID: " + foundEmployee.getUniqueID() + "\n~ name: " + foundEmployee.getName() + "\n~ address: " + foundEmployee.getAddress());
        int jobType = foundEmployee.getJobType();
        if (jobType == 0){
            System.out.println("~ job type: Hourly-paid");
        }else if (jobType == 1){
            System.out.println("~ job type: Fixed wage");
        }else if (jobType == 2){
            System.out.println("~ job type: Commissioned");
        }

        int paymentType = foundEmployee.getPaymentType();
        if (paymentType == 0){
            System.out.println("~ payment method: Mail");
        }else if (paymentType == 1){
            System.out.println("~ payment method: At Hands");
        }else if (paymentType == 2){
            System.out.println("~ payment method: Bank deposit");
        }

        System.out.println("~ is unionist: " + foundEmployee.getUnionist());
        System.out.println("~~~~~~~   ~~~~~~~\n");
    }

    public static void listUnionist(Unionist foundUnionist){
        System.out.println("\n~~~~~~~   ~~~~~~~");
        System.out.println("~ employee general ID: " + foundUnionist.getUniqueID() + "\n~ union ID: " + foundUnionist.getUnionID());
        System.out.println("~ name: " + foundUnionist.getName() + "\n~ current fee: $" + foundUnionist.getUnionFee());
        System.out.println("~~~~~~~   ~~~~~~~\n");
    }
}
