package booking.structure;

import java.util.Random;

public class GermanBooking implements Booking {
    private final String head, body;
    private final int footer;

    private int bookingMonth;
    private int bookingYear = 2023;
    public GermanBooking(String head, String body, int footer) {
        this.head = head;
        this.body = body;
        this.footer = footer;
    }

    @Override
    public void printBooking() {
        System.out.printf("""
                Rechnung fuer: %s
                Sie haben folgendes gebucht: %s
                Ihre Buchung kostet: %s
                %n""", head, body, footer); // %n  = new line
    }

    @Override
    public int getCosts() {
        return footer;
    }

    public int randomBookingMonth() {
        Random random = new Random();
        this.bookingMonth = random.nextInt(12) + 1;
        return bookingMonth;
    }

    @Override
    public int getBookingMonth() {
        return bookingMonth;
    }

    @Override
    public int getBookingYear(){
        return bookingYear;
    }

}
