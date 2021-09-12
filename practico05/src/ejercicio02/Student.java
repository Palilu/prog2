package ejercicio02;

import java.util.ArrayList;
import java.util.List;

/**
 * De un alumno se conoce su nombre, su conjunto de cualidades
 * y el conjunto de familiares que asisten a la escuela.
 */
public class Student {

    private String name;
    private List<String> traits;
    private List<Student> family;

    public Student(String name, List<String> traits, List<Student> family) {
        this.name = name;
        this.traits = traits;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public List<String> getTraits() {
        return new ArrayList<>(traits);
    }

    public List<Student> getFamily() {
        return family;
    }
}
