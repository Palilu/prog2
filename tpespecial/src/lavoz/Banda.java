package lavoz;

import lavoz.filtros.FiltroParticipante;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Del Latin: "son una banda".
 * 
 * Los participantes pueden estar organizados en grupos y bandas. un grupo
 * o banda posee una lista de miembros que los componen (pueden ser
 * integrantes o incluso sub bandas). Una banda o grupo posee un nombre, y
 * una edad (la cual se calcula como el promedio de las edades de cada uno
 * de sus miembros). Los géneros de preferencia se calculan como la
 * intersección de los géneros de preferencia de todos sus miembros. Por
 * ejemplo si un grupo tienen dos miembros A y B, el integrante A tiene
 * preferencias {g1,g2,g3,g4} y el integrante B las preferencias {g1,g4,g7,g11}
 * el grupo tendrá como preferencias de géneros {g1, g4}. En el caso de los
 * idiomas que pueden interpretar una banda o grupo se considera la unión
 * de los idiomas de todos sus miembros (no pueden existir repetidos), lo
 * mismo ocurre para los instrumentos que puede tocar una banda.
 */
public class Banda extends Participante {

    private List<Participante> miembros;

    public Banda(String nombre, List<Participante> miembros) {
        super(nombre);
        this.miembros = miembros;
    }

    @Override
    public Integer getEdad() {
        return Double.valueOf(miembros.stream()
                .map(Participante::getEdad)
                .mapToInt(i -> i)
                .average().orElse(0D)).intValue();
    }

    @Override
    public Set<String> getGeneros() {
        if (miembros.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        Set<String> result = miembros.get(0).getGeneros();
        for (int i = 0; i < miembros.size(); i++) {
            result.retainAll(miembros.get(i).getGeneros());
        }
        return result;
    }

    @Override
    public Set<String> getIdiomas() {
        return miembros.stream()
                .map(Participante::getIdiomas)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getInstrumentos() {
        return miembros.stream()
                .map(Participante::getInstrumentos)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public List<Participante> filtrar(FiltroParticipante filtro) {
        if (filtro.filtrar(this)) {
            // 1. Si una banda o grupo cumple con lo que está buscando el jurado, se debe retornar la banda
            // o el grupo entero (respetando la organización interna de grupos y subgrupos)
            return List.of(this);
        } else {
            // 2. Si una banda o grupo NO cumple con lo que está buscando el jurado, se buscan posibles
            // miembros de la banda que sí cumplan y se retorna a estos miembros.
            // 3. El mecanismo anterior se repite en cada nivel organizativo que tenga la banda o grupo.
            return this.miembros.stream()
                    .map(miembro -> miembro.filtrar(filtro))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
    }
}
