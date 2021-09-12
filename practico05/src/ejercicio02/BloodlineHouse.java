package ejercicio02;

import java.util.List;

public class BloodlineHouse extends House {

    private List<String> bloodline;

    public BloodlineHouse(String name,
                          List<String> traits,
                          List<String> bloodline) {
        super(name, traits);
        this.bloodline = bloodline;
    }

    @Override
    public Boolean accepts(Student student) {
        // Algunas casas no se contentan con que los alumnos tengan todas las cualidades que
        // requieren, sino que además en un afán de conservar los linajes de sangre pura, también
        // exigen que el alumno cuente con un familiar que pertenezca en este momento a la misma
        // casa.
        if (!super.accepts(student)) {
            return Boolean.FALSE;
        } else {
            return hasFamiliyInTheHouse(student);
        }
    }

    private boolean hasFamiliyInTheHouse(Student student) {
        return hasFamily(student, this.bloodline);
    }

    private boolean hasFamily(Student candidate, List<String> students) {
        return students.stream().filter(student -> isFamily(candidate, student)).findAny().isPresent();
    }

    private boolean isFamily(Student candidate, String member) {
        return getLastName(candidate.getName()).equals(getLastName(member));
    }

    private String getLastName(String fullName) {
        String[] names = fullName.split(" ");
        return names[names.length - 1];
    }
}
