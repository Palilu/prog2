package lavoz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TemaDeFinal extends Tema {

    private Integer cantidatDeInterpretes;

    public TemaDeFinal(String titulo, 
                       String idioma, 
                       List<String> generos, 
                       List<String> instrumentos,
                       Integer cantidadDeInterpretes) {
        super(titulo, idioma, generos, instrumentos);
        this.cantidatDeInterpretes = cantidadDeInterpretes;
    }

    @Override
    public Boolean puedeSerInterpretadoPor(Participante participante) {
        // para los temas de la final se debe chequear además de lo anterior que la
        // banda/grupo/solista posea al menos un miembro que toque un instrumento de los necesarios
        // para interpretar el tema. Este requisito es más restrictivo para otros temas, que requieren, por
        // ejemplo, 2 miembros o incluso 3, que sepan tocar algún instrumento necesario para
        // interpretar el tema.
        return super.puedeSerInterpretadoPor(participante) ? tieneInterpretesNecesarios(participante) : false;
    }

    private Boolean tieneInterpretesNecesarios(Participante participante) {
        Set<String> interseccion = new HashSet<>(getInstrumentos());
        interseccion.retainAll(participante.getInstrumentos());
        return interseccion.size() >= cantidatDeInterpretes;
    }
}
