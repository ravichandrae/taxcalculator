package in.letuscode.taxcalculator.service;

import in.letuscode.taxcalculator.engine.TaxCalculator;
import in.letuscode.taxcalculator.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaxCalculatorService {
    private final Map<String, TaxRegime> taxRegimes;
    private final Map<String, Deduction> availableDeductions;
    private final List<Deduction> appliedDeductions;

    public TaxCalculatorService() {
        taxRegimes = new HashMap<>();
        taxRegimes.put("old", new OldTaxRegime());
        taxRegimes.put("new", new NewTaxRegime());

        availableDeductions = new HashMap<>();
        availableDeductions.put("standard", new StandardDeduction());
        availableDeductions.put("section80C", new Section80CDeduction());

        appliedDeductions = new ArrayList<>();
    }

    public double calculateTax(double income, String regimeType) {
        TaxRegime regime = taxRegimes.get(regimeType.toLowerCase());
        if (regime == null) {
            throw new IllegalArgumentException("Invalid tax regime type");
        }

        TaxCalculator calculator = new TaxCalculator(regime);
        for (Deduction deduction : appliedDeductions) {
            calculator.addDeduction(deduction);
        }

        return calculator.calculateTax(income);
    }

    public List<String> getAvailableTaxRegimes() {
        return new ArrayList<>(taxRegimes.keySet());
    }

    public List<String> getAvailableDeductions() {
        return new ArrayList<>(availableDeductions.keySet());
    }

    public void addDeduction(String deductionType) {
        Deduction deduction = availableDeductions.get(deductionType.toLowerCase());
        if (deduction == null) {
            throw new IllegalArgumentException("Invalid deduction type");
        }
        appliedDeductions.add(deduction);
    }
}
