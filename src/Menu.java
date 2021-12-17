import java.util.Scanner;
import java.util.Stack;

import objects.*;

import java.util.ArrayList;

import utils.*;
import static utils.ListAllEmployee.*;
import static utils.CreatePaymentSchedule.setDefaultSchedule;

public class Menu{
    public void init(){
        Scanner scanf = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();
        ArrayList<Unionist> unionistList = new ArrayList<>();
        ArrayList<String> availableSchedules = new ArrayList<>();
        Stack<State> states = new Stack<>();

        setDefaultSchedule(availableSchedules);
        State database = new State(employeeList, unionistList, availableSchedules);
        states.add(database);

        int uniqueID = 0;

        while(true){
            System.out.printf("~~~             ~~~ %n~ Choose an option ~ %n~~~             ~~~ %n");
            System.out.printf("1   Add new employee %n2   Remove an employee");
            System.out.printf("%n3   Post a time card %n4   Post a sales commission");
            System.out.printf("%n5   Post a union service fee %n6   Change employee info");
            System.out.printf("%n7   Run today's payroll %n8   Undo/redo");
            System.out.printf("%n9   Choose payment schedule %n10  New payment schedule");
            System.out.printf("%n11  Show all employees%n12  Show all unionists%n13  EXIT %n> ");
            int userInput = scanf.nextInt();

            switch(userInput){
                case 1: // add employee
                    AddEmployee addEmployee = new AddEmployee();
                    uniqueID++;
                    Employee employeeToBeAdded = addEmployee.newEmployee(uniqueID, availableSchedules);
                    employeeList.add(employeeToBeAdded);
                    database.setEmployeeList(employeeList);
                    if (employeeToBeAdded.getUnionist().booleanValue()){
                        Unionist newUnionist = addEmployee.addUnionist(employeeToBeAdded.getName(), uniqueID);
                        unionistList.add(newUnionist);
                        database.setUnionistList(unionistList);
                        System.out.println("\n\n|~ union ID: " + newUnionist.getUnionID());
                    }
                    states.add(database);

                    System.out.println("\n\n| ~ EMPLOYEE ADDED ~ |\n");
                    break;
                case 2: // remove employee
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        FindEmployee rmEmployee = new FindEmployee();
                        Boolean flag = rmEmployee.removeEmployee(employeeList, unionistList);
                        database.setEmployeeList(employeeList);
                        if(flag)
                            database.setUnionistList(unionistList);
                        states.add(database);

                    }
                    break;
                case 3: // post time card
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        TimeCard card = new TimeCard();
                        boolean flag = card.addTimeCard(employeeList);
                        if (flag){
                            database.setEmployeeList(employeeList);
                            states.add(database);

                            System.out.println("\n\n| ~ NEW TIME CARD ADDED ~ |\n");
                        }
                    }
                    break;
                case 4: // sales commission
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        AddSalesCommission add = new AddSalesCommission();
                        boolean flag = add.addCommission(employeeList);
                        if (flag){
                            database.setEmployeeList(employeeList);
                            states.add(database);

                            System.out.println("\n\n| ~ SALES COMMISSION ADDED ~ |\n");
                        }
                    }
                    break;
                case 5: // syndicate service fee
                    AddUnionServiceFee addFee = new AddUnionServiceFee();
                    addFee.addServiceFee(unionistList);
                    database.setUnionistList(unionistList);
                    states.add(database);

                    System.out.println("\n\n| ~ TAX ADDED ~ |\n");
                    break;
                case 6: // change employee info
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        FindEmployee updateEmployee = new FindEmployee();
                        updateEmployee.updateEmployeeInfo(employeeList, unionistList);
                        database.setEmployeeList(employeeList);
                        database.setUnionistList(unionistList);
                        states.add(database);

                        System.out.println("\n\n|~    UPDATE SUCESSFULLY DONE    ~|\n");
                    }
                    break;
                case 7: // todays payroll
                    RunPayroll todayPayroll = new RunPayroll();
                    todayPayroll.runPayroll(availableSchedules, employeeList, unionistList);
                    database.setEmployeeList(employeeList);
                    database.setUnionistList(unionistList);
                    states.add(database);

                    break;
                case 8: // undo redo
                    UndoRedo undoManager = new UndoRedo();
                    State newState = undoManager.displayMenu(states);
                    if (newState != null){
                        employeeList = newState.getEmployeeList();
                        unionistList = newState.getUnionistList();
                        availableSchedules = newState.getScheduleList();
                    }
                    break;
                case 9: // choose payment schedule
                    CreatePaymentSchedule chooser = new CreatePaymentSchedule();
                    boolean flag = chooser.choosePaymentSchedule(availableSchedules, employeeList);
                    if (flag){
                        database.setEmployeeList(employeeList);
                        states.add(database);
                        System.out.println("\n\n| ~ PAYMENT CHOICE UPDATED ~ |\n");
                    }
                    break;
                case 10: // new payment schedule
                    CreatePaymentSchedule creator = new CreatePaymentSchedule();
                    creator.newPaymentSchedule(availableSchedules);
                    database.setScheduleList(availableSchedules);
                    states.add(database);
                    break;
                case 11: // show all employees
                    if (employeeList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        System.out.println("\n\n| " + employeeList.size() + " employee(s) registered. |");
                        for (Object employees : employeeList) {
                            listEmployee((Employee)employees);
                        }
                    }
                    break;
                case 12: // show all unionists
                    if (unionistList.isEmpty()){
                        System.out.println("\n\n{!} Empty database.\n");
                    }else{
                        System.out.println("\n\n| " + unionistList.size() + " unionist(s) registered. |");
                        for (Unionist unionist : unionistList) {
                            listUnionist(unionist);
                        }
                    }
                    break;
                case 13: // exit
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
