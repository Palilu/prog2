package parcialito;

import parcialito.criterias.Comparators;
import parcialito.filters.Filter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Company {

    private List<SalesPerson> salesStaff;
    // Este cambio en la condición para el armado del ranking debe poder realizarse en tiempo de ejecución.
    private Comparator<SalesPerson> rankingStrategy;

    public Company() {
        this.salesStaff = new ArrayList<>();
        this.rankingStrategy = Comparators.byEarnings();
    }

    public void add(SalesPerson salesPerson) {
        this.salesStaff.add(salesPerson);
    }

    public List<SalesPerson> getSalesRanking(LocalDate beginning, LocalDate end) {
        return salesStaff.stream()
                .sorted(rankingStrategy)
                .collect(Collectors.toList());
    }

    public List<SalesPerson> getSalesPersons(Filter filter, Comparator<SalesPerson> order) {
        return salesStaff.stream()
                .filter(filter::matches)
                .sorted(order)
                .collect(Collectors.toList());
    }

    public void setRankingStrategy(Comparator<SalesPerson> rankingStrategy) {
        this.rankingStrategy = rankingStrategy;
    }
}
