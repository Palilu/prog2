package ejercicio01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args){
        // Test first constructor
        Person p1 = new Person("12345678");
        print(p1);
        // Test second constructor
        Person p2 = new Person("23456789", "Calvin", "Watterson");
        print(p2);
        // Test third constructor
        Person p3 = new Person("34567890", "Hobbes", "Watterson");
        print(p3);
        // A person where everything is false
        Person mrNo = new Person("45678901", "No", "Never", LocalDate.of(1984, 4, 26));
        mrNo.setAge(15);
        mrNo.setWeight(85D);
        mrNo.setHeight(1.79);
        print(mrNo);
        // A person where everything is true
        Person mrYes = new Person("56789012", "Yes", "Always", LocalDate.now().minus(37, ChronoUnit.YEARS));
        mrYes.setAge(37);
        mrYes.setWeight(75D);
        mrYes.setHeight(1.79);
        print(mrYes);
    }

    private static void print(Person p) {
        System.out.println(p.toString());
        System.out.println("BMI:" + p.getBodyMassIndex());
        System.out.println("In Shape:" + p.isInShape());
        System.out.println("Legal Age:" + p.isOfLegalAge());
        System.out.println("Voting Age:" + p.canVote());
        System.out.println("Coherent:" + p.isCoherent());
        System.out.println("Birthday:" + p.isMyBirthday());
    }
}
