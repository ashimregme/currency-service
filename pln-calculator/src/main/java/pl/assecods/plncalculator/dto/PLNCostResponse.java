package pl.assecods.plncalculator.dto;

public class PLNCostResponse {
    private double totalCost;

    public PLNCostResponse() {
    }

    public PLNCostResponse(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
