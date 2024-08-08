package in.letuscode.taxcalculator.engine;

import in.letuscode.taxcalculator.entity.Deduction;
import in.letuscode.taxcalculator.entity.TaxRegime;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
    private final TaxRegime taxRegime;
    private final List<Deduction> deductions;

    public TaxCalculator(TaxRegime taxRegime) {
        this.taxRegime = taxRegime;
        this.deductions = new ArrayList<>();
    }

    public void addDeduction(Deduction deduction) {
        deductions.add(deduction);
    }

    public double calculateTax(double income) {
        double taxableIncome = applyDeductions(income);
        return taxRegime.calculateTax(taxableIncome);
    }

    private double applyDeductions(double income) {
        for (Deduction deduction : deductions) {
            income -= deduction.apply(income);
        }
        return income;
    }
}
