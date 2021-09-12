package ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class House {

    private static final Integer DEFAULT_MAX_SIZE = 10;

    private Integer maxSize;
    private String name;
    private List<String> traits;
    protected List<Student> students;

    public House(String name, List<String> traits) {
        this.students = new ArrayList<>();
        this.maxSize = DEFAULT_MAX_SIZE;
        this.name = name;
        this.traits = traits;
    }

    public Boolean accept(Student student) {
        if (this.accepts(student)) {
            students.add(student);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    protected Boolean accepts(Student student) {
        // Para que una casa pueda aceptar a un nuevo alumno,
        if (students.size() == maxSize) {
            // además de haber lugar
            return Boolean.FALSE;
        } else if (!hasEveryHouseTrait(student)){
            // el alumno tiene que poseer todas las cualidades que la casa requiera.
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean hasEveryHouseTrait(Student student) {
        for (String houseTrait : getTraits()) {
            if (!student.getTraits().contains(houseTrait)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public List<String> getTraits() {
        return traits;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
