package in.letuscode.taxcalculator.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTaxRegime implements TaxRegime {
    protected List<TaxSlab> taxSlabs;

    public BaseTaxRegime() {
        taxSlabs = new ArrayList<>();
        initializeTaxSlabs();
    }

    protected abstract void initializeTaxSlabs();

    @Override
    public double calculateTax(double income) {
        double totalTax = 0;
        for (TaxSlab slab : taxSlabs) {
            if (slab.isApplicable(income)) {
                totalTax += slab.calculateTax(income);
            }
        }
        return totalTax;
    }
}