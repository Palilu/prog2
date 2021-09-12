package ejercicio02;

import java.util.ArrayList;
import java.util.List;

/**
 * Modernizando el sombrero seleccionador
 *
 * La Escuela Hogwarts de Magia y Hechicería decidió que era momento de reemplazar el
 * sombrero seleccionador en la tradicional ceremonia de comienzo de año y ahora requiere de
 * un sistema que permita realizar la asignación de alumnos a las diferentes casas. Cada una de
 * las casas cuenta con un conjunto de cualidades que deben tener los alumnos para poder
 * pertenecer a dicha casa y una cantidad máxima de alumnos que pueden aceptar. De esta
 * forma, si la casa se encuentra llena, ya no puede recibir nuevos alumnos. De un alumno se
 * conoce su nombre, su conjunto de cualidades y el conjunto de familiares que asisten a la
 * escuela. Para que una casa pueda aceptar a un nuevo alumno, además de haber lugar, el
 * alumno tiene que poseer todas las cualidades que la casa requiera. Es importante destacar que
 * los alumnos pueden ser asignados como máximo a una única casa.
 * Algunas casas no se contentan con que los alumnos tengan todas las cualidades que
 * requieren, sino que además en un afán de conservar los linajes de sangre pura, también
 * exigen que el alumno cuente con un familiar que pertenezca en este momento a la misma
 * casa. Y por último, hay casas que a lo largo de su historia se han encontrado enemistadas. En
 * el caso en el que la casa tenga una enemistad con otra, además de exigir al alumno tener todas
 * las cualidades, se debe controlar que dicho alumno no pueda ser aceptado por la casa
 * enemiga.
 * Defina las clases para implementar una solución orientada a objetos para el problema e
 * implemente en Java todos los métodos involucrados en asignar un alumno a una casa.
 */
public class Main {

    private static final List<String> SLYTHERIN_BLOODLINE = List.of("Salazar Slytherin",
            "Merlin", "Severus Snape", "Phineas Nigellus Black", "Tom Riddle", "Horace Slughorn", "Lucius Malfoy");
    private static final List<String> SLYTHERIN_TRAITS = List.of(
            "Resourcefulness", "Determination", "Pride", "Cunning", "Ambition", "Self-preservation");
    private static final List<String> GRYFFINDOR_TRAITS = List.of(
            "Courage", "Bravery", "Determination", "Daring", "Nerve", "Chivalry");
    private static final List<String> RAVENCLAW_TRAITS = List.of(
            "Wit", "Learning", "Wisdom", "Acceptance", "Intelligence", "Creativity");
    private static final List<String> HUFFLEPUFF_TRAITS = List.of(
            "Hard-working", "Patience", "Fairness", "Just", "Loyalty", "Modesty");

    public static void main(String[] args) {
        House gryffindor = new House("Gryffindor", GRYFFINDOR_TRAITS);
        House ravenclaw = new House("Ravenclaw", RAVENCLAW_TRAITS);
        House hufflepuff = new House("Hufflepuff", HUFFLEPUFF_TRAITS);
        HouseWithEnemies slytherin = new HouseWithEnemies("Slytherin", SLYTHERIN_TRAITS, SLYTHERIN_BLOODLINE, List.of(gryffindor));
        SortingHat sortingHat = new SortingHat(List.of(gryffindor, ravenclaw, hufflepuff, slytherin));

        Student ron = new Student("Ron Weasley", GRYFFINDOR_TRAITS, new ArrayList<>());
        Student luna = new Student("Luna Lovegood", RAVENCLAW_TRAITS, new ArrayList<>());
        Student cedric = new Student("Cedric Diggory", HUFFLEPUFF_TRAITS, new ArrayList<>());
        Student draco = new Student("Draco Malfoy", SLYTHERIN_TRAITS, new ArrayList<>());

        sortingHat.sort(ron);
        sortingHat.sort(luna);
        sortingHat.sort(cedric);
        sortingHat.sort(draco);

        List<String> slyfindorTraits = new ArrayList<>();
        slyfindorTraits.addAll(GRYFFINDOR_TRAITS);
        slyfindorTraits.addAll(SLYTHERIN_TRAITS);

        Student harry = new Student("Harry Potter", slyfindorTraits, new ArrayList<>());
        Student sirius = new Student("Sirius Black", slyfindorTraits, new ArrayList<>());
        Student bellatrix = new Student("Bellatrix Black", SLYTHERIN_TRAITS, new ArrayList<>());
        sortingHat.sort(harry);
        sortingHat.sort(sirius);
        sortingHat.sort(bellatrix);
    }
}
