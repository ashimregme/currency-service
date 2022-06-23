package pl.assecods.nlbfetcher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.assecods.nlbfetcher.dto.ExchangeRateResponse;
import pl.assecods.nlbfetcher.service.NLBService;

@RestController
public class NLBController {
    private final NLBService nlbService;

    public NLBController(NLBService nlbService) {
        this.nlbService = nlbService;
    }

    @GetMapping("/nlb/sell/exr/{code}/{date}")
    public ResponseEntity<ExchangeRateResponse> getSellExchangeRate(@PathVariable String code,
                                                                    @PathVariable String date) {
        return ResponseEntity.of(nlbService.getSellExchangeRate(code, date));
    }

    @GetMapping("/nlb/mid/exr/{code}/{date}")
    public ResponseEntity<ExchangeRateResponse> getMidExchangeRate(@PathVariable String code,
                                                                    @PathVariable String date) {
        return ResponseEntity.of(nlbService.getMidExchangeRate(code, date));
    }
}
