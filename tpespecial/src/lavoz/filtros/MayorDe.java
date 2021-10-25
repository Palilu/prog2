package lavoz.filtros;

import lavoz.Participante;

public class MayorDe implements FiltroParticipante {

    private Integer edad;

    public MayorDe(Integer edad) {
        this.edad = edad;
    }

    @Override
    public Boolean filtrar(Participante participante) {
        return participante.getEdad().compareTo(edad) > 0;
    }
}
