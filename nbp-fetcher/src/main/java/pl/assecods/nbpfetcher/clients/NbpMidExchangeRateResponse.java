package pl.assecods.nbpfetcher.clients;

import java.util.List;

public class NbpMidExchangeRateResponse {
    private List<NbpMidExchangeRate> rates;

    public List<NbpMidExchangeRate> getRates() {
        return rates;
    }

    public void setRates(List<NbpMidExchangeRate> rates) {
        this.rates = rates;
    }

    public static class NbpMidExchangeRate {
        private double mid;

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }
    }
}
