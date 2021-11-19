package objects;

public class Employee{
    private String name;
    private String address;
    private int jobType;
    private int paymentType;
    private Boolean unionist;
    int uniqueID;

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
}
