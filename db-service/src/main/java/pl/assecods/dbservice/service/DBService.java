package pl.assecods.dbservice.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.assecods.dbservice.dto.ExchangeRateResponse;
import pl.assecods.dbservice.utils.JsonUtils;

import java.util.Optional;

@Service
public class DBService {
    private final CacheService cacheService;

    public DBService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public Optional<ExchangeRateResponse> getExchangeRate(String type, String code, String date) {
        String cacheKey = getCacheKey(type, code, date);

        String valueFromCache = cacheService.get(cacheKey);
        if(StringUtils.hasLength(valueFromCache)) {
            return Optional.of(JsonUtils.fromJson(valueFromCache, ExchangeRateResponse.class));
        }

        return Optional.empty();
    }

    public void setExchangeRate(String type, String code, String date, double exr) {
        String cacheKey = getCacheKey(type, code, date);
        cacheService.set(cacheKey, JsonUtils.toJson(new ExchangeRateResponse(exr)));
    }

    private static String getCacheKey(String type, String code, String date) {
        return String.format("nlb-%s-%s-%s", type, code, date);
    }
}
