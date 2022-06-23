package pl.assecods.dbservice.service;

import org.springframework.stereotype.Service;
import pl.assecods.dbservice.domain.ExchangeRate;
import pl.assecods.dbservice.dto.ExchangeRateResponse;
import pl.assecods.dbservice.repository.ExchangeRateRepository;

import java.util.Optional;

@Service
public class DBService {
    private final ExchangeRateRepository exchangeRateRepository;

    public DBService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public Optional<ExchangeRateResponse> getExchangeRate(String type, String code, String date) {
        Optional<ExchangeRate> optionalExchangeRate = exchangeRateRepository.findById(getId(type, code, date));
        return optionalExchangeRate.map(exchangeRate -> new ExchangeRateResponse(exchangeRate.getRate()));
    }

    public void setExchangeRate(String type, String code, String date, double rate) {
        exchangeRateRepository.save(new ExchangeRate(getId(type, code, date), rate));
    }

    private static String getId(String type, String code, String date) {
        return String.format("%s_%s_%s", type, code, date);
    }
}
