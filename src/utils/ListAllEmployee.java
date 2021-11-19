package utils;
import objects.Employee;

public class ListAllEmployee{
    public static void listEmployee(Employee employee){
        System.out.println("\n~~~~~~~   ~~~~~~~");
        System.out.println("~ employee ID: " + employee.getUniqueID() + "\n~ name: " + employee.getName() + "\n~ address: " + employee.getAddress());
        int jobType = employee.getJobType();
        if (jobType == 0){
            System.out.println("~ job type: Hourly");
        }else if (jobType == 1){
            System.out.println("~ job type: Salaried");
        }else{
            System.out.println("~ job type: Comissioned");
        }

        int paymentType = employee.getPaymentType();
        if (paymentType == 0){
            System.out.println("~ payment method: Mail");
        }else if (paymentType == 1){
            System.out.println("~ payment method: At Hands");
        }else{
            System.out.println("~ payment method: Bank deposit");
        }

        System.out.println("~ is unionist: " + employee.getUnionist() + "\n~~~~~~~   ~~~~~~~\n");
    }
}
