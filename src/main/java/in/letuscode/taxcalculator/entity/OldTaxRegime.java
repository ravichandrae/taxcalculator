package in.letuscode.taxcalculator.entity;

public class OldTaxRegime extends BaseTaxRegime{
    @Override
    protected void initializeTaxSlabs() {
        taxSlabs.add(new TaxSlab(0, 250000, 0));
        taxSlabs.add(new TaxSlab(250000, 500000, 0.05));
        taxSlabs.add(new TaxSlab(500000, 1000000, 0.20));
        taxSlabs.add(new TaxSlab(1000000, Double.MAX_VALUE, 0.30));
    }
}
