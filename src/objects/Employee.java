package objects;

import java.util.Set;

public class Employee{
    private int cpf; // six first digits
    private String name;
    private String address;
    private int jobType;
    private int paymentType;
    private Boolean syndicalist;

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
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
