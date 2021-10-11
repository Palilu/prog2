package ejercicio03;

import java.time.LocalDate;

public class FieldRent {

    private Integer filedNumber;
    private LocalDate rentDate;
    private Double cost;

    public FieldRent(Integer filedNumber, LocalDate rentDate, Double cost) {
        this.filedNumber = filedNumber;
        this.rentDate = rentDate;
        this.cost = cost;
    }

    public Integer getFiledNumber() {
        return filedNumber;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public Double getCost() {
        return cost;
    }
}
