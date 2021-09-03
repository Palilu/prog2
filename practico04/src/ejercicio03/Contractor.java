package ejercicio03;

public class Contractor extends Employee {

    public Contractor(Integer workedHours, Double salesAmount, Double baseSalary) {
        super(workedHours, salesAmount, baseSalary);
    }

    @Override
    public Double calculateSalary() {
        return this.baseSalary;
    }
}
