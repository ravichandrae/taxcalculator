package in.letuscode.taxcalculator.entity;

public class NewTaxRegime extends BaseTaxRegime{
    @Override
    protected void initializeTaxSlabs() {
        taxSlabs.add(new TaxSlab(0, 300000, 0));
        taxSlabs.add(new TaxSlab(300000, 600000, 0.05));
        taxSlabs.add(new TaxSlab(600000, 900000, 0.10));
        taxSlabs.add(new TaxSlab(900000, 1200000, 0.15));
        taxSlabs.add(new TaxSlab(1200000, 1500000, 0.20));
        taxSlabs.add(new TaxSlab(1500000, Double.MAX_VALUE, 0.30));
    }
}
