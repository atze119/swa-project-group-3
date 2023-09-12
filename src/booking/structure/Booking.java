package booking.structure;

import payment.structure.Payment;
import statistics.structure.Visitor;

public interface Booking {


    void accept(Visitor visitor, Payment payment);
    void printBooking();
    int getCosts();
    int getBookingMonth();
    int getBookingYear();
    int randomBookingMonth();

    int getBookingId();
}
