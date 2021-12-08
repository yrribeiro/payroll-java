package objects;

public class CommissionedEmployee extends WageEmployee{
    private double ratePerSale;
    private double totalCommissions;

    public void setRatePerSale(double ratePerSale) {
        this.ratePerSale = ratePerSale;
    }

    public double getRatePerSale() {
        return ratePerSale;
    }

    public double getTotalCommissions() {
        return totalCommissions;
    }

    public void setTotalCommissions(double totalCommissions) {
        this.totalCommissions += totalCommissions;
    }

    @Override
    public void setPaymentSchedule(String paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }

}
