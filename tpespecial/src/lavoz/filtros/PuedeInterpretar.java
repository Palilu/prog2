package lavoz.filtros;

import lavoz.Participante;
import lavoz.Tema;

/**
 * Puedan Interpretar un determinado Tema Musical
 */
public class PuedeInterpretar implements FiltroParticipante {

    private Tema tema;

    public PuedeInterpretar(Tema tema) {
        this.tema = tema;
    }

    @Override
    public Boolean filtrar(Participante participante) {
        return tema.puedeSerInterpretadoPor(participante);
    }
}
