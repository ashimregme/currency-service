package pl.assecods.nlbfetcher.clients;

import java.util.List;

public class NLBMidExchangeRateResponse {
    private List<NLBMidExchangeRate> rates;

    public List<NLBMidExchangeRate> getRates() {
        return rates;
    }

    public void setRates(List<NLBMidExchangeRate> rates) {
        this.rates = rates;
    }

    public static class NLBMidExchangeRate {
        private double mid;

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }
    }
}
