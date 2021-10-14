package parcialito;

import parcialito.criterias.Comparators;
import parcialito.filters.Filters;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company company = setUpCompany();
        LocalDate from = LocalDate.now().minusDays(6);
        LocalDate to = LocalDate.now();
        // La empresa desea armar un ranking periódico de mejores vendedores, según las ganancias
        // totales por ventas en el período. Para esto, dadas una fecha inicial y una fecha final, se
        // calculan las ganancias por ventas de cada vendedor (monto al que se vendió el producto *
        // cantidad de productos) y se arma el ranking de los mejores vendedores en base a ese total.
        System.out.println("Por defecto:");
        company.getSalesRanking(from, to).forEach(System.out::println);
        // La empresa considera que, a futuro y hasta nuevo aviso, puede desear variar la condición
        // por la que se arma el ranking de vendedores por lo que la solución debe ser lo
        // suficientemente flexible para, por ejemplo, poder armar el ranking por la cantidad total de
        // ventas en el período dado (independientemente de la cantidad de productos vendidos en cada una)
        System.out.println("Por precio total:");
        company.setRankingStrategy(Comparators.byPrice()); // Este cambio en la condición para el armado del ranking debe poder realizarse en tiempo de ejecución.
        company.getSalesRanking(from, to).forEach(System.out::println);
        // o por la cantidad total de productos vendidos (considerando la cantidad de productos en cada venta).
        System.out.println("Por cantidad total:");
        company.setRankingStrategy(Comparators.byQuantity());
        company.getSalesRanking(from, to).forEach(System.out::println);
        // Durante algunos períodos también desea poder premiar a
        // vendedores jóvenes y por lo tanto el ranking se calculará como una ponderación de la
        // cantidad total de ventas del período, dividido por la edad del vendedor.
        System.out.println("Por precio total sobre edad:");
        company.setRankingStrategy(Comparators.byPriceDividedByAge());
        company.getSalesRanking(from, to).forEach(System.out::println);
        // Otra alternativa de armado del ranking podría ser el ratio de ventas, que se calcula como el
        // monto total de ventas del período, dividido la cantidad de productos vendidos en el período.
        System.out.println("Radio de ventas:");
        company.setRankingStrategy(Comparators.salesRatio());
        company.getSalesRanking(from, to).forEach(System.out::println);

        //NOTA: el orden de los listados anteriores es siempre por edad y apellido y no va a cambiar
        //      a futuro. Se ordena alfabéticamente por edad (ascendente) y si hay dos vendedores con la
        //      misma edad, se ordenan por apellido (alfabéticamente, ascendente).

//        Comparator<SalesPerson> byAgeAndLastName = Comparator.comparing(SalesPerson::getAge)
//                .thenComparing(SalesPerson::getLname);
//        era porfiado el loco xD
//      TODO: Borrar todos esos comparadores precambricos una vez aprobada la materia
//       o abandonada la carrera para poder dormir en paz
        Comparator<SalesPerson> byAgeAndLastName = Comparators.firstThen(Comparators.byAge(), Comparators.byLastName());

        // La empresa también desea poder obtener un listado (ordenado por edad y apellido) de
        // todos los vendedores:
        // ● que vendieron menos de 50 productos en un período dado
        System.out.println("Filtro A:");
        company.getSalesPersons(Filters.moreSalesThan(50D), byAgeAndLastName)
                .forEach(System.out::println);
        // ● que generaron a la empresa ganancias por menos de $150.000
        System.out.println("Filtro B:");
        company.getSalesPersons(Filters.lessEarningsThan(150000D), byAgeAndLastName)
                .forEach(System.out::println);
        // ● que vendieron el producto con código “RAN780”
        System.out.println("Filtro C:");
        company.getSalesPersons(Filters.soldProductCode("RAN780"), byAgeAndLastName)
                .forEach(System.out::println);
        // ● que vendieron el producto con código “ADI4825” y generaron ganancias por menos
        // de $200.000 en un período dado (independientemente del producto vendido)
        System.out.println("Filtro D:");
        company.getSalesPersons(Filters.and(
                Filters.soldProductCode("ADI4825"),
                Filters.lessEarningsThan(200000D)
        ), byAgeAndLastName)
                .forEach(System.out::println);
        // ● Combinaciones lógicas de las formas de búsqueda reflejadas en los ejemplos anteriores
    }

    /**
     *  Una empresa de venta por catálogo desea premiar a
     *  sus mejores vendedores para estimular las ventas.
     *  De cada vendedor se registra su nombre, apellido, edad
     *  y la lista de productos vendidos. De cada producto
     *  vendido por un vendedor se registra la fecha de venta,
     *  el código del producto, el dni del comprador, el monto al
     *  que se vendió y la cantidad vendida de ese producto.
     *  Las ganancias por una venta se calculan como el monto
     *  al que se vendió el producto, por la cantidad de
     *  productos vendidos.
     */
    private static Company setUpCompany () {
        Product p1 = new Product(LocalDate.now().minusDays(5), "1", "a", 100D, 6);
        Product p2 = new Product(LocalDate.now().minusDays(4), "2", "b", 200D, 5);
        Product p3 = new Product(LocalDate.now().minusDays(3), "3", "c", 300D, 4);
        Product p4 = new Product(LocalDate.now().minusDays(2), "RAN780", "d", 400D, 3);
        Product p5 = new Product(LocalDate.now().minusDays(1), "ADI4825", "e", 500D, 2);
        SalesPerson s1 = new SalesPerson("Rachel", "Green", 30, List.of(p1, p2));
        SalesPerson s2 = new SalesPerson("Monica", "Geller", 32, List.of(p3, p4));
        SalesPerson s3 = new SalesPerson("Phoebe", "Buffay", 31, List.of(p5));

        Company company = new Company();
        company.add(s1);
        company.add(s2);
        company.add(s3);
        return company;
    }
}
