package pl.assecods.plncalculator.dto;

public class PLNCostForeignCurrency {
    private String code;
    private double amount;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
