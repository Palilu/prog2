package lavoz;

import java.util.HashSet;
import java.util.Set;

public class Solista extends Participante {

    private String apellido;
    private Integer edad;
    private Set<String> generos;
    private Set<String> idiomas;
    private Set<String> instrumentos;

    public Solista(String nombre,
                   String apellido,
                   Integer edad,
                   Set<String> generos,
                   Set<String> idiomas,
                   Set<String> instrumentos) {
        super(nombre);
        this.apellido = apellido;
        this.edad = edad;
        this.generos = generos;
        this.idiomas = idiomas;
        this.instrumentos = instrumentos;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public Set<String> getGeneros() {
        return new HashSet<>(generos);
    }

    public Set<String> getIdiomas() {
        return new HashSet<>(idiomas);
    }

    public Set<String> getInstrumentos() {
        return new HashSet<>(instrumentos);
    }
}
