package pl.assecods.plncalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.assecods.plncalculator.dto.PLNCostRequest;
import pl.assecods.plncalculator.dto.PLNCostResponse;
import pl.assecods.plncalculator.service.CalculatorService;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculate/pln")
    public ResponseEntity<PLNCostResponse> calculatePLN(@RequestBody PLNCostRequest plnCostRequest) {
        return ResponseEntity.ok(calculatorService.calculatePLN(plnCostRequest));
    }
}
