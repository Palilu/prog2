package lavoz.comparadores;

import lavoz.Participante;

import java.util.Comparator;

public class PorEstoLuegoAquello implements Comparator<Participante> {

    private Comparator<Participante> esto, aquello;

    public PorEstoLuegoAquello(Comparator<Participante> esto, Comparator<Participante> aquello) {
        this.esto = esto;
        this.aquello = aquello;
    }

    @Override
    public int compare(Participante o1, Participante o2) {
        int resEsto = esto.compare(o1, o2);
        return resEsto == 0 ? aquello.compare(o1, o2) : resEsto;
    }
}
