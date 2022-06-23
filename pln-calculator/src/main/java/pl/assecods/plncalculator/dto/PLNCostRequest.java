package pl.assecods.plncalculator.dto;

import java.util.List;

public class PLNCostRequest {
    private String date;

    private List<PLNCostForeignCurrency> currencies;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<PLNCostForeignCurrency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<PLNCostForeignCurrency> currencies) {
        this.currencies = currencies;
    }
}
