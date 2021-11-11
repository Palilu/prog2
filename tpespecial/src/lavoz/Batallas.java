package lavoz;

import java.util.Comparator;
import java.util.Optional;

public class Batallas {

    private Comparator<Participante> reglas;

    public Batallas(Comparator<Participante> reglas) {
        this.reglas = reglas;
    }

    public void setReglas(Comparator<Participante> reglas) {
        this.reglas = reglas;
    }

    public Optional<Participante> obtenerGanador(Participante p1, Participante p2) {
        int resultado = reglas.compare(p1, p2);
        return resultado == 0 ? Optional.empty() : Optional.of(resultado > 0 ? p1 : p2);
    }
}
