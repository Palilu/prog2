package ejercicio04;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Player p = new Player();
        p.setFirstName("Lionel");
        p.setFirstName("Messi");
        p.setPassportNumber("1");
        p.setDateOfBirth(LocalDate.of(1987, 06, 04));
        p.setStatus(Status.TRAVELING);
        p.setGoals(Integer.MAX_VALUE);
        p.setLeftHanded(Boolean.TRUE);
        p.setPosition("Crack");
        System.out.println("Messi availability: " + p.isAvailable());
        Coach c = new Coach();
        c.setFirstName("Lionel");
        c.setFirstName("Scaloni");
        c.setPassportNumber("2");
        c.setDateOfBirth(LocalDate.of(1978, 05, 16));
        c.setStatus(Status.IN_COUNTRY_OF_ORIGIN);
        c.setFederationId("Scaloneta");
        System.out.println("Scaloni availability: " + c.isAvailable());
        Massager m = new Massager();
        m.setFirstName("Marcelo");
        m.setFirstName("D'Andrea");
        m.setPassportNumber("3");
        m.setDateOfBirth(LocalDate.of(1975, 04, 26));
        m.setStatus(Status.IN_CONCENTRATION);
        m.setTitle("Técnicatura en frotado de futbolistas");
        System.out.println("D'Andrea availability: " + m.isAvailable());
    }
}
