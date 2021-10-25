package lavoz;

import lavoz.filtros.FiltroParticipante;

import java.util.*;

/**
 * Cada coach/jurado tiene un listado de participantes asignados como equipo propio. Para una mejor
 * organización, cada coach/jurado desea poder obtener:
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
        Set<String> instrumentos = new HashSet<>();
        for (Participante participante : this.equipo) {
            instrumentos.addAll(participante.getInstrumentos());
        }
        return instrumentos;
    }

    /**
     * @return un listado de todos los idiomas que pueden cantar los participantes de su equipo
     * (sin idiomas repetidos)
     */
    public Set<String> obtenerIdiomasEquipo() {
        Set<String> idiomas = new HashSet<>();
        for (Participante participante : this.equipo) {
            idiomas.addAll(participante.getIdiomas());
        }
        return idiomas;
    }

    /**
     * @return un listado de géneros de preferencia de los participantes de su equipo
     * (sin repetidos y ordenados alfabéticamente)
     */
    public Set<String> obtenerGenerosEquipo() {
        Set<String> generos = new HashSet<>();
        for (Participante participante : this.equipo) {
            generos.addAll(participante.getGeneros());
        }
        return new TreeSet<>(generos);
    }

    /**
     * @return El promedio de edad de su equipo
     */
    public Double obtenerPromedioEdadEquipo() {
        Double suma = 0D;
        for (Participante participante : this.equipo) {
            suma += participante.getEdad();
        }
        return suma / this.equipo.size();
    }

    public List<Participante> buscar(FiltroParticipante filtroParticipante) {
        List<Participante> resultado = new ArrayList<>();
        for (Participante participante : this.equipo) {
            if (filtroParticipante.filtrar(participante)) {
                resultado.add(participante);
            }
        }
        return resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void imprimirEquipo() {
        this.equipo.forEach(System.out::println);
    }
}
