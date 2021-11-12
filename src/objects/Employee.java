package objects;

public class Employee{
    private String name;
    private String address;
    private int jobType;
    private int paymentType;
    private Boolean syndicalist;
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

    public void setSyndicalist(Boolean syndicalist) {
        this.syndicalist = syndicalist;
    }

    public Boolean getSyndicalist() {
        return syndicalist;
    }
}
