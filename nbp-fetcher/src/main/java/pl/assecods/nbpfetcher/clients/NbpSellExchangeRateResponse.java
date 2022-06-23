package pl.assecods.nbpfetcher.clients;

import java.util.List;

public class NbpSellExchangeRateResponse {
    private List<NbpSellExchangeRate> rates;

    public List<NbpSellExchangeRate> getRates() {
        return rates;
    }

    public void setRates(List<NbpSellExchangeRate> rates) {
        this.rates = rates;
    }

    public static class NbpSellExchangeRate {
        private double ask;

        public double getAsk() {
            return ask;
        }

        public void setAsk(double ask) {
            this.ask = ask;
        }
    }
}
