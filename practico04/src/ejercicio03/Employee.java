package ejercicio03;

public abstract class Employee {

    protected Integer workedHours;
    protected Double salesAmount;
    protected Double baseSalary;

    public Employee(Integer workedHours, Double salesAmount, Double baseSalary) {
        this.workedHours = workedHours;
        this.salesAmount = salesAmount;
        this.baseSalary = baseSalary;
    }

    public abstract Double calculateSalary();
}
