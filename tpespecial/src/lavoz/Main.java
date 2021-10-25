package lavoz;

import lavoz.filtros.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Dado el reciente éxito de los realities, en especial el último de canciones, un
 * canal de la competencia (cuya identidad no podemos revelar) decidió armar su
 * propio reality de canto. Para poder organizarse mejor y facilitar la tarea de
 * selección de participantes, armado de equipos y demás menesteres, la
 * producción de dicho canal encargó la realización de un sistema para la
 * apropiada administración del reality.
 * En el reality participan un conjunto de coaches, que a su vez juegan el rol de
 * jurados, y un conjunto de participantes. La producción también almacena un
 * conjunto de temas musicales que pueden ser cantados durante el reality.
 *
 * Durante el reality, se organizan batallas para decidir quién es expulsado del concurso en cada ronda
 * 1
 * .
 * Para poder organizar cada batalla, la producción del programa le pide a cada jurado que seleccione
 * un participante de su equipo para cantar un determinado tema musical. Para esto y acorde al avance
 * del programa se van solicitando a los jurados que busquen:
 *
 */
public class Main {

    public static void main(String[] args) {

        Participante p1 = new Participante("Pedro", "Gomez", 25,
                List.of("folklore", "balada"), List.of("español"), Set.of("guitarra"));
        Participante p2 = new Participante("Adele", "Petunia", 20,
                List.of("r&b", "pop", "rock", "reggeaton", "trap"), List.of("español", "inglés"), Set.of("batería"));
        Participante p3 = new Participante("Johan Sebastian", "Mastropiero", 96,
                List.of("clásico", "rock", "jazz"), List.of("español", "inglés", "alemán"), Set.of("piano", "guitarra", "contrabajo"));

        Coach c1 = new Coach("Lali");
        c1.agregar(p1);
        c1.agregar(p2);
        c1.agregar(p3);

        System.out.println("Los intrumentos del equipo de Lali son: " + c1.obtenerInstrumentosEquipo());
        System.out.println("Los idiomas del equipo de Lali son: " + c1.obtenerIdiomasEquipo());
        System.out.println("Los generos del equipo de Lali son: " + c1.obtenerGenerosEquipo());
        System.out.println("El promedio de edad del equipo Lali es: " + c1.obtenerPromedioEdadEquipo());

        // Todos los participantes que canten en un determinado idioma, por ejemplo “inglés”.
        FiltroParticipante cantaIngles = new CantaIdioma("inglés");
        System.out.println("Los que cantan inglés son: ");
        c1.buscar(cantaIngles).forEach(System.out::println);
        // Todos los participantes que prefieran un determinado género, por ejemplo “rock”.
        FiltroParticipante prefiereRock = new PrefiereGenero("rock");
        System.out.println("Los que prefieren rock son: ");
        c1.buscar(prefiereRock).forEach(System.out::println);
        // Todos los participantes que canten en un determinado idioma y toquen un instrumento
        // específico. Por ejemplo, “Aleman” y “Guitarra”
        FiltroParticipante cantaAleman = new CantaIdioma("alemán");
        FiltroParticipante tocaGuitarra = new TocaInstrumento("guitarra");
        FiltroParticipante cantaAlemanYTocaGuitarra = new FiltroAnd(cantaAleman, tocaGuitarra);
        System.out.println("Los que cantan aleman y tocan guitarra son: ");
        c1.buscar(cantaAlemanYTocaGuitarra).forEach(System.out::println);
        // Todos los participantes que toquen “guitarra” y prefieran el género “balada” o que canten en “inglés”.
        FiltroParticipante prefiereBalada = new PrefiereGenero("balada");
        FiltroParticipante todoEso = new FiltroOr(new FiltroAnd(tocaGuitarra, prefiereBalada), cantaIngles);
        System.out.println("Los que (tocan guitarra y prefieren balada) o cantan en inglés son: ");
        c1.buscar(todoEso).forEach(System.out::println);
        // Todos los participantes mayores de una determinada edad.
        FiltroParticipante mayorDe21 = new MayorDe(21);
        System.out.println("Los mayores de 21 son: ");
        c1.buscar(mayorDe21).forEach(System.out::println);
        //Los anteriores son algunos ejemplos de los listados que la producción le pide
        //constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así
        //como combinación lógicas de los existentes.


        // Uno de los jurados se puso exigente y solo permite agregar a su equipo participantes que al menos
        // toquen un determinado instrumento, conozcan ciertos idiomas y prefieran un determinado género.
        // Puntualmente, solo permite agregar participantes que toquen la batería, puedan cantar en español e
        // inglés, y que prefieran “pop”.
        FiltroParticipante tocaBateria = new TocaInstrumento("batería");
        FiltroParticipante cantaEspaniol = new CantaIdioma("español");
        FiltroParticipante prefierePop = new PrefiereGenero("pop");
        FiltroParticipante todoEsto = new FiltroAnd(tocaBateria, new FiltroAnd(cantaEspaniol, prefierePop));
        CoachExigente montaner = new CoachExigente("Montaner", todoEsto);
        System.out.println("Los que acepta montaner son: ");
        montaner.agregar(p1);
        montaner.agregar(p2);
        montaner.agregar(p3);
        montaner.imprimirEquipo();
        // Es posible que este jurado cambie en tiempo de ejecución su
        // restricción para aceptar participantes, aunque los participantes ya aceptados no se eliminan si
        // cambia su preferencia por nuevos participantes.
        montaner.setFiltro(cantaAleman);
        montaner.agregar(p1);
        montaner.agregar(p3);
        System.out.println("Los que acepta montaner despues de bajar sus exigencias en tiempo de ejecucion son: ");
        montaner.imprimirEquipo();

    }
}
