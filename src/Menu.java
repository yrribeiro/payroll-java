import java.util.Scanner;
import java.util.LinkedList;
import objects.Employee;
import utils.*;
import static utils.ListAllEmployee.listEmployee;

public class Menu{
    public void init(){
        Scanner scanf = new Scanner(System.in);
        LinkedList<Employee> employeeList = new LinkedList<>();
        int uniqueID = 0;

        while(true){
            System.out.printf("~~~             ~~~ %n~ Choose a option ~ %n~~~             ~~~ %n");
            System.out.printf("1   Add new employee %n2   Remove an employee");
            System.out.printf("%n3   Post a time card %n4   Post a commission sales result");
            System.out.printf("%n5   Post a syndicate service fee %n6   Change employee info");
            System.out.printf("%n7   Run today's payroll %n8   Undo/redo");
            System.out.printf("%n9   Payment schedule %n10  New payment schedule");
            System.out.printf("%n11  Show all employees%n12  EXIT %n> ");
            int userInput = scanf.nextInt();

            switch(userInput){
                case 1:
                    AddEmployee addEmployee = new AddEmployee();
                    uniqueID++;
                    employeeList.add(addEmployee.newEmployee(uniqueID));
                    System.out.println("\n\n| ~ EMPLOYEE ADDED ~ |\n");
                    break;
                case 2:
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        FindEmployee rmEmployee = new FindEmployee();
                        rmEmployee.removeEmployee(employeeList);
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        System.out.println("\n\n| " + employeeList.size() + " employee(s) registered. |");
                        for (Employee employees : employeeList) {
                            listEmployee(employees);
                        }
                    }
                    break;
                case 12:
                    System.out.println("Shutting down system...");
                    scanf.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\n{!} Option not available. Please insert one from listed above.\n");
                    break;
            }
        }
    }
}
