package lavoz;

import lavoz.filtros.FiltroParticipante;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * De los participantes, se registra su nombre, apellido, edad, géneros musicales de preferencia, idiomas en los que
 * canta y los instrumentos que toca.
 */
public abstract class Participante {

    private String nombre;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    public List<Participante> filtrar(FiltroParticipante filtro) {
        return filtro.filtrar(this) ? List.of(this) : Collections.EMPTY_LIST;
    }

    public abstract Integer getEdad();

    public abstract Set<String> getGeneros();

    public abstract Set<String> getIdiomas();

    public abstract Set<String> getInstrumentos();

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + getNombre() +
                ", edad=" + getEdad() +
                ", generos=" + getGeneros() +
                ", idiomas=" + getIdiomas() +
                ", instrumentos=" + getInstrumentos() +
                '}';
    }

    public String getNombre() {
        return nombre;
    }
}
