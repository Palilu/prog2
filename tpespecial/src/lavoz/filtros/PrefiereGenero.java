package lavoz.filtros;

import lavoz.Participante;

public class PrefiereGenero implements FiltroParticipante {

    private String genero;

    public PrefiereGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public Boolean filtrar(Participante participante) {
        return participante.getGeneros().contains(genero);
    }
}
