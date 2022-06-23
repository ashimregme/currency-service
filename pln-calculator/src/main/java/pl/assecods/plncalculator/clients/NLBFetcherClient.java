package pl.assecods.plncalculator.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.assecods.plncalculator.dto.ExchangeRateResponse;

@FeignClient(value = "nlbFetcher", url = "http://localhost:8080/nlb/mid/exr", decode404 = true)
public interface NLBFetcherClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{code}/{date}"
    )
    ResponseEntity<ExchangeRateResponse> getMidExchangeRate(@PathVariable String code, @PathVariable String date);
}
