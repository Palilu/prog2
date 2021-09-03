package ejercicio03;

public class ExtraHoursEmployee extends Employee {

    private Double extraHourRate;

    public ExtraHoursEmployee(Integer workedHours, Double salesAmount, Double baseSalary, Double extraHourRate) {
        super(workedHours, salesAmount, baseSalary);
        this.extraHourRate = extraHourRate;
    }

    @Override
    public Double calculateSalary() {
        return this.baseSalary + this.workedHours * this.extraHourRate;
    }
}
