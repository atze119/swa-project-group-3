package booking.structure;

import java.util.Date;

public interface Booking {
    void printBooking();
    int getCosts();
    int getBookingMonth();
    int getBookingYear();
    int randomBookingMonth();
}
