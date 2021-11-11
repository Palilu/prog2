package lavoz;

import lavoz.comparadores.Comparadores;
import lavoz.filtros.Filtros;
import lavoz.filtros.FiltroParticipante;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Continuando con la implementación del reality de canto en esta segunda parte se agrega a lo
 * realizado en la primera parte las siguientes características.
 *
 * Los participantes pueden estar organizados en grupos y bandas, un grupo
 * o banda posee una lista de miembros que los componen (pueden ser
 * integrantes o incluso sub bandas). Una banda o grupo posee un nombre, y
 * una edad (la cual se calcula como el promedio de las edades de cada uno
 * de sus miembros). Los géneros de preferencia se calculan como la
 * intersección de los géneros de preferencia de todos sus miembros. Por
 * ejemplo si un grupo tienen dos miembros A y B, el integrante A tiene
 * preferencias {g1,g2,g3,g4} y el integrante B las preferencias {g1,g4,g7,g11}
 * el grupo tendrá como preferencias de géneros {g1, g4}. En el caso de los
 * idiomas que pueden interpretar una banda o grupo se considera la unión
 * de los idiomas de todos sus miembros (no pueden existir repetidos), lo
 * mismo ocurre para los instrumentos que puede tocar una banda.
 * Ahora cada coach/jurado tiene un listado de participantes asignados como equipo propio, este listado
 * puede incluir Bandas, Grupos o Integrantes solistas.
 * Para una mejor organización, cada coach/jurado desea poder obtener:
 * ● Un listado de todos los instrumentos que pueden tocar los participantes de su equipo (no
 * debe haber repetidos)
 * ● Un listado de todos los idiomas que pueden cantar los participantes de su equipo (sin idiomas
 * repetidos)
 * ● Un listado de géneros de preferencia de los participantes de su equipo (sin repetidos y
 * ordenados alfabéticamente)
 * ● El promedio de edad de su equipo
 * Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes
 * integrantes, bandas o grupos que :
 * ● Canten en un determinado idioma, por ejemplo “inglés”
 * ● Prefieren un determinado género, por ejemplo “rock”.
 * ● Canten en un determinado idioma y toquen un instrumento específico. Por ejemplo, “Aleman”
 * y “Guitarra”
 * ● Todos los participantes mayores de una determinada edad.
 * ● Puedan Interpretar un determinado Tema Musical
 * ● Los anteriores son algunos ejemplos de los listados que la producción le pide
 * constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así
 * como combinación lógicas de los existentes.
 * Aclaraciones sobre la búsqueda de participantes:
 * 1. Si una banda o grupo cumple con lo que está buscando el jurado, se debe retornar la banda
 * o el grupo entero (respetando la organización interna de grupos y subgrupos)
 * 2. Si una banda o grupo NO cumple con lo que está buscando el jurado, se buscan posibles
 * miembros de la banda que sí cumplan y se retorna a estos miembros.
 * 3. El mecanismo anterior se repite en cada nivel organizativo que tenga la banda o grupo.
 * 4. Un tema puede ser interpretado por una banda/grupo/solista si puede cantar en el idioma del
 * tema y al menos uno de los géneros está entre las preferencias del grupo/banda/solista.Sin
 * embargo, para los temas de la final se debe chequear además de lo anterior que la
 *
 * Tecnicatura en Desarrollo de Aplicaciones Informáticas (TUDAI)
 *
 * Trabajo Práctico Especial 2021
 * Segunda Parte
 *
 * _________________________________________________________________________
 * banda/grupo/solista posea al menos un miembro que toque un instrumento de los necesarios
 * para interpretar el tema. Este requisito es más restrictivo para otros temas, que requieren, por
 * ejemplo, 2 miembros o incluso 3, que sepan tocar algún instrumento necesario para
 * interpretar el tema.
 * El jurado exigente sigue existiendo solo que ahora solo permite agregar a su equipo participantes
 * (solistas, grupos o bandas) que al menos toquen un determinado instrumento, conozcan ciertos
 * idiomas y/o prefieran un determinado género. Por ejemplo, sólo permite agregar participantes que
 * toquen la batería, puedan cantar en español e inglés, y que prefieran “pop”. Es posible que este
 * jurado cambie en tiempo de ejecución su restricción para aceptar participantes, aunque los
 * participantes ya aceptados no se eliminan si cambia su preferencia por nuevos participantes.
 * Batallas
 * Una batalla implica que dos participantes (sea banda, grupo
 * o solista) se enfrenten entre sí (puede ser incluso un solista
 * contra una banda). Si un participante gana una batalla contra
 * otro participante se retorna 1, en el caso de empate un 0 y
 * en el caso de que pierda un -1. Como la producción es
 * medio caprichosa existen diferentes formas de poder
 * determinar si un participante gana una batalla, que la
 * producción puede cambiar en cualquier momento
 * dependiendo del rating que está teniendo el programa:
 * ● Si la cantidad de instrumentos que toca es mayor
 * que la de su oponente.
 * ● Si la cantidad de géneros preferidos es menor que la
 * de su oponente.
 * ● Si la cantidad de instrumentos que toca es mayor a
 * la de su rival, y en caso de ser iguales se desempata
 * por que que tiene mayor edad
 * ● Si la edad es mayor que la de su oponente y en
 * caso de empate se decide por quién sabe más idiomas que su oponente.
 * Los anteriores son algunos ejemplos de batallas entre dos participantes, puede ser incluso que haya
 * más de dos formas encadenadas, es decir que si las dos primeras dan empate se decide por una
 * tercera forma. Se debe proveer un mecanismo que permita que en el concurso se enfrenten dos
 * participantes y se determine el ganador acorde a la forma de la batalla que se esté utilizando en ese
 * momento.
 * Como los jurados no quieren perder una desean poder contar con un mecanismo que les permita
 * dada la forma actual que se va a utilizar para determinar el ganador de una batalla, obtener un listado
 * de sus participantes ordenado de forma tal que los primeros miembros del listado sean los que les
 * ganen o empaten con los siguientes miembros (siempre dentro del mismo equipo del juez).
 *
 */
public class Main {

    public static void main(String[] args) {

        Participante p1 = new Solista("Pedro", "Gomez", 25,
                Set.of("folklore", "balada"), Set.of("español"), Set.of("guitarra"));
        Participante p2 = new Solista("Adele", "Petunia", 20,
                Set.of("r&b", "balada", "pop", "rock", "reggeaton", "trap"), Set.of("español", "inglés"), Set.of("batería"));
        Participante p3 = new Solista("Johan Sebastian", "Mastropiero", 96,
                Set.of("clásico", "rock", "jazz"), Set.of("español", "inglés", "alemán"), Set.of("piano", "guitarra", "contrabajo"));

        Coach lali = new Coach("Lali");
        lali.agregar(p1);
        lali.agregar(p2);
        lali.agregar(p3);

        System.out.println("Los intrumentos del equipo de Lali son: " + lali.obtenerInstrumentosEquipo());
        System.out.println("Los idiomas del equipo de Lali son: " + lali.obtenerIdiomasEquipo());
        System.out.println("Los generos del equipo de Lali son: " + lali.obtenerGenerosEquipo());
        System.out.println("El promedio de edad del equipo Lali es: " + lali.obtenerPromedioEdadEquipo());

        FiltroParticipante cantaIngles = Filtros.cantaIdioma("inglés");
        System.out.println("Los que cantan inglés son: ");
        lali.buscar(cantaIngles).forEach(System.out::println);
        // Todos los participantes que prefieran un determinado género, por ejemplo “rock”.
        FiltroParticipante prefiereRock = Filtros.prefiereGenero("rock");
        System.out.println("Los que prefieren rock son: ");
        lali.buscar(prefiereRock).forEach(System.out::println);
        // Todos los participantes que canten en un determinado idioma y toquen un instrumento
        // específico. Por ejemplo, “Aleman” y “Guitarra”
        FiltroParticipante cantaAleman = Filtros.cantaIdioma("alemán");
        FiltroParticipante tocaGuitarra = Filtros.tocaInstrumento("guitarra");
        FiltroParticipante cantaAlemanYTocaGuitarra = Filtros.and(cantaAleman, tocaGuitarra);
        System.out.println("Los que cantan aleman y tocan guitarra son: ");
        lali.buscar(cantaAlemanYTocaGuitarra).forEach(System.out::println);
        // Todos los participantes que toquen “guitarra” y prefieran el género “balada” o que canten en “inglés”.
        FiltroParticipante prefiereBalada = Filtros.prefiereGenero("balada");
        FiltroParticipante todoEso = Filtros.or(Filtros.and(tocaGuitarra, prefiereBalada), cantaIngles);
        System.out.println("Los que (tocan guitarra y prefieren balada) o cantan en inglés son: ");
        lali.buscar(todoEso).forEach(System.out::println);
        // Todos los participantes mayores de una determinada edad.
        FiltroParticipante mayorDe21 = Filtros.mayorDe(21);
        System.out.println("Los mayores de 21 son: ");
        lali.buscar(mayorDe21).forEach(System.out::println);
        //Los anteriores son algunos ejemplos de los listados que la producción le pide
        //constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así
        //como combinación lógicas de los existentes.


        // El jurado exigente sigue existiendo solo que ahora solo permite agregar a su equipo participantes
        // (solistas, grupos o bandas) que al menos toquen un determinado instrumento, conozcan ciertos
        // idiomas y/o prefieran un determinado género. Por ejemplo, sólo permite agregar participantes que
        // toquen la batería, puedan cantar en español e inglés, y que prefieran “pop”.
        FiltroParticipante tocaBateria = Filtros.tocaInstrumento("batería");
        FiltroParticipante cantaEspaniol = Filtros.cantaIdioma("español");
        FiltroParticipante prefierePop = Filtros.prefiereGenero("pop");
        FiltroParticipante todoEsto = Filtros.and(tocaBateria, Filtros.and(Filtros.and(cantaEspaniol, cantaIngles), prefierePop));
        CoachExigente montaner = new CoachExigente("Montaner", todoEsto);
        System.out.println("Los que acepta montaner son: ");
        montaner.agregar(p1);
        montaner.agregar(p2);
        montaner.agregar(p3);
        montaner.imprimirEquipo();
        // Es posible que este jurado cambie en tiempo de ejecución su restricción para aceptar participantes, aunque
        // los participantes ya aceptados no se eliminan si cambia su preferencia por nuevos participantes.
        montaner.setFiltro(cantaAleman);
        montaner.agregar(p1);
        montaner.agregar(p3);
        System.out.println("Los que acepta montaner despues de bajar sus exigencias en tiempo de ejecucion son: ");
        montaner.imprimirEquipo();
        // Batallas
        // Una batalla implica que dos participantes (sea banda, grupo o solista) se enfrenten entre sí
        // (puede ser incluso un solista contra una banda). Si un participante gana una batalla contra
        // otro participante se retorna 1, en el caso de empate un 0 y en el caso de que pierda un -1.
        // Como la producción es medio caprichosa existen diferentes formas de poder determinar si un
        // participante gana una batalla, que la producción puede cambiar en cualquier momento
        // dependiendo del rating que está teniendo el programa:
        //● Si la cantidad de instrumentos que toca es mayor que la de su oponente.
        Comparator<Participante> reglasBatalla1 = Comparadores.porCantidadDeInstrumentos();
        //● Si la cantidad de géneros preferidos es menor que la de su oponente.
        Comparator<Participante> reglasBatalla2 = Comparadores.porCantidadDeGeneros().reversed();
        //● Si la cantidad de instrumentos que toca es mayor a la de su rival,
        // y en caso de ser iguales se desempata por que que tiene mayor edad
        Comparator<Participante> reglasBatalla3 = Comparadores.porEstoLuegoAquello(
                Comparadores.porCantidadDeInstrumentos(), Comparadores.porEdad());
        //● Si la edad es mayor que la de su oponente y en caso de empate se decide por quién sabe más idiomas que su oponente.
        Comparator<Participante> reglasBatalla4 = Comparadores.porEstoLuegoAquello(
                Comparadores.porEdad(), Comparadores.porCantidadDeIdiomas());

        // Los anteriores son algunos ejemplos de batallas entre dos participantes, puede ser incluso que haya
        // más de dos formas encadenadas, es decir que si las dos primeras dan empate se decide por una
        // tercera forma. Se debe proveer un mecanismo que permita que en el concurso se enfrenten dos
        // participantes y se determine el ganador acorde a la forma de la batalla que se esté utilizando en ese
        // momento.
        System.out.println("Round 1, Pedro contra Adele:");
        Batallas batallas = new Batallas(reglasBatalla1);
        System.out.println("El ganador de la batalla 1 es " + imprimir(batallas.obtenerGanador(p1, p2)));
        batallas.setReglas(reglasBatalla2);
        System.out.println("El ganador de la batalla 2 es " + imprimir(batallas.obtenerGanador(p1, p2)));
        batallas.setReglas(reglasBatalla3);
        System.out.println("El ganador de la batalla 3 es " + imprimir(batallas.obtenerGanador(p1, p2)));
        batallas.setReglas(reglasBatalla4);
        System.out.println("El ganador de la batalla 4 es " + imprimir(batallas.obtenerGanador(p1, p2)));
        System.out.println("Round 2, Pedro contra Johan Sebastian:");
        batallas.setReglas(reglasBatalla1);
        System.out.println("El ganador de la batalla 1 es " + imprimir(batallas.obtenerGanador(p1, p3)));
        batallas.setReglas(reglasBatalla2);
        System.out.println("El ganador de la batalla 2 es " + imprimir(batallas.obtenerGanador(p1, p3)));
        batallas.setReglas(reglasBatalla3);
        System.out.println("El ganador de la batalla 3 es " + imprimir(batallas.obtenerGanador(p1, p3)));
        batallas.setReglas(reglasBatalla4);
        System.out.println("El ganador de la batalla 4 es " + imprimir(batallas.obtenerGanador(p1, p3)));
        // Pedro y Adele arman una banda para poder ganarle a Johan Sebastian
        Participante p4 = new Banda("Los Salieris De Johan Sebastian", List.of(p1, p2));
        System.out.println("Round 3, Los Salieris de Johan Sebastian vs Johan Sebastian:");
        batallas.setReglas(reglasBatalla1);
        System.out.println("El ganador de la batalla 1 es " + imprimir(batallas.obtenerGanador(p4, p3)));
        batallas.setReglas(reglasBatalla2);
        System.out.println("El ganador de la batalla 2 es " + imprimir(batallas.obtenerGanador(p4, p3)));
        batallas.setReglas(reglasBatalla3);
        System.out.println("El ganador de la batalla 3 es " + imprimir(batallas.obtenerGanador(p4, p3)));
        batallas.setReglas(reglasBatalla4);
        System.out.println("El ganador de la batalla 4 es " + imprimir(batallas.obtenerGanador(p4, p3)));

        // Como los jurados no quieren perder una desean poder contar con un mecanismo que les permita
        // dada la forma actual que se va a utilizar para determinar el ganador de una batalla, obtener un listado
        // de sus participantes ordenado de forma tal que los primeros miembros del listado sean los que les
        // ganen o empaten con los siguientes miembros (siempre dentro del mismo equipo del jurado).
        System.out.println("Por cantidad de instrumentos");
        montaner.obtenerEquipoOrdenadoParaLaBatalla(reglasBatalla1.reversed()).forEach(System.out::println);
        System.out.println("Por géneros (de menor a mayor)");
        montaner.obtenerEquipoOrdenadoParaLaBatalla(reglasBatalla1.reversed()).forEach(System.out::println);

        // Aclaraciones sobre la búsqueda de participantes:
        // 1. Si una banda o grupo cumple con lo que está buscando el jurado, se debe retornar la banda
        // o el grupo entero (respetando la organización interna de grupos y subgrupos)
        Coach rickAndMorty = new Coach("Rick and Morty");
        rickAndMorty.agregar(p3);
        rickAndMorty.agregar(p4); // Rick y Morty agregan a Johan Sebastian y a los Salieris del mismo
        System.out.println("Los mayores de 21 de Rick and Morty");
        rickAndMorty.buscar(Filtros.mayorDe(21)).forEach(System.out::println); // Aparecen los Salieris
        // 2. Si una banda o grupo NO cumple con lo que está buscando el jurado, se buscan posibles
        // * miembros de la banda que sí cumplan y se retorna a estos miembros.
        System.out.println("Los mayores de 22 de Rick and Morty");
        rickAndMorty.buscar(Filtros.mayorDe(22)).forEach(System.out::println); // Al dejar de aparecer los Salieris aparece pedro que si es mayor de 22
        // 3. El mecanismo anterior se repite en cada nivel organizativo que tenga la banda o grupo.
        // 4. Un tema puede ser interpretado por una banda/grupo/solista si puede cantar en el idioma del
        // tema y al menos uno de los géneros está entre las preferencias del grupo/banda/solista.Sin
        // embargo, para los temas de la final se debe chequear además de lo anterior que la
        // banda/grupo/solista posea al menos un miembro que toque un instrumento de los necesarios
        // para interpretar el tema. Este requisito es más restrictivo para otros temas, que requieren, por
        // ejemplo, 2 miembros o incluso 3, que sepan tocar algún instrumento necesario para
        // interpretar el tema.
        Tema temaDeFinal = new TemaDeFinal("After the storm", "inglés", List.of("r&b", "hip hop", "pop"), List.of("teclado"), 1);
        System.out.println("Tema de final");
        rickAndMorty.buscar(Filtros.puedeInterpretar(temaDeFinal)).forEach(System.out::println);
        // Dado que nadie puede interpretar el tema de final se decide crear a un Johan Sebastian
        // Cybernetico, ahora además de su virtuosismo y talento es joven, canchero y escribe hits del verano
        Participante p5 = new Solista("Johan Sebastian", "2.0", 1,
                Set.of("r&b", "hip hop", "pop"), Set.of("español", "inglés", "alemán"), Set.of("piano", "guitarra", "teclado", "contrabajo"));
        rickAndMorty.agregar(p5);
        System.out.println("Tema de final, segundo intento");
        rickAndMorty.buscar(Filtros.puedeInterpretar(temaDeFinal)).forEach(System.out::println);
    }

    private static String imprimir(Optional<Participante> participante) {
        return participante.isPresent() ? participante.toString() : "nadie";
    }
}
