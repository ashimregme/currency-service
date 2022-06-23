package pl.assecods.dbservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.assecods.dbservice.dto.ExchangeRateResponse;
import pl.assecods.dbservice.service.DBService;

@RestController
public class DBController {
    private final DBService dbService;

    public DBController(DBService dbService) {
        this.dbService = dbService;
    }

    @GetMapping("/db/{type}/exr/{date}/{code}")
    public ResponseEntity<ExchangeRateResponse> getSellExchangeRate(@PathVariable String type,
                                                                    @PathVariable String code,
                                                                    @PathVariable String date) {
        return ResponseEntity.of(dbService.getExchangeRate(type, code, date));
    }

    @PostMapping("/db/{type}/exr/{date}/{code}/{rate}")
    public void setSellExchangeRate(@PathVariable String type,
                                    @PathVariable String code,
                                    @PathVariable String date,
                                    @PathVariable double rate) {
        dbService.setExchangeRate(type, code, date, rate);
    }
}
