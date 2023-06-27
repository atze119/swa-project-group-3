package booking.structure;

public class BookingBuilder {
    private String head, body;
    private int footer;

    public BookingBuilder head(String head) {
        this.head = head;
        return this;
    }
    public BookingBuilder body(String body) {
        this.body = body;
        return this;
    }

    public BookingBuilder footer(int footer) {
        this.footer = footer;
        return this;
    }

    public GermanBooking buildGerman() {
        return new GermanBooking(head, body, footer);
    }
    public EnglishBooking buildEnglish() { // TODO is it allowed to use two build methods?
        return new EnglishBooking(head, body, footer);
    }

}
