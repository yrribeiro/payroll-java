package objects;

public class Unionist extends Employee{
    private double unionFee;
    private String unionID;

    public static String calculateUnionID(String name, int ID){
        return String.format("%d%d", (int) name.charAt(0), ID);
    }

    public void setUnionFee(double unionFee) {
        this.unionFee = unionFee;
    }

    public double getUnionFee() {
        return unionFee;
    }

    public void setUnionID(String unionID) {
        this.unionID = unionID;
    }

    public String getUnionID() {
        return unionID;
    }
}
