package ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class HouseWithEnemies extends BloodlineHouse {

    private List<House> enemies;

    public HouseWithEnemies(String name,
                            List<String> traits,
                            List<String> bloodline,
                            List<House> enemies) {
        super(name, traits, bloodline);
        this.enemies = enemies;
    }

    public void addEnemy(House enemy) {
        this.enemies.add(enemy);
    }

    public List<House> getEnemies() {
        return new ArrayList<>(enemies);
    }

    @Override
    public Boolean accepts(Student student) {
        // hay casas que a lo largo de su historia se han encontrado enemistadas.
        if (!super.accepts(student)) {
            return Boolean.FALSE;
        } else {
            // En el caso en el que la casa tenga una enemistad con otra,
            if (enemies.size() > 0) {
                // además de exigir al alumno tener todas las cualidades,
                for (House enemyHouse: enemies) {
                    if (enemyHouse.accepts(student)) {
                        // se debe controlar que dicho alumno no pueda ser aceptado por la casa enemiga.
                        return Boolean.FALSE;
                    }
                }
            }
            return Boolean.TRUE;
        }
    }
}
