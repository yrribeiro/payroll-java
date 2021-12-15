package objects;

public class Employee{
    int uniqueID;
    private String name;
    private String address;
    private int jobType;
    private int paymentType;
    private Boolean unionist;
    private String paymentSchedule;
    private int workedDays;

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public int getJobType() {
        return jobType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setUnionist(Boolean unionist) {
        this.unionist = unionist;
    }

    public Boolean getUnionist() {
        return unionist;
    }

    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public String getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setWorkedDays() {
        this.workedDays += 1;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void eraseWorkedDays(){
        this.workedDays = 0;
    }
}
