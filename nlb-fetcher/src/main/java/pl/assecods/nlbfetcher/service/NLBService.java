package pl.assecods.nlbfetcher.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.assecods.nlbfetcher.clients.DBClient;
import pl.assecods.nlbfetcher.clients.NLBClient;
import pl.assecods.nlbfetcher.clients.NLBMidExchangeRateResponse;
import pl.assecods.nlbfetcher.clients.NLBSellExchangeRateResponse;
import pl.assecods.nlbfetcher.dto.ExchangeRateResponse;

import java.util.Optional;

@Service
public class NLBService {
    private final DBClient dbClient;
    private final NLBClient nlbClient;

    public NLBService(DBClient dbClient, NLBClient nlbClient) {
        this.dbClient = dbClient;
        this.nlbClient = nlbClient;
    }

    public Optional<ExchangeRateResponse> getSellExchangeRate(String code, String date) {
        ResponseEntity<ExchangeRateResponse> exchangeRateResponseFromDb = dbClient.getExchangeRate("sell", code, date);
        if(exchangeRateResponseFromDb.getStatusCode() == HttpStatus.OK) {
            return Optional.ofNullable(exchangeRateResponseFromDb.getBody());
        }

        ResponseEntity<NLBSellExchangeRateResponse> response = nlbClient.getSellExchangeRate(code, date);
        if(response.getStatusCode() == HttpStatus.OK) {
            double rate = response.getBody().getRates().get(0).getAsk();
            dbClient.setExchangeRate("sell", code, date, rate);
            return Optional.of(new ExchangeRateResponse(rate));
        }
        return Optional.empty();
    }

    public Optional<ExchangeRateResponse> getMidExchangeRate(String code, String date) {
        ResponseEntity<ExchangeRateResponse> exchangeRateResponseFromDb = dbClient.getExchangeRate("mid", code, date);
        if(exchangeRateResponseFromDb.getStatusCode() == HttpStatus.OK) {
            return Optional.ofNullable(exchangeRateResponseFromDb.getBody());
        }

        ResponseEntity<NLBMidExchangeRateResponse> response = nlbClient.getMidExchangeRate(code, date);
        if(response.getStatusCode() == HttpStatus.OK) {
            double rate = response.getBody().getRates().get(0).getMid();
            dbClient.setExchangeRate("mid", code, date, rate);
            return Optional.of(new ExchangeRateResponse(rate));
        }
        return Optional.empty();
    }
}
