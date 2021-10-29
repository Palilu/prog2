package parcial;

import java.time.LocalDate;

/**
 * Vida en la naturaleza en familia, consiste de un viaje en avión o auto
 *  rentado, a un destino estrechamente ligado a la naturaleza, se ofrece
 *  alojamiento para la cantidad de miembros de la familia durante el
 *  tiempo de estadía que la agencia estipule. Este paquete posee un
 *  identificador, los datos del alojamiento, la ciudad de origen y destino,
 *  una fecha de pago acordada y un costo.
 *
 *  Esta clase.
 *
 *  Escapada romántica, consiste en un viaje en auto rentado o avión, a
 *  un destino romántico como puede ser por ejemplo Burzaco o Realicó,
 *  con alojamiento para 2 personas durante un fin de semana. Este
 *  paquete posee un identificador, ciudad de origen y destino, un costo,
 *  una fecha de pago acordada y los datos del alojamiento.
 *
 *  Esta clase con familyMembers = 2.
 *
 *  Viaje con amigos, este paquete consiste de un viaje en
 *  avión o auto rentado, a un destino con gran vida nocturna, como puede ser por ejemplo Lago Puelo o
 *  Centinela del Mar. El alojamiento ofrecido depende de la cantidad de miembros del grupo de amigos y
 *  será otorgado durante el tiempo consensuado entre los amigos. El paquete es descrito por un
 *  identificador, un costo, fecha de pago, ciudad de origen y destino, y los datos del alojamiento.
 *  Nota: la fecha de pago acordada es inicialmente null y se establece en un momento posterior , cuando el
 *  cliente realiza efectivamente la coordinación del pago.
 *
 *  Esta clase con agreedPaymentDate = null.
 */
public class SimpleTrip extends Trip {

    private String hotelAddress;
    private String from;
    private String to;
    private LocalDate agreedPaymentDate;
    private Double cost;

    public SimpleTrip(Integer id,
                      Integer familyMembers,
                      String hotelAddress,
                      String from,
                      String to,
                      LocalDate agreedPaymentDate,
                      Double cost) {
        super(id, familyMembers);
        this.hotelAddress = hotelAddress;
        this.from = from;
        this.to = to;
        this.agreedPaymentDate = agreedPaymentDate;
        this.cost = cost;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public LocalDate getAgreedPaymentDate() {
        return agreedPaymentDate;
    }
}
