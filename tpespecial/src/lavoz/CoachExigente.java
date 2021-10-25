package lavoz;

import lavoz.filtros.FiltroParticipante;

public class CoachExigente extends Coach {

    private FiltroParticipante filtro;

    public CoachExigente(String nombre, FiltroParticipante filtroParticipante) {
        super(nombre);
        this.filtro = filtroParticipante;
    }

    @Override
    public void agregar(Participante participante) {
        if (filtro.filtrar(participante)) {
            super.agregar(participante);
        }
    }

    public void setFiltro(FiltroParticipante filtro) {
        this.filtro = filtro;
    }
}
