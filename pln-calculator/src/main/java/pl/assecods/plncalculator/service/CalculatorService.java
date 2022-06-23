package pl.assecods.plncalculator.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.assecods.plncalculator.clients.NBPFetcherClient;
import pl.assecods.plncalculator.dto.ExchangeRateResponse;
import pl.assecods.plncalculator.dto.PLNCostRequest;
import pl.assecods.plncalculator.dto.PLNCostResponse;

import java.text.DecimalFormat;

@Service
public class CalculatorService {
    private static final DecimalFormat twoDecimalPlacesFormatter = new DecimalFormat("#.00");
    private final NBPFetcherClient NBPFetcherClient;

    public CalculatorService(NBPFetcherClient NBPFetcherClient) {
        this.NBPFetcherClient = NBPFetcherClient;
    }

    public PLNCostResponse calculatePLN(PLNCostRequest plnCostRequest) {
        double sum = plnCostRequest.getCurrencies().stream()
                .map(plnCostForeignCurrency -> {
                    ResponseEntity<ExchangeRateResponse> response = NBPFetcherClient.getMidExchangeRate(
                            plnCostForeignCurrency.getCode(),
                            plnCostRequest.getDate()
                    );
                    if(response.getStatusCode() == HttpStatus.OK) {
                        return plnCostForeignCurrency.getAmount() * response.getBody().getRate();
                    }
                    return 0.0;
                }).reduce(Double::sum).orElse(0.0);
        return new PLNCostResponse(Double.parseDouble(twoDecimalPlacesFormatter.format(sum)));
    }
}
