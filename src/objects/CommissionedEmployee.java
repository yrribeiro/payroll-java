package objects;

public class CommissionedEmployee extends WageEmployee{
    private double ratePerSale;

    public void setRatePerSale(double ratePerSale) {
        this.ratePerSale = ratePerSale;
    }

    public double getMonthlyIncome() {
        return ratePerSale;
    }

    @Override
    public void setPaymentSchedule(String paymentSchedule) {
        super.setPaymentSchedule(paymentSchedule);
    }

}
