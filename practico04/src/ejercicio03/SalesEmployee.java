package ejercicio03;

public class SalesEmployee extends Employee {

    private Double salesPercentage;

    public SalesEmployee(Integer workedHours, Double salesAmount, Double baseSalary, Double salesPercentage) {
        super(workedHours, salesAmount, baseSalary);
        this.salesPercentage = salesPercentage;
    }

    @Override
    public Double calculateSalary() {
        return this.baseSalary + this.salesAmount * this.salesPercentage;
    }
}
