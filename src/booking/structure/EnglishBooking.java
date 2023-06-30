package booking.structure;

import java.util.Random;

public class EnglishBooking implements Booking {
    private final String head, body;
    private final int footer;

    private int bookingMonth;
    private int bookingYear = 2023;

    public EnglishBooking(String head, String body, int footer) {
        this.head = head;
        this.body = body;
        this.footer = footer;
    }
    public void printBooking() {
        System.out.printf("""
                Invoice for: %s
                You have booked: %s
                Your booking costs: %s
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
