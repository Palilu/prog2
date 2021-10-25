package lavoz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * De los participantes, se registra su
 *  * nombre, apellido, edad, géneros musicales de preferencia, idiomas en los que
 *  * canta y los instrumentos que toca.
 */
public class Participante {

    private String nombre;
    private String apellido;
    private Integer edad;
    private List<String> generos;
    private List<String> idiomas;
    private Set<String> instrumentos;

    public Participante(String nombre, String apellido, Integer edad, List<String> generos, List<String> idiomas, Set<String> instrumentos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.generos = generos;
        this.idiomas = idiomas;
        this.instrumentos = instrumentos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public List<String> getGeneros() {
        return new ArrayList<>(generos);
    }

    public List<String> getIdiomas() {
        return new ArrayList<>(idiomas);
    }

    public Set<String> getInstrumentos() {
        return new HashSet<>(instrumentos);
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", generos=" + generos +
                ", idiomas=" + idiomas +
                ", instrumentos=" + instrumentos +
                '}';
    }
}
