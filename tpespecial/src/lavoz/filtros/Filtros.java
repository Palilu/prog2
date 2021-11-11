package lavoz.filtros;

import lavoz.Tema;

public class Filtros {

    public static FiltroParticipante cantaIdioma(String idioma) {
        return new CantaIdioma(idioma);
    }

    public static FiltroParticipante prefiereGenero(String genero) {
        return new PrefiereGenero(genero);
    }

    public static FiltroParticipante mayorDe(Integer edad) {
        return new MayorDe(edad);
    }

    public static FiltroParticipante puedeInterpretar(Tema tema) {
        return new PuedeInterpretar(tema);
    }

    public static FiltroParticipante tocaInstrumento(String instrumento) {
        return new TocaInstrumento(instrumento);
    }

    public static FiltroParticipante not(FiltroParticipante f) {
        return new FiltroNot(f);
    }

    public static FiltroParticipante and(FiltroParticipante f1, FiltroParticipante f2) {
        return new FiltroAnd(f1, f2);
    }

    public static FiltroParticipante or(FiltroParticipante f1, FiltroParticipante f2) {
        return new FiltroOr(f1, f2);
    }
}
