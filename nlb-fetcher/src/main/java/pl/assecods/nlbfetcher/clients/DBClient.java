package pl.assecods.nlbfetcher.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.assecods.nlbfetcher.dto.ExchangeRateResponse;

@FeignClient(value = "db", url = "http://localhost:8082/db/", decode404 = true)
public interface DBClient {
    @RequestMapping(method = RequestMethod.GET, value = "/{type}/exr/{date}/{code}")
    ResponseEntity<ExchangeRateResponse> getExchangeRate(@PathVariable String type, @PathVariable String code, @PathVariable String date);

    @RequestMapping(method = RequestMethod.POST, value = "/{type}/exr/{date}/{code}/{exr}")
    void setExchangeRate(@PathVariable String type, @PathVariable String code, @PathVariable String date, @PathVariable double exr);
}
