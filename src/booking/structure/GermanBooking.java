package booking.structure;

public class GermanBooking implements Booking {
    private final String head, body;
    private final int footer;
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

}
