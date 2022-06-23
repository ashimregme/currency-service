package pl.assecods.plncalculator.dto;

public class ExchangeRateResponse {
    private double rate;

    public ExchangeRateResponse() {
    }

    public ExchangeRateResponse(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
