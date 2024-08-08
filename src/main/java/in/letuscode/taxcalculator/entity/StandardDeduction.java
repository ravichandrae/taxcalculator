package in.letuscode.taxcalculator.entity;

public class StandardDeduction implements Deduction{
    @Override
    public double apply(double income) {
        return Math.min(50000, income);
    }
}
