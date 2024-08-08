package in.letuscode.taxcalculator.entity;

public class TaxRegimeFactory {
    public static TaxRegime createTaxRegime(String type) {
        if ("old".equalsIgnoreCase(type)) {
            return new OldTaxRegime();
        } else if ("new".equalsIgnoreCase(type)) {
            return new NewTaxRegime();
        }
        throw new IllegalArgumentException("Invalid tax regime type");
    }
}
