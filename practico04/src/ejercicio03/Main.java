package ejercicio03;

public class Main {

    public static void main(String[] args) {
        Employee contractor = new Contractor(40, null, 10000D);
        Employee extraHours = new ExtraHoursEmployee(40, null, 10000D, 10D);
        Employee sales = new SalesEmployee(40, 5000D, 10000D, 0.10);
        System.out.println("Contractor salary: " + contractor.calculateSalary());
        System.out.println("Extra hours salary: " + extraHours.calculateSalary());
        System.out.println("Sales salary: " + sales.calculateSalary());
    }
}
