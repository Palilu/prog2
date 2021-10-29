package parcial;

import java.time.LocalDate;

/**
 * Paquete Promo Previaje, tiene un identificador propio,
 * ciudad de origen y destino propio, un monto propio, una
 * fecha de pago acordada propia, los datos del
 * alojamiento propio, y un porcentaje de descuento.
 * Cuando se quiere consultar el costo del paquete, si la
 * fecha de pago acordada se encuentra entre dos fechas
 * determinadas por la promoción, se aplica el descuento
 * al costo original. Si la fecha de pago acordada no está
 * informada o está fuera del rango de fechas de la
 * promoción, el descuento no aplica.
 */
public class PromoPreTrip extends Trip {

    private Trip trip;
    private LocalDate discountFrom;
    private LocalDate discountTo;
    private Double discount; // 0.7 para un descuento del 30%

    public PromoPreTrip(Integer id, Trip trip, LocalDate discountFrom, LocalDate discountTo, Double discount) {
        super(id, trip.getFamilyMembers());
        this.trip = trip;
        this.discountFrom = discountFrom;
        this.discountTo = discountTo;
        this.discount = discount;
    }

    @Override
    public String getFrom() {
        return trip.getFrom();
    }

    @Override
    public String getTo() {
        return trip.getTo();
    }

    @Override
    public Double getCost() {
        return discountApplies() ? trip.getCost() * discount : trip.getCost();
    }

    private boolean discountApplies() {
        return trip.getAgreedPaymentDate().isAfter(discountFrom) && trip.getAgreedPaymentDate().isBefore(discountTo);
    }

    @Override
    public LocalDate getAgreedPaymentDate() {
        return trip.getAgreedPaymentDate();
    }
}
