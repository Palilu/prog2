package lavoz.filtros;

import lavoz.Participante;

/**
 * Los anteriores son algunos ejemplos de los listados que la producción le pide
 * constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así
 * como combinación lógicas de los existentes.
 */
public class FiltroOr implements FiltroParticipante {

    private FiltroParticipante filtroParticipante1;
    private FiltroParticipante filtroParticipante2;

    public FiltroOr(FiltroParticipante filtroParticipante1, FiltroParticipante filtroParticipante2) {
        this.filtroParticipante1 = filtroParticipante1;
        this.filtroParticipante2 = filtroParticipante2;
    }

    @Override
    public Boolean filtrar(Participante participante) {
        return filtroParticipante1.filtrar(participante) || filtroParticipante2.filtrar(participante);
    }
}
