package parcialito.filters;

/**
 * Un catálogo de filtros
 */
public class Filters {

    /**
     * que vendieron menos de X productos en un período dado
     */
    public static Filter moreSalesThan(Double totalSales) {
        return new MoreSalesThanFilter(totalSales);
    }

    /**
     * que generaron a la empresa ganancias por menos de $150.000
     */
    public static Filter lessEarningsThan(Double totalEarnings) {
        return new LessEarningsThanFilter(totalEarnings);
    }

    /**
     * que vendieron el producto con código “RAN780”
     */
    public static Filter soldProductCode(String productCode) {
        return new ProductCodeEqualsFilter(productCode);
    }

    /**
     * Combinaciones lógicas de las formas de búsqueda reflejadas en los ejemplos anteriores
     */
    public static Filter and(Filter a, Filter b) {
        return new AndFilter(a, b);
    }

    public static Filter or(Filter a, Filter b) {
        return new OrFilter(a, b);
    }

    public static Filter not(Filter a) {
        return new NotFilter(a);
    }
}
