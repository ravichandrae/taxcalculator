package in.letuscode.taxcalculator.controller;

import in.letuscode.taxcalculator.dto.DeductionRequest;
import in.letuscode.taxcalculator.dto.TaxCalculationRequest;
import in.letuscode.taxcalculator.dto.TaxCalculationResult;
import in.letuscode.taxcalculator.service.TaxCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tax")
public class TaxCalculatorController {

    @Autowired
    private TaxCalculatorService taxCalculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<TaxCalculationResult> calculateTax(@RequestBody TaxCalculationRequest request) {
        double tax = taxCalculatorService.calculateTax(request.getIncome(), request.getRegimeType());
        TaxCalculationResult result = new TaxCalculationResult();
        result.setIncome(request.getIncome());
        result.setTax(tax);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/regimes")
    public ResponseEntity<List<String>> getTaxRegimes() {
        List<String> regimes = taxCalculatorService.getAvailableTaxRegimes();
        return ResponseEntity.ok(regimes);
    }

    @GetMapping("/deductions")
    public ResponseEntity<List<String>> getDeductions() {
        List<String> deductions = taxCalculatorService.getAvailableDeductions();
        return ResponseEntity.ok(deductions);
    }

    @PostMapping("/deductions")
    public ResponseEntity<String> addDeduction(@RequestBody DeductionRequest request) {
        taxCalculatorService.addDeduction(request.getDeductionType());
        return ResponseEntity.ok("Deduction added successfully");
    }
}