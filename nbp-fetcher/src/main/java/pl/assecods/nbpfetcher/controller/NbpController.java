package pl.assecods.nbpfetcher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.assecods.nbpfetcher.dto.ExchangeRateResponse;
import pl.assecods.nbpfetcher.service.NbpService;

@RestController
public class NbpController {
    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/nbp/sell/exr/{code}/{date}")
    public ResponseEntity<ExchangeRateResponse> getSellExchangeRate(@PathVariable String code,
                                                                    @PathVariable String date) {
        return ResponseEntity.of(nbpService.getSellExchangeRate(code, date));
    }

    @GetMapping("/nbp/mid/exr/{code}/{date}")
    public ResponseEntity<ExchangeRateResponse> getMidExchangeRate(@PathVariable String code,
                                                                    @PathVariable String date) {
        return ResponseEntity.of(nbpService.getMidExchangeRate(code, date));
    }
}
