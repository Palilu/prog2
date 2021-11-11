package lavoz.comparadores;

import lavoz.Participante;

import java.util.Comparator;

public class Comparadores {

    public static Comparator<Participante> porCantidadDeInstrumentos() {
        return new PorCantidadDeInstrumentos();
    }

    public static Comparator<Participante> porCantidadDeGeneros() {
        return new PorCantidadDeGeneros();
    }

    public static Comparator<Participante> porEdad() {
        return Comparator.comparing(Participante::getEdad);
    }

    public static Comparator<Participante> porCantidadDeIdiomas() {
        return new PorCantidadDeIdiomas();
    }

    public static Comparator<Participante> porEstoLuegoAquello(Comparator<Participante> esto,
                                                               Comparator<Participante> aquello) {
        return new PorEstoLuegoAquello(esto, aquello);
    }
}
