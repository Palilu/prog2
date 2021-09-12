package ejercicio01;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Person {
    private static final String DEFAULT_NAME = "N";
    private static final LocalDate DEFAULT_DOB = LocalDate.of(2000, 1, 1);
    private static final Double DEFAULT_EIGHT = 1D;
    private static final Integer VOTE_AGE = 16;
    private static final Integer LEGAL_AGE = 18;

    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate dob;
    private String dni;
    private Sex sex;
    private Double weight;
    private Double height;

    public Person(String dni) {
        this.dni = dni;
        firstName = DEFAULT_NAME;
        lastName = DEFAULT_NAME;
        age = calculateAge(DEFAULT_DOB);
        dob = DEFAULT_DOB;
        sex = Sex.F;
        weight = DEFAULT_EIGHT;
        height = DEFAULT_EIGHT;
    }

    public Person(String dni, String firstName, String lastName) {
        this(dni);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String dni, String firstName, String lastName, LocalDate dob) {
        this(dni, firstName, lastName);
        this.dob = dob;
    }

    public Double getBodyMassIndex() {
        return new BodyMassIndex(weight, height).getValue();
    }

    public Boolean isInShape() {
        return new BodyMassIndex(weight, height).isInShape();
    }

    public Boolean isMyBirthday() {
        LocalDate today = LocalDate.now();
        return dob.getDayOfMonth() == today.getDayOfMonth() && dob.getMonth() == today.getMonth();
    }

    public Boolean isOfLegalAge() {
        return age >= LEGAL_AGE;
    }

    public Boolean canVote() {
        return age >= VOTE_AGE;
    }

    public boolean isCoherent() {
        return calculateAge(dob) == age;
    }

    private Integer calculateAge(LocalDate age) {
        return ((Long) ChronoUnit.YEARS.between(age, LocalDate.now())).intValue();
    }

    @Override
    public String toString() {
        return "ejercicio01.Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", dni='" + dni + '\'' +
                ", sex=" + sex +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
