package lavoz;

import lavoz.filtros.FiltroParticipante;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ahora cada coach/jurado tiene un listado de participantes asignados como equipo propio, este listado
 * puede incluir Bandas, Grupos o Integrantes solistas.
 */
public class Coach {

    private String nombre;
    private List<Participante> equipo;

    public Coach(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
    }

    public void agregar(Participante participante) {
        this.equipo.add(participante);
    }

    /**
     * @return un listado de todos los instrumentos que pueden tocar los participantes de su equipo
     * (no debe haber repetidos)
     */
    public Set<String> obtenerInstrumentosEquipo() {
        return new Banda(null, equipo).getInstrumentos();
    }

    /**
     * @return un listado de todos los idiomas que pueden cantar los participantes de su equipo
     * (sin idiomas repetidos)
     */
    public Set<String> obtenerIdiomasEquipo() {
        return new Banda(null, equipo).getIdiomas();
    }

    /**
     * @return un listado de géneros de preferencia de los participantes de su equipo
     * (sin repetidos y ordenados alfabéticamente)
     */
    public Set<String> obtenerGenerosEquipo() {
        return new TreeSet<>(equipo.stream()
                .map(Participante::getGeneros)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));
    }

    /**
     * @return El promedio de edad de su equipo
     */
    public Integer obtenerPromedioEdadEquipo() {
        return new Banda(null, equipo).getEdad();
    }

    public List<Participante> buscar(FiltroParticipante filtroParticipante) {
        return this.equipo.stream()
                .map(miembro -> miembro.filtrar(filtroParticipante))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Participante> obtenerEquipoOrdenadoParaLaBatalla(Comparator<Participante> reglasBatalla) {
        return this.equipo.stream()
                .sorted(reglasBatalla)
                .collect(Collectors.toList());
    }

    public String getNombre() {
        return nombre;
    }

    public void imprimirEquipo() {
        this.equipo.forEach(System.out::println);
    }
}
