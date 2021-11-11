package lavoz.filtros;

import lavoz.Participante;

/**
 * Los anteriores son algunos ejemplos de los listados que la producción le pide
 * constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así
 * como combinación lógicas de los existentes.
 */
public class FiltroNot implements FiltroParticipante {

    private FiltroParticipante filtroParticipante;

    public FiltroNot(FiltroParticipante filtroParticipante) {
        this.filtroParticipante = filtroParticipante;
    }

    @Override
    public Boolean filtrar(Participante participante) {
        return !filtroParticipante.filtrar(participante);
    }
}
