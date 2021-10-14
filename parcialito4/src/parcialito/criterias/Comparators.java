package parcialito.criterias;

import parcialito.SalesPerson;

import java.util.Comparator;

/**
 * Un catálogo de comparadores
 */
public class Comparators {

    /**
     * se calculan las ganancias por ventas de cada vendedor
     * (monto al que se vendió el producto * cantidad de productos)
     */
    public static Comparator<SalesPerson> byEarnings() {
        return new EarningsComparator();
    }

    /**
     * armar el ranking por la cantidad total de ventas en el período dado
     * (independientemente de la cantidad de productos vendidos en cada una)
     */
    public static Comparator<SalesPerson> byPrice() {
        return new PriceComparator();
    }

    /**
     * o por la cantidad total de productos vendidos
     * (considerando la cantidad de productos en cada venta)
     */
    public static Comparator<SalesPerson> byQuantity() {
        return new QuantityComparator();
    }

    /**
     * Durante algunos períodos también desea poder premiar a vendedores jóvenes y por lo tanto
     * el ranking se calculará como una ponderación de la cantidad total de ventas del período,
     * dividido por la edad del vendedor.
     */
    public static Comparator<SalesPerson> byPriceDividedByAge() {
        return new PriceByAgeComparator();
    }

    /**
     * Otra alternativa de armado del ranking podría ser el ratio de ventas, que se calcula como el monto total de
     * ventas del período, dividido la cantidad de productos vendidos en el período.
     */
    public static Comparator<SalesPerson> salesRatio() {
        return new SalesRatioComparator();
    }

    /**
     * ordenados por apellido
     */
    public static Comparator<SalesPerson> byLastName() {
        return new LastNameComparator();
    }

    /**
     * ordenados por edad
     */
    public static Comparator<SalesPerson> byAge() {
        return new AgeComparator();
    }

    /**
     * Comparador compuesto
     */
    public static Comparator<SalesPerson> firstThen(Comparator<SalesPerson> first, Comparator<SalesPerson> then) {
        return new ThenComparator(first, then);
    }
}
