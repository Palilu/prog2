package lavoz.comparadores;

import lavoz.Participante;

import java.util.Comparator;

public class PorCantidadDeGeneros implements Comparator<Participante> {

    @Override
    public int compare(Participante o1, Participante o2) {
        return o1.getGeneros().size() - o2.getGeneros().size();
    }
}
