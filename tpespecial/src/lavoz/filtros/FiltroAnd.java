package lavoz.filtros;

import lavoz.Participante;

public class FiltroAnd implements FiltroParticipante {

    private FiltroParticipante filtroParticipante1;
    private FiltroParticipante filtroParticipante2;

    public FiltroAnd(FiltroParticipante filtroParticipante1, FiltroParticipante filtroParticipante2) {
        this.filtroParticipante1 = filtroParticipante1;
        this.filtroParticipante2 = filtroParticipante2;
    }

    @Override
    public Boolean filtrar(Participante participante) {
        return filtroParticipante1.filtrar(participante) && filtroParticipante2.filtrar(participante);
    }
}
