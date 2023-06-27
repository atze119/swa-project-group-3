package booking.structure;

public class EnglishBooking implements Booking {
    private final String head, body;
    private final int footer;
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
}
