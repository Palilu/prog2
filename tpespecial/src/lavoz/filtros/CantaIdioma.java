package lavoz.filtros;

import lavoz.Participante;

/**
 * Canten en un determinado idioma, por ejemplo “inglés”
 */
public class CantaIdioma implements FiltroParticipante {

    private String idioma;

    public CantaIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public Boolean filtrar(Participante participante) {
        return participante.getIdiomas().contains(idioma);
    }
}
