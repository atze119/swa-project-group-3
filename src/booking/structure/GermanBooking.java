package booking.structure;

public class GermanBooking {
    private final String head, body, footer;
    public GermanBooking(String head, String body, String footer) {
        this.head = head;
        this.body = body;
        this.footer = footer;
    }



    public void printBooking() {
        System.out.printf(head + "\n" + body + "\n" + footer + "\n");
    }
}
