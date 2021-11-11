package lavoz.comparadores;

import lavoz.Participante;

import java.util.Comparator;

public class PorCantidadDeInstrumentos implements Comparator<Participante> {

    @Override
    public int compare(Participante o1, Participante o2) {
        return o1.getInstrumentos().size() - o2.getInstrumentos().size();
    }
}
