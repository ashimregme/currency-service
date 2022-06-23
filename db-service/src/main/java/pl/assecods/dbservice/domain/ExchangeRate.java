package pl.assecods.dbservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeRate {
    @Id
    private String id;
    private double rate;

    public ExchangeRate() {
    }

    public ExchangeRate(String id, double rate) {
        this.id = id;
        this.rate = rate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
