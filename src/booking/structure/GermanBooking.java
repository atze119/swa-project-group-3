package booking.structure;

public class GermanBooking implements Booking {
    private final String head, body, footer;
    public GermanBooking(String head, String body, String footer) {
        this.head = head;
        this.body = body;
        this.footer = footer;
    }

    @Override
    public void printBooking() {
        System.out.printf("""
                Rechnung für %s
                Sie haben %s gebucht
                Vielen Dank %s
                %n""", head, body, footer); // %n  = new line
    }
}
