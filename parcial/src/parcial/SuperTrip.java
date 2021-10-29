package parcial;

import parcial.filters.TripFilter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Paquete Superviaje, consiste de un viaje de larga duración compuesto por diferentes combinaciones
 *  * de otros paquetes ofrecidos por la empresa, y cualquier otro tipo de paquete que pueda ofrecer en un
 *  * futuro. Poseen un identificador propio y la fecha de pago acordada se establece como la última fecha
 *  * de pago acordada de los paquetes que lo componen, siempre y cuando estén todas las fechas de pago
 *  * acordadas (si alguno no tienen una fecha acordada es null). Los paquetes intermedios son agregados
 *  * en orden, por lo tanto, la ciudad de origen de un nuevo paquete debe coincidir con la ciudad de destino
 *  * del último paquete incorporado, en caso de que esto no se cumpla no se incorpora el paquete que se
 *  * deseaba agregar. De esta forma, la ciudad origen del Paquete Superviaje será la ciudad origen de su
 *  * primer paquete y la ciudad destino del Paquete Superviaje será la ciudad destino del último. Como
 *  * condición fundamental todos los paquetes intermedios deben poseer la misma cantidad de pasajeros,
 *  * estipulada en el Paquete Superviaje en el momento de su creación. El costo de este paquete es la
 *  * suma de los costos de todos los paquetes que lo componen.
 */
public class SuperTrip extends Trip {

    private List<Trip> segments;

    public SuperTrip(Integer id, Integer familyMembers) {
        super(id, familyMembers);
        // Paquete Superviaje, consiste de un viaje de larga duración compuesto por diferentes combinaciones
        // de otros paquetes ofrecidos por la empresa, y cualquier otro tipo de paquete que pueda ofrecer en un
        // futuro
        this.segments = new ArrayList<>();
    }

    public boolean addSegment(Trip segment) {
        if (isSegmentCityValid(segment) && isSegmentFamilyCountValid(segment)) {
            segments.add(segment);
            return true;
        }
        return false;
    }

    public boolean isSegmentCityValid(Trip segment) {
        // Los paquetes intermedios son agregados
        // en orden, por lo tanto, la ciudad de origen de un nuevo paquete debe coincidir con la ciudad de destino
        // del último paquete incorporado, en caso de que esto no se cumpla no se incorpora el paquete que se
        // deseaba agregar
        //ACLARACIÓN: El primer paquete que se agrega a un paquete superviaje, obviamente se agrega de
        // * forma incondicional (sin controlar origen y destino). Si se controla la cantidad de pasajeros.
        return segments.isEmpty() || segment.getFrom().equals(getLastSegment().getTo());
    }

    private Trip getLastSegment() {
        return segments.get(segments.size() - 1);
    }

    public boolean isSegmentFamilyCountValid(Trip segment) {
        // Como condición fundamental todos los paquetes intermedios deben poseer la misma cantidad de pasajeros,
        // estipulada en el Paquete Superviaje en el momento de su creación.
        return this.getFamilyMembers().equals(segment.getFamilyMembers());
    }

    @Override
    public String getFrom() {
        // De esta forma, la ciudad origen del Paquete Superviaje será la ciudad origen de su primer paquete
        return segments.get(0).getFrom();
    }

    @Override
    public String getTo() {
        // y la ciudad destino del Paquete Superviaje será la ciudad destino del último
        return getLastSegment().getTo();
    }

    @Override
    public Double getCost() {
        // El costo de este paquete es la suma de los costos de todos los paquetes que lo componen.
        return segments.stream().collect(Collectors.summingDouble(Trip::getCost));
    }

    @Override
    public LocalDate getAgreedPaymentDate() {
        // la fecha de pago acordada se establece como la última fecha
        // de pago acordada de los paquetes que lo componen, siempre y cuando estén todas las fechas de pago
        // acordadas (si alguno no tienen una fecha acordada es null)
        List<LocalDate> agreedPaymentDates = segments.stream()
                .map(Trip::getAgreedPaymentDate)
                .collect(Collectors.toList());
        if (agreedPaymentDates.contains(null)) {
            return null;
        } else {
            return agreedPaymentDates.stream().sorted().findFirst().orElse(null);
        }
    }

    @Override
    public List<Trip> getMatches(TripFilter filter) {
//        NOTA: Si un paquete Súperviaje cumple con los requisitos de la búsqueda, se incluye él mismo en los
//        resultados y no los sub-paquetes que lo componen. En caso de que el paquete Súperviaje no cumpla
//        con el criterio se deben retornar los paquetes que lo componen que sí cumplan.
        if (filter.matches(this)) {
            return List.of(this);
        } else {
            return this.segments.stream() // Para cada segmento
                    .map(trip -> trip.getMatches(filter)) // Obtengo los viajes que matcheen
                    .flatMap(Collection::stream) // Unifico las lisras
                    .collect(Collectors.toList()); // Lo retorno
        }
    }
}
