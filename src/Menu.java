import java.util.Scanner;
import java.util.LinkedList;
import objects.Employee;
import utils.AddEmployee;

public class Menu{
    public void init(){
        Scanner scanf = new Scanner(System.in);
        LinkedList<Employee> employee = new LinkedList<>();

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
                employee.add(addEmployee.newEmployee());
                System.out.println("ADICIONADO");
                break;
            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            case 8:

            case 9:

            case 10:

            case 11:

            case 12:
                System.out.println("Shutting down system...");
                scanf.close();
                System.exit(0);
                break;
            default:
                System.out.println("{!} Option not available. Please insert one from listed above.");
        }
    }
}
