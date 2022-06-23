package pl.assecods.nlbfetcher.clients;

import java.util.List;

public class NLBSellExchangeRateResponse {
    private List<NLBSellExchangeRate> rates;

    public List<NLBSellExchangeRate> getRates() {
        return rates;
    }

    public void setRates(List<NLBSellExchangeRate> rates) {
        this.rates = rates;
    }

    public static class NLBSellExchangeRate {
        private double ask;

        public double getAsk() {
            return ask;
        }

        public void setAsk(double ask) {
            this.ask = ask;
        }
    }
}
