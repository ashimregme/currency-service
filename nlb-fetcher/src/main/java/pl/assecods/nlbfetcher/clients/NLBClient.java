package pl.assecods.nlbfetcher.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "nlb", url = "https://api.nbp.pl/api/exchangerates/rates", decode404 = true)
public interface NLBClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/c/{code}/{date}",
            params = {"format=json"}
    )
    ResponseEntity<NLBSellExchangeRateResponse> getSellExchangeRate(@PathVariable String code, @PathVariable String date);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/a/{code}/{date}",
            params = {"format=json"}
    )
    ResponseEntity<NLBMidExchangeRateResponse> getMidExchangeRate(@PathVariable String code, @PathVariable String date);
}
