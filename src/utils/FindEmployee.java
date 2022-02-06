package utils;

import java.util.ArrayList;
import java.util.Scanner;
import objects.Employee;
import objects.Unionist;

public class FindEmployee {
    static Scanner scanf = new Scanner(System.in);

    public static int findEmployee(ArrayList<Employee> employeeList){
        int employeeID;

        System.out.printf("%n%n|~ Insert the employee's ID: ");
        employeeID = scanf.nextInt();

        for (Employee employee : employeeList){
            if (employee.getUniqueID() == employeeID){
                return employeeList.lastIndexOf(employee);
            }
        }
        return -1;
    }

    public static Unionist findUnionist(String ID, ArrayList<Unionist> unionistList){
        for (Unionist unionist : unionistList) {
            if (unionist.getUnionID().equals(ID)){
                return unionist;
            }
        }
        return null;
    }

    public Boolean removeEmployee(ArrayList<Employee> employeeList, ArrayList<Unionist> unionistList){
        String confirmation;
        int foundEmployeeIndex;
        Boolean flag = false;

        foundEmployeeIndex = findEmployee(employeeList);
        if (foundEmployeeIndex < 0){
            System.out.println("{!} Employee not found. Make sure to retype the ID correctly.");
        }else{
            Employee foundEmployee = employeeList.get(foundEmployeeIndex);
            ListAllEmployee.listEmployee(foundEmployee);
            System.out.println("| Are you sure you want to delete this employee (including from the union)? [y/n]");
            confirmation = scanf.next().toLowerCase();
            if (confirmation.contains("y")){
                employeeList.remove(foundEmployeeIndex);
                flag = true;
                removeUnionist(
                    Unionist.calculateUnionID(foundEmployee.getName(), foundEmployee.getUniqueID()),
                    unionistList
                );
                System.out.println("\n\n| ~ REMOVED SUCCESSFULLY. EMPLOYEE LIST UPDATED ~ |\n");
            }else{
                System.out.println("\n\n{!} Action canceled.\n");
            }
        }
        return flag;
    }

    private void removeUnionist(String ID, ArrayList<Unionist> unionistList){
        Unionist foundUnionist = findUnionist(ID, unionistList);
        unionistList.remove(foundUnionist);
    }

    public void updateEmployeeInfo(ArrayList<Employee> employeeList, ArrayList<Unionist> unionistList){
        int action;
        int foundEmployeeIndex;
        Employee foundEmployee = new Employee();

        foundEmployeeIndex = findEmployee(employeeList);
        if (foundEmployeeIndex < 0){
            System.out.println("{!} Employee not found. Make sure to retype the ID correctly.");
        }else{
            System.out.println("\n|~ Changing data of the following employee:");
            foundEmployee = employeeList.get(foundEmployeeIndex);
            ListAllEmployee.listEmployee(foundEmployee);
            System.out.println("\n|~ Select what you want to change:\n 1  Name\n 2  Address\n 3  Job type\n 4  Payment method\n 5  Union membership");
            System.out.printf(" 6  Union ID%n 7  Union Fee%n> ");
            action = scanf.nextInt();
            scanf.nextLine();

            int foundID = foundEmployee.getUniqueID();
            String foundName = foundEmployee.getName();
            String foundAdress =foundEmployee.getAddress();
            int foundPaymentType = foundEmployee.getPaymentType();
            Boolean foundUnionStatus = foundEmployee.getUnionist();
            String foundPaymentSchedule = foundEmployee.getPaymentSchedule();
            AddEmployee update = new AddEmployee();

            switch (action) {
                case 1: // change name
                    System.out.println("|~ Type the new name: ");
                    foundEmployee.setName(scanf.nextLine());
                    break;
                case 2: // change address
                    System.out.println("|~ Type the new address: ");
                    foundEmployee.setAddress(scanf.nextLine());
                    break;
                case 3: // change job type
                    System.out.println("|~ Type the new job type [0 for Hourly-paid | 1 for Fixed wage | 2 for Commissioned]");
                    int newJobType = scanf.nextInt();
                    if (foundEmployee.getJobType() != newJobType){
                        if (newJobType == 0){
                            employeeList.remove(foundEmployeeIndex);
                            foundEmployee = update.addHourly(
                                foundID,
                                foundName,
                                foundAdress,
                                foundPaymentType,
                                foundPaymentSchedule
                            );
                            foundEmployee.setUnionist(foundUnionStatus);
                            employeeList.add(foundEmployeeIndex, foundEmployee);
                        }else if (newJobType == 1){
                            employeeList.remove(foundEmployeeIndex);
                            foundEmployee = update.addWage(
                                foundID,
                                foundName,
                                foundAdress,
                                foundPaymentType,
                                foundPaymentSchedule
                            );
                            foundEmployee.setUnionist(foundUnionStatus);
                            employeeList.add(foundEmployeeIndex, foundEmployee);
                        }else if (newJobType == 2){
                            foundEmployee = update.addCommissioned(
                                foundID,
                                foundName,
                                foundAdress,
                                foundPaymentType,
                                foundPaymentSchedule
                            );
                            foundEmployee.setUnionist(foundUnionStatus);
                            employeeList.add(foundEmployeeIndex, foundEmployee);
                        }
                    }else{
                        System.out.println("{!} No change needed.");
                    }
                    break;
                case 4: // change payment method
                    System.out.println("|~ Type the new payment method [0 for Mail | 1 for At Hands | 2 for Bank]");
                    foundEmployee.setPaymentType(scanf.nextInt());
                    break;
                case 5: // change union membership status
                    System.out.println("|~ Is an union member [y/n] ");
                    Boolean newStatus = scanf.hasNext("y");
                    if (isRemovingUnionist(foundUnionStatus, newStatus)){
                        removeUnionist(
                            Unionist.calculateUnionID(foundName, foundID),
                            unionistList
                        );
                    }else{
                        unionistList.add(update.addUnionist(foundName, foundID));
                    }
                    foundEmployee.setUnionist(newStatus);
                    break;
                case 6: // change union ID
                    System.out.println("|~ Type the OLD ID: ");
                    Unionist foundUnionist = findUnionist(scanf.nextLine(), unionistList);
                    if (foundUnionist != null){
                        System.out.println("|~ Type the NEW ID: ");
                        foundUnionist.setUnionID(scanf.nextLine());
                        break;
                    }else{
                        System.out.println("{!} Unionist not found. Make sure to retype the ID correctly.");
                    }
                    break;
                case 7: // change union fee
                    System.out.println("|~ Type the unionist ID: ");
                    Unionist foundUnionist2 = findUnionist(scanf.nextLine(), unionistList);
                    if (foundUnionist2 != null){
                        System.out.println("|~ Type the new fee: ");
                        foundUnionist2.setUnionFee(scanf.nextDouble());
                        break;
                    }else{
                        System.out.println("{!} Unionist not found. Make sure to retype the ID correctly.");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private Boolean isRemovingUnionist(Boolean currentState, Boolean newState){
        return currentState && !newState;
    }
}
