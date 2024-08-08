package in.letuscode.taxcalculator.entity;

public class Section80CDeduction implements Deduction {
    @Override
    public double apply(double income) {
        return Math.min(150000, income * 0.1);  // Assume 10% of income up to 1.5 lakhs
    }
}
