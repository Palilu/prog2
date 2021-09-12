package ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class SortingHat {

    private List<House> options =  new ArrayList<>();

    public SortingHat(List<House> options) {
        this.options = options;
    }

    public House sort(Student student) {
        for (House house : options) {
            if (house.accept(student)) {
                System.out.println(student.getName() + " has been accepted in " + house.getName() + ".");
                return house;
            }
        }
        System.out.println(student.getName() + " it's getting a muggle education.");
        return null;
    }
}
