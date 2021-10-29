package parcial;

import parcial.filters.TripFilter;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TripAgency {

    private List<Trip> trips;

    public TripAgency(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Trip> search(TripFilter filter, Comparator<Trip> comparator) {
        return trips.stream()// Para cada viaja
                .map(trip -> trip.getMatches(filter)) // Obtengo sus matches
                .flatMap(Collection::stream) // Unifico las listas
                .sorted(comparator) // La ordeno
                .collect(Collectors.toList()); // La devuelvo
    }
}
