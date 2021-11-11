package lavoz.comparadores;

import lavoz.Participante;

import java.util.Comparator;

public class PorCantidadDeIdiomas implements Comparator<Participante> {

    @Override
    public int compare(Participante o1, Participante o2) {
        return o1.getIdiomas().size() - o2.getIdiomas().size();
    }
}
