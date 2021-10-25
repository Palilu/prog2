package lavoz.filtros;

import lavoz.Participante;

public class TocaInstrumento implements FiltroParticipante {

    private String instrumento;

    public TocaInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public Boolean filtrar(Participante participante) {
        return participante.getInstrumentos().contains(instrumento);
    }
}
