package objects;

public class CommissionedEmployee extends Employee{
    private double ratePerSale;

    public void setRatePerSale(double ratePerSale) {
        this.ratePerSale = ratePerSale;
    }

    public double getMonthlyIncome() {
        return ratePerSale;
    }
}
