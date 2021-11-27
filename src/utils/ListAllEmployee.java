package utils;
import java.util.LinkedList;

import objects.Employee;
import objects.Unionist;

public class ListAllEmployee{
    public static void listEmployee(Employee foundEmployee, LinkedList<Unionist> unionistList){
        System.out.println("\n~~~~~~~   ~~~~~~~");
        System.out.println("~ employee ID: " + foundEmployee.getUniqueID() + "\n~ name: " + foundEmployee.getName() + "\n~ address: " + foundEmployee.getAddress());
        int jobType = foundEmployee.getJobType();
        if (jobType == 0){
            System.out.println("~ job type: Hourly");
        }else if (jobType == 1){
            System.out.println("~ job type: Salaried");
        }else{
            System.out.println("~ job type: Comissioned");
        }

        int paymentType = foundEmployee.getPaymentType();
        if (paymentType == 0){
            System.out.println("~ payment method: Mail");
        }else if (paymentType == 1){
            System.out.println("~ payment method: At Hands");
        }else{
            System.out.println("~ payment method: Bank deposit");
        }

        System.out.println("~ is unionist: " + foundEmployee.getUnionist());
        System.out.println("~~~~~~~   ~~~~~~~");
    }

    public static void listUnionist(Unionist foundEmployee){
        System.out.println("\n~~~~~~~   ~~~~~~~");
        System.out.println("~ employee general ID: " + foundEmployee.getUniqueID() + "\n~ union ID: " + foundEmployee.getUnionID());
        System.out.println("~ name: " + foundEmployee.getName() + "\n~ current fee: $" + foundEmployee.getUnionFee());
        System.out.println("~~~~~~~   ~~~~~~~");
    }
}