package lavoz;

import lavoz.filtros.Filtros;

import java.util.ArrayList;
import java.util.List;

/**
 * Cada tema musical tiene un título, un idioma, una lista de géneros musicales a los que pertenece y una
 * lista de instrumentos musicales necesarios para interpretarlo durante el concurso (puede ser vacía).
 */
public class Tema {

    private String titulo;
    private String idioma;
    private List<String> generos;
    private List<String> instrumentos;

    public Tema(String titulo, String idioma, List<String> generos, List<String> instrumentos) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.generos = generos;
        this.instrumentos = instrumentos;
    }

    public Boolean puedeSerInterpretadoPor(Participante participante) {
        // 4. Un tema puede ser interpretado por una banda/grupo/solista si puede cantar en el idioma del
        // tema y al menos uno de los géneros está entre las preferencias del grupo/banda/solista.
        return Filtros.cantaIdioma(idioma).filtrar(participante) && generos.stream()
                .filter(genero -> Filtros.prefiereGenero(genero).filtrar(participante))
                .findFirst().isPresent();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public List<String> getGeneros() {
        return new ArrayList<>(generos);
    }

    public List<String> getInstrumentos() {
        return new ArrayList<>(instrumentos);
    }

    @Override
    public String toString() {
        return "Tema{" +
                "titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", generos=" + generos +
                ", instrumentos=" + instrumentos +
                '}';
    }
}
