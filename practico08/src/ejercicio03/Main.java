package ejercicio03;

import ejercicio03.comparators.FieldRentedNumberComparator;
import ejercicio03.filters.Filters;
import ejercicio03.seach.Searchs;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

/**
 * Un club de futbol 5 necesita un sistema que le permita llevar control de sus socios y
 * alquileres de canchas. Cada socio posee un nombre y apellido, una edad, si tiene paga la
 * última cuota y una lista que contiene información de los alquileres de canchas que ha
 * realizado. Cuando un socio alquila una cancha, se registra la fecha, el ID de la cancha que
 * alquiló y cuánto pagó por el alquiler.
 * Cuando el dueño del club arriba al predio, le pide a los que administran el sistema, diferentes
 * listados, para comprobar cómo está funcionando el club:
 *
 * a) Todas los socios con cuota impaga, ordenados alfabéticamente (primero por
 * apellido, y si hay varios con el mismo apellido por nombre)
 * b) Todos los socios menores de edad, ordenados por edad
 * c) Todos los socios que alquilaron alguna vez la cancha N°13, ordenados cantidad
 * total de alquileres de esa cancha.
 * d) Todos los socios que pagaron más de $500 por algún alquiler de cancha, listando
 * primero los que tienen las cuotas pagas, ordenados alfabéticamente y luego los
 * morosos, también ordenados alfabéticamente.
 * e) Cualquier combinación lógica de búsquedas.
 */
public class Main {

    public static void main(String[] args) {
        Member m1 = new Member("John", "Lennon", 27, false, List.of(new FieldRent(11, LocalDate.now(), 600D)));
        Member m2 = new Member("John", "Carpenter", 32, false, List.of(new FieldRent(13, LocalDate.now(), 1000D)));
        Member m3 = new Member("John", "Baptist", 36, false, List.of(new FieldRent(11, LocalDate.now(), 400D)));
        Member m4 = new Member("John", "Wick", 17, true, List.of(new FieldRent(13, LocalDate.now(), 1000D), new FieldRent(13, LocalDate.now().minusDays(1), 900D)));
        Member m5 = new Member("John", "Petit", 8, true, List.of(new FieldRent(11, LocalDate.now(), 501D)));

        List<Member> members = List.of(m1, m2, m3, m4, m5);

        //a) Todas los socios con cuota impaga, ordenados alfabéticamente (primero por
        // apellido, y si hay varios con el mismo apellido por nombre)
        System.out.println("Search A:");
        Searchs.sorted(Searchs.filtered(Filters.inDebt()),
                Comparator.comparing(Member::getFname).thenComparing(Member::getLname))
            .search(members).forEach(System.out::println);
        // b) Todos los socios menores de edad, ordenados por edad
        System.out.println("Search B:");
        Searchs.sorted(Searchs.filtered(Filters.minor()),
                Comparator.comparing(Member::getAge))
            .search(members).forEach(System.out::println);
        // c) Todos los socios que alquilaron alguna vez la cancha N°13, ordenados cantidad
        // * total de alquileres de esa cancha.
        System.out.println("Search C:");
        Searchs.sorted(Searchs.filtered(Filters.rentedFieldNumber(13)),
                new FieldRentedNumberComparator(13))
            .search(members).forEach(System.out::println);
        // d) Todos los socios que pagaron más de $500 por algún alquiler de cancha, listando
        //        * primero los que tienen las cuotas pagas, ordenados alfabéticamente y luego los
        // * morosos, también ordenados alfabéticamente.
        System.out.println("Search D:");
        Comparator<Member> fullNameComparator = Comparator.comparing(Member::getFname).thenComparing(Member::getLname);
        Searchs.or(
                Searchs.sorted(
                        Searchs.and(
                                Searchs.filtered(Filters.paidMoreThan(500D)),
                                Searchs.not(
                                        Searchs.filtered(Filters.inDebt())
                                )
                        ), fullNameComparator),
                Searchs.sorted(
                        Searchs.and(
                                Searchs.filtered(Filters.paidMoreThan(500D)),
                                Searchs.filtered(Filters.inDebt())
                        ), fullNameComparator)
        ).search(members).forEach(System.out::println);
        // e) Cualquier combinación lógica de búsquedas.
    }
}
