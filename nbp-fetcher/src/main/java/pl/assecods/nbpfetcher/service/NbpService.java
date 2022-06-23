package pl.assecods.nbpfetcher.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.assecods.nbpfetcher.clients.DBClient;
import pl.assecods.nbpfetcher.clients.NBPClient;
import pl.assecods.nbpfetcher.clients.NbpMidExchangeRateResponse;
import pl.assecods.nbpfetcher.clients.NbpSellExchangeRateResponse;
import pl.assecods.nbpfetcher.dto.ExchangeRateResponse;

import java.util.Optional;

@Service
public class NbpService {
    private final DBClient dbClient;
    private final NBPClient NBPClient;

    public NbpService(DBClient dbClient, NBPClient NBPClient) {
        this.dbClient = dbClient;
        this.NBPClient = NBPClient;
    }

    public Optional<ExchangeRateResponse> getSellExchangeRate(String code, String date) {
        ResponseEntity<ExchangeRateResponse> exchangeRateResponseFromDb = dbClient.getExchangeRate("sell", code, date);
        if(exchangeRateResponseFromDb.getStatusCode() == HttpStatus.OK) {
            return Optional.ofNullable(exchangeRateResponseFromDb.getBody());
        }

        ResponseEntity<NbpSellExchangeRateResponse> response = NBPClient.getSellExchangeRate(code, date);
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

        ResponseEntity<NbpMidExchangeRateResponse> response = NBPClient.getMidExchangeRate(code, date);
        if(response.getStatusCode() == HttpStatus.OK) {
            double rate = response.getBody().getRates().get(0).getMid();
            dbClient.setExchangeRate("mid", code, date, rate);
            return Optional.of(new ExchangeRateResponse(rate));
        }
        return Optional.empty();
    }
}
