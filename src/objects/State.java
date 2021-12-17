package objects;

import java.util.ArrayList;

public class State{
    ArrayList<Employee> employeeList;
    ArrayList<Unionist> unionistList;
    ArrayList<String> availableSchedules;

    public State(ArrayList<Employee> employeeList, ArrayList<Unionist> unionistList, ArrayList<String> availableSchedules){
        this.employeeList = employeeList;
        this.unionistList = unionistList;
        this.availableSchedules = availableSchedules;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList){
        this.employeeList = employeeList;
    }

    public void setUnionistList(ArrayList<Unionist> unionistList){
        this.unionistList = unionistList;
    }

    public void setScheduleList(ArrayList<String> availableSchedules){
        this.availableSchedules = availableSchedules;
    }

    public ArrayList<Employee> getEmployeeList(){
        return employeeList;
    }

    public ArrayList<Unionist> getUnionistList(){
        return unionistList;
    }

    public ArrayList<String> getScheduleList(){
        return availableSchedules;
    }
}
