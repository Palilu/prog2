package parcial.filters;

import java.time.LocalDate;

/**
 * Se desea brindar listados en los cuales se incluyan todos los paquetes que ofrezca la empresa y que
 *  * cumplan con determinado criterio. A continuación se listan algunos ejemplos.
 *  * a) Listar todos los paquetes cuyo origen sea “Buenos Aires” y cuyo destino sea “Bariloche” ,
 *  * ordenados por costo del paquete.
 *  * b) Listar todos los paquetes cuyo origen sea “Barcelona”, ordenados por ciudad de destino, y luego
 *  * por identificador, si hay más de un paquete con la misma ciudad de destino.
 *  * c) Listar todos los paquetes con costo mayor a $200.000, ordenados por costo y, si hay dos
 *  * paquetes con el mismo costo, y luego por fecha acordada de pago (los que no tienen fecha
 *  * acordada deben ir a lo último).
 *  * d) Listar todos los paquetes con fecha acordada 25 de Mayo de 2022, ordenados por costo y, si hay
 *  * dos paquetes con el mismo costo, y luego por cantidad de pasajeros.
 *  * e) Se pueden agregar nuevos tipos de búsquedas así como también combinaciones lógicas de las
 *  * mismas. Los criterios de ordenamiento también pueden variar y deben poder combinarse de
 *  * cualquier manera.
 *  * NOTA: Si un paquete Súperviaje cumple con los requisitos de la búsqueda, se incluye él mismo en los
 *  * resultados y no los sub-paquetes que lo componen. En caso de que el paquete Súperviaje no cumpla
 *  * con el criterio se deben retornar los paquetes que lo componen que sí cumplan.
 *  * Machete LEGAL
 */
public class Filters {

    public static TripFilter from(String from) {
        return new FilterFrom(from);
    }

    public static TripFilter to(String to) {
        return new FilterTo(to);
    }

    public static TripFilter costMoreThan(Double amount) {
        return new FilterCostMoreThan(amount);
    }

    public static TripFilter agreedPaymentDate(LocalDate paymentDate) {
        return new FilterArreedPaymentDate(paymentDate);
    }

    public static TripFilter and(TripFilter a, TripFilter b) {
        return new FilterAnd(a, b);
    }

    public static TripFilter or(TripFilter a, TripFilter b) {
        return new FilterOr(a, b);
    }

    public static TripFilter not(TripFilter a) {
        return new FilterNot(a);
    }
}
