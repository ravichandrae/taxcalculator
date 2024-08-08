package in.letuscode.taxcalculator.dto;

import lombok.Data;

@Data
public class TaxCalculationRequest {
    private double income;
    private String regimeType;
}
