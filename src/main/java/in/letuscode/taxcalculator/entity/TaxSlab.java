package in.letuscode.taxcalculator.entity;

public class TaxSlab {
    private final double lowerLimit;
    private final double upperLimit;
    private final double taxRate;

    public TaxSlab(double lowerLimit, double upperLimit, double taxRate) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.taxRate = taxRate;
    }

    public double calculateTax(double income) {
        if (income > upperLimit) {
            return (upperLimit - lowerLimit) * taxRate;
        } else if (income > lowerLimit) {
            return (income - lowerLimit) * taxRate;
        }
        return 0;
    }

    public boolean isApplicable(double income) {
        return income > lowerLimit;
    }

    // Getters
    public double getLowerLimit() { return lowerLimit; }
    public double getUpperLimit() { return upperLimit; }
    public double getTaxRate() { return taxRate; }

}
